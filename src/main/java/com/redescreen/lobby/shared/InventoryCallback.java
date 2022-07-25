package com.redescreen.lobby.shared;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryCallback {

    public static void inventoryCallback(InventoryClickEvent e) {
        ItemStack ArrowReturn = new ItemStack(Material.ARROW);
        ItemMeta ArrowReturnMeta = ArrowReturn.getItemMeta();

        // TODO Terminar a criação da função compartilhada de maneira global para voltar para o inventário anterior.
    }
}
