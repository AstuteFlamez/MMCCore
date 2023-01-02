package mandomc.mmccore.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.BrewEvent;

public class Brew implements Listener {

    @EventHandler
    public void brew(BrewEvent event){
        event.setCancelled(true);
    }

}
