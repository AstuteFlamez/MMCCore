package mandomc.mmccore.commands;

import io.lumine.mythic.api.mobs.MythicMob;
import io.lumine.mythic.bukkit.BukkitAdapter;
import io.lumine.mythic.bukkit.MythicBukkit;
import io.lumine.mythic.core.mobs.ActiveMob;
import mandomc.mmccore.MMCCore;
import mandomc.mmccore.listeners.MythicMobDeath;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class SpawnRancor implements CommandExecutor {

    World world;
    double x;
    double y;
    double z;

    MMCCore plugin;

    public SpawnRancor(MMCCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("mmc.spawnrancor")){

                MythicMobDeath.rancorSpawn(plugin);

                MythicMob mob = MythicBukkit.inst().getMobManager().getMythicMob("rancor").orElse(null);

            }else{
                player.sendMessage(ChatColor.RED + "bozo");
            }

        }
        return true;
    }
}
