package com.redescreen.lobby.listener.collectibles.categories;

import com.redescreen.lobby.ScreenLobbyPlugin;
import org.bukkit.Sound;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class WingsListener implements Listener {

    ConfigurationSection wingsCategoryMenu = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Collectibles.Categories.Wings");

    @EventHandler
    public void wingsMenuClickEvent(InventoryClickEvent e) {
        if (!e.getInventory().getName().equalsIgnoreCase(wingsCategoryMenu.getString("inventory-name").replace("&", "§"))) return;

        Player player = (Player) e.getWhoClicked();
        e.setCancelled(true);

        if (e.getCurrentItem() == null) {
            return;
        } else {
            switch (e.getCurrentItem().getType()) {
                case FEATHER:
                case BLAZE_ROD:
                    if (!player.hasPermission("screen.*")) {
                        player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
                    } else {
                        player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
                        player.sendMessage("§aEm breve...");
                    }
                    break;
                // TODO Adicionar efeitos e sistema de colecionáveis (asas de anjo e flamejantes)...
            }
        }
    }
}
