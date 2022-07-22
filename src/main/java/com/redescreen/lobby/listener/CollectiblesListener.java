package com.redescreen.lobby.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CollectiblesListener implements Listener {

    // TODO Adicionar função de verificação da posse do item pelo jogador para evitar entregar mais itens ao entrar no servidor.
    // TODO Trocar as funcionalidades possíveis por arquivos de configuração.

    private void openCollectiblesMenu(Player player) {
        Inventory i = Bukkit.createInventory(null, 27, "Colecionáveis");

        ItemStack Wings = new ItemStack(Material.FEATHER);
        ItemMeta WingsMeta = Wings.getItemMeta();
        ItemStack Effects = new ItemStack(Material.BLAZE_POWDER);
        ItemMeta EffectsMeta = Effects.getItemMeta();
        ItemStack Clothes = new ItemStack(Material.ARMOR_STAND);
        ItemMeta ClothesMeta = Clothes.getItemMeta();

        WingsMeta.setDisplayName("§6Asas");
        Wings.setItemMeta(WingsMeta);
        EffectsMeta.setDisplayName("§6Efeitos");
        Effects.setItemMeta(EffectsMeta);
        ClothesMeta.setDisplayName("§6Roupas");
        Clothes.setItemMeta(ClothesMeta);

        i.setItem(11, Wings);
        i.setItem(13, Effects);
        i.setItem(15, Clothes);

        player.openInventory(i);
    }

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent e) {
        if (!e.getInventory().getName().equalsIgnoreCase("Colecionáveis")) return;

        Player player = (Player) e.getWhoClicked();
        e.setCancelled(true);

//        if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR || !e.getCurrentItem().hasItemMeta()) {
//            player.closeInventory();
//            return;
//        }
        switch (e.getCurrentItem().getType()) {
            case FEATHER:
            case BLAZE_POWDER:
            case ARMOR_STAND:
                player.sendMessage("§aEm breve...");
                player.closeInventory();
                break;
        }
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent e) {
        e.getPlayer().getInventory().addItem(new ItemStack(Material.RAW_FISH, 1, (short) 3));
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Action a = e.getAction();
        if (a == Action.PHYSICAL || e.getItem() == null || e.getItem().getType() == Material.AIR) return;

        if (e.getItem().getType() == Material.RAW_FISH) {
            openCollectiblesMenu(e.getPlayer());
        }
    }
}
