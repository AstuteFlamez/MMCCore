package mandomc.mmccore.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Yaw implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if(!(sender instanceof Player)) {return true;}

        if(command.getName().equalsIgnoreCase("yaw")){
            Player player = (Player) sender;
            Float yaw = player.getLocation().getYaw();

            player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "MMCCore" + ChatColor.DARK_GRAY + " » " + ChatColor.GRAY + "Your yaw is: " + yaw + "!");
        }

        return true;
    }

}
