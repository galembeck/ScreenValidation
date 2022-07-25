package com.redescreen.lobby.listener.player;

import com.redescreen.lobby.ScreenLobbyPlugin;
import com.redescreen.lobby.util.SkullUtil;
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
        ConfigurationSection playersCombatItem = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Items.Players-Combat.interact-item");
        ConfigurationSection playersVisibilityItem = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Items.Players-Visibility.interact-item");

        ItemStack CollectiblesMenuItem = new ItemStack(Material.RAW_FISH, 1, (short) 3);
        ItemMeta CollectiblesMenuItemMeta = CollectiblesMenuItem.getItemMeta();
        ItemStack SelectorMenuItem = new ItemStack(Material.COMPASS, 1);
        ItemMeta SelectorMenuItemMeta = SelectorMenuItem.getItemMeta();
        ItemStack PlayersCombatItem = new ItemStack(Material.WOOD_SWORD, 1);
        ItemMeta PlayersCombatItemMeta = PlayersCombatItem.getItemMeta();
        ItemStack PlayersVisibilityItem = SkullUtil.getCustomSkull("https://textures.minecraft.net/texture/a7695f96dda626faaa010f4a5f28a53cd66f77de0cc280e7c5825ad65eedc72e");
        ItemMeta PlayersVisibilityItemMeta = PlayersVisibilityItem.getItemMeta();


        String collectiblesMenuItemDisplayName = collectiblesMenu.getString("display-name").replace("&", "§");
        CollectiblesMenuItemMeta.setDisplayName(collectiblesMenuItemDisplayName);
        List<String> collectiblesMenuItemLore = new ArrayList<>();
        for (String all : collectiblesMenu.getStringList("lore")) {
            collectiblesMenuItemLore.add(ChatColor.translateAlternateColorCodes('&', all));
        }
        CollectiblesMenuItemMeta.setLore(collectiblesMenuItemLore);
        CollectiblesMenuItem.setItemMeta(CollectiblesMenuItemMeta);


        String selectorMenuItemDisplayName = selectorMenu.getString("display-name").replace("&", "§");
        SelectorMenuItemMeta.setDisplayName(selectorMenuItemDisplayName);
        List<String> selectorMenuItemLore = new ArrayList<>();
        for (String all : selectorMenu.getStringList("lore")) {
            selectorMenuItemLore.add(ChatColor.translateAlternateColorCodes('&', all));
        }
        SelectorMenuItemMeta.setLore(selectorMenuItemLore);
        SelectorMenuItem.setItemMeta(SelectorMenuItemMeta);


        String playersCombatItemDisplayName = playersCombatItem.getString("display-name").replace("&", "§");
        PlayersCombatItemMeta.setDisplayName(playersCombatItemDisplayName);
        List<String> playersCombatItemLore = new ArrayList<>();
        for (String all : playersCombatItem.getStringList("lore")) {
            playersCombatItemLore.add(ChatColor.translateAlternateColorCodes('&', all));
        }
        PlayersCombatItemMeta.setLore(playersCombatItemLore);
        PlayersCombatItem.setItemMeta(PlayersCombatItemMeta);


        String playersVisibilityItemDisplayName = playersVisibilityItem.getString("display-name").replace("&", "§");
        PlayersVisibilityItemMeta.setDisplayName(playersVisibilityItemDisplayName);
        PlayersVisibilityItem.setItemMeta(PlayersVisibilityItemMeta);


        e.getPlayer().getInventory().clear();

        e.getPlayer().getInventory().setItem(1, CollectiblesMenuItem);
        e.getPlayer().getInventory().setItem(3, PlayersCombatItem);
        e.getPlayer().getInventory().setItem(5, SelectorMenuItem);
        e.getPlayer().getInventory().setItem(7, PlayersVisibilityItem);
    }
}
