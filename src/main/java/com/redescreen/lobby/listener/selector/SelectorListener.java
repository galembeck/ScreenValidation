package com.redescreen.lobby.listener.selector;

import com.redescreen.lobby.ScreenLobbyPlugin;
import com.redescreen.lobby.inventory.selector.SelectorInventory;
import net.md_5.bungee.api.chat.*;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class SelectorListener implements Listener {

    ConfigurationSection selectorMenu = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Selector");

    ConfigurationSection donationOption = ScreenLobbyPlugin.plugin.getConfig().getConfigurationSection("Messages.Inventories.Selector.Options.Donation.click-event");

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Action a = e.getAction();
        if (a == Action.PHYSICAL || e.getItem() == null || e.getItem().getType() == Material.AIR) return;

        if (e.getItem().getType() == Material.COMPASS) {
            SelectorInventory.openSelectorInventory(e.getPlayer());
        }
    }

    @EventHandler
    public void selectorMenuClickEvent(InventoryClickEvent e) {
        if (!e.getInventory().getName().equalsIgnoreCase(selectorMenu.getString("inventory-name"))) return;

        Player player = (Player) e.getWhoClicked();
        e.setCancelled(true);

        if (e.getCurrentItem() == null) {
            return;
        } else {
            switch (e.getCurrentItem().getType()) {
                case GOLD_INGOT:
                    TextComponent donationComponent = new TextComponent(donationOption.getString("text-component").replace("&", "§"));
                    BaseComponent[] donationComponentBuilder = new ComponentBuilder(donationOption.getString("component-builder").replace("&", "§")).create();
                    HoverEvent donationHoverEvent = new HoverEvent(HoverEvent.Action.SHOW_TEXT, donationComponentBuilder);
                    donationComponent.setHoverEvent(donationHoverEvent);
                    ClickEvent donationAction = new ClickEvent(ClickEvent.Action.OPEN_URL, donationOption.getString("url"));
                    donationComponent.setClickEvent(donationAction);
                    player.spigot().sendMessage(donationComponent);
                    player.closeInventory();
                    break;
                case DIAMOND_PICKAXE:
                case WATER_BUCKET:
                case OBSIDIAN:
                case REDSTONE:
                case WEB:
                    player.sendMessage("§cExpulso ao tentar se conectar ao servidor (em manutenção)...");
                    player.closeInventory();
                    break;
                    // TODO Terminar de adicionar as funções de Twitter, Discord e YouTube...
            }
        }
    }

    @EventHandler
    public void onDropEvent(PlayerDropItemEvent e) {
        Player player = e.getPlayer();
        int slot = 5;
        if (player.getInventory().getHeldItemSlot() == slot) {
            e.setCancelled(true);
        }
    }
}
