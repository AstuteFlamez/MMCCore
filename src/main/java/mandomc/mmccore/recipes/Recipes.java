package mandomc.mmccore.recipes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;
import mandomc.mmccore.handlers.GI;
import mandomc.mmccore.handlers.ISC;
public class Recipes {

    public static void init(){createRecipe();}

    private static void createRecipe(){

        ItemStack whiteKyber = GI.whiteKyber();
        ShapedRecipe whiteKyberRecipe = new ShapedRecipe(NamespacedKey.minecraft("whitekyber"), whiteKyber);
        whiteKyberRecipe.shape("   ", " R ", "   ");
        whiteKyberRecipe.setIngredient('R', new RecipeChoice.ExactChoice(GI.redKyber()));
        Bukkit.getServer().addRecipe(whiteKyberRecipe);

        ItemStack crossGuardHilt = GI.crossGuardHilt();
        ShapedRecipe crossGuardHiltRecipe = new ShapedRecipe(NamespacedKey.minecraft("crossguardhilt"), crossGuardHilt);
        crossGuardHiltRecipe.shape("SN ",
                "NIR",
                " GN");
        crossGuardHiltRecipe.setIngredient('S', Material.NETHERITE_SCRAP);
        crossGuardHiltRecipe.setIngredient('N', Material.NETHERITE_INGOT);
        crossGuardHiltRecipe.setIngredient('I', Material.IRON_INGOT);
        crossGuardHiltRecipe.setIngredient('R', Material.REDSTONE);
        crossGuardHiltRecipe.setIngredient('G', Material.GLOWSTONE);
        Bukkit.getServer().addRecipe(crossGuardHiltRecipe);

        ItemStack doubleBladedHilt = GI.doubleBladedHilt();
        ShapedRecipe doubleBladedHiltRecipe = new ShapedRecipe(NamespacedKey.minecraft("doublebladedhilt"), doubleBladedHilt);
        doubleBladedHiltRecipe.shape("NI ",
                "IRI",
                " IN");
        doubleBladedHiltRecipe.setIngredient('N', Material.NETHERITE_INGOT);
        doubleBladedHiltRecipe.setIngredient('I', Material.IRON_INGOT);
        doubleBladedHiltRecipe.setIngredient('R', Material.REDSTONE);
        Bukkit.getServer().addRecipe(doubleBladedHiltRecipe);

        ItemStack singleBladedHilt = GI.singleBladedHilt();
        ShapedRecipe singleBladedHiltRecipe = new ShapedRecipe(NamespacedKey.minecraft("singlebladedhilt"), singleBladedHilt);
        singleBladedHiltRecipe.shape("NR ",
                "IIN",
                " NN");
        singleBladedHiltRecipe.setIngredient('N', Material.NETHERITE_INGOT);
        singleBladedHiltRecipe.setIngredient('I', Material.IRON_INGOT);
        singleBladedHiltRecipe.setIngredient('R', Material.REDSTONE);
        Bukkit.getServer().addRecipe(singleBladedHiltRecipe);

        ItemStack core = GI.lightsaberCore();
        ShapedRecipe coreRecipe = new ShapedRecipe(NamespacedKey.minecraft("core"), core);
        coreRecipe.shape("INI", "BSB", "INI");
        coreRecipe.setIngredient('S', Material.IRON_BLOCK);
        coreRecipe.setIngredient('B', Material.NETHERITE_BLOCK);
        coreRecipe.setIngredient('N', Material.NETHERITE_INGOT);
        coreRecipe.setIngredient('I', Material.IRON_INGOT);
        Bukkit.getServer().addRecipe(coreRecipe);

        ISC.createItem(ChatColor.translateAlternateColorCodes('&', "&c&lCrossguard Lightsaber"), 13, "redcrossguardlightsaber", GI.redKyber(), core, crossGuardHilt);
        ISC.createItem(ChatColor.translateAlternateColorCodes('&', "&9&lCrossguard Lightsaber"), 14, "bluecrossguardlightsaber", GI.blueKyber(), core, crossGuardHilt);
        ISC.createItem(ChatColor.translateAlternateColorCodes('&', "&a&lCrossguard Lightsaber"), 15, "greencrossguardlightsaber", GI.greenKyber(), core, crossGuardHilt);
        ISC.createItem(ChatColor.translateAlternateColorCodes('&', "&5&lCrossguard Lightsaber"), 16, "purplecrossguardlightsaber", GI.purpleKyber(), core, crossGuardHilt);
        ISC.createItem(ChatColor.translateAlternateColorCodes('&', "&e&lCrossguard Lightsaber"), 17, "yellowcrossguardlightsaber", GI.yellowKyber(), core, crossGuardHilt);
        ISC.createItem(ChatColor.translateAlternateColorCodes('&', "&f&lCrossguard Lightsaber"), 18, "whitecrossguardlightsaber", whiteKyber, core, crossGuardHilt);

        ISC.createItem(ChatColor.translateAlternateColorCodes('&', "&c&lDouble-Bladed Lightsaber"), 1, "reddoublebladedlightsaber", GI.redKyber(), core, doubleBladedHilt);
        ISC.createItem(ChatColor.translateAlternateColorCodes('&', "&9&lDouble-Bladed Lightsaber"), 2, "bluedoublebladedlightsaber", GI.blueKyber(), core, doubleBladedHilt);
        ISC.createItem(ChatColor.translateAlternateColorCodes('&', "&a&lDouble-Bladed Lightsaber"), 3, "greendoublebladedlightsaber", GI.greenKyber(), core, doubleBladedHilt);
        ISC.createItem(ChatColor.translateAlternateColorCodes('&', "&5&lDouble-Bladed Lightsaber"), 4, "purpledoublebladedlightsaber", GI.purpleKyber(), core, doubleBladedHilt);
        ISC.createItem(ChatColor.translateAlternateColorCodes('&', "&e&lDouble-Bladed Lightsaber"), 5, "yellowdoublebladedlightsaber", GI.yellowKyber(), core, doubleBladedHilt);
        ISC.createItem(ChatColor.translateAlternateColorCodes('&', "&f&lDouble-Bladed Lightsaber"), 6, "whitedoublebladedlightsaber", whiteKyber, core, doubleBladedHilt);

        ISC.createItem(ChatColor.translateAlternateColorCodes('&', "&c&lSingle-Bladed Lightsaber"), 7, "redsinglebladedlightsaber", GI.redKyber(), core, singleBladedHilt);
        ISC.createItem(ChatColor.translateAlternateColorCodes('&', "&9&lSingle-Bladed Lightsaber"), 8, "bluesinglebladedlightsaber", GI.blueKyber(), core, singleBladedHilt);
        ISC.createItem(ChatColor.translateAlternateColorCodes('&', "&a&lSingle-Bladed Lightsaber"), 9, "greensinglebladedlightsaber", GI.greenKyber(), core, singleBladedHilt);
        ISC.createItem(ChatColor.translateAlternateColorCodes('&', "&5&lSingle-Bladed Lightsaber"), 10, "purplesinglebladedlightsaber", GI.purpleKyber(), core, singleBladedHilt);
        ISC.createItem(ChatColor.translateAlternateColorCodes('&', "&e&lSingle-Bladed Lightsaber"), 11, "yellowsinglebladedlightsaber", GI.yellowKyber(), core, singleBladedHilt);
        ISC.createItem(ChatColor.translateAlternateColorCodes('&', "&f&lSingle-Bladed Lightsaber"), 12, "whitesinglebladedlightsaber", whiteKyber, core, singleBladedHilt);


    }

}
