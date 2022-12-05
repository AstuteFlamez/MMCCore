package mandomc.mmccore;

import mandomc.mmccore.commands.Help;
import mandomc.mmccore.commands.HelpBook;
import mandomc.mmccore.commands.Pitch;
import mandomc.mmccore.commands.Yaw;
import mandomc.mmccore.events.InventoryClick;
import mandomc.mmccore.events.PlayerJoin;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class MMCCore extends JavaPlugin {

    @Override
    public void onEnable() {

        getCommand("yaw").setExecutor(new Yaw());
        getCommand("pitch").setExecutor(new Pitch());
        getCommand("help").setExecutor(new Help());
        getCommand("helpbook").setExecutor(new HelpBook());

        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new InventoryClick(), this);

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[MMCCore]: Plugin is enabled");

    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[MMCCore]: Plugin is disabled");
    }
}
