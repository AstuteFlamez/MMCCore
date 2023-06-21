package mandomc.mmccore.commands;

import mandomc.mmccore.MMCCore;
import mandomc.mmccore.config.WarpConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor {

    String prefix = MMCCore.prefix + ChatColor.GRAY + "Traveling to the ";
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            Location naboo = new Location(Bukkit.getWorld("Naboo"), WarpConfig.get().getDouble("NabooX"), WarpConfig.get().getDouble("NabooY"), WarpConfig.get().getDouble("NabooZ"), (float) WarpConfig.get().getDouble("NabooYaw"), (float) WarpConfig.get().getDouble("NabooPitch"));
            player.sendMessage(prefix + translate("NabooName"));
            player.teleport(naboo);
        }

        return true;
    }

    public String translate(String string) {
        return ChatColor.translateAlternateColorCodes('&', WarpConfig.get().getString(string));
    }
}
