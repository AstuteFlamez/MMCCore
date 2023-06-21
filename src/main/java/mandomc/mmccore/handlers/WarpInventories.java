package mandomc.mmccore.handlers;

import mandomc.mmccore.config.WarpConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import java.util.Base64;



public class WarpInventories {



    public static Inventory createWarp(Player player){
        Inventory warps = Bukkit.createInventory(player, 54, createString("&2&lMandoMC Warps"));


        // All warps in descending order

        warps.setItem(WarpConfig.get().getInt("DathomirSlot"), UtilityMethods.createWarp(Material.RED_GLAZED_TERRACOTTA, "DathomirName", "DathomirDesc"));
        warps.setItem(WarpConfig.get().getInt("MustafarSlot"), UtilityMethods.createWarp(Material.MAGMA_BLOCK, "MustafarName", "MustafarDesc"));
        warps.setItem(WarpConfig.get().getInt("EarthSlot"), UtilityMethods.createWarp(Material.GRASS_BLOCK, "EarthName", "EarthDesc"));
        warps.setItem(WarpConfig.get().getInt("UmbaraSlot"), UtilityMethods.createWarp(Material.WARPED_HYPHAE, "UmbaraName", "UmbaraDesc"));
        warps.setItem(WarpConfig.get().getInt("AlderaanSlot"), UtilityMethods.createWarp(Material.GREEN_CONCRETE_POWDER, "AlderaanName", "AlderaanDesc"));
        warps.setItem(WarpConfig.get().getInt("ConcordiaSlot"), UtilityMethods.createWarp(Material.MUD_BRICKS, "ConcordiaName", "ConcordiaDesc"));
        warps.setItem(WarpConfig.get().getInt("KashyyykSlot"), UtilityMethods.createWarp(Material.JUNGLE_WOOD, "KashyyykName", "KashyyykDesc"));
        warps.setItem(WarpConfig.get().getInt("NabooSlot"), UtilityMethods.createWarp(Material.PRISMARINE, "NabooName", "NabooDesc"));
        warps.setItem(WarpConfig.get().getInt("IlumSlot"), UtilityMethods.createWarp(Material.BLUE_ICE, "IlumName", "IlumDesc"));
        warps.setItem(WarpConfig.get().getInt("GeonosisSlot"), UtilityMethods.createWarp(Material.SMOOTH_RED_SANDSTONE, "GeonosisName", "GeonosisDesc"));
        warps.setItem(WarpConfig.get().getInt("MorakSlot"), UtilityMethods.createWarp(Material.MANGROVE_WOOD, "MorakName", "MorakDesc"));
        warps.setItem(WarpConfig.get().getInt("TatooineSlot"), UtilityMethods.createWarp(Material.SANDSTONE, "TatooineName", "TatooineDesc"));
        warps.setItem(WarpConfig.get().getInt("HothSlot"), UtilityMethods.createWarp(Material.SNOW_BLOCK, "HothName", "HothDesc"));
        warps.setItem(WarpConfig.get().getInt("MandaloreSlot"), UtilityMethods.createWarp(Material.NETHERITE_BLOCK, "MandaloreName", "MandaloreDesc"));

        for (int slot = 0; slot < 54; slot++) {
            ItemStack item = warps.getItem(slot);if (item == null || item.getType() == Material.AIR) {
                warps.setItem(slot, ISC.createItem(Material.BLACK_STAINED_GLASS_PANE, createString("&a"),  createString("&a")));
            }
        }


        return warps;
    }

    public static Inventory createTatooine(Player player){

        Inventory tatooine = Bukkit.createInventory(player, 54, ChatColor.translateAlternateColorCodes('&', WarpConfig.get().getString("TatooineName")));

        tatooine.setItem(WarpConfig.get().getInt("BlackMarketSlot"), UtilityMethods.createSubWarp(Material.TINTED_GLASS, "BlackMarketName"));
        tatooine.setItem(WarpConfig.get().getInt("JabbaSlot"), UtilityMethods.createSubWarp(Material.GREEN_TERRACOTTA, "JabbaName"));

        for (int slot = 0; slot < 54; slot++) {
            ItemStack item = tatooine.getItem(slot);if (item == null || item.getType() == Material.AIR) {
                tatooine.setItem(slot, ISC.createItem(Material.BLACK_STAINED_GLASS_PANE, createString("&a"),  createString("&a")));
            }
        }

        return tatooine;
    }

    public static Inventory createConcordia(Player player){

        Inventory concordia = Bukkit.createInventory(player, 54, ChatColor.translateAlternateColorCodes('&', WarpConfig.get().getString("ConcordiaName")));

        concordia.setItem(WarpConfig.get().getInt("ArenaSlot"), UtilityMethods.createSubWarp(Material.BLACKSTONE_WALL, "ArenaName"));
        for (int slot = 0; slot < 54; slot++) {
            ItemStack item = concordia.getItem(slot);if (item == null || item.getType() == Material.AIR) {
                concordia.setItem(slot, ISC.createItem(Material.BLACK_STAINED_GLASS_PANE, createString("&a"),  createString("&a")));
            }
        }

        return concordia;
    }

    public static String createString(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }

}
