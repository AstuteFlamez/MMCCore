package mandomc.mmccore.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onFirstJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();

        String n = "\n";

        if(!player.hasPlayedBefore()){

            ItemStack book = new ItemStack(Material.WRITTEN_BOOK);

            BookMeta bookMeta = (BookMeta) book.getItemMeta();
            bookMeta.setAuthor(ChatColor.GREEN + "MandoMC");
            bookMeta.setTitle(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "MandoMC HelpBook");

            ArrayList<String> pages = new ArrayList<>();
            pages.add(0, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "MandoMC Tips & Tricks"
                    + n + "" + n + ChatColor.GRAY + "This book is a tutorial that will help you learn this server!" +
                    " If you have any additional questions please ask anyone online or a staff. " +
                    "You can also get a quick reply on our discord!");
            pages.add(1, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Claiming & Teams"
                    + n + "" + n + ChatColor.GRAY + "We use the Factions plugin! You can claim land and create epic bases with your team. " +
                    "Use the command " + ChatColor.UNDERLINE + "/f help" + ChatColor.GRAY + " to learn how to use it!");
            pages.add(2, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Warping/Traveling"
                    + n + "" + n + ChatColor.GRAY + "Use the command " + ChatColor.UNDERLINE + "/warp" + ChatColor.GRAY + " and click on a planet to teleport to it!");
            pages.add(3, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Blasters (Guns)"
                    + n + "" + n + ChatColor.GRAY + "Blasters are a major block in our pvp system. " +
                    "You can purchase them at the " + ChatColor.DARK_GRAY + "black market" + ChatColor.GRAY +
                    ". Travel to the black market by using the command " + ChatColor.UNDERLINE + "/warp" + ChatColor.GRAY +
                    " and click on " + ChatColor.GOLD + "" + ChatColor.BOLD + "Tatooine" + ChatColor.GRAY + " and then the " + ChatColor.DARK_GRAY + "black market" + ChatColor.GRAY +
                    ". You can purchase blasters there.");
            pages.add(4, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Custom Items"
                    + n + "" + n + ChatColor.GRAY + "We have custom items on our server!" +
                    " Currently they only include " + ChatColor.RED + "lightsabers" + ChatColor.GRAY + ", however we will add more items soon!" +
                    ChatColor.GRAY + "Use the command " + ChatColor.UNDERLINE + "/recipes" + ChatColor.GRAY + " to see how to craft them!");
            pages.add(5, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Bosses"
                    + n + "" + n + ChatColor.GRAY + "Currently, every hour the "
                    + ChatColor.GOLD + "" + ChatColor.BOLD + "Rancor Boss" + ChatColor.GRAY + "spawns at Jabba's Palace! " +
                    "Bosses are a great way to get extremely valuable items!");
            pages.add(6, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Koths"
                    + n + "" + n + ChatColor.GRAY + "Koths, or King of the Hills generate every 4 hours; " +
                    "however, if no one won the last koth it will continue to run so make sure to check if a koth is active! " +
                    "Koths contain great rewards!");
            pages.add(7, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Vehicles"
                    + n + "" + n + ChatColor.GRAY + "Vehicles are fun ways to get from one to place to the next!" +
                    " Purchase a speeder bike at "
                    + ChatColor.UNDERLINE + "/hoverbikeshop" + ChatColor.GRAY + "!");

            bookMeta.setPages(pages);
            book.setItemMeta(bookMeta);
            player.getInventory().setItem(8, book);

        }
    }

}
