package mandomc.mmccore.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.BrewEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class ListenerSpam implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent event){
        Player player = event.getPlayer();
        Block block = event.getBlockPlaced();
        Material type = block.getType();
        if(type == Material.END_CRYSTAL || type == Material.END_PORTAL_FRAME || type == Material.BEDROCK){
                event.setCancelled(true);
                player.sendMessage(ChatColor.RED + "This block is banned from being used!");
        }
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event){
        Player player = event.getPlayer();

        if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(player.getItemInUse() != null){
                if(player.getItemInUse().getType() == Material.MUSIC_DISC_13 || player.getItemInUse().getType() == Material.MUSIC_DISC_CAT || player.getItemInUse().getType() == Material.MUSIC_DISC_BLOCKS || player.getItemInUse().getType() == Material.MUSIC_DISC_CHIRP || player.getItemInUse().getType() == Material.MUSIC_DISC_FAR || player.getItemInUse().getType() == Material.MUSIC_DISC_MALL || player.getItemInUse().getType() == Material.MUSIC_DISC_MELLOHI || player.getItemInUse().getType() == Material.MUSIC_DISC_STAL || player.getItemInUse().getType() == Material.MUSIC_DISC_STRAD || player.getItemInUse().getType() == Material.MUSIC_DISC_WARD || player.getItemInUse().getType() == Material.MUSIC_DISC_11 || player.getItemInUse().getType() == Material.MUSIC_DISC_WAIT || player.getItemInUse().getType() == Material.MUSIC_DISC_OTHERSIDE || player.getItemInUse().getType() == Material.MUSIC_DISC_5 || player.getItemInUse().getType() == Material.MUSIC_DISC_PIGSTEP){
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.RED + "This feature is temporarily disabled!");
                }
            }
        }
    }

    @EventHandler
    public void onEntityClick(PlayerInteractEntityEvent event){

        if(event.getRightClicked().getType() == EntityType.ENDER_CRYSTAL){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void brew(BrewEvent event){
        event.setCancelled(true);
    }

    @EventHandler
    public void onSpawn(CreatureSpawnEvent event){
        if(event.getEntity() instanceof Phantom){
            if(event.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.NATURAL)){
                event.setCancelled(true);
            }
        }
    }

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

    @EventHandler
    public void villagerInteract(PlayerInteractEntityEvent event) {
        Entity entity = event.getRightClicked();
        if (entity instanceof Villager) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "Villagers are disabled!");
        }
    }

    @EventHandler
    public void damage(EntityDamageEvent event){

        if(event.getEntity().getType() == EntityType.ENDER_CRYSTAL){
            event.setCancelled(true);
        }
    }
}
