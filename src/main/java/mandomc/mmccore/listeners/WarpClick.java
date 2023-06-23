package mandomc.mmccore.listeners;

import mandomc.mmccore.MMCCore;
import mandomc.mmccore.config.WarpConfig;
import mandomc.mmccore.handlers.WarpInventories;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class WarpClick implements Listener {

    String prefix = MMCCore.prefix + ChatColor.GRAY + "Traveling to the ";

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();

        if (event.getCurrentItem() == null) {
            return;
        }

        Inventory tatooine = WarpInventories.createTatooine(player);

        Inventory concordia = WarpInventories.createConcordia(player);

        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "MandoMC Warps")) {
            event.setCancelled(true);
            if(event.getSlot() == WarpConfig.get().getInt("MorakSlot")) {
                Location morak = new Location(Bukkit.getWorld("Morak"), WarpConfig.get().getDouble("MorakX"), WarpConfig.get().getDouble("MorakY"), WarpConfig.get().getDouble("MorakZ"), (float) WarpConfig.get().getDouble("MorakYaw"), (float) WarpConfig.get().getDouble("MorakPitch"));
                player.sendMessage(prefix + translate("MorakName"));
                player.teleport(morak);
                player.updateInventory();
            }else if(event.getSlot() == WarpConfig.get().getInt("IlumSlot")) {
                Location ilum = new Location(Bukkit.getWorld("Ilum"), WarpConfig.get().getDouble("IlumX"), WarpConfig.get().getDouble("IlumY"), WarpConfig.get().getDouble("IlumZ"), (float) WarpConfig.get().getDouble("IlumYaw"), (float) WarpConfig.get().getDouble("IlumPitch"));
                player.sendMessage(prefix + translate("IlumName"));
                player.teleport(ilum);
                player.updateInventory();
            }else if(event.getSlot() == WarpConfig.get().getInt("MandaloreSlot")) {
                Location mandalore = new Location(Bukkit.getWorld("Mandalore"), WarpConfig.get().getDouble("MandaloreX"), WarpConfig.get().getDouble("MandaloreY"), WarpConfig.get().getDouble("MandaloreZ"), (float) WarpConfig.get().getDouble("MandaloreYaw"), (float) WarpConfig.get().getDouble("MandalorePitch"));
                player.sendMessage(prefix + translate("MandaloreName"));
                player.teleport(mandalore);
                player.updateInventory();
            }else if(event.getSlot() == WarpConfig.get().getInt("DathomirSlot")) {
                Location dathomir = new Location(Bukkit.getWorld("Dathomir"), WarpConfig.get().getDouble("DathomirX"), WarpConfig.get().getDouble("DathomirY"), WarpConfig.get().getDouble("DathomirZ"), (float) WarpConfig.get().getDouble("DathomirYaw"), (float) WarpConfig.get().getDouble("DathomirPitch"));
                player.sendMessage(prefix + translate("DathomirName"));
                player.teleport(dathomir);
                player.updateInventory();
            }else if(event.getSlot() == WarpConfig.get().getInt("UmbaraSlot")) {
                Location umbara = new Location(Bukkit.getWorld("Umbara"), WarpConfig.get().getDouble("UmbaraX"), WarpConfig.get().getDouble("UmbaraY"), WarpConfig.get().getDouble("UmbaraZ"), (float) WarpConfig.get().getDouble("UmbaraYaw"), (float) WarpConfig.get().getDouble("UmbaraPitch"));
                player.sendMessage(prefix + translate("UmbaraName"));
                player.teleport(umbara);
                player.updateInventory();
            }else if(event.getSlot() == WarpConfig.get().getInt("KashyyykSlot")) {
                Location kashyyyk = new Location(Bukkit.getWorld("Kashyyyk"), WarpConfig.get().getDouble("KashyyykX"), WarpConfig.get().getDouble("KashyyykY"), WarpConfig.get().getDouble("KashyyykZ"), (float) WarpConfig.get().getDouble("KashyyykYaw"), (float) WarpConfig.get().getDouble("KashyyykPitch"));
                player.sendMessage(prefix + translate("KashyyykName"));
                player.teleport(kashyyyk);
                player.updateInventory();
            }else if(event.getSlot() == WarpConfig.get().getInt("AlderaanSlot")) {
                Location alderaan = new Location(Bukkit.getWorld("Alderaan"), WarpConfig.get().getDouble("AlderaanX"), WarpConfig.get().getDouble("AlderaanY"), WarpConfig.get().getDouble("AlderaanZ"), (float) WarpConfig.get().getDouble("AlderaanYaw"), (float) WarpConfig.get().getDouble("AlderaanPitch"));
                player.sendMessage(prefix + translate("AlderaanName"));
                player.teleport(alderaan);
                player.updateInventory();
            }else if(event.getSlot() == WarpConfig.get().getInt("HothSlot")) {
                Location hoth = new Location(Bukkit.getWorld("Hoth"), WarpConfig.get().getDouble("HothX"), WarpConfig.get().getDouble("HothY"), WarpConfig.get().getDouble("HothZ"), (float) WarpConfig.get().getDouble("HothYaw"), (float) WarpConfig.get().getDouble("HothPitch"));
                player.sendMessage(prefix + translate("HothName"));
                player.teleport(hoth);
                player.updateInventory();
            }else if(event.getSlot() == WarpConfig.get().getInt("NabooSlot")) {
                Location naboo = new Location(Bukkit.getWorld("Naboo"), WarpConfig.get().getDouble("NabooX"), WarpConfig.get().getDouble("NabooY"), WarpConfig.get().getDouble("NabooZ"), (float) WarpConfig.get().getDouble("NabooYaw"), (float) WarpConfig.get().getDouble("NabooPitch"));
                player.sendMessage(prefix + translate("NabooName"));
                player.teleport(naboo);
                player.updateInventory();
            }else if(event.getSlot() == WarpConfig.get().getInt("ConcordiaSlot")) {
                player.openInventory(concordia);
            }else if(event.getSlot() == WarpConfig.get().getInt("TatooineSlot")) {
                player.openInventory(tatooine);
            }else if(event.getSlot() == WarpConfig.get().getInt("MustafarSlot")) {
                Location mustafar = new Location(Bukkit.getWorld("Mustafar"), WarpConfig.get().getDouble("MustafarX"), WarpConfig.get().getDouble("MustafarY"), WarpConfig.get().getDouble("MustafarZ"), (float) WarpConfig.get().getDouble("MustafarYaw"), (float) WarpConfig.get().getDouble("MustafarPitch"));
                player.sendMessage(prefix + translate("MustafarName"));
                player.teleport(mustafar);
                player.updateInventory();
            }else if(event.getSlot() == WarpConfig.get().getInt("EarthSlot")) {
                Location Earth = new Location(Bukkit.getWorld("Earth"), WarpConfig.get().getDouble("EarthX"), WarpConfig.get().getDouble("EarthY"), WarpConfig.get().getDouble("EarthZ"), (float) WarpConfig.get().getDouble("EarthYaw"), (float) WarpConfig.get().getDouble("EarthPitch"));
                player.sendMessage(prefix + translate("EarthName"));
                player.teleport(Earth);
                player.updateInventory();
            }else if(event.getSlot() == WarpConfig.get().getInt("GeonosisSlot")) {
                Location geonosisLoc = new Location(Bukkit.getWorld("Geonosis"), WarpConfig.get().getDouble("GeonosisX"), WarpConfig.get().getDouble("GeonosisY"), WarpConfig.get().getDouble("GeonosisZ"), (float) WarpConfig.get().getDouble("GeonosisYaw"), (float) WarpConfig.get().getDouble("GeonosisPitch"));
                player.sendMessage(prefix + translate("GeonosisName"));
                player.teleport(geonosisLoc);
                player.updateInventory();
            }
        }
        if (event.getView().getTitle().equalsIgnoreCase(translate("TatooineName"))){
            event.setCancelled(true);
            if(event.getSlot() == WarpConfig.get().getInt("BlackMarketSlot")) {
                Location blackMarket = new Location(Bukkit.getWorld("Tatooine"), WarpConfig.get().getDouble("BlackMarketX"), WarpConfig.get().getDouble("BlackMarketY"), WarpConfig.get().getDouble("BlackMarketZ"), (float) WarpConfig.get().getDouble("BlackMarketYaw"), (float) WarpConfig.get().getDouble("BlackMarketPitch"));
                player.sendMessage(prefix + translate("BlackMarketName"));
                player.teleport(blackMarket);
                player.updateInventory();
            }else if(event.getSlot() == WarpConfig.get().getInt("JabbaSlot")) {
                    Location jabba = new Location(Bukkit.getWorld("JabbasPalace"), WarpConfig.get().getDouble("JabbaX"), WarpConfig.get().getDouble("JabbaY"), WarpConfig.get().getDouble("JabbaZ"), (float) WarpConfig.get().getDouble("JabbaYaw"), (float) WarpConfig.get().getDouble("JabbaPitch"));
                    player.sendMessage(prefix + translate("JabbaName"));
                    player.teleport(jabba);
                    player.updateInventory();
            }else if(event.getSlot() == WarpConfig.get().getInt("MosEisleySlot")) {
                Location moseisley = new Location(Bukkit.getWorld("Tatooine"), WarpConfig.get().getDouble("MosEisleyX"), WarpConfig.get().getDouble("MosEisleyY"), WarpConfig.get().getDouble("MosEisleyZ"), (float) WarpConfig.get().getDouble("MosEisleyYaw"), (float) WarpConfig.get().getDouble("MosEisleyPitch"));
                player.sendMessage(prefix + translate("MosEisleyName"));
                player.teleport(moseisley);
                player.updateInventory();
            }
        }
        if (event.getView().getTitle().equalsIgnoreCase(translate("ConcordiaName"))){
            event.setCancelled(true);
            if(event.getSlot() == WarpConfig.get().getInt("ArenaSlot")) {
                    Location arena = new Location(Bukkit.getWorld("Concordia"), WarpConfig.get().getDouble("ArenaX"), WarpConfig.get().getDouble("ArenaY"), WarpConfig.get().getDouble("ArenaZ"), (float) WarpConfig.get().getDouble("ArenaYaw"), (float) WarpConfig.get().getDouble("ArenaPitch"));
                    player.sendMessage(prefix + translate("ArenaName"));
                    player.teleport(arena);
                    player.updateInventory();
            }else if(event.getSlot() == WarpConfig.get().getInt("MinesSlot")) {
                Location mines = new Location(Bukkit.getWorld("Concordia"), WarpConfig.get().getDouble("MinesX"), WarpConfig.get().getDouble("MinesY"), WarpConfig.get().getDouble("MinesZ"), (float) WarpConfig.get().getDouble("MinesYaw"), (float) WarpConfig.get().getDouble("MinesPitch"));
                player.sendMessage(prefix + translate("MinesName"));
                player.teleport(mines);
                player.updateInventory();
            }
        }
    }

    public String translate(String string) {
        return ChatColor.translateAlternateColorCodes('&', WarpConfig.get().getString(string));
    }

}
