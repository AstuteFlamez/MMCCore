package mandomc.mmccore.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class VillagersDisabled implements Listener {

    @EventHandler
    public void villagerInteract(PlayerInteractEntityEvent event) {
        Entity entity = event.getRightClicked();
        if (entity instanceof Villager) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "Villagers are disabled!");
        }
    }
}
