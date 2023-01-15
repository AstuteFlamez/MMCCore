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
        pages.add(0, ChatColor.translateAlternateColorCodes('&', "&2&lMandoMC Guide\n\n&7Read this book to learn how to play! Ask staff any questions!\nUse&6 /guide&7 to regain this book!"));
        pages.add(1, ChatColor.translateAlternateColorCodes('&', "&2&lFACTIONS\n\n&7Factions is a claiming + teams plugin! Use &6/f help &r&7for more info!"));
        pages.add(2, ChatColor.translateAlternateColorCodes('&', "&2&lPLANETS\n\n&7Use the command &6/warp&r&7 and click on a planet to teleport to it!"));
        pages.add(3, ChatColor.translateAlternateColorCodes('&', "&2&lBLASTERS\n\n&7Warp to the &8Black Market &7and buy blasters from a vendor."));
        pages.add(4, ChatColor.translateAlternateColorCodes('&', "&2&lLIGHTSABERS\n\n&7Lightsabers can be crafted using the recipe found in &6/recipes&r&7!"));
        pages.add(5, ChatColor.translateAlternateColorCodes('&', "&2&lBOSSES\n\n&7Bosses drop super useful items! Keep an eye on chat for them!"));
        pages.add(6, ChatColor.translateAlternateColorCodes('&', "&2&lTHE FORCE\n\n&7Use &6/forceside&r&7 to pick a side of the force!\nThen you can use &6/force &7and left click powers to obtain them!"));
        pages.add(7, ChatColor.translateAlternateColorCodes('&', "&2&lVEHICLES\n\n&7Use the command &6/hoverbikeshop &r&7or &6/recipes&r&7 to obtain vehicles."));
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
