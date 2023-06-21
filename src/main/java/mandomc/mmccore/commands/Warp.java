package mandomc.mmccore.commands;

import mandomc.mmccore.MMCCore;
import mandomc.mmccore.config.WarpConfig;
import mandomc.mmccore.handlers.WarpInventories;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Warp implements CommandExecutor {

    String prefix = MMCCore.prefix + ChatColor.GRAY + "Traveling to the ";
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;

            Inventory warps = WarpInventories.createWarp(player);

            if(args.length == 1){
                if(args[0].equalsIgnoreCase("morak")){
                    Location morak = new Location(Bukkit.getWorld("Morak"), WarpConfig.get().getDouble("MorakX"), WarpConfig.get().getDouble("MorakY"), WarpConfig.get().getDouble("MorakZ"), (float) WarpConfig.get().getDouble("MorakYaw"), (float) WarpConfig.get().getDouble("MorakPitch"));
                    player.sendMessage(prefix + translate("MorakName"));
                    player.teleport(morak);
                }else if(args[0].equalsIgnoreCase("dathomir")){
                    Location dathomir = new Location(Bukkit.getWorld("Dathomir"), WarpConfig.get().getDouble("DathomirX"), WarpConfig.get().getDouble("DathomirY"), WarpConfig.get().getDouble("DathomirZ"), (float) WarpConfig.get().getDouble("DathomirYaw"), (float) WarpConfig.get().getDouble("DathomirPitch"));
                    player.sendMessage(prefix + translate("DathomirName"));
                    player.teleport(dathomir);
                }else if(args[0].equalsIgnoreCase("umbara")){
                    Location umbara = new Location(Bukkit.getWorld("Umbara"), WarpConfig.get().getDouble("UmbaraX"), WarpConfig.get().getDouble("UmbaraY"), WarpConfig.get().getDouble("UmbaraZ"), (float) WarpConfig.get().getDouble("UmbaraYaw"), (float) WarpConfig.get().getDouble("UmbaraPitch"));
                    player.sendMessage(prefix + translate("UmbaraName"));
                    player.teleport(umbara);
                }else if(args[0].equalsIgnoreCase("alderaan")){
                    Location alderaan = new Location(Bukkit.getWorld("Alderaan"), WarpConfig.get().getDouble("AlderaanX"), WarpConfig.get().getDouble("AlderaanY"), WarpConfig.get().getDouble("AlderaanZ"), (float) WarpConfig.get().getDouble("AlderaanYaw"), (float) WarpConfig.get().getDouble("AlderaanPitch"));
                    player.sendMessage(prefix + translate("AlderaanName"));
                    player.teleport(alderaan);
                }else if(args[0].equalsIgnoreCase("hoth")){
                    Location hoth = new Location(Bukkit.getWorld("Hoth"), WarpConfig.get().getDouble("HothX"), WarpConfig.get().getDouble("HothY"), WarpConfig.get().getDouble("HothZ"), (float) WarpConfig.get().getDouble("HothYaw"), (float) WarpConfig.get().getDouble("HothPitch"));
                    player.sendMessage(prefix + translate("HothName"));
                    player.teleport(hoth);
                }else if(args[0].equalsIgnoreCase("mustafar")){
                    Location mustafar = new Location(Bukkit.getWorld("Mustafar"), WarpConfig.get().getDouble("MustafarX"), WarpConfig.get().getDouble("MustafarY"), WarpConfig.get().getDouble("MustafarZ"), (float) WarpConfig.get().getDouble("MustafarYaw"), (float) WarpConfig.get().getDouble("MustafarPitch"));
                    player.sendMessage(prefix + translate("MustafarName"));
                    player.teleport(mustafar);
                }else if(args[0].equalsIgnoreCase("geonosis")){
                    Location geonosisLoc = new Location(Bukkit.getWorld("Geonosis"), WarpConfig.get().getDouble("GeonosisX"), WarpConfig.get().getDouble("GeonosisY"), WarpConfig.get().getDouble("GeonosisZ"), (float) WarpConfig.get().getDouble("GeonosisYaw"), (float) WarpConfig.get().getDouble("GeonosisPitch"));
                    player.sendMessage(prefix + translate("GeonosisName"));
                    player.teleport(geonosisLoc);
                }else if(args[0].equalsIgnoreCase("blackmarket") || args[0].equalsIgnoreCase("tatooine")){
                    Location blackMarket = new Location(Bukkit.getWorld("Tatooine"), WarpConfig.get().getDouble("BlackMarketX"), WarpConfig.get().getDouble("BlackMarketY"), WarpConfig.get().getDouble("BlackMarketZ"), (float) WarpConfig.get().getDouble("BlackMarketYaw"), (float) WarpConfig.get().getDouble("BlackMarketPitch"));
                    player.sendMessage(prefix + translate("BlackMarketName"));
                    player.teleport(blackMarket);
                }else if (args[0].equalsIgnoreCase("jabba")) {
                    Location jabba = new Location(Bukkit.getWorld("JabbasPalace"), WarpConfig.get().getDouble("JabbaX"), WarpConfig.get().getDouble("JabbaY"), WarpConfig.get().getDouble("JabbaZ"), (float) WarpConfig.get().getDouble("JabbaYaw"), (float) WarpConfig.get().getDouble("JabbaPitch"));
                    player.sendMessage(prefix + translate("JabbaName"));
                    player.teleport(jabba);
                }else if(args[0].equalsIgnoreCase("arena")){
                    Location arena = new Location(Bukkit.getWorld("Concordia"), WarpConfig.get().getDouble("ArenaX"), WarpConfig.get().getDouble("ArenaY"), WarpConfig.get().getDouble("ArenaZ"), (float) WarpConfig.get().getDouble("ArenaYaw"), (float) WarpConfig.get().getDouble("ArenaPitch"));
                    player.sendMessage(prefix + translate("ArenaName"));
                    player.teleport(arena);
                }else if(args[0].equalsIgnoreCase("kashyyyk")){
                    Location kashyyyk = new Location(Bukkit.getWorld("Kashyyyk"), WarpConfig.get().getDouble("KashyyykX"), WarpConfig.get().getDouble("KashyyykY"), WarpConfig.get().getDouble("KashyyykZ"), (float) WarpConfig.get().getDouble("KashyyykYaw"), (float) WarpConfig.get().getDouble("KashyyykPitch"));
                    player.sendMessage(prefix + translate("KashyyykName"));
                    player.teleport(kashyyyk);
                }else if(args[0].equalsIgnoreCase("mandalore")){
                    Location mandalore = new Location(Bukkit.getWorld("Mandalore"), WarpConfig.get().getDouble("MandaloreX"), WarpConfig.get().getDouble("MandaloreY"), WarpConfig.get().getDouble("MandaloreZ"), (float) WarpConfig.get().getDouble("MandaloreYaw"), (float) WarpConfig.get().getDouble("MandalorePitch"));
                    player.sendMessage(prefix + translate("MandaloreName"));
                    player.teleport(mandalore);
                }else if(args[0].equalsIgnoreCase("ilum")){
                    Location ilum = new Location(Bukkit.getWorld("Ilum"), WarpConfig.get().getDouble("IlumX"), WarpConfig.get().getDouble("IlumY"), WarpConfig.get().getDouble("IlumZ"), (float) WarpConfig.get().getDouble("IlumYaw"), (float) WarpConfig.get().getDouble("IlumPitch"));
                    player.sendMessage(prefix + translate("IlumName"));
                    player.teleport(ilum);
                }else if(args[0].equalsIgnoreCase("naboo")){
                    Location naboo = new Location(Bukkit.getWorld("Naboo"), WarpConfig.get().getDouble("NabooX"), WarpConfig.get().getDouble("NabooY"), WarpConfig.get().getDouble("NabooZ"), (float) WarpConfig.get().getDouble("NabooYaw"), (float) WarpConfig.get().getDouble("NabooPitch"));
                    player.sendMessage(prefix + translate("NabooName"));
                    player.teleport(naboo);
                }else if(args[0].equalsIgnoreCase("earth")){
                    Location Earth = new Location(Bukkit.getWorld("Earth"), WarpConfig.get().getDouble("EarthX"), WarpConfig.get().getDouble("EarthY"), WarpConfig.get().getDouble("EarthZ"), (float) WarpConfig.get().getDouble("EarthYaw"), (float) WarpConfig.get().getDouble("EarthPitch"));
                    player.sendMessage(prefix + translate("EarthName"));
                    player.teleport(Earth);
                }else{
                    player.openInventory(warps);
                }
            }else{
                player.openInventory(warps);
            }


        }else{
            return true;
        }

        return true;
    }
    public String translate(String string) {
        return ChatColor.translateAlternateColorCodes('&', WarpConfig.get().getString(string));
    }
}
