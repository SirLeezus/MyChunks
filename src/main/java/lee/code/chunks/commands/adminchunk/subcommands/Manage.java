package lee.code.chunks.commands.adminchunk.subcommands;

import lee.code.chunks.GoldmanChunks;
import lee.code.chunks.commands.SubCommand;
import lee.code.chunks.database.Cache;
import lee.code.chunks.lists.Lang;
import lee.code.chunks.menusystem.menus.AdminChunkSettings;
import org.bukkit.Chunk;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Manage extends SubCommand {

    @Override
    public String getName() {
        return "manage";
    }

    @Override
    public String getDescription() {
        return "Change the settings of the admin chunk you are standing on.";
    }

    @Override
    public String getSyntax() {
        return "/adminchunk manage";
    }

    @Override
    public String getPermission() {
        return "mychunk.admin.manage";
    }

    @Override
    public void perform(Player player, String[] args) {
        GoldmanChunks plugin = GoldmanChunks.getPlugin();
        Cache cache = plugin.getCache();

        Chunk chunk = player.getLocation().getChunk();
        String chunkCord = plugin.getPU().formatChunkLocation(chunk);
        if (cache.isAdminChunk(chunkCord)) {
            new AdminChunkSettings(plugin.getData().getPlayerMU(player.getUniqueId())).open();
            player.playSound(player.getLocation(), Sound.ENTITY_LLAMA_SWAG, 1, 1);
        } else player.sendMessage(Lang.PREFIX.getString(null) + Lang.ERROR_COMMAND_ADMIN_MANAGE_NOT_ADMIN_CHUNK.getString(null));
    }

    @Override
    public void performConsole(CommandSender console, String[] args) {
        console.sendMessage(Lang.PREFIX.getString(null) + Lang.ERROR_NOT_A_CONSOLE_COMMAND.getString(null));
    }
}
