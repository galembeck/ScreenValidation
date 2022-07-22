package com.redescreen.lobby;

import com.redescreen.lobby.listener.CollectiblesListener;
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
        pm.registerEvents(new CollectiblesListener(), this);
    }
}
