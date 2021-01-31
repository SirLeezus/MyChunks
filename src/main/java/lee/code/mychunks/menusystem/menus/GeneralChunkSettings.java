package lee.code.mychunks.menusystem.menus;

import lee.code.mychunks.MyChunks;
import lee.code.mychunks.files.defaults.Lang;
import lee.code.mychunks.menusystem.Menu;
import lee.code.mychunks.menusystem.PlayerMenuUtility;
import org.bukkit.Chunk;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GeneralChunkSettings extends Menu {

    public GeneralChunkSettings(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return Lang.MENU_GENERAL_CHUNK_SETTINGS_TITLE.getConfigValue(null);
    }

    @Override
    public int getSlots() {
        return 36;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {
        MyChunks plugin = MyChunks.getPlugin();
        Player player = playerMenuUtility.getOwner();

        //click delay
        if (plugin.getData().getPlayerClickDelay(player.getUniqueId())) return;
        else plugin.getUtility().addPlayerClickDelay(player.getUniqueId());

        if (e.getClickedInventory() == player.getInventory()) return;

        switch (e.getSlot()) {
            case 11:
                updatePermItem(e.getCurrentItem(), 11, player.getLocation().getChunk());
                break;
            case 13:
                updatePermItem(e.getCurrentItem(), 13, player.getLocation().getChunk());
                break;
            case 15:
                updatePermItem(e.getCurrentItem(), 15, player.getLocation().getChunk());
                break;
            case 31:
                new ChunkManager(playerMenuUtility).open();
                break;
        }
    }

    @Override
    public void setMenuItems() {
        MyChunks plugin = MyChunks.getPlugin();
        setFillerGlass();

        ItemStack allow = new ItemStack(permTrueItem);
        ItemMeta allowMeta = allow.getItemMeta();

        ItemStack deny = new ItemStack(permFalseItem);
        ItemMeta denyMeta = deny.getItemMeta();

        Player player = playerMenuUtility.getOwner();
        Chunk chunk = player.getLocation().getChunk();
        String chunkCord = plugin.getUtility().formatChunk(chunk);

        //chunk monster spawning
        if (plugin.getSqLite().canChunkSpawnMonsters(chunkCord)) {
            allowMeta.setDisplayName(Lang.ITEM_SETTINGS_MONSTER_SPAWNING_NAME.getConfigValue(new String[] { plugin.getUtility().format("&atrue") }));
            allow.setItemMeta(allowMeta);
            inventory.setItem(11, allow);
        } else {
            denyMeta.setDisplayName(Lang.ITEM_SETTINGS_MONSTER_SPAWNING_NAME.getConfigValue(new String[] { plugin.getUtility().format("&cfalse") }));
            deny.setItemMeta(denyMeta);
            inventory.setItem(11, deny);
        }

        //chunk pvp
        if (plugin.getSqLite().canChunkPVP(chunkCord)) {
            allowMeta.setDisplayName(Lang.ITEM_SETTINGS_PVP_NAME.getConfigValue(new String[] { plugin.getUtility().format("&atrue") }));
            allow.setItemMeta(allowMeta);
            inventory.setItem(13, allow);

        } else {
            denyMeta.setDisplayName(Lang.ITEM_SETTINGS_PVP_NAME.getConfigValue(new String[] { plugin.getUtility().format("&cfalse") }));
            deny.setItemMeta(denyMeta);
            inventory.setItem(13, deny);
        }

        //chunk explosions
        if (plugin.getSqLite().canChunkExplode(chunkCord)) {
            allowMeta.setDisplayName(Lang.ITEM_SETTINGS_EXPLOSIONS_NAME.getConfigValue(new String[] { plugin.getUtility().format("&atrue") }));
            allow.setItemMeta(allowMeta);
            inventory.setItem(15, allow);
        } else {
            denyMeta.setDisplayName(Lang.ITEM_SETTINGS_EXPLOSIONS_NAME.getConfigValue(new String[] { plugin.getUtility().format("&cfalse") }));
            deny.setItemMeta(denyMeta);
            inventory.setItem(15, deny);
        }

        //back
        inventory.setItem(31, backItem);
    }

    private void updatePermItem(ItemStack item, int slot, Chunk chunk) {
        MyChunks plugin = MyChunks.getPlugin();
        String chunkCord = plugin.getUtility().formatChunk(chunk);
        ItemStack allow = new ItemStack(permTrueItem);
        ItemStack deny = new ItemStack(permFalseItem);
        ItemMeta allowMeta = allow.getItemMeta();
        ItemMeta denyMeta = deny.getItemMeta();

        //allow
        if (item.getType() != permTrueItem.getType()) {
            switch (slot) {
                case 11:
                    allowMeta.setDisplayName(Lang.ITEM_SETTINGS_MONSTER_SPAWNING_NAME.getConfigValue(new String[]{plugin.getUtility().format("&atrue")}));
                    allow.setItemMeta(allowMeta);
                    plugin.getSqLite().setChunkSpawnMonsters(chunkCord, 1);
                    inventory.setItem(slot, allow);
                    break;
                case 13:
                    allowMeta.setDisplayName(Lang.ITEM_SETTINGS_PVP_NAME.getConfigValue(new String[] { plugin.getUtility().format("&atrue") }));
                    allow.setItemMeta(allowMeta);
                    plugin.getSqLite().setChunkPVP(chunkCord, 1);
                    inventory.setItem(slot, allow);
                    break;
                case 15:
                    allowMeta.setDisplayName(Lang.ITEM_SETTINGS_EXPLOSIONS_NAME.getConfigValue(new String[]{plugin.getUtility().format("&atrue")}));
                    allow.setItemMeta(allowMeta);
                    plugin.getSqLite().setChunkExplosion(chunkCord, 1);
                    inventory.setItem(slot, allow);
                    break;
            }
            //deny
        } else if (item.getType() != permFalseItem.getType()) {

            switch (slot) {
                case 11:
                    denyMeta.setDisplayName(Lang.ITEM_SETTINGS_MONSTER_SPAWNING_NAME.getConfigValue(new String[]{plugin.getUtility().format("&cfalse")}));
                    deny.setItemMeta(denyMeta);
                    plugin.getSqLite().setChunkSpawnMonsters(chunkCord, 0);
                    inventory.setItem(slot, deny);
                    break;
                case 13:
                    denyMeta.setDisplayName(Lang.ITEM_SETTINGS_PVP_NAME.getConfigValue(new String[] { plugin.getUtility().format("&cfalse") }));
                    deny.setItemMeta(denyMeta);
                    plugin.getSqLite().setChunkPVP(chunkCord, 0);
                    inventory.setItem(slot, deny);
                    break;
                case 15:
                    denyMeta.setDisplayName(Lang.ITEM_SETTINGS_EXPLOSIONS_NAME.getConfigValue(new String[]{plugin.getUtility().format("&cfalse")}));
                    deny.setItemMeta(denyMeta);
                    plugin.getSqLite().setChunkExplosion(chunkCord, 0);
                    inventory.setItem(slot, deny);
                    break;
            }
        }
    }
}
