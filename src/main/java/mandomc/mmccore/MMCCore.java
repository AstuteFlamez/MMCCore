package mandomc.mmccore;

import mandomc.mmccore.commands.*;
import mandomc.mmccore.listeners.*;
import mandomc.mmccore.recipes.Recipes;
import mandomc.mmccore.tasks.ShipsRunnable;
import mandomc.mmccore.vehicles.TieFighter;
import mandomc.mmccore.vehicles.XWing;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.UUID;

public final class MMCCore extends JavaPlugin {

    private final HashMap<UUID, Long> lightsaberCooldown;

    public static String prefix = ChatColor.GREEN + "" + ChatColor.BOLD + "MMCITEMS" + ChatColor.DARK_GRAY + " » ";

    public static MMCCore instance;

    public MMCCore() {
        lightsaberCooldown = new HashMap<>();
    }

    @Override
    public void onEnable() {

        Recipes.init();

        instance = this;

        BukkitTask vehicleTask = new ShipsRunnable(this).runTaskTimer(this, 0L, 1L);

        getCommand("recipes").setExecutor(new mandomc.mmccore.commands.Recipes());
        getCommand("mmcget").setExecutor(new MMCGet());
        getCommand("mmcgive").setExecutor(new MMCGive());
        getCommand("yaw").setExecutor(new Yaw());
        getCommand("pitch").setExecutor(new Pitch());
        getCommand("startkoth").setExecutor(new StartKoth(this));
        getCommand("warp").setExecutor(new Warp());
        getCommand("spawn").setExecutor(new Spawn());

        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new ExploitFixes(), this);
        getServer().getPluginManager().registerEvents(new MythicMobDeath(), this);
        getServer().getPluginManager().registerEvents(new BeskarChance(), this);
        getServer().getPluginManager().registerEvents(new KyberBleeding(), this);
        getServer().getPluginManager().registerEvents(new TieFighter(), this);
        getServer().getPluginManager().registerEvents(new XWing(), this);
        getServer().getPluginManager().registerEvents(new Vehicles(), this);
        getServer().getPluginManager().registerEvents(new mandomc.mmccore.guis.Recipes(this), this);
        getServer().getPluginManager().registerEvents(new WarpClick(), this);
        getServer().getPluginManager().registerEvents(new LightsaberThrow(lightsaberCooldown), this);

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
