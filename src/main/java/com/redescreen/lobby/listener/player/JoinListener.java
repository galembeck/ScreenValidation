package com.redescreen.lobby.listener.player;

import com.redescreen.lobby.ScreenLobbyPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class JoinListener implements Listener {

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent e) {
        ConfigurationSection collectiblesMenu = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Collectibles.interact-item");
        ConfigurationSection selectorMenu = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Selector.interact-item");

        ItemStack CollectiblesMenuItem = new ItemStack(Material.RAW_FISH, 1, (short) 3);
        ItemMeta CollectiblesMenuItemMeta = CollectiblesMenuItem.getItemMeta();

        String collectiblesMenuItemDisplayName = collectiblesMenu.getString("display-name").replace("&", "§");
        CollectiblesMenuItemMeta.setDisplayName(collectiblesMenuItemDisplayName);
        List<String> collectiblesMenuItemLore = new ArrayList<>();
        for (String all : collectiblesMenu.getStringList("lore")) {
            collectiblesMenuItemLore.add(ChatColor.translateAlternateColorCodes('&', all));
        }
        CollectiblesMenuItemMeta.setLore(collectiblesMenuItemLore);
        CollectiblesMenuItem.setItemMeta(CollectiblesMenuItemMeta);


        ItemStack ServerSelectorMenuItem = new ItemStack(Material.COMPASS, 1);
        ItemMeta ServerSelectorMenuItemMeta = ServerSelectorMenuItem.getItemMeta();

        String serverSelectorMenuItemDisplayName = selectorMenu.getString("display-name").replace("&", "§");
        ServerSelectorMenuItemMeta.setDisplayName(serverSelectorMenuItemDisplayName);
        List<String> serverSelectorMenuItemLore = new ArrayList<>();
        for (String all : selectorMenu.getStringList("lore")) {
            serverSelectorMenuItemLore.add(ChatColor.translateAlternateColorCodes('&', all));
        }
        ServerSelectorMenuItemMeta.setLore(serverSelectorMenuItemLore);
        ServerSelectorMenuItem.setItemMeta(ServerSelectorMenuItemMeta);


        e.getPlayer().getInventory().clear();

        e.getPlayer().getInventory().setItem(1, CollectiblesMenuItem);
        e.getPlayer().getInventory().setItem(5, ServerSelectorMenuItem);
    }
}
