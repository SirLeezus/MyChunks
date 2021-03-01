package lee.code.chunks.lists;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.ChatColor;

@AllArgsConstructor
public enum Lang {
    PREFIX("&e&lChunks &6➔ &r"),
    TELEPORT("&eWhooosh!"),
    TRUE("&atrue"),
    FALSE("&cfalse"),
    MESSAGE_HELP_DIVIDER("&e▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"),
    MESSAGE_HELP_TITLE("                      &6-== &e&l&nChunk Help&r &6==-"),
    MESSAGE_HELP_SUB_COMMAND("&3{0}&b. &e{1} &c| &7{2}"),
    ERROR_NO_PERMISSION("&cYou sadly do not have permission for this."),
    ERROR_PVP_DISABLED("&c&lPvP is disabled in this chunk"),
    ERROR_NO_CLAIM_PERMISSION("&6&lTrusted&7: {0} &7| {1} &7| &6&lOwner&7: &2{2}"),
    ERROR_CLAIMED("&cSadly this chunk has already been claimed by &6{0}&c."),
    ERROR_ADMIN_CLAIMED("&cSadly this chunk has already been claimed as a &4&lAdmin &cchunk."),
    ERROR_COMMAND_ADMIN_UNCLAIM("&cThe chunk &e(&b{0}&e) &cis not owned by anyone, you need to stand on a chunk owned by a player."),
    ERROR_COMMAND_UNCLAIM_OWNER("&cThis chunk is owned by &6{0}&c, you need to be the owner to unclaim it."),
    ERROR_COMMAND_UNCLAIMED_NOT_CLAIMED("&cThis chunk is not claimed so you can not unclaim it."),
    ERROR_COMMAND_AUTO_CLAIM("&cYou moved outside of the chunks around the last group you auto claimed so auto claim has been disabled."),
    ERROR_COMMAND_AUTO_CLAIM_WORLD_GUARD_REGION("&cYou can not claim chunks inside World Guard regions. Auto claim has been disabled."),
    ERROR_COMMAND_ABANDONALLCLAIMS_NO_CLAIMS("&cYou have no claimed chunks so nothing was unclaimed."),
    ERROR_COMMAND_CLAIM_MAXED("&cYou have reached the max amount of chunks you can claim at this time &e(&2{0}&7/&2{1}&e)&c. "),
    ERROR_COMMAND_TRUSTED_NOT_CHUNK_OWNER("&cYou do not own this chunk."),
    ERROR_COMMAND_TRUST_ALREADY_ADDED("&cThe player &6{0} &cis already added to your trusted list on chunk &e(&b{1}&e)&c."),
    ERROR_COMMAND_TRUSTALL_ALREADY_ADDED("&cThe player &6{0} &cis already added to your global trusted list."),
    ERROR_COMMAND_LIST_TELEPORT_UNSAFE("&cSadly there wasn't a safe place to teleport so it was canceled."),
    ERROR_COMMAND_UNTRUST_PLAYER_NOT_TRUSTED("&cThe player &6{0} &cis not trusted to the chunk &e(&b{1}&e)&c."),
    ERROR_COMMAND_UNTRUSTALL_PLAYER_NOT_TRUSTED("&cThe player &6{0} &cis not listed on your global trust list."),
    ERROR_COMMAND_UNTRUST_NOT_CHUNK_OWNER("&cYou need to be the owner of the chunk to untrust a player from it."),
    ERROR_COMMAND_ADMIN_BONUS_CLAIMS_AMOUNT("&cThe input &6{0} &cis not a number."),
    ERROR_COMMAND_ADMIN_BONUS_CLAIMS_ARG_2("&cYou need to specify if you want to add, remove or set a players bonus claims."),
    ERROR_COMMAND_ADMIN_BONUS_CLAIMS_ARG_3("&cYou need to specify a player and an amount you want to give them."),
    ERROR_COMMAND_ADMIN_BONUS_CLAIMS_ARG_4("&cYou need to specify an amount of bonus claims."),
    ERROR_COMMAND_ADMIN_ARGS("&cYou need to specify which admin command you would like to run."),
    ERROR_COMMAND_ADMIN_WRONG_ARG("&cThe admin arg &6{0} &cis not a valid option."),
    ERROR_COMMAND_SETPRICE_NOT_CLAIMED("&cThe chunk you're currently standing on is not claimed."),
    ERROR_COMMAND_SETPRICE_ADMIN_CHUNK("&cYou can not sell admin chunks."),
    ERROR_COMMAND_SETPRICE_NOT_OWNER("&cThe chunk you're currently standing on is owned by &6{0} &cand only they are able to put a chunk up for sale."),
    ERROR_COMMAND_SETPRICE_MAX_VALUE("&cYou can only sell a chunk for a max of ${0}&c."),
    ERROR_COMMAND_SETPRICE_NOT_NUMBER("&cThe input &b{0} &cis not a accepted value. You need to input a sell price, decimals are not supported."),
    ERROR_COMMAND_SETPRICE_NO_NUMBER("&cYou need to input a number for how much you would like to sell the chunk you're standing on. Keep in mind decimals are not supported."),
    ERROR_PREVIOUS_PAGE("&7You are already on the first page."),
    ERROR_NEXT_PAGE("&7You are on the last page."),
    ERROR_COMMAND_MANAGE_NOT_CHUNK_OWNER("&cYou need to be standing on a chunk you own to open this menu."),
    ERROR_COMMAND_ADMIN_MANAGE_NOT_ADMIN_CHUNK("&cYou need to be standing on a admin chunk to open this menu."),
    ERROR_PLAYER_NOT_ONLINE("&cThe player &6{0} &cis not online."),
    ERROR_COMMAND_TRUST_NOT_OWNER("&cYou need to be the owner of this chunk to trust a player to it."),
    ERROR_NOT_A_CONSOLE_COMMAND("&cThis is not a console command."),
    ERROR_PLAYER_NOT_FOUND("&cThe player &6{0} &chas never logged into this server."),
    COMMAND_RELOAD_SUCCESSFUL("&aThe plugin has been reloaded."),
    COMMAND_CLAIM_SUCCESSFUL("&aYou successfully claimed the chunk &e(&b{0}&e)&a! You now have &e(&2{1}&7/&2{2}&e) &aclaims."),
    COMMAND_BUY_SUCCESSFUL("&aYou successfully bought the chunk &e(&b{0}&e)&a for &6${1}&a from &6{2}&a! You now have &e(&2{3}&7/&2{4}&e) &aclaims."),
    COMMAND_BUY_SUCCESSFUL_OWNER("&aThe player &6{0} &abought your chunk &e(&b{1}&e)&a for &6${2}&a! You now have &e(&2{3}&7/&2{4}&e) &aclaims."),
    COMMAND_ABANDONALLCLAIMS_SUCCESSFUL("&aYou successfully unclaimed all your chunks. You now have &e(&2{0}&7/&2{1}&e) &aclaims."),
    COMMAND_UNCLAIM_SUCCESSFUL("&aYou successfully unclaimed the chunk &e(&b{0}&e)&a!"),
    COMMAND_AUTO_CLAIM_DISABLED("&aYou successfully &cdisabled &aauto claim."),
    COMMAND_AUTO_CLAIM_ENABLED("&aYou successfully &2enabled &aauto claim!"),
    COMMAND_TRUST_ADDED_PLAYER("&aYou successfully added the player &6{0} &ato your trusted list on chunk &e(&b{1}&e)&a!"),
    COMMAND_UNTRUST_REMOVED_PLAYER("&aYou successfully removed the player &6{0} &afrom your trusted list on chunk &e(&b{1}&e)&a."),
    COMMAND_ADMIN_BYPASS_ENABLED("&aAdmin claim bypass is now &2enabled&a!"),
    COMMAND_ADMIN_BYPASS_DISABLED("&aAdmin claim bypass is now &cdisabled&a."),
    COMMAND_ADMIN_CLAIM_FIRST_CHUNK_SELECTED("&aYou successfully selected the chunk &e(&b{0}&e)&a! Now run the command &6/adminchunk claim &aagain to claim all admin chunks between this selected chunk."),
    COMMAND_ADMIN_UNCLAIM_FIRST_CHUNK_SELECTED("&aYou successfully selected the chunk &e(&b{0}&e)&a! Now run the command &6/adminchunk unclaim &aagain to unclaim all admin chunks between this selected chunk."),
    COMMAND_ADMIN_CLAIM_SUCCESSFUL("&aYou successfully claimed &4{0} &aadmin chunks!"),
    COMMAND_ADMIN_UNCLAIM_SUCCESSFUL("&aYou successfully unclaimed &4{0} &aadmin chunks!"),
    COMMAND_ADMIN_UNCLAIM("&aYou successfully unclaimed chunk &e(&b{0}&e) &afrom &6{1}&a."),
    COMMAND_ADMIN_UNCLAIMALL("&aYou successfully unclaimed all the chunks the player &6{0} &aowned."),
    COMMAND_ADMIN_BONUS_CLAIMS_ADD("&aSuccessfully added &2{0} bonus claims &ato player &6{1}&a."),
    COMMAND_ADMIN_BONUS_CLAIMS_REMOVE("&aSuccessfully removed &2{0} bonus claims &afrom player &6{1}&a."),
    COMMAND_ADMIN_BONUS_CLAIMS_SET("&aSuccessfully set &2{0} bonus claims &afor player &6{1}&a."),
    COMMAND_UNTRUSTALL_REMOVED_PLAYER("&aYou successfully removed the player &6{0} &afrom your global trusted list."),
    COMMAND_TRUSTALL_ADDED_PLAYER("&aYou successfully added the player &6{0} &ato your global trusted list!"),
    COMMAND_SETPRICE_SUCCESSFUL("&aYou successfully set your chunk &e(&b{0}&e) &aat a sell price of &6${1}&a!"),
    COMMAND_SETPRICE_REMOVE_SUCCESSFUL("&aYour chunk &e(&b{0}&e) &ais now no longer for sale."),
    COMMAND_INFO_HEADER("&e--------- &7[ &a&lChunk Info &7] &e---------"),
    COMMAND_INFO_LINE_1("&2&lChunk Owner&7: &6{0}"),
    COMMAND_INFO_LINE_2("&2&lChunk Coordinate&7: &b{0}"),
    COMMAND_INFO_LINE_3("&2&lChunk Price&7: &6${0}"),
    COMMAND_INFO_FOOTER("&e---------------------------------"),
    COMMAND_MAP_HEADER("&e--------- &7[ &a&lChunk Map &7] &e---------"),
    COMMAND_MAP_KEY_HEADER("&e---------- &7[ &a&lMap Key &7] &e----------"),
    COMMAND_MAP_LINE_1(" {0}  &6&lYOU&7: &9■ &6&lCLAIMED&7: &2■ &6&lWILD&7: &7■"),
    COMMAND_MAP_LINE_2(" {0}     &6&lTRUSTED&7: &a■ &6&lOWNED&7: &c■"),
    COMMAND_MAP_LINE_3(" {0}              &6&lADMIN&7: &4■"),
    COMMAND_MAP_FOOTER("&e--------------------------------"),
    COMMAND_TRUSTED_HEADER("&2-------------- &6[ &a&lTrusted Players &6] &2--------------"),
    COMMAND_TRUSTED_LINE_1("&6&lGlobal Trusted&7: &a{0}"),
    COMMAND_TRUSTED_LINE_2("&6&lChunk Trusted&7: &a{0}"),
    COMMAND_TRUSTED_FOOTER("&2-------------------------------------------------"),
    COMMAND_MAX_CLAIMS_HEADER("&2----------------- &6[ &a&lClaim Info &6] &2-----------------"),
    COMMAND_MAX_CLAIMS_LINE_1("&6&lDefault Claims&7: &2{0}"),
    COMMAND_MAX_CLAIMS_LINE_2("&6&lBonus Claims&7: &2{0}"),
    COMMAND_MAX_CLAIMS_LINE_3("&6&lClaimed&7: &2{0}"),
    COMMAND_MAX_CLAIMS_LINE_4("&6&lTime Played&7: &e{0}"),
    COMMAND_MAX_CLAIMS_LINE_5("&6&lAccrued Timer&7: &e{0} claims every {1} played"),
    COMMAND_MAX_CLAIMS_LINE_6("&6&lAccrued Claims&7: &2{0}&7/&2{1}"),
    COMMAND_MAX_CLAIMS_LINE_7("&6&lTotal Claims&7: &2{0}&7/&2{1}"),
    COMMAND_MAX_CLAIMS_FOOTER("&2------------------------------------------------"),
    MENU_ADMIN_CHUNK_SETTINGS_TITLE("&4&lAdmin Chunk Settings"),
    MENU_CHUNK_MANAGER_TITLE("&c&lChunk Manager"),
    MENU_PLAYER_CHUNKS_TITLE("&2&lClaimed Chunks &8Page {0}"),
    MENU_GENERAL_CHUNK_SETTINGS_TITLE("&e&lGeneral Chunk Settings"),
    MENU_TRUSTED_TITLE("&2&lTrusted Chunk Settings"),
    MENU_GLOBAL_TRUSTED_TITLE("&2&lTrusted Global Settings"),
    ITEM_TRUSTED_CHUNK_SETTINGS_NAME("&2&lTrusted Chunk Settings"),
    ITEM_GLOBAL_TRUSTED_CHUNK_SETTINGS_NAME("&2&lTrusted Global Settings"),
    ITEM_GLOBAL_TRUSTED_CHUNK_SETTINGS_LORE_1("&7Toggle your trusted player global"),
    ITEM_GLOBAL_TRUSTED_CHUNK_SETTINGS_LORE_2("&7settings on all your claimed chunks."),
    ITEM_GENERAL_CHUNK_SETTINGS_NAME("&e&lGeneral Chunk Settings"),
    ITEM_GENERAL_CHUNK_SETTINGS_LORE_1("&7Toggle settings for the chunk you"),
    ITEM_GENERAL_CHUNK_SETTINGS_LORE_2("&7are standing on."),
    ITEM_TRUSTED_CHUNK_PLAYERS_NAME("&2&lTrusted Chunk Players"),
    ITEM_TRUSTED_CHUNK_PLAYERS_LORE_1("&7List the players that are trusted"),
    ITEM_TRUSTED_CHUNK_PLAYERS_LORE_2("&7in the chunk you are standing on."),
    ITEM_SETTINGS_BUILD_NAME("&6&lBuild&7: {0}"),
    ITEM_SETTINGS_BREAK_NAME("&6&lBreak&7: {0}"),
    ITEM_SETTINGS_INTERACT_NAME("&6&lInteract&7: {0}"),
    ITEM_SETTINGS_PVP_NAME("&6&lPvP&7: {0}"),
    ITEM_SETTINGS_PVE_NAME("&6&lPvE&7: {0}"),
    ITEM_SETTINGS_MONSTER_SPAWNING_NAME("&6&lMonster Spawning&7: {0}"),
    ITEM_SETTINGS_EXPLOSIONS_NAME("&6&lExplosions&7: {0}"),
    INTERFACE_ITEM_NEXT_PAGE_NAME("&eNext Page >"),
    INTERFACE_ITEM_PREVIOUS_PAGE_NAME("&e< Previous Page"),
    ;

    @Getter private final String string;

    public String getString(final String[] variables) {
        String value = ChatColor.translateAlternateColorCodes('&', string);
        if (variables == null) return value;
        else if (variables.length == 0) return value;
        for (int i = 0; i < variables.length; i++) value = value.replace("{" + i + "}", variables[i]);
        return ChatColor.translateAlternateColorCodes('&', value);
    }
}