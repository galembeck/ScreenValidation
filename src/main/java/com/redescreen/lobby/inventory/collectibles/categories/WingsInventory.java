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

public class WingsInventory {

    public static void openWingsInventory(Player player) {
        ConfigurationSection inventorySlots = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Collectibles.Categories");
        ConfigurationSection wingsCategoryMenu = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Collectibles.Categories.Wings");
        ConfigurationSection angelWings = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Collectibles.Categories.Wings.angel-wings");
        ConfigurationSection flameWings = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Collectibles.Categories.Wings.flame-wings");

        ConfigurationSection returnArrow = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Collectibles.Return");

        Inventory i = Bukkit.createInventory(null, inventorySlots.getInt("inventory-slots"), wingsCategoryMenu.getString("inventory-name"));

        ItemStack AngelWings = new ItemStack(Material.FEATHER);
        ItemMeta AngelWingsMeta = AngelWings.getItemMeta();

        ItemStack FlameWings = new ItemStack(Material.BLAZE_ROD);
        ItemMeta FlameWingsMeta = FlameWings.getItemMeta();

        ItemStack ReturnArrow = new ItemStack(Material.ARROW);
        ItemMeta ReturnArrowMeta = ReturnArrow.getItemMeta();


        String angelWingsDisplayName = angelWings.getString("unequipped-display-name").replace("&", "§");
        AngelWingsMeta.setDisplayName(angelWingsDisplayName);
        List<String> angelWingsLore = new ArrayList<>();
        if (!player.hasPermission("screen.*")) {
            for (String all : angelWings.getStringList("no-permission-lore")) {
                angelWingsLore.add(ChatColor.translateAlternateColorCodes('&', all));
            }
        } else {
            for (String all : angelWings.getStringList("permission-lore")) {
                angelWingsLore.add(ChatColor.translateAlternateColorCodes('&', all));
            }
        }
        AngelWingsMeta.setLore(angelWingsLore);
        AngelWings.setItemMeta(AngelWingsMeta);


        String flameWingsDisplayName = flameWings.getString("unequipped-display-name").replace("&", "§");
        FlameWingsMeta.setDisplayName(flameWingsDisplayName);
        List<String> flameWingsLore = new ArrayList<>();
        if (!player.hasPermission("screen.*")) {
            for (String all : flameWings.getStringList("no-permission-lore")) {
                flameWingsLore.add(ChatColor.translateAlternateColorCodes('&', all));
            }
        } else {
            for (String all : flameWings.getStringList("permission-lore")) {
                flameWingsLore.add(ChatColor.translateAlternateColorCodes('&', all));
            }
        }
        FlameWingsMeta.setLore(flameWingsLore);
        FlameWings.setItemMeta(FlameWingsMeta);

        String returnArrowDisplayName = returnArrow.getString("display-name").replace("&", "§");
        ReturnArrowMeta.setDisplayName(returnArrowDisplayName);
        ReturnArrow.setItemMeta(ReturnArrowMeta);

        i.setItem(11, AngelWings);
        i.setItem(12, FlameWings);
        i.setItem(40, ReturnArrow);

        player.openInventory(i);
    }
}
