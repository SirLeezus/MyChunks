package lee.code.chunks.commands.chunk.subcommands;

import lee.code.chunks.GoldmanChunks;
import lee.code.chunks.commands.SubCommand;
import lee.code.chunks.database.Cache;
import lee.code.chunks.lists.Lang;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Claim extends SubCommand {

    @Override
    public String getName() {
        return "claim";
    }

    @Override
    public String getDescription() {
        return "Claim the chunk you're standing on.";
    }

    @Override
    public String getSyntax() {
        return "/chunk claim";
    }

    @Override
    public String getPermission() {
        return "chunk.command.claim";
    }

    @Override
    public void perform(Player player, String[] args) {
        GoldmanChunks plugin = GoldmanChunks.getPlugin();
        Cache cache = plugin.getCache();

        UUID uuid = player.getUniqueId();
        Chunk chunk = player.getLocation().getChunk();
        String chunkCord = plugin.getPU().formatChunkLocation(chunk);

        if (!cache.isChunkClaimed(chunkCord)) {
            if (!cache.isAdminChunk(chunkCord)) {
                int playerClaimAmount = cache.getClaimedAmount(uuid);
                int playerMaxClaims = cache.getPlayerMaxClaimAmount(uuid);

                if (playerClaimAmount < playerMaxClaims) {
                    playerClaimAmount++;
                    cache.claimChunk(chunkCord, uuid);
                    player.sendMessage(Lang.PREFIX.getComponent(null).append(Lang.COMMAND_CLAIM_SUCCESSFUL.getComponent(new String[] { chunkCord, plugin.getPU().formatAmount(playerClaimAmount), plugin.getPU().formatAmount(playerMaxClaims) })));
                    plugin.getPU().renderChunkBorder(player, chunk, "claim");
                } else player.sendMessage(Lang.PREFIX.getComponent(null).append(Lang.ERROR_COMMAND_CLAIM_MAXED.getComponent(new String[] { plugin.getPU().formatAmount(playerClaimAmount), plugin.getPU().formatAmount(playerMaxClaims) })));
            } else player.sendMessage(Lang.PREFIX.getComponent(null).append(Lang.ERROR_ADMIN_CLAIMED.getComponent(null)));
        } else {
            UUID ownerUUID = cache.getChunkOwnerUUID(chunkCord);
            String ownerName = Bukkit.getOfflinePlayer(ownerUUID).getName();
            if (!uuid.equals(ownerUUID)) player.sendMessage(Lang.PREFIX.getComponent(null).append(Lang.ERROR_CLAIMED.getComponent(new String[] { ownerName })));
            else player.sendMessage(Lang.PREFIX.getComponent(null).append(Lang.ERROR_CLAIMED_OWNER.getComponent(null)));
        }
    }

    @Override
    public void performConsole(CommandSender console, String[] args) {
        console.sendMessage(Lang.PREFIX.getComponent(null).append(Lang.ERROR_NOT_A_CONSOLE_COMMAND.getComponent(null)));
    }
}
