package lee.code.chunks.menusystem.menus;

import lee.code.chunks.GoldmanChunks;
import lee.code.chunks.lists.Lang;
import lee.code.chunks.menusystem.Menu;
import lee.code.chunks.menusystem.PlayerMU;
import org.bukkit.Chunk;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AdminChunkSettings extends Menu {

    public AdminChunkSettings(PlayerMU pmu) {
        super(pmu);
    }

    @Override
    public String getMenuName() {
        return Lang.MENU_ADMIN_CHUNK_SETTINGS_TITLE.getString(null);
    }

    @Override
    public int getSlots() {
        return 27;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {
        GoldmanChunks plugin = GoldmanChunks.getPlugin();
        Player player = pmu.getOwner();

        if (plugin.getData().getPlayerClickDelay(player.getUniqueId())) return;
        else plugin.getPU().addPlayerClickDelay(player.getUniqueId());
        if (e.getClickedInventory() == player.getInventory()) return;

        ItemStack item = e.getCurrentItem();

        if (item != null) {
            switch (e.getSlot()) {
                case 10:
                    updatePermItem(item, 10, player.getLocation().getChunk());
                    break;
                case 11:
                    updatePermItem(item, 11, player.getLocation().getChunk());
                    break;
                case 12:
                    updatePermItem(item, 12, player.getLocation().getChunk());
                    break;
                case 13:
                    updatePermItem(item, 13, player.getLocation().getChunk());
                    break;
                case 14:
                    updatePermItem(item, 14, player.getLocation().getChunk());
                    break;
                case 15:
                    updatePermItem(item, 15, player.getLocation().getChunk());
                    break;
                case 16:
                    updatePermItem(item, 16, player.getLocation().getChunk());
                    break;
            }
        }
    }

    @Override
    public void setMenuItems() {
        GoldmanChunks plugin = GoldmanChunks.getPlugin();
        setFillerGlass();

        ItemStack allow = new ItemStack(permTrueItem);
        ItemMeta allowMeta = allow.getItemMeta();

        ItemStack deny = new ItemStack(permFalseItem);
        ItemMeta denyMeta = deny.getItemMeta();

        Player player = pmu.getOwner();
        Chunk chunk = player.getLocation().getChunk();
        String chunkCord = plugin.getPU().formatChunk(chunk);

        if (plugin.getSqLite().canAdminChunkExplode(chunkCord)) {
            allowMeta.setDisplayName(Lang.ITEM_SETTINGS_EXPLOSIONS_NAME.getString(new String[] { Lang.TRUE.getString(null) }));
            allow.setItemMeta(allowMeta);
            inventory.setItem(10, allow);
        } else {
            denyMeta.setDisplayName(Lang.ITEM_SETTINGS_EXPLOSIONS_NAME.getString(new String[] { Lang.FALSE.getString(null) }));
            deny.setItemMeta(denyMeta);
            inventory.setItem(10, deny);
        }

        if (plugin.getSqLite().canAdminChunkBuild(chunkCord)) {
            allowMeta.setDisplayName(Lang.ITEM_SETTINGS_BUILD_NAME.getString(new String[] { Lang.TRUE.getString(null) }));
            allow.setItemMeta(allowMeta);
            inventory.setItem(11, allow);
        } else {
            denyMeta.setDisplayName(Lang.ITEM_SETTINGS_BUILD_NAME.getString(new String[] { Lang.FALSE.getString(null) }));
            deny.setItemMeta(denyMeta);
            inventory.setItem(11, deny);
        }

        if (plugin.getSqLite().canAdminChunkBreak(chunkCord)) {
            allowMeta.setDisplayName(Lang.ITEM_SETTINGS_BREAK_NAME.getString(new String[] { Lang.TRUE.getString(null) }));
            allow.setItemMeta(allowMeta);
            inventory.setItem(12, allow);
        } else {
            denyMeta.setDisplayName(Lang.ITEM_SETTINGS_BREAK_NAME.getString(new String[] { Lang.FALSE.getString(null) }));
            deny.setItemMeta(denyMeta);
            inventory.setItem(12, deny);
        }

        if (plugin.getSqLite().canAdminChunkInteract(chunkCord)) {
            allowMeta.setDisplayName(Lang.ITEM_SETTINGS_INTERACT_NAME.getString(new String[] { Lang.TRUE.getString(null) }));
            allow.setItemMeta(allowMeta);
            inventory.setItem(13, allow);
        } else {
            denyMeta.setDisplayName(Lang.ITEM_SETTINGS_INTERACT_NAME.getString(new String[] { Lang.FALSE.getString(null) }));
            deny.setItemMeta(denyMeta);
            inventory.setItem(13, deny);
        }

        if (plugin.getSqLite().canAdminChunkSpawnMonsters(chunkCord)) {
            allowMeta.setDisplayName(Lang.ITEM_SETTINGS_MONSTER_SPAWNING_NAME.getString(new String[] { Lang.TRUE.getString(null) }));
            allow.setItemMeta(allowMeta);
            inventory.setItem(14, allow);
        } else {
            denyMeta.setDisplayName(Lang.ITEM_SETTINGS_MONSTER_SPAWNING_NAME.getString(new String[] { Lang.FALSE.getString(null) }));
            deny.setItemMeta(denyMeta);
            inventory.setItem(14, deny);
        }

        if (plugin.getSqLite().canAdminChunkPVP(chunkCord)) {
            allowMeta.setDisplayName(Lang.ITEM_SETTINGS_PVP_NAME.getString(new String[] { Lang.TRUE.getString(null) }));
            allow.setItemMeta(allowMeta);
            inventory.setItem(15, allow);

        } else {
            denyMeta.setDisplayName(Lang.ITEM_SETTINGS_PVP_NAME.getString(new String[] { Lang.FALSE.getString(null) }));
            deny.setItemMeta(denyMeta);
            inventory.setItem(15, deny);
        }

        if (plugin.getSqLite().canAdminChunkPVE(chunkCord)) {
            allowMeta.setDisplayName(Lang.ITEM_SETTINGS_PVE_NAME.getString(new String[] { Lang.TRUE.getString(null) }));
            allow.setItemMeta(allowMeta);
            inventory.setItem(16, allow);

        } else {
            denyMeta.setDisplayName(Lang.ITEM_SETTINGS_PVE_NAME.getString(new String[] { Lang.FALSE.getString(null) }));
            deny.setItemMeta(denyMeta);
            inventory.setItem(16, deny);
        }
    }

    private void updatePermItem(ItemStack item, int slot, Chunk chunk) {
        GoldmanChunks plugin = GoldmanChunks.getPlugin();
        String chunkCord = plugin.getPU().formatChunk(chunk);
        ItemStack allow = new ItemStack(permTrueItem);
        ItemStack deny = new ItemStack(permFalseItem);
        ItemMeta allowMeta = allow.getItemMeta();
        ItemMeta denyMeta = deny.getItemMeta();

        //allow
        if (item.getType() != permTrueItem.getType()) {
            switch (slot) {
                case 10:
                    allowMeta.setDisplayName(Lang.ITEM_SETTINGS_EXPLOSIONS_NAME.getString(new String[]{Lang.TRUE.getString(null)}));
                    allow.setItemMeta(allowMeta);
                    plugin.getSqLite().setAdminChunkExplosion(chunkCord, 1);
                    inventory.setItem(slot, allow);
                    break;
                case 11:
                    allowMeta.setDisplayName(Lang.ITEM_SETTINGS_BUILD_NAME.getString(new String[]{Lang.TRUE.getString(null)}));
                    allow.setItemMeta(allowMeta);
                    plugin.getSqLite().setAdminChunkBuild(chunkCord, 1);
                    inventory.setItem(slot, allow);
                    break;
                case 12:
                    allowMeta.setDisplayName(Lang.ITEM_SETTINGS_BREAK_NAME.getString(new String[]{Lang.TRUE.getString(null)}));
                    allow.setItemMeta(allowMeta);
                    plugin.getSqLite().setAdminChunkBreak(chunkCord, 1);
                    inventory.setItem(slot, allow);
                    break;
                case 13:
                    allowMeta.setDisplayName(Lang.ITEM_SETTINGS_INTERACT_NAME.getString(new String[]{Lang.TRUE.getString(null)}));
                    allow.setItemMeta(allowMeta);
                    plugin.getSqLite().setAdminChunkInteract(chunkCord, 1);
                    inventory.setItem(slot, allow);
                    break;
                case 14:
                    allowMeta.setDisplayName(Lang.ITEM_SETTINGS_MONSTER_SPAWNING_NAME.getString(new String[]{Lang.TRUE.getString(null)}));
                    allow.setItemMeta(allowMeta);
                    plugin.getSqLite().setAdminChunkSpawnMonsters(chunkCord, 1);
                    inventory.setItem(slot, allow);
                    break;
                case 15:
                    allowMeta.setDisplayName(Lang.ITEM_SETTINGS_PVP_NAME.getString(new String[] { Lang.TRUE.getString(null) }));
                    allow.setItemMeta(allowMeta);
                    plugin.getSqLite().setAdminChunkPVP(chunkCord, 1);
                    inventory.setItem(slot, allow);
                    break;
                case 16:
                    allowMeta.setDisplayName(Lang.ITEM_SETTINGS_PVE_NAME.getString(new String[] { Lang.TRUE.getString(null) }));
                    allow.setItemMeta(allowMeta);
                    plugin.getSqLite().setAdminChunkPVE(chunkCord, 1);
                    inventory.setItem(slot, allow);
                    break;
            }
            //deny
        } else if (item.getType() != permFalseItem.getType()) {

            switch (slot) {
                case 10:
                    denyMeta.setDisplayName(Lang.ITEM_SETTINGS_EXPLOSIONS_NAME.getString(new String[]{Lang.FALSE.getString(null)}));
                    deny.setItemMeta(denyMeta);
                    plugin.getSqLite().setAdminChunkExplosion(chunkCord, 0);
                    inventory.setItem(slot, deny);
                    break;
                case 11:
                    denyMeta.setDisplayName(Lang.ITEM_SETTINGS_BUILD_NAME.getString(new String[]{Lang.FALSE.getString(null)}));
                    deny.setItemMeta(denyMeta);
                    plugin.getSqLite().setAdminChunkBuild(chunkCord, 0);
                    inventory.setItem(slot, deny);
                    break;
                case 12:
                    denyMeta.setDisplayName(Lang.ITEM_SETTINGS_BREAK_NAME.getString(new String[]{Lang.FALSE.getString(null)}));
                    deny.setItemMeta(denyMeta);
                    plugin.getSqLite().setAdminChunkBreak(chunkCord, 0);
                    inventory.setItem(slot, deny);
                    break;
                case 13:
                    denyMeta.setDisplayName(Lang.ITEM_SETTINGS_INTERACT_NAME.getString(new String[]{Lang.FALSE.getString(null)}));
                    deny.setItemMeta(denyMeta);
                    plugin.getSqLite().setAdminChunkInteract(chunkCord, 0);
                    inventory.setItem(slot, deny);
                    break;
                case 14:
                    denyMeta.setDisplayName(Lang.ITEM_SETTINGS_MONSTER_SPAWNING_NAME.getString(new String[]{Lang.FALSE.getString(null)}));
                    deny.setItemMeta(denyMeta);
                    plugin.getSqLite().setAdminChunkSpawnMonsters(chunkCord, 0);
                    inventory.setItem(slot, deny);
                    break;
                case 15:
                    denyMeta.setDisplayName(Lang.ITEM_SETTINGS_PVP_NAME.getString(new String[] { Lang.FALSE.getString(null) }));
                    deny.setItemMeta(denyMeta);
                    plugin.getSqLite().setAdminChunkPVP(chunkCord, 0);
                    inventory.setItem(slot, deny);
                    break;
                case 16:
                    denyMeta.setDisplayName(Lang.ITEM_SETTINGS_PVE_NAME.getString(new String[] { Lang.FALSE.getString(null) }));
                    deny.setItemMeta(denyMeta);
                    plugin.getSqLite().setAdminChunkPVE(chunkCord, 0);
                    inventory.setItem(slot, deny);
                    break;
            }
        }
    }
}
