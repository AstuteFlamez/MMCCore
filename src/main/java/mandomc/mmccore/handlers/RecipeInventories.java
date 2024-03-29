package mandomc.mmccore.handlers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class RecipeInventories {

    /* 0  1  2  3  4  5  6  7  8
       9  10 11 12 13 14 15 16 17
       18 19 20 21 22 23 24 25 26
       27 28 29 30 31 32 33 34 35
       36 37 38 39 40 41 42 43 44
       45 46 47 48 49 50 51 51 53
     */

    public static Inventory recipes(Player player){
        Inventory recipes = Bukkit.createInventory(player, 9, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "MandoMC Recipes");

        recipes.setItem(0, ISC.createItem(Material.SHIELD, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Weapon Recipes", 1, ChatColor.GRAY + "Inside you will find weapons from a more civilized age!"));
        recipes.setItem(1, ISC.createItem(Material.WOODEN_SWORD, ChatColor.translateAlternateColorCodes('&', "&2&lPart Recipes"),2,ChatColor.GRAY + "Use these recipes to create larger items!"));
        recipes.setItem(8, GI.close());
        return recipes;
    }

    public static Inventory weapons(Player player){
        Inventory weapons = Bukkit.createInventory(player, 9, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Weapon Recipes");

        weapons.setItem(0, ISC.createItem(Material.SHIELD, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Lightsabers", 1, ChatColor.GRAY + "The ancient weapon of force users..."));
        weapons.setItem(7, GI.back());
        weapons.setItem(8, GI.close());
        return weapons;
    }

    public static Inventory parts(Player player){
        Inventory parts = Bukkit.createInventory(player, 9, ChatColor.translateAlternateColorCodes('&', "&2&lPart Recipes"));

        parts.setItem(0, ISC.createItem(Material.WOODEN_SWORD, ChatColor.translateAlternateColorCodes('&', "&7Crossguard Hilt"), 3));
        parts.setItem(1, ISC.createItem(Material.WOODEN_SWORD, ChatColor.translateAlternateColorCodes('&', "&7Double-Bladed Hilt"), 4));
        parts.setItem(2, ISC.createItem(Material.WOODEN_SWORD, ChatColor.translateAlternateColorCodes('&', "&7Single-Bladed Hilt"), 5));
        parts.setItem(3, ISC.createItem(Material.BEACON, ChatColor.translateAlternateColorCodes('&', "&b&lLightsaber Core")));
        parts.setItem(7, GI.back());
        parts.setItem(8, GI.close());
        return parts;
    }

    public static Inventory lightsabers(Player player){
        Inventory sabers = Bukkit.createInventory(player, 9, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Lightsaber Recipes");

        sabers.setItem(0, ISC.createItem(Material.SHIELD, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Crossguard Lightsaber Recipes", 13, ChatColor.GRAY + "An ancient lightsaber design for force users..."));
        sabers.setItem(1, ISC.createItem(Material.SHIELD, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Double-Bladed Lightsaber Recipes", 1, ChatColor.GRAY + "Designed to be a more agile saber."));
        sabers.setItem(2, ISC.createItem(Material.SHIELD, ChatColor.BLUE + "" + ChatColor.BOLD + "Single-Bladed Lightsaber Recipes", 8, ChatColor.GRAY + "Basic, but good too."));
        sabers.setItem(7, GI.back());
        sabers.setItem(8, GI.close());
        return sabers;
    }

    public static Inventory crossGuardHilt(Player player){
        Inventory crossGuardHilt = Bukkit.createInventory(player, 54, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Crossguard Hilt Recipe");

        crossGuardHilt.setItem(10, ISC.createItem(Material.NETHERITE_SCRAP));
        crossGuardHilt.setItem(11, ISC.createItem(Material.NETHERITE_INGOT));
        crossGuardHilt.setItem(19, ISC.createItem(Material.NETHERITE_INGOT));
        crossGuardHilt.setItem(20, ISC.createItem(Material.IRON_INGOT));
        crossGuardHilt.setItem(21, ISC.createItem(Material.REDSTONE));
        crossGuardHilt.setItem(25, ISC.createItem(Material.WOODEN_SWORD, ChatColor.GRAY + "Crossguard Hilt", 3));
        crossGuardHilt.setItem(29, ISC.createItem(Material.GLOWSTONE));
        crossGuardHilt.setItem(30, ISC.createItem(Material.NETHERITE_INGOT));
        crossGuardHilt.setItem(23, ISC.createItem(Material.CRAFTING_TABLE, ChatColor.DARK_GRAY + "Crafting Table", ChatColor.GRAY + "Craft this recipe using a work bench!"));
        crossGuardHilt.setItem(52, GI.back());
        crossGuardHilt.setItem(53, GI.close());
        return crossGuardHilt;
    }

    public static Inventory doubleBladedHilt(Player player){
        Inventory dbHilt = Bukkit.createInventory(player, 54, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Double-Bladed Hilt Recipe");

        dbHilt.setItem(10, ISC.createItem(Material.NETHERITE_INGOT));
        dbHilt.setItem(11, ISC.createItem(Material.IRON_INGOT));
        dbHilt.setItem(19, ISC.createItem(Material.IRON_INGOT));
        dbHilt.setItem(20, ISC.createItem(Material.REDSTONE));
        dbHilt.setItem(21, ISC.createItem(Material.IRON_INGOT));
        dbHilt.setItem(25, ISC.createItem(Material.WOODEN_SWORD, ChatColor.GRAY + "Double-Bladed Hilt", 4));
        dbHilt.setItem(29, ISC.createItem(Material.IRON_INGOT));
        dbHilt.setItem(30, ISC.createItem(Material.NETHERITE_INGOT));
        dbHilt.setItem(23, ISC.createItem(Material.CRAFTING_TABLE, ChatColor.DARK_GRAY + "Crafting Table", ChatColor.GRAY + "Craft this recipe using a work bench!"));
        dbHilt.setItem(52, GI.back());
        dbHilt.setItem(53, GI.close());
        return dbHilt;
    }

    public static Inventory singleBladedHilt(Player player){
        Inventory sHilt = Bukkit.createInventory(player, 54, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Single-Bladed Hilt Recipe");

        sHilt.setItem(10, ISC.createItem(Material.NETHERITE_INGOT));
        sHilt.setItem(11, ISC.createItem(Material.REDSTONE));
        sHilt.setItem(19, ISC.createItem(Material.IRON_INGOT));
        sHilt.setItem(20, ISC.createItem(Material.IRON_INGOT));
        sHilt.setItem(21, ISC.createItem(Material.NETHERITE_INGOT));
        sHilt.setItem(25, ISC.createItem(Material.WOODEN_SWORD, ChatColor.GRAY + "Single-Bladed Hilt", 5));
        sHilt.setItem(29, ISC.createItem(Material.NETHERITE_INGOT));
        sHilt.setItem(30, ISC.createItem(Material.NETHERITE_INGOT));
        sHilt.setItem(23, ISC.createItem(Material.CRAFTING_TABLE, ChatColor.DARK_GRAY + "Crafting Table", ChatColor.GRAY + "Craft this recipe using a work bench!"));
        sHilt.setItem(52, GI.back());
        sHilt.setItem(53, GI.close());
        return sHilt;
    }

    public static Inventory lightsaberCore(Player player){
        Inventory core = Bukkit.createInventory(player, 54, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Lightsaber Core Recipe");

        core.setItem(10, ISC.createItem(Material.IRON_INGOT));
        core.setItem(11, ISC.createItem(Material.NETHERITE_INGOT));
        core.setItem(12, ISC.createItem(Material.IRON_INGOT));
        core.setItem(19, ISC.createItem(Material.NETHERITE_BLOCK));
        core.setItem(20, ISC.createItem(Material.IRON_BLOCK));
        core.setItem(21, ISC.createItem(Material.NETHERITE_BLOCK));
        core.setItem(25, ISC.createItem(Material.BEACON, ChatColor.translateAlternateColorCodes('&', "&b&lLightsaber Core")));
        core.setItem(28, ISC.createItem(Material.IRON_INGOT));
        core.setItem(29, ISC.createItem(Material.NETHERITE_INGOT));
        core.setItem(30, ISC.createItem(Material.IRON_INGOT));
        core.setItem(23, ISC.createItem(Material.CRAFTING_TABLE, ChatColor.DARK_GRAY + "Crafting Table",  ChatColor.GRAY + "Craft this recipe using a work bench!"));
        core.setItem(52, GI.back());
        core.setItem(53, GI.close());
        return core;
    }
}
