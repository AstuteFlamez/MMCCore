package mandomc.mmccore.commands;

import mandomc.mmccore.handlers.ISC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class Help implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            if(command.getName().equalsIgnoreCase("help")){

                Player player = (Player) sender;

                Inventory help = Bukkit.createInventory(player, 9, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "MandoMC Help Page");

                ItemStack book = new ItemStack(Material.WRITTEN_BOOK);

                BookMeta bookMeta = (BookMeta) book.getItemMeta();
                bookMeta.setAuthor(ChatColor.GREEN + "MandoMC");
                bookMeta.setTitle(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "MandoMC HelpBook");
                book.setItemMeta(bookMeta);

                help.setItem(4, book);

                player.openInventory(help);

            }

        }else{
            return true;
        }

        return true;
    }
}
