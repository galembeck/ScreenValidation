package com.redescreen.lobby.shared.inventory;

import com.redescreen.lobby.inventory.collectibles.categories.ClothesInventory;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PreviousInventory {

    public static void previousInventory(InventoryClickEvent e) {
        ItemStack ArrowReturn = new ItemStack(Material.ARROW);
        ItemMeta ArrowReturnMeta = ArrowReturn.getItemMeta();

        // TODO Terminar a criação da função compartilhada de maneira global para voltar para o inventário anterior.
    }
}
