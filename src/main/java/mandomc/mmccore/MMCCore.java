package mandomc.mmccore;

import jdk.javadoc.internal.tool.Start;
import mandomc.mmccore.commands.*;
import mandomc.mmccore.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class MMCCore extends JavaPlugin {

    public static MMCCore instance;

    @Override
    public void onEnable() {

        instance = this;

        getCommand("yaw").setExecutor(new Yaw());
        getCommand("pitch").setExecutor(new Pitch());
        getCommand("help").setExecutor(new Help());
        getCommand("helpbook").setExecutor(new HelpBook());
        getCommand("spawnRancor").setExecutor(new SpawnRancor(this));
        getCommand("startkoth").setExecutor(new StartKoth(this));

        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new InventoryClick(), this);
        getServer().getPluginManager().registerEvents(new ListenerSpam(), this);
        getServer().getPluginManager().registerEvents(new MythicMobDeath(), this);

        MythicMobDeath.rancorSpawn(this);
        MythicMobDeath.maulSpawn(this);
        MythicMobDeath.bobaSpawn(this);
        MythicMobDeath.dookuSpawn(this);

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[MMCCore]: Plugin is enabled");

    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[MMCCore]: Plugin is disabled");
    }

    public static MMCCore getInstance(){
        return instance;
    }

}
