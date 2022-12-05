package mandomc.mmccore.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Pitch implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {return true;}

        if(command.getName().equalsIgnoreCase("pitch")){
            Player player = (Player) sender;
            Float pitch = player.getLocation().getPitch();

            player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "MMCCore" + ChatColor.DARK_GRAY + " » " + ChatColor.GRAY + "Your pitch is: " + pitch + "!");
        }

        return true;
    }
}
