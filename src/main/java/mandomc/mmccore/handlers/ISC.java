package mandomc.mmccore.handlers;

import mandomc.mmccore.config.SaberConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.UUID;

public class ISC {

    public static ItemStack createItem(Material material, String displayName, String newLore){ //no customModelData
        ItemStack i = new ItemStack(material);

        ItemMeta meta = i.getItemMeta();
        meta.setDisplayName(displayName);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(newLore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        meta.setLore(lore);

        return i;
    }

    public static ItemStack createItem(Material material){ //just a minecraft item
        ItemStack i = new ItemStack(material);

        return i;
    }

    public static ItemStack createItem(Material material, String displayName){ //just a minecraft item + new name
        ItemStack i = new ItemStack(material);

        ItemMeta meta = i.getItemMeta();
        meta.setDisplayName(displayName);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        i.setItemMeta(meta);

        return i;
    }

    public static ItemStack createItem(Material material, String displayName, int customModelData){
        ItemStack i = new ItemStack(material);

        ItemMeta meta = i.getItemMeta();
        meta.setDisplayName(displayName);
        meta.setCustomModelData(customModelData);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        i.setItemMeta(meta);

        return i;
    }

    public static ItemStack createItem(Material material, String displayName, int customModelData, String l1){
        ItemStack i = new ItemStack(material);

        ItemMeta meta = i.getItemMeta();
        meta.setDisplayName(displayName);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(l1);
        meta.setCustomModelData(customModelData);
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        i.setItemMeta(meta);

        return i;
    }

    public static ItemStack createItem(Material material, String displayName, int customModelData, String l1, String l2){
        ItemStack i = new ItemStack(material);

        ItemMeta meta = i.getItemMeta();
        meta.setDisplayName(displayName);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(l1);
        lore.add(l2);
        meta.setCustomModelData(customModelData);
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        i.setItemMeta(meta);

        return i;
    }

    public static ItemStack createItem(Material material, String displayName, int customModelData, String l1, String l2, String l3){
        ItemStack i = new ItemStack(material);

        ItemMeta meta = i.getItemMeta();
        meta.setDisplayName(displayName);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(l1);
        lore.add(l2);
        lore.add(l3);
        meta.setCustomModelData(customModelData);
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        i.setItemMeta(meta);

        return i;
    }

    public static ItemStack createItem(Material material, String displayName, int customModelData, String l1, String l2, String l3, String l4){
        ItemStack i = new ItemStack(material);

        ItemMeta meta = i.getItemMeta();
        meta.setDisplayName(displayName);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(l1);
        lore.add(l2);
        lore.add(l3);
        lore.add(l4);
        meta.setCustomModelData(customModelData);
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        i.setItemMeta(meta);

        return i;
    }

    public static ItemStack createItem(Material material, String displayName, int customModelData, String l1, String l2, String l3, String l4, String l5){
        ItemStack i = new ItemStack(material);

        ItemMeta meta = i.getItemMeta();
        meta.setDisplayName(displayName);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(l1);
        lore.add(l2);
        lore.add(l3);
        lore.add(l4);
        lore.add(l5);
        meta.setCustomModelData(customModelData);
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        i.setItemMeta(meta);

        return i;
    }

    public static ItemStack createItem(Material material, String displayName, int customModelData, String l1, String l2, String l3, String l4, String l5, String l6){
        ItemStack i = new ItemStack(material);

        ItemMeta meta = i.getItemMeta();
        meta.setDisplayName(displayName);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(l1);
        lore.add(l2);
        lore.add(l3);
        lore.add(l4);
        lore.add(l5);
        lore.add(l6);
        meta.setCustomModelData(customModelData);
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        i.setItemMeta(meta);

        return i;
    }

    public static ItemStack createItem(Material material, String displayName, int customModelData, String l1, String l2, String l3, String l4, String l5, String l6, String l7){
        ItemStack i = new ItemStack(material);

        ItemMeta meta = i.getItemMeta();
        meta.setDisplayName(displayName);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(l1);
        lore.add(l2);
        lore.add(l3);
        lore.add(l4);
        lore.add(l5);
        lore.add(l6);
        lore.add(l7);
        meta.setCustomModelData(customModelData);
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        i.setItemMeta(meta);

        return i;
    }

    public static ItemStack createItem(Material material, String displayName, int customModelData, String l1, String l2, String l3, String l4, String l5, String l6, String l7, String l8){
        ItemStack i = new ItemStack(material);

        ItemMeta meta = i.getItemMeta();
        meta.setDisplayName(displayName);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(l1);
        lore.add(l2);
        lore.add(l3);
        lore.add(l4);
        lore.add(l5);
        lore.add(l6);
        lore.add(l7);
        lore.add(l8);
        meta.setCustomModelData(customModelData);
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        i.setItemMeta(meta);

        return i;
    }

    public static ItemStack createItem(Material material, String displayName, int customModelData, String l1, String l2, String l3, String l4, String l5, String l6, String l7, String l8, String l9){
        ItemStack i = new ItemStack(material);

        ItemMeta meta = i.getItemMeta();
        meta.setDisplayName(displayName);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(l1);
        lore.add(l2);
        lore.add(l3);
        lore.add(l4);
        lore.add(l5);
        lore.add(l6);
        lore.add(l7);
        lore.add(l8);
        lore.add(l9);
        meta.setCustomModelData(customModelData);
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        i.setItemMeta(meta);

        return i;
    }

    public static ItemStack createItem(Material material, String displayName, String l1, String l2){
        ItemStack i = new ItemStack(material);

        ItemMeta meta = i.getItemMeta();
        meta.setDisplayName(displayName);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(l1);
        lore.add(l2);
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        i.setItemMeta(meta);

        return i;
    }

    public static ItemStack createItem(Material material, String displayName, String l1, String l2, String l3){
        ItemStack i = new ItemStack(material);

        ItemMeta meta = i.getItemMeta();
        meta.setDisplayName(displayName);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(l1);
        lore.add(l2);
        lore.add(l3);
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        i.setItemMeta(meta);

        return i;
    }

    public static ItemStack createItem(Material material, String displayName, String l1, String l2, String l3, String l4){
        ItemStack i = new ItemStack(material);

        ItemMeta meta = i.getItemMeta();
        meta.setDisplayName(displayName);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(l1);
        lore.add(l2);
        lore.add(l3);
        lore.add(l4);
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        i.setItemMeta(meta);

        return i;
    }

    public static ItemStack createItem(Material material, String displayName, String l1, String l2, String l3, String l4, String l5){
        ItemStack i = new ItemStack(material);

        ItemMeta meta = i.getItemMeta();
        meta.setDisplayName(displayName);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(l1);
        lore.add(l2);
        lore.add(l3);
        lore.add(l4);
        lore.add(l5);
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        i.setItemMeta(meta);

        return i;
    }

    public static ItemStack createItem(Material material, String displayName, String l1, String l2, String l3, String l4, String l5, String l6){
        ItemStack i = new ItemStack(material);

        ItemMeta meta = i.getItemMeta();
        meta.setDisplayName(displayName);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(l1);
        lore.add(l2);
        lore.add(l3);
        lore.add(l4);
        lore.add(l5);
        lore.add(l6);
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        i.setItemMeta(meta);

        return i;
    }

    public static ItemStack createItem(Material material, String displayName, String l1, String l2, String l3, String l4, String l5, String l6, String l7){
        ItemStack i = new ItemStack(material);

        ItemMeta meta = i.getItemMeta();
        meta.setDisplayName(displayName);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(l1);
        lore.add(l2);
        lore.add(l3);
        lore.add(l4);
        lore.add(l5);
        lore.add(l6);
        lore.add(l7);
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        i.setItemMeta(meta);

        return i;
    }

    public static ItemStack createItem(Material material, String displayName, String l1, String l2, String l3, String l4, String l5, String l6, String l7, String l8){
        ItemStack i = new ItemStack(material);

        ItemMeta meta = i.getItemMeta();
        meta.setDisplayName(displayName);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(l1);
        lore.add(l2);
        lore.add(l3);
        lore.add(l4);
        lore.add(l5);
        lore.add(l6);
        lore.add(l7);
        lore.add(l8);
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        i.setItemMeta(meta);

        return i;
    }

    public static ItemStack createItem(Material material, String displayName, String l1, String l2, String l3, String l4, String l5, String l6, String l7, String l8, String l9){
        ItemStack i = new ItemStack(material);

        ItemMeta meta = i.getItemMeta();
        meta.setDisplayName(displayName);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(l1);
        lore.add(l2);
        lore.add(l3);
        lore.add(l4);
        lore.add(l5);
        lore.add(l6);
        lore.add(l7);
        lore.add(l8);
        lore.add(l9);
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        i.setItemMeta(meta);

        return i;
    }

    public static ItemStack createItem(String displayName, int customModelData, String nameSpacedKey, ItemStack kyber, ItemStack core, ItemStack hilt, String damage){

        ItemStack i = new ItemStack(Material.SHIELD);
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(displayName);
        ArrayList<String> iL = new ArrayList<>();
        iL.add(ChatColor.translateAlternateColorCodes('&', "&6&l&oOptifine Required!"));
        iL.add("");
        iL.add(ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"");
        iL.add("");
        iL.add(ChatColor.GRAY + "Melee Damage: " + ChatColor.RED + SaberConfig.get().getDouble(damage));
        iL.add("");
        iL.add(ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK");
        iL.add(ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24");
        iL.add(ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
        iL.add(ChatColor.GOLD + "Ability: Block ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " RIGHT CLICK");
        iM.setLore(iL);
        iM.setCustomModelData(customModelData);
        iM.setUnbreakable(true);
        iM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        AttributeModifier iD = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", SaberConfig.get().getDouble(damage), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        iM.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, iD);
        i.setItemMeta(iM);
        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft(nameSpacedKey), i);
        recipe.shape(" C ",
                " L ",
                " H ");
        recipe.setIngredient('C', new RecipeChoice.ExactChoice(kyber));
        recipe.setIngredient('L', new RecipeChoice.ExactChoice(core));
        recipe.setIngredient('H', new RecipeChoice.ExactChoice(hilt));
        Bukkit.getServer().addRecipe(recipe);
        return  i;
    }

}

