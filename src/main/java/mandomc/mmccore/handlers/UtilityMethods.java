package mandomc.mmccore.handlers;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.flags.Flags;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldguard.protection.regions.RegionQuery;
import mandomc.mmccore.config.WarpConfig;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class UtilityMethods {

    public static ItemStack createWarp(Material material, String namePath, String descPath){

        ItemStack i = new ItemStack(material);

        ItemMeta meta = i.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', WarpConfig.get().getString(namePath)));
        ArrayList<String> lore = new ArrayList<String>();
        for(String yourItemLoreLines : WarpConfig.get().getStringList(descPath)) {
            lore.add(ChatColor.translateAlternateColorCodes('&', yourItemLoreLines));
        }
        meta.setLore(lore);

        return i;

    }

    public static boolean isMobSpawningEnabled(Location location, Player player){
        LocalPlayer localPlayer = WorldGuardPlugin.inst().wrapPlayer(player);
        RegionContainer regionContainer = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionQuery query = regionContainer.createQuery();

        com.sk89q.worldedit.util.Location loc = BukkitAdapter.adapt(location);

        return query.testState(loc, localPlayer, Flags.MOB_SPAWNING);
    }

    public static Vector genVec(Location a, Location b) {
        double dX = a.getX() - b.getX();
        double dY = a.getY() - b.getY();
        double dZ = a.getZ() - b.getZ();
        double yaw = Math.atan2(dZ, dX);
        double pitch = Math.atan2(Math.sqrt(dZ * dZ + dX * dX), dY) + Math.PI;
        double x = Math.sin(pitch) * Math.cos(yaw);
        double y = Math.sin(pitch) * Math.sin(yaw);
        double z = Math.cos(pitch);

        Vector vector = new Vector(x, z, y);
        vector = vector.normalize();

        return vector;
    }

    public static void itemList(Player player){
        player.sendMessage("xwing");
        player.sendMessage("n1");
        player.sendMessage("tie");
        player.sendMessage("lightsaberCore");
        player.sendMessage("singleBladedHilt");
        player.sendMessage("doubleBladedHilt");
        player.sendMessage("crossGuardHilt");
        player.sendMessage("dookuHilt");
        player.sendMessage("inquisitorHilt");
        player.sendMessage("dookuSaber");
        player.sendMessage("inquisitorSaber");
        player.sendMessage("xwing");
        player.sendMessage("singleBladed <color>");
        player.sendMessage("doubleBladed <color>");
        player.sendMessage("crossGuard <color>");
        player.sendMessage("kyber <color>");
    }

}