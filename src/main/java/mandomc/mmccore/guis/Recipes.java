package mandomc.mmccore.guis;

import mandomc.mmccore.handlers.GI;
import mandomc.mmccore.handlers.ISC;
import mandomc.mmccore.handlers.RecipeInventories;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Recipes implements Listener {

    private int kyberIndex = 0;
    private int crossguardIndex = 0;
    private int doublebladedIndex = 0;
    private int singlebladedIndex = 0;

    private final JavaPlugin plugin;

    public Recipes(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();

        if (event.getCurrentItem() == null) {
            return;
        }

        Inventory recipes = RecipeInventories.recipes(player);

        Inventory weapons = RecipeInventories.weapons(player);

        Inventory lightsabers = RecipeInventories.lightsabers(player);

        Inventory parts = RecipeInventories.parts(player);

        Inventory crossGuardHilt = RecipeInventories.crossGuardHilt(player);

        Inventory dbHilt = RecipeInventories.doubleBladedHilt(player);

        Inventory sHilt = RecipeInventories.singleBladedHilt(player);

        Inventory core = RecipeInventories.lightsaberCore(player);


        if ((event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "MandoMC Recipes"))) {
            switch (event.getSlot()) {
                case 0:
                    player.openInventory(weapons);
                    break;
                case 1:
                    player.openInventory(parts);
                    break;
                case 8:
                    player.closeInventory();
                    break;
            }
            event.setCancelled(true);
        }

        if ((event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Weapon Recipes"))) {
            switch (event.getSlot()) {
                case 0:
                    player.openInventory(lightsabers);
                    break;
                case 7:
                    player.openInventory(recipes);
                    break;
                case 8:
                    player.closeInventory();
                    break;
            }
            event.setCancelled(true);
        }

        if ((event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Lightsaber Recipes"))) {
            switch (event.getSlot()) {
                case 0:
                    crossGuardAnimation(player);
                    break;
                case 1:
                    doubleBladedAnimation(player);
                    break;
                case 2:
                    singleBladedAnimation(player);
                    break;
                case 7:
                    player.openInventory(weapons);
                    break;
                case 8:
                    player.closeInventory();
                    break;
            }
            event.setCancelled(true);
        }

        if ((event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Part Recipes"))) {
            switch (event.getSlot()) {
                case 0:
                    player.openInventory(crossGuardHilt);
                    break;
                case 1:
                    player.openInventory(dbHilt);
                    break;
                case 2:
                    player.openInventory(sHilt);
                    break;
                case 3:
                    player.openInventory(core);
                    break;
                case 7:
                    player.openInventory(recipes);
                    break;
                case 8:
                    player.closeInventory();
                    break;
            }
            event.setCancelled(true);
        }
        if ((event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Crossguard Hilt Recipe"))) {
            switch (event.getSlot()) {
                case 23:
                    player.openWorkbench(null, true);
                    break;
                case 52:
                    player.openInventory(parts);
                    break;
                case 53:
                    player.closeInventory();
                    break;
            }
            event.setCancelled(true);
        }
        if ((event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Double-Bladed Hilt Recipe"))) {
            switch (event.getSlot()) {
                case 23:
                    player.openWorkbench(null, true);
                    break;
                case 52:
                    player.openInventory(parts);
                    break;
                case 53:
                    player.closeInventory();
                    break;
            }
            event.setCancelled(true);
        }
        if ((event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Single-Bladed Hilt Recipe"))) {
            switch (event.getSlot()) {
                case 23:
                    player.openWorkbench(null, true);
                    break;
                case 52:
                    player.openInventory(parts);
                    break;
                case 53:
                    player.closeInventory();
                    break;
            }
            event.setCancelled(true);
        }
        if ((event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Lightsaber Core Recipe"))) {
            switch (event.getSlot()) {
                case 23:
                    player.openWorkbench(null, true);
                    break;
                case 52:
                    player.openInventory(parts);
                    break;
                case 53:
                    player.closeInventory();
                    break;
            }
            event.setCancelled(true);
        }
        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Kyber Crystal Recipes")) {
            switch (event.getSlot()) {
                case 23:
                    player.openWorkbench(null, true);
                    break;
                case 52:
                    player.openInventory(parts);
                    break;
                case 53:
                    player.closeInventory();
                    break;
            }
            event.setCancelled(true);
        }

        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Crossguard Saber Recipes")) {
            switch (event.getSlot()) {
                case 23:
                    player.openWorkbench(null, true);
                    break;
                case 52:
                    player.openInventory(lightsabers);
                    break;
                case 53:
                    player.closeInventory();
                    break;
            }
            event.setCancelled(true);
        }
        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Double-Bladed Saber Recipes")) {
            switch (event.getSlot()) {
                case 23:
                    player.openWorkbench(null, true);
                    break;
                case 52:
                    player.openInventory(lightsabers);
                    break;
                case 53:
                    player.closeInventory();
                    break;
            }
            event.setCancelled(true);
        }
        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "" + ChatColor.BOLD + "Single-Bladed Saber Recipes")) {
            switch (event.getSlot()) {
                case 23:
                    player.openWorkbench(null, true);
                    break;
                case 52:
                    player.openInventory(lightsabers);
                    break;
                case 53:
                    player.closeInventory();
                    break;
            }
            event.setCancelled(true);
        }
    }

    public void kyberAnimation(Player player){
        ItemStack[] kybers = new ItemStack[6];
        ItemStack[] glass = new ItemStack[6];

        Inventory inv = Bukkit.createInventory(player, 54, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Kyber Crystal Recipes");

        player.openInventory(inv);

        glass[0] = ISC.createItem(Material.RED_STAINED_GLASS_PANE);
        glass[1] = ISC.createItem(Material.BLUE_STAINED_GLASS_PANE);
        glass[2] = ISC.createItem(Material.GREEN_STAINED_GLASS_PANE);
        glass[3] = ISC.createItem(Material.PURPLE_STAINED_GLASS_PANE);
        glass[4] = ISC.createItem(Material.YELLOW_STAINED_GLASS_PANE);
        glass[5] = ISC.createItem(Material.WHITE_STAINED_GLASS_PANE);

        kybers[0] = GI.redKyber();
        kybers[1] = GI.blueKyber();
        kybers[2] = GI.greenKyber();
        kybers[3] = GI.purpleKyber();
        kybers[4] = GI.yellowKyber();
        kybers[5] = GI.whiteKyber();

        new BukkitRunnable(){
            @Override
            public void run(){

                if(kyberIndex < 5){
                    kyberIndex++;
                }else{
                    kyberIndex = 0;
                }

                inv.setItem(10, glass[kyberIndex]);
                inv.setItem(11, glass[kyberIndex]);
                inv.setItem(12, glass[kyberIndex]);
                inv.setItem(19, glass[kyberIndex]);
                inv.setItem(21, glass[kyberIndex]);
                inv.setItem(28, glass[kyberIndex]);
                inv.setItem(29, glass[kyberIndex]);
                inv.setItem(30, glass[kyberIndex]);

                inv.setItem(20, GI.kyberite());

                inv.setItem(25, kybers[kyberIndex]);

                inv.setItem(23, ISC.createItem(Material.CRAFTING_TABLE, ChatColor.DARK_GRAY + "Crafting Table", ChatColor.GRAY + "Craft this recipe using a work bench!"));
                inv.setItem(48, ISC.createItem(Material.ARROW, ChatColor.RED + "" + ChatColor.BOLD + "Back", ChatColor.GRAY + "Click to go back to Weapon Recipes!"));
                inv.setItem(49, ISC.createItem(Material.BARRIER, ChatColor.RED + "" + ChatColor.BOLD + "CLOSE"));

                player.updateInventory();
            }
        }.runTaskTimer(plugin, 15, 15);

    }

    public void crossGuardAnimation(Player player){
        ItemStack[] kybers = new ItemStack[6];
        ItemStack[] sabers = new ItemStack[6];

        Inventory inv = Bukkit.createInventory(player, 54, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Crossguard Saber Recipes");

        player.openInventory(inv);

        sabers[0] = GI.crossGuardRed();
        sabers[1] = GI.crossGuardBlue();
        sabers[2] = GI.crossGuardGreen();
        sabers[3] = GI.crossGuardPurple();
        sabers[4] = GI.crossGuardYellow();
        sabers[5] = GI.crossGuardWhite();

        kybers[0] = GI.redKyber();
        kybers[1] = GI.blueKyber();
        kybers[2] = GI.greenKyber();
        kybers[3] = GI.purpleKyber();
        kybers[4] = GI.yellowKyber();
        kybers[5] = GI.whiteKyber();

        new BukkitRunnable(){
            @Override
            public void run(){

                if(crossguardIndex < 5){
                    crossguardIndex++;
                }else{
                    crossguardIndex = 0;
                }

                inv.setItem(11, kybers[crossguardIndex]);
                inv.setItem(20, GI.lightsaberCore());
                inv.setItem(29, GI.crossGuardHilt());

                inv.setItem(25, sabers[crossguardIndex]);

                inv.setItem(23, ISC.createItem(Material.CRAFTING_TABLE, ChatColor.DARK_GRAY + "Crafting Table", ChatColor.GRAY + "Craft this recipe using a work bench!"));
                inv.setItem(48, ISC.createItem(Material.ARROW, ChatColor.RED + "" + ChatColor.BOLD + "Back", ChatColor.GRAY + "Click to go back to Weapon Recipes!"));
                inv.setItem(49, ISC.createItem(Material.BARRIER, ChatColor.RED + "" + ChatColor.BOLD + "CLOSE"));

                player.updateInventory();
            }
        }.runTaskTimer(plugin, 15, 15);
    }

    public void singleBladedAnimation(Player player){
        ItemStack[] kybers = new ItemStack[6];
        ItemStack[] sabers = new ItemStack[6];

        Inventory inv = Bukkit.createInventory(player, 54, ChatColor.BLUE + "" + ChatColor.BOLD + "Single-Bladed Saber Recipes");

        player.openInventory(inv);

        sabers[0] = GI.singleBladedBlue();
        sabers[1] = GI.singleBladedBlue();
        sabers[2] = GI.singleBladedGreen();
        sabers[3] = GI.singleBladedPurple();
        sabers[4] = GI.singleBladedYellow();
        sabers[5] = GI.singleBladedWhite();

        kybers[0] = GI.redKyber();
        kybers[1] = GI.blueKyber();
        kybers[2] = GI.greenKyber();
        kybers[3] = GI.purpleKyber();
        kybers[4] = GI.yellowKyber();
        kybers[5] = GI.whiteKyber();

        new BukkitRunnable(){
            @Override
            public void run(){

                if(singlebladedIndex < 5){
                    singlebladedIndex++;
                }else{
                    singlebladedIndex = 0;
                }

                inv.setItem(11, kybers[singlebladedIndex]);
                inv.setItem(20, GI.lightsaberCore());
                inv.setItem(29, GI.singleBladedHilt());

                inv.setItem(25, sabers[singlebladedIndex]);

                inv.setItem(23, ISC.createItem(Material.CRAFTING_TABLE, ChatColor.DARK_GRAY + "Crafting Table", ChatColor.GRAY + "Craft this recipe using a work bench!"));
                inv.setItem(48, ISC.createItem(Material.ARROW, ChatColor.RED + "" + ChatColor.BOLD + "Back", ChatColor.GRAY + "Click to go back to Weapon Recipes!"));
                inv.setItem(49, ISC.createItem(Material.BARRIER, ChatColor.RED + "" + ChatColor.BOLD + "CLOSE"));

                player.updateInventory();
            }
        }.runTaskTimer(plugin, 15, 15);
    }

    public void doubleBladedAnimation(Player player){
        ItemStack[] kybers = new ItemStack[6];
        ItemStack[] sabers = new ItemStack[6];

        Inventory inv = Bukkit.createInventory(player, 54, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Double-Bladed Saber Recipes");

        player.openInventory(inv);

        sabers[0] = GI.doubleBladedBlue();
        sabers[1] = GI.doubleBladedBlue();
        sabers[2] = GI.doubleBladedGreen();
        sabers[3] = GI.doubleBladedPurple();
        sabers[4] = GI.doubleBladedYellow();
        sabers[5] = GI.doubleBladedWhite();

        kybers[0] = GI.redKyber();
        kybers[1] = GI.blueKyber();
        kybers[2] = GI.greenKyber();
        kybers[3] = GI.purpleKyber();
        kybers[4] = GI.yellowKyber();
        kybers[5] = GI.whiteKyber();

        new BukkitRunnable(){
            @Override
            public void run(){

                if(doublebladedIndex < 5){
                    doublebladedIndex++;
                }else{
                    doublebladedIndex = 0;
                }

                inv.setItem(11, kybers[doublebladedIndex]);
                inv.setItem(20, GI.lightsaberCore());
                inv.setItem(29, GI.doubleBladedHilt());

                inv.setItem(25, sabers[doublebladedIndex]);

                inv.setItem(23, ISC.createItem(Material.CRAFTING_TABLE, ChatColor.DARK_GRAY + "Crafting Table", ChatColor.GRAY + "Craft this recipe using a work bench!"));
                inv.setItem(48, ISC.createItem(Material.ARROW, ChatColor.RED + "" + ChatColor.BOLD + "Back", ChatColor.GRAY + "Click to go back to Weapon Recipes!"));
                inv.setItem(49, ISC.createItem(Material.BARRIER, ChatColor.RED + "" + ChatColor.BOLD + "CLOSE"));

                player.updateInventory();
            }
        }.runTaskTimer(plugin, 15, 15);

    }
}
