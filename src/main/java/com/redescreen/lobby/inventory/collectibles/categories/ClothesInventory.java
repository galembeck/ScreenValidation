package com.redescreen.lobby.inventory.collectibles.categories;

import com.redescreen.lobby.ScreenLobbyPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ClothesInventory {

    public static void openClothesInventory(Player player) {
        ConfigurationSection inventorySlots = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Collectibles.Categories");
        ConfigurationSection clothesCategoryMenu = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Collectibles.Categories.Clothes");
        ConfigurationSection empty = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Collectibles.Categories.Clothes.empty");

        ConfigurationSection arrowReturn = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Collectibles.Return");

        Inventory i = Bukkit.createInventory(null, inventorySlots.getInt("inventory-slots"), clothesCategoryMenu.getString("inventory-name"));

        ItemStack Empty = new ItemStack(Material.WEB);
        ItemMeta EmptyMeta = Empty.getItemMeta();

        ItemStack ArrowReturn = new ItemStack(Material.ARROW);
        ItemMeta ArrowReturnMeta = Empty.getItemMeta();


        String emptyDisplayName = empty.getString("display-name").replace("&", "§");
        EmptyMeta.setDisplayName(emptyDisplayName);
        List<String> emptyLore = new ArrayList<>();
        for (String all : empty.getStringList("lore")) {
            emptyLore.add(ChatColor.translateAlternateColorCodes('&', all));
        }
        EmptyMeta.setLore(emptyLore);
        Empty.setItemMeta(EmptyMeta);


        String arrowReturnDisplayName = arrowReturn.getString("display-name").replace("&", "§");
        ArrowReturnMeta.setDisplayName(arrowReturnDisplayName);
        ArrowReturn.setItemMeta(ArrowReturnMeta);


        i.setItem(22, Empty);
        i.setItem(40, ArrowReturn);

        player.openInventory(i);
    }
}
