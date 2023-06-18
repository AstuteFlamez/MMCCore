package mandomc.mmccore.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onFirstJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();

        String n = "\n";

        if(!player.hasPlayedBefore()){

            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "st play tutorial " + player.getName());

        }
    }

}
