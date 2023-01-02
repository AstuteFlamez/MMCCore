package mandomc.mmccore.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;

public class InventoryClick implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){

        Player player = (Player) event.getWhoClicked();

        String n = "\n";

        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);

        BookMeta bookMeta = (BookMeta) book.getItemMeta();
        bookMeta.setAuthor(ChatColor.GREEN + "MandoMC");
        bookMeta.setTitle(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "MandoMC Guide");

        ArrayList<String> pages = new ArrayList<>();
        pages.add(0, ChatColor.translateAlternateColorCodes('&', "&2&lMandoMC Tricks & Tips\n\n&7This book is a tutorial that will help you learn the ways of the force and server! If you have any additional questions please ask anyone online or a staff. You can also get a quick reply on our discord!"));
        pages.add(1, ChatColor.translateAlternateColorCodes('&', "&2&lClaiming & Teams\n\n &7We use the Factions plugin! You can claim land and create epic bases with your team. Use the command &u/f help&r&7 to learn how to use it!"));
        pages.add(2, ChatColor.translateAlternateColorCodes('&', "&2&lWarping/Traveling\n\n &7Use the command &u/warp&r&7 and click on a planet to teleport to it!"));
        pages.add(3, ChatColor.translateAlternateColorCodes('&', "&2&lBlasters (Guns)\n\n &7Warp to &6Tatooine &7and then the &8Black Market &7to purchases blasters and grenades!"));
        pages.add(4, ChatColor.translateAlternateColorCodes('&', "&2&lLightsabers\n\n &7Lightsabers can be crafted using the recipe found in &u/recipes&r&7!"));
        pages.add(5, ChatColor.translateAlternateColorCodes('&', "&2&lBosses\n\n &7Bosses drop super useful items! Right now the Rancor boss is the only way to get a nether star which is needed to craft lightsabers!"));
        pages.add(6, ChatColor.translateAlternateColorCodes('&', "&2&lForce Powers\n\n &7Use &u/forceside&r&7 to pick a side of the force! Then you can use &u/force &7and left click powers to obtain them!"));
        pages.add(7, ChatColor.translateAlternateColorCodes('&', "&2&lVehicles\n\n &7Use the command &u/hoverbikeshop &7to purchase speeder-bikes! Soon X-Wings & N-1 Starfighters will be craftable aswell!"));
        bookMeta.setPages(pages);
        book.setItemMeta(bookMeta);

        if(event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "MandoMC Help Page")){

            switch (event.getCurrentItem().getType()){
                case WRITTEN_BOOK:
                    player.closeInventory();
                    event.setCancelled(true);
                    player.getInventory().addItem(book);
                    player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "MMCCore" + ChatColor.DARK_GRAY + " » " + ChatColor.GRAY + "Gave you the MandoMC Help Book!");
                    break;
            }
            event.setCancelled(true);
        }

    }

}
