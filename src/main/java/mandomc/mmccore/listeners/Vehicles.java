package mandomc.mmccore.listeners;

import mandomc.mmccore.vehicles.TieFighter;
import mandomc.mmccore.vehicles.Vehicle;
import mandomc.mmccore.vehicles.XWing;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

import java.util.ArrayList;

public class Vehicles implements Listener {

    public static ArrayList<Entity> entitiesInShip = new ArrayList<>();
    public static ArrayList<Player> playersInShip = new ArrayList<>();
    public static ArrayList<Entity> armorStandsInShip = new ArrayList<>();

    @EventHandler
    public void onTarget(EntityTargetLivingEntityEvent event){
        if(entitiesInShip.contains(event.getEntity())){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event){
        if((entitiesInShip.contains(event.getEntity())) && event.getCause() == EntityDamageEvent.DamageCause.FIRE || event.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK || event.getCause() == EntityDamageEvent.DamageCause.SUFFOCATION){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBreak(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            if(entitiesInShip.contains(event.getEntity()) && playersInShip.contains(event.getDamager())){
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBurn(EntityCombustEvent event){
        if(entitiesInShip.contains(event.getEntity())){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDeath(EntityDeathEvent event){
        Entity entity = event.getEntity();
        if(entitiesInShip.contains(event.getEntity())){
            event.getDrops().clear();
            entitiesInShip.remove(event.getEntity());
        }
        for(Vehicle xWing : XWing.getAllXWings()){
            if(xWing.getSeat1() == entity){
                xWing.getModel().remove();
            }
            if(xWing.getModel() == entity){
                xWing.getSeat1().remove();
            }
        }
        for(Vehicle tieFighter : TieFighter.getAllTieFighters()){
            if(tieFighter.getSeat1() == entity){
                tieFighter.getModel().remove();
            }
            if(tieFighter.getModel() == entity){
                tieFighter.getSeat1().remove();
            }
        }
    }

    @EventHandler
    public void onInteraction(PlayerInteractAtEntityEvent event){
        if(armorStandsInShip.contains(event.getRightClicked())){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onFallDamage(EntityDamageEvent event){

        if(event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();

            for(Vehicle xWing : XWing.getAllXWings()){
                if(xWing.getPilot() == player){
                    if(event.getCause() == EntityDamageEvent.DamageCause.FALL){
                        event.setCancelled(true);
                    }
                }
            }
            for(Vehicle tieFighter : TieFighter.getAllTieFighters()){
                if(tieFighter.getPilot() == player){
                    if(event.getCause() == EntityDamageEvent.DamageCause.FALL){
                        event.setCancelled(true);
                    }
                }
            }
        }
    }

}
