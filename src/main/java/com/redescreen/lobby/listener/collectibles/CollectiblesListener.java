package com.redescreen.lobby.listener.collectibles;

import com.redescreen.lobby.ScreenLobbyPlugin;
import com.redescreen.lobby.inventory.collectibles.CollectiblesInventory;
import com.redescreen.lobby.inventory.collectibles.categories.ClothesInventory;
import com.redescreen.lobby.inventory.collectibles.categories.EffectsInventory;
import com.redescreen.lobby.inventory.collectibles.categories.WingsInventory;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class CollectiblesListener implements Listener {

    ConfigurationSection collectiblesMenu = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Collectibles");

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Action a = e.getAction();
        if (a == Action.PHYSICAL || e.getItem() == null || e.getItem().getType() == Material.AIR) return;

        if (e.getItem().getType() == Material.RAW_FISH) {
            CollectiblesInventory.openCollectiblesInventory(e.getPlayer());
        }
    }

    @EventHandler
    public void collectiblesMenuClickEvent(InventoryClickEvent e) {
        if (!e.getInventory().getName().equalsIgnoreCase(collectiblesMenu.getString("inventory-name"))) return;

        Player player = (Player) e.getWhoClicked();
        e.setCancelled(true);

        if (e.getCurrentItem() == null) {
            return;
        } else {
            switch (e.getCurrentItem().getType()) {
                case FEATHER:
                    WingsInventory.openWingsInventory(player);
                    break;
                case BLAZE_POWDER:
                    EffectsInventory.openEffectsInventory(player);
                    break;
                case ARMOR_STAND:
                    ClothesInventory.openClothesInventory(player);
                    break;
            }
        }
    }

    @EventHandler
    public void onDropEvent(PlayerDropItemEvent e) {
        Player player = e.getPlayer();
        int slot = 1;
        if (player.getInventory().getHeldItemSlot() == slot) {
            e.setCancelled(true);
        }
    }
}
