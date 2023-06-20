package mandomc.mmccore.commands;

import mandomc.mmccore.handlers.RecipeInventories;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Recipes implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            ItemStack close = new ItemStack(Material.BARRIER, 1);
            ItemMeta cIM = close.getItemMeta();
            cIM.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "CLOSE");
            close.setItemMeta(cIM);

            Player player = (Player) sender;

            player.openInventory(RecipeInventories.recipes(player));

        }else{
            System.out.println("You need to be a player to run this command!");
        }
        return true;
    }
}
