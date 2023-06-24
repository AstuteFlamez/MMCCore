package mandomc.mmccore.commands;

import mandomc.mmccore.MMCCore;
import mandomc.mmccore.managers.Koth;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class StartKoth implements CommandExecutor {

    MMCCore plugin;
    Koth koth;

    String prefix = ChatColor.GREEN + "" + ChatColor.BOLD + "MMCKoth" + ChatColor.DARK_GRAY + " » ";

    public StartKoth(MMCCore plugin) {
        this.plugin = plugin;
    }

    static int time = 0;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("mmc.startkoth")){
                UUID uuid = UUID.randomUUID();

                koth = new Koth(uuid);

                Bukkit.broadcastMessage(prefix + ChatColor.GRAY + "A koth has started on Hoth at -156, 30, 128!");

                new BukkitRunnable(){
                    @Override
                    public void run() {
                        time++;
                        Bukkit.getConsoleSender().sendMessage("" + time);
                        UUID uuid = koth.getUuid();

                        for(Player player : Bukkit.getOnlinePlayers()){

                            String world = player.getWorld().getName();
                            double x = player.getLocation().getX();
                            double z = player.getLocation().getZ();

                            if(world.equals("Hoth") && ((x <= -150 && x >= -158) && (z <= 138 && z >= 124)) && player.getGameMode() == GameMode.SURVIVAL && !player.isInsideVehicle()){
                                if(!koth.getPlayersInKothTime().containsKey(player)){
                                    koth.getPlayersInKothTime().put(player,0);
                                }else{
                                    int playerTime = koth.getPlayersInKothTime().get(player) + 1;
                                    koth.getPlayersInKothTime().replace(player, playerTime);

                                    if(playerTime == 20){
                                        Bukkit.broadcastMessage(prefix + ChatColor.GRAY + player.getName() + " is " + ChatColor.GREEN + "20%" + ChatColor.GRAY + " done capturing koth!");
                                    }else if(playerTime == 50){
                                        Bukkit.broadcastMessage(prefix + ChatColor.GRAY + player.getName() + " is " + ChatColor.GREEN + "50%" + ChatColor.GRAY + " done capturing koth!");
                                    }else if(playerTime == 80){
                                        Bukkit.broadcastMessage(prefix + ChatColor.GRAY + player.getName() + " is " + ChatColor.GREEN + "80%" + ChatColor.GRAY + " done capturing koth!");
                                    } else if(playerTime == 100){
                                        koth.getPlayersInKothTime().clear();
                                        Bukkit.broadcastMessage(prefix + ChatColor.GRAY + player.getName() + " captured koth!");
                                        cancel();
                                        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "excellentcrates key give " + player.getName() + " koth_key 1");
                                    }
                                }
                            }
                        }
                        if(time >= 3600){
                            cancel();
                        }
                    }

                }.runTaskTimer(plugin, 0, 20);
                return true;
            }else{
                player.sendMessage(ChatColor.RED + "The force is not with you...");
            }
        }else{
            UUID uuid = UUID.randomUUID();

            koth = new Koth(uuid);

            Bukkit.broadcastMessage(prefix + ChatColor.GRAY + "A koth has started on Hoth at -138, 30, 135!");

            new BukkitRunnable(){
                @Override
                public void run() {
                    time++;
                    UUID uuid = koth.getUuid();

                    for(Player player : Bukkit.getOnlinePlayers()){

                        String world = player.getWorld().getName();
                        double x = player.getLocation().getX();
                        double z = player.getLocation().getZ();

                        if(world.equals("Hoth2") && ((x <= -128 && x >= -143) && (z <= 143 && z >= 128)) && player.getGameMode() == GameMode.SURVIVAL && !player.isInsideVehicle()){
                            if(!koth.getPlayersInKothTime().containsKey(player)){
                                koth.getPlayersInKothTime().put(player,0);
                            }else{
                                int playerTime = koth.getPlayersInKothTime().get(player) + 1;
                                koth.getPlayersInKothTime().replace(player, playerTime);
                                Bukkit.broadcastMessage(player.getName() + " " + time);

                                if(playerTime == 20){
                                    Bukkit.broadcastMessage(prefix + ChatColor.GRAY + player.getName() + " is " + ChatColor.GREEN + "20%" + ChatColor.GRAY + " done capturing koth!");
                                }else if(playerTime == 50){
                                    Bukkit.broadcastMessage(prefix + ChatColor.GRAY + player.getName() + " is " + ChatColor.GREEN + "50%" + ChatColor.GRAY + " done capturing koth!");
                                }else if(playerTime == 80){
                                    Bukkit.broadcastMessage(prefix + ChatColor.GRAY + player.getName() + " is " + ChatColor.GREEN + "80%" + ChatColor.GRAY + " done capturing koth!");
                                } else if(playerTime == 100){
                                    koth.getPlayersInKothTime().clear();
                                    Bukkit.broadcastMessage(prefix + ChatColor.GRAY + player.getName() + " captured koth!");
                                    cancel();
                                    Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "excellentcrates key give " + player.getName() + " koth_key 1");
                                }
                            }
                        }
                    }
                    if(time >= 3600){
                        cancel();
                    }
                }

            }.runTaskTimer(plugin, 0, 20);
            return true;
        }

        return true;
    }
}
