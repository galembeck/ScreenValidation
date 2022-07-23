package com.redescreen.lobby;

import com.redescreen.lobby.listener.collectibles.CollectiblesListener;
import com.redescreen.lobby.listener.inventory.InventoryListener;
import com.redescreen.lobby.listener.player.JoinListener;
import com.redescreen.lobby.listener.collectibles.categories.WingsListener;
import com.redescreen.lobby.listener.serverselector.SelectorListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class ScreenLobbyPlugin extends JavaPlugin {

    public static ScreenLobbyPlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;

        registerEvents();

        if (!new File(getDataFolder(), "config.yml").exists())
            saveDefaultConfig();
    }

    public void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new CollectiblesListener(), this);
        pm.registerEvents(new InventoryListener(), this);
        pm.registerEvents(new WingsListener(), this);
        pm.registerEvents(new SelectorListener(), this);
    }
}
