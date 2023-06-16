package mandomc.mmccore.listeners;

import io.lumine.mythic.api.exceptions.InvalidMobTypeException;
import io.lumine.mythic.api.mobs.MythicMob;
import io.lumine.mythic.bukkit.BukkitAdapter;
import io.lumine.mythic.bukkit.MythicBukkit;
import io.lumine.mythic.bukkit.events.MythicMobDeathEvent;
import io.lumine.mythic.bukkit.events.MythicMobDespawnEvent;
import io.lumine.mythic.core.mobs.ActiveMob;
import mandomc.mmccore.MMCCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;
import java.util.UUID;

public class MythicMobDeath implements Listener {

    @EventHandler
    public void rancor(MythicMobDeathEvent event){

        if(event.getMob().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "Rancor")){
            rancorSpawn(MMCCore.getInstance());
        }
        if(event.getMob().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Darth Maul")){
            maulSpawn(MMCCore.getInstance());
        }
        if(event.getMob().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Count Dooku")){
            dookuSpawn(MMCCore.getInstance());
        }
        if(event.getMob().getDisplayName().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Boba Fett")){
            bobaSpawn(MMCCore.getInstance());
        }
    }

    static int rancorChance = 0;
    static int maulChance = 0;
    static int bobaChance = 0;
    static int dookuChance = 0;

    public static void rancorSpawn(MMCCore plugin){

        new BukkitRunnable(){

            @Override
            public void run() {
                rancorChance++;
                int random = new Random().nextInt(120);
                if (random + 30 < rancorChance) {
                    spawnRancor();
                    rancorChance = 0;
                    cancel();
                }
            }

        }.runTaskTimer(plugin, 0, 60*20);
    }

    public static void dookuSpawn(MMCCore plugin){

        new BukkitRunnable(){

            @Override
            public void run() {
                dookuChance++;
                int random = new Random().nextInt(180);
                if (random + 60 < dookuChance) {
                    spawnDooku();
                    dookuChance = 0;
                    cancel();
                }
            }

        }.runTaskTimer(plugin, 0, 60*20);
    }

    public static void maulSpawn(MMCCore plugin){

        new BukkitRunnable(){

            @Override
            public void run() {
                maulChance++;
                int random = new Random().nextInt(180);
                if (random + 60 < maulChance) {
                    spawnMaul();
                    maulChance = 0;
                    cancel();
                }
            }

        }.runTaskTimer(plugin, 0, 60*20);
    }

    public static void bobaSpawn(MMCCore plugin){

        new BukkitRunnable(){

            @Override
            public void run() {
                bobaChance++;
                int random = new Random().nextInt(180);
                if (random + 60 < bobaChance) {
                    spawnBoba();
                    bobaChance = 0;
                    cancel();
                }
            }

        }.runTaskTimer(plugin, 0, 60*20);
    }

    public static void spawnRancor(){
        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "mm mobs spawn Rancor:1 1 JabbasPalace,-86,-59,102");
    }

    public static void spawnMaul(){
        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "mm mobs spawn DarthMaul:1 1 Naboo,-13091,142,1189");
    }

    public static void spawnBoba(){
        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "mm mobs spawn BobaFett:1 1 JabbasPalace,-124,-51,116");
    }

    public static void spawnDooku(){
        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "mm mobs spawn CountDooku:1 1 Geonosis,-58,79,-61");
    }
}
