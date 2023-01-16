package mandomc.mmccore.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class Pearls implements Listener {

    @EventHandler
    public void onTeleport(PlayerTeleportEvent event){
        if (event.getCause() == PlayerTeleportEvent.TeleportCause.ENDER_PEARL){
            Player player = event.getPlayer();
            if(!player.hasPermission("mmc.enderpearls")){
                event.setCancelled(true);
                player.sendMessage(ChatColor.RED + "Enderpearls are disabled!");
            }
        }
    }
}
