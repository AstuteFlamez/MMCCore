package mandomc.mmccore.commands;

import mandomc.mmccore.MMCCore;
import mandomc.mmccore.config.WarpConfig;
import mandomc.mmccore.handlers.GI;
import mandomc.mmccore.handlers.ISC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Vehicle implements CommandExecutor, TabExecutor, Listener {

    String prefix = "&a&lMMCCore &8» ";
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            Inventory conv = Bukkit.createInventory(player, 54, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Vehicles");

            conv.setItem(13, ISC.createItem(Material.DIAMOND, ChatColor.DARK_AQUA + "Pick a Vehicle!"));
            conv.setItem(30, GI.xWing(ChatColor.RED));
            conv.setItem(32, GI.tieFighter());

            conv.setItem(53, GI.close());

            player.openInventory(conv);
        }

        return true;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        return completions;
    }

    @EventHandler
    public void onConvClick(InventoryClickEvent event){

        Player player = (Player) event.getWhoClicked();

        if (event.getCurrentItem() == null) {
            return;
        }

        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Vehicles")) {
            event.setCancelled(true);
            switch(event.getSlot()){
                case 30:
                    Inventory xWing = Bukkit.createInventory(player, 9, ChatColor.RED + "" + ChatColor.BOLD + "X-Wing Starfighter");

                    xWing.setItem(3, GI.xWing(ChatColor.RED));
                    xWing.setItem(4, GI.xWing(ChatColor.DARK_GREEN));
                    xWing.setItem(5, GI.xWing(ChatColor.DARK_AQUA));

                    xWing.setItem(7, GI.back());
                    xWing.setItem(8, GI.close());

                    player.openInventory(xWing);
                    break;
                case 32:
                    Inventory tie = Bukkit.createInventory(player, 9, ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "Tie Fighter");

                    tie.setItem(4, GI.tieFighter());

                    tie.setItem(7, GI.back());
                    tie.setItem(8, GI.close());

                    player.openInventory(tie);
                    break;
                case 53:
                    player.closeInventory();
                    break;
            }
        }

        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "" + ChatColor.BOLD + "X-Wing Starfighter")) {
            event.setCancelled(true);
            /*if(player.getItemInUse() == null){
                return;
            }*/
            ItemStack inUse = player.getInventory().getItemInMainHand();

            player.closeInventory();

            switch(event.getSlot()){
                case 3:
                    if(inUse.isSimilar(GI.xWing(ChatColor.DARK_GREEN)) || inUse.isSimilar(GI.xWing(ChatColor.DARK_AQUA))){
                        player.getInventory().setItemInMainHand(GI.xWing(ChatColor.RED));
                        player.sendMessage(translate(prefix + "&7Converted your X-Wing into a &cRed Squadron X-Wing&7."));
                    }else if(inUse.isSimilar(GI.xWing(ChatColor.RED))){
                        player.sendMessage(translate(prefix + "&7You already have a &cRed Squadron X-Wing&7."));
                    }else{
                        player.sendMessage(translate(prefix + "&7You are not holding a &cRed Squadron X-Wing &7in your hand!"));
                    }
                    break;
                case 4:
                    if(inUse.isSimilar(GI.xWing(ChatColor.RED)) || inUse.isSimilar(GI.xWing(ChatColor.DARK_AQUA))){
                        player.getInventory().setItemInMainHand(GI.xWing(ChatColor.DARK_GREEN));
                        player.sendMessage(translate(prefix + "&7Converted your X-Wing into a &2Green Squadron X-Wing&7."));
                    }else if(inUse.isSimilar(GI.xWing(ChatColor.DARK_GREEN))){
                        player.sendMessage(translate(prefix + "&7You already have a &2Green Squadron X-Wing&7."));
                    }else{
                        player.sendMessage(translate(prefix + "&7You are not holding a &2Green Squadron X-Wing &7in your hand!"));
                    }
                    break;
                case 5:
                    if(inUse.isSimilar(GI.xWing(ChatColor.RED)) || inUse.isSimilar(GI.xWing(ChatColor.DARK_GREEN))){
                        player.getInventory().setItemInMainHand(GI.xWing(ChatColor.DARK_AQUA));
                        player.sendMessage(translate(prefix + "&7Converted your X-Wing into a &3Blue Squadron X-Wing&7."));
                    }else if(inUse.isSimilar(GI.xWing(ChatColor.DARK_AQUA))){
                        player.sendMessage(translate(prefix + "&7You already have a &3Blue Squadron X-Wing&7."));
                    }else{
                        player.sendMessage(translate(prefix + "&7You are not holding a &3Blue Squadron X-Wing &7in your hand!"));
                    }
                    break;
                case 7:
                    player.performCommand("vehicle");
                    break;
                //don't need 8 bc close inventory is before switch statement
            }
        }

        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "Tie Fighter")) {
            event.setCancelled(true);

            player.closeInventory();

            switch(event.getSlot()){
                case 4:
                    player.sendMessage(prefix + "&7Sorry, we only have one Tie Fighter variant...mining guild soon!");
                case 7:
                    player.performCommand("vehicle");
                    break;
                //don't need 8 bc close inventory is before switch statement
            }
        }
    }

    public String translate(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
