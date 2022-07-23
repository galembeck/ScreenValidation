package com.redescreen.lobby.inventory.collectibles.categories;

import com.redescreen.lobby.ScreenLobbyPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class EffectsInventory {

    public static void openEffectsInventory(Player player) {
        ConfigurationSection inventorySlots = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Collectibles.Categories");
        ConfigurationSection effectsCategoryMenu = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Collectibles.Categories.Effects");
        ConfigurationSection empty = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Collectibles.Categories.Effects.empty");

        Inventory i = Bukkit.createInventory(null, inventorySlots.getInt("inventory-slots"), effectsCategoryMenu.getString("inventory-name"));

        ItemStack Empty = new ItemStack(Material.WEB);
        ItemMeta EmptyMeta = Empty.getItemMeta();


        String emptyDisplayName = empty.getString("display-name").replace("&", "§");
        EmptyMeta.setDisplayName(emptyDisplayName);
        List<String> emptyLore = new ArrayList<>();
        for (String all : empty.getStringList("lore")) {
            emptyLore.add(ChatColor.translateAlternateColorCodes('&', all));
        }
        EmptyMeta.setLore(emptyLore);
        Empty.setItemMeta(EmptyMeta);


        i.setItem(22, Empty);

        player.openInventory(i);
    }
}
