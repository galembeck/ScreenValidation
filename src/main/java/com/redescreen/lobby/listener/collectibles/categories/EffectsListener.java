package com.redescreen.lobby.listener.collectibles.categories;

import com.redescreen.lobby.ScreenLobbyPlugin;
import com.redescreen.lobby.inventory.collectibles.CollectiblesInventory;
import com.redescreen.lobby.inventory.collectibles.categories.EffectsInventory;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class EffectsListener implements Listener {

    @EventHandler
    public void wingsMenuClickEvent(InventoryClickEvent e) {
        ConfigurationSection effectsCategoryMenu = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Collectibles.Categories.Effects");

        if (!e.getInventory().getName().equalsIgnoreCase(effectsCategoryMenu.getString("inventory-name").replace("&", "§")))
            return;

        Player player = (Player) e.getWhoClicked();
        e.setCancelled(true);

        if (e.getCurrentItem() == null) {
            return;
        } else {
            switch (e.getCurrentItem().getType()) {
                case ARROW:
                    CollectiblesInventory.openCollectiblesInventory(player);
                    break;
            }
        }
    }
}
