package com.redescreen.lobby.inventory.collectibles;

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

public class CollectiblesInventory {

    public static void openCollectiblesInventory(Player player) {
        ConfigurationSection collectiblesMenu = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Collectibles");
        ConfigurationSection wingsCollectibles = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Collectibles.Categories.Wings");
        ConfigurationSection effectsCollectibles = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Collectibles.Categories.Effects");
        ConfigurationSection clothesCollectibles = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Collectibles.Categories.Clothes");

        Inventory i = Bukkit.createInventory(null, collectiblesMenu.getInt("inventory-slots"), collectiblesMenu.getString("inventory-name"));

        ItemStack Wings = new ItemStack(Material.FEATHER);
        ItemMeta WingsMeta = Wings.getItemMeta();
        ItemStack Effects = new ItemStack(Material.BLAZE_POWDER);
        ItemMeta EffectsMeta = Effects.getItemMeta();
        ItemStack Clothes = new ItemStack(Material.ARMOR_STAND);
        ItemMeta ClothesMeta = Clothes.getItemMeta();

        //

        String wingsDisplayName = wingsCollectibles.getString("display-name").replace("&", "§");
        WingsMeta.setDisplayName(wingsDisplayName);
        List<String> wingsLore = new ArrayList<>();
        for (String all : wingsCollectibles.getStringList("lore")) {
            wingsLore.add(ChatColor.translateAlternateColorCodes('&', all));
        }
        WingsMeta.setLore(wingsLore);
        Wings.setItemMeta(WingsMeta);

        //

        String effectsDisplayName = effectsCollectibles.getString("display-name").replace("&", "§");
        EffectsMeta.setDisplayName(effectsDisplayName);
        List<String> effectsLore = new ArrayList<>();
        for (String all : effectsCollectibles.getStringList("lore")) {
            effectsLore.add(ChatColor.translateAlternateColorCodes('&', all));
        }
        EffectsMeta.setLore(effectsLore);
        Effects.setItemMeta(EffectsMeta);

        //

        String clothesDisplayName = clothesCollectibles.getString("display-name").replace("&", "§");
        ClothesMeta.setDisplayName(clothesDisplayName);
        List<String> clothesLore = new ArrayList<>();
        for (String all : clothesCollectibles.getStringList("lore")) {
            clothesLore.add(ChatColor.translateAlternateColorCodes('&', all));
        }
        ClothesMeta.setLore(clothesLore);
        Clothes.setItemMeta(ClothesMeta);

        i.setItem(11, Wings);
        i.setItem(13, Effects);
        i.setItem(15, Clothes);

        player.openInventory(i);
    }
}
