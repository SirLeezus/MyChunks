package lee.code.chunks.commands.chunk.subcommands;

import lee.code.chunks.GoldmanChunks;
import lee.code.chunks.commands.SubCommand;
import lee.code.chunks.database.Cache;
import lee.code.chunks.lists.Lang;
import net.kyori.adventure.text.Component;
import org.bukkit.Chunk;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Trusted extends SubCommand {

    @Override
    public String getName() {
        return "trusted";
    }

    @Override
    public String getDescription() {
        return "Check your global and chunk trusted players.";
    }

    @Override
    public String getSyntax() {
        return "/chunk trusted";
    }

    @Override
    public String getPermission() {
        return "chunk.command.trusted";
    }

    @Override
    public void perform(Player player, String[] args) {
        GoldmanChunks plugin = GoldmanChunks.getPlugin();
        UUID uuid = player.getUniqueId();
        Chunk chunk = player.getLocation().getChunk();
        String chunkCord = plugin.getPU().formatChunkLocation(chunk);
        Cache cache = plugin.getCache();

        String trusted;
        List<Component> lines = new ArrayList<>();

        if (cache.isChunkOwner(chunkCord, uuid)) trusted = String.join(", ", cache.getChunkTrustedNames(chunkCord));
        else trusted = Lang.ERROR_COMMAND_TRUSTED_NOT_CHUNK_OWNER.getString(null);

        String globalTrusted = String.join(", ", cache.getGlobalTrustedNames(uuid));

        lines.add(Lang.COMMAND_TRUSTED_HEADER.getComponent(null));
        lines.add(Component.text(""));
        lines.add(Lang.COMMAND_TRUSTED_LINE_1.getComponent(new String[] { globalTrusted }));
        lines.add(Lang.COMMAND_TRUSTED_LINE_2.getComponent(new String[] { trusted }));
        lines.add(Component.text(""));
        lines.add(Lang.COMMAND_TRUSTED_FOOTER.getComponent(null));

        for (Component line : lines) player.sendMessage(line);
        plugin.getPU().renderChunkBorder(player, chunk, "info");
    }

    @Override
    public void performConsole(CommandSender console, String[] args) {
        console.sendMessage(Lang.PREFIX.getString(null) + Lang.ERROR_NOT_A_CONSOLE_COMMAND.getString(null));
    }
}
