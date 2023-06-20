package mandomc.mmccore.commands;

import mandomc.mmccore.MMCCore;
import mandomc.mmccore.config.WarpConfig;
import mandomc.mmccore.handlers.RecipeInventories;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class Reload implements CommandExecutor {

    MMCCore plugin;

    public Reload(MMCCore plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(commandSender instanceof Player){
            Player player = (Player) commandSender;

            if(player.hasPermission("mmc.reload")){
                plugin.reloadConfig();
                WarpConfig.reload();
                player.sendMessage("you reloaded mmccore");
            }

        }else{
            plugin.reloadConfig();
            WarpConfig.reload();
            System.out.println("MMCCore successfully reloaded");
        }
        return true;
    }
}
