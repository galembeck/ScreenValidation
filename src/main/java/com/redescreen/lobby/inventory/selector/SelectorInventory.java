package com.redescreen.lobby.inventory.selector;

import com.redescreen.lobby.ScreenLobbyPlugin;
import com.redescreen.lobby.util.SkullUtil;
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

public class SelectorInventory {

    public static void openSelectorInventory(Player player) {
        ConfigurationSection selectorMenu = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Selector");

        ConfigurationSection donationOption = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Selector.Options.Donation");
        ConfigurationSection overpowerOption = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Selector.Options.Overpower");
        ConfigurationSection prisonAquaOption = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Selector.Options.PrisonAqua");
        ConfigurationSection factionsOption = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Selector.Options.Factions");
        ConfigurationSection clickerTycoonOption = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Selector.Options.ClickerTycoon");
        ConfigurationSection soonOption = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Selector.Options.Soon");
        ConfigurationSection twitterOption = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Selector.Options.Twitter");
        ConfigurationSection discordOption = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Selector.Options.Discord");
        ConfigurationSection youtubeOption = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Selector.Options.YouTube");

        Inventory i = Bukkit.createInventory(null, selectorMenu.getInt("inventory-slots"), selectorMenu.getString("inventory-name"));

        ItemStack Donation = new ItemStack(Material.GOLD_INGOT);
        ItemMeta DonationMeta = Donation.getItemMeta();
        ItemStack Overpower = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta OverpowerMeta = Overpower.getItemMeta();
        ItemStack PrisonAqua = new ItemStack(Material.WATER_BUCKET);
        ItemMeta PrisonAquaMeta = PrisonAqua.getItemMeta();
        ItemStack Factions = new ItemStack(Material.OBSIDIAN);
        ItemMeta FactionsMeta = Factions.getItemMeta();
        ItemStack ClickerTycoon = new ItemStack(Material.REDSTONE);
        ItemMeta ClickerTycoonMeta = ClickerTycoon.getItemMeta();
        ItemStack Soon = new ItemStack(Material.WEB);
        ItemMeta SoonMeta = Soon.getItemMeta();

        ItemStack Twitter = SkullUtil.getCustomSkull("https://textures.minecraft.net/texture/6ad46a422ae59603fd889c25344ff67bc843af8ee518932c2e2ad07cdbf939b3");
        ItemMeta TwitterMeta = Twitter.getItemMeta();
        ItemStack Discord = SkullUtil.getCustomSkull("https://textures.minecraft.net/texture/dc59e5c7b0738b579f3b444c13a47bed496b30838b2ee2b127cc59cd798aee77");
        ItemMeta DiscordMeta = Discord.getItemMeta();
        ItemStack Youtube = SkullUtil.getCustomSkull("https://textures.minecraft.net/texture/cecd041f628c005a690fc6b8237e7311bb7c3b3aac10539fefe396a4c7c783e7");
        ItemMeta YoutubeMeta = Youtube.getItemMeta();


        String donationDisplayName = donationOption.getString("display-name").replace("&", "§");
        DonationMeta.setDisplayName(donationDisplayName);
        List<String> donationLore = new ArrayList<>();
        for (String all : donationOption.getStringList("lore")) {
            donationLore.add(ChatColor.translateAlternateColorCodes('&', all));
        }
        DonationMeta.setLore(donationLore);
        Donation.setItemMeta(DonationMeta);


        String overpowerDisplayName = overpowerOption.getString("display-name").replace("&", "§");
        OverpowerMeta.setDisplayName(overpowerDisplayName);
        List<String> overpowerLore = new ArrayList<>();
        for (String all : overpowerOption.getStringList("lore")) {
            overpowerLore.add(ChatColor.translateAlternateColorCodes('&', all).replace("^", "➜").replace("*", "➟"));
        }
        OverpowerMeta.setLore(overpowerLore);
        Overpower.setItemMeta(OverpowerMeta);


        String prisonAquaDisplayName = prisonAquaOption.getString("display-name").replace("&", "§");
        PrisonAquaMeta.setDisplayName(prisonAquaDisplayName);
        List<String> prisonAquaLore = new ArrayList<>();
        for (String all : prisonAquaOption.getStringList("lore")) {
            prisonAquaLore.add(ChatColor.translateAlternateColorCodes('&', all).replace("*", "➟"));
        }
        PrisonAquaMeta.setLore(prisonAquaLore);
        PrisonAqua.setItemMeta(PrisonAquaMeta);


        String factionsDisplayName = factionsOption.getString("display-name").replace("&", "§");
        FactionsMeta.setDisplayName(factionsDisplayName);
        List<String> factionsLore = new ArrayList<>();
        for (String all : factionsOption.getStringList("lore")) {
            factionsLore.add(ChatColor.translateAlternateColorCodes('&', all).replace("*", "➟"));
        }
        FactionsMeta.setLore(factionsLore);
        Factions.setItemMeta(FactionsMeta);


        String clickerTycoonDisplayName = clickerTycoonOption.getString("display-name").replace("&", "§");
        ClickerTycoonMeta.setDisplayName(clickerTycoonDisplayName);
        List<String> clickerTycoonLore = new ArrayList<>();
        for (String all : clickerTycoonOption.getStringList("lore")) {
            clickerTycoonLore.add(ChatColor.translateAlternateColorCodes('&', all).replace("*", "➟"));
        }
        ClickerTycoonMeta.setLore(clickerTycoonLore);
        ClickerTycoon.setItemMeta(ClickerTycoonMeta);


        String soonDisplayName = soonOption.getString("display-name").replace("&", "§");
        SoonMeta.setDisplayName(soonDisplayName);
        List<String> soonLore = new ArrayList<>();
        for (String all : soonOption.getStringList("lore")) {
            soonLore.add(ChatColor.translateAlternateColorCodes('&', all).replace("*", "➟"));
        }
        SoonMeta.setLore(soonLore);
        Soon.setItemMeta(SoonMeta);


        String twitterDisplayName = twitterOption.getString("display-name").replace("&", "§");
        TwitterMeta.setDisplayName(twitterDisplayName);
        List<String> twitterLore = new ArrayList<>();
        for (String all : twitterOption.getStringList("lore")) {
            twitterLore.add(ChatColor.translateAlternateColorCodes('&', all));
        }
        TwitterMeta.setLore(twitterLore);
        Twitter.setItemMeta(TwitterMeta);


        String discordDisplayName = discordOption.getString("display-name").replace("&", "§");
        DiscordMeta.setDisplayName(discordDisplayName);
        List<String> discordLore = new ArrayList<>();
        for (String all : discordOption.getStringList("lore")) {
            discordLore.add(ChatColor.translateAlternateColorCodes('&', all));
        }
        DiscordMeta.setLore(discordLore);
        Discord.setItemMeta(DiscordMeta);


        String youtubeDisplayName = youtubeOption.getString("display-name").replace("&", "§");
        YoutubeMeta.setDisplayName(youtubeDisplayName);
        List<String> youtubeLore = new ArrayList<>();
        for (String all : youtubeOption.getStringList("lore")) {
            youtubeLore.add(ChatColor.translateAlternateColorCodes('&', all));
        }
        YoutubeMeta.setLore(youtubeLore);
        Youtube.setItemMeta(YoutubeMeta);


        i.setItem(10, Donation);
        i.setItem(12, Overpower);
        i.setItem(13, PrisonAqua);
        i.setItem(14, Factions);
        i.setItem(15, ClickerTycoon);
        i.setItem(16, Soon);
        i.setItem(30, Twitter);
        i.setItem(31, Discord);
        i.setItem(32, Youtube);

        player.openInventory(i);
    }
}
