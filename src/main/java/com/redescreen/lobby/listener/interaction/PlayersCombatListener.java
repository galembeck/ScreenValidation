package com.redescreen.lobby.listener.interaction;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class PlayersCombatListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Action a = e.getAction();
        if (a == Action.PHYSICAL || e.getItem() == null || e.getItem().getType() == Material.AIR) return;

        if (e.getPlayer().getInventory().getHeldItemSlot() == 3) {
            Player player = e.getPlayer();
            PlayerInventory pI = player.getInventory();

            PermissionUser user = PermissionsEx.getUser(player);
            String prefix = user.getPrefix("RegistrationWorld").replace("&", "§");

            e.getPlayer().sendMessage(prefix + e.getPlayer().getName() + " §fentrou no modo combate!");

            ItemStack WoodSword = new ItemStack(Material.WOOD_SWORD, 1);
            ItemStack GoldenApple = new ItemStack(Material.GOLDEN_APPLE, 2);
            ItemStack IronChestplate = new ItemStack(Material.IRON_CHESTPLATE);

            pI.clear();
            pI.setItem(0, WoodSword);
            pI.setItem(1, GoldenApple);
            pI.setArmorContents(null);
            pI.setChestplate(IronChestplate);
        }
    }

    @EventHandler
    public void onDropEvent(PlayerDropItemEvent e) {
        Player player = e.getPlayer();
        int slot = 0;
        if (player.getInventory().getHeldItemSlot() == slot) {
            e.setCancelled(true);
        }
    }
}
