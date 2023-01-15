package mandomc.mmccore.listeners;

import org.bukkit.entity.Phantom;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class NaturalSpawn implements Listener {

    @EventHandler
    public void onSpawn(CreatureSpawnEvent event){

        if(event.getEntity() instanceof Phantom){
            if(event.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.NATURAL)){
                event.setCancelled(true);
            }
        }

    }

}
