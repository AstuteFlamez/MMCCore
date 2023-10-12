package mandomc.mmccore.commands;

import mandomc.mmccore.MMCCore;
import mandomc.mmccore.config.SaberConfig;
import mandomc.mmccore.config.WarpConfig;
import mandomc.mmccore.handlers.GI;
import mandomc.mmccore.handlers.RecipeInventories;
import mandomc.mmccore.handlers.WarpInventories;
import mandomc.mmccore.managers.Koth;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static mandomc.mmccore.MMCCore.prefix;

public class MC implements CommandExecutor, TabExecutor, Listener {

    MMCCore plugin;
    Koth koth;
    static int time = 0;


    public MC(MMCCore plugin){
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            if(args.length==0){

            }else if(args.length==1){

                switch(args[0]){
                    case "get":
                        getGUI();
                        break;
                    case "give":
                        player.sendMessage("ee");
                        break;
                    case "yaw":
                        yaw(player);
                        break;
                    case "pitch":
                        pitch(player);
                        break;
                    case "recipes":
                        player.openInventory(RecipeInventories.recipes(player));
                        break;
                    case "reload":
                        reload(player);
                        break;
                    case "spawn":
                        Location naboo = new Location(Bukkit.getWorld("Naboo"), WarpConfig.get().getDouble("NabooX"), WarpConfig.get().getDouble("NabooY"), WarpConfig.get().getDouble("NabooZ"), (float) WarpConfig.get().getDouble("NabooYaw"), (float) WarpConfig.get().getDouble("NabooPitch"));
                        player.sendMessage(prefix + translate("NabooName"));
                        player.teleport(naboo);
                        break;
                    case "startkoth":
                        startkoth(player);
                        break;
                    case "warp":
                        player.openInventory(WarpInventories.createWarp(player));
                        break;
                }
            }else if(args.length==2){
                switch(args[0]){
                    case "get":
                        get(player, args[1]);
                        break;
                    case "give":
                        player.sendMessage("player??");
                        break;
                    case "warp":
                        warp(player, args[1]);
                        break;
                }
            }else if(args.length==3){
                if(args[0].equalsIgnoreCase("get")){
                    get(player, args[1], args[2]);
                }else if(args[0].equalsIgnoreCase("give")){
                    give(player, args[1], args[2]);
                }
            }else if(args.length==4){
                if(args[0].equalsIgnoreCase("give")){
                    give(player, args[1], args[2], args[3]);
                }
            }

        }else{
            if(args.length==0){

            }else if(args.length==1){

                switch(args[0]){
                    case "reload":
                        reload();
                    case "startkoth":
                        startkoth();
                }
            }
        }

        return true;
    }

    public void warp(Player player, String input){
        if (player.hasPermission("mmc.warps")) {
            Location warpLocation = null;
            String warpPrefix = MMCCore.prefix + ChatColor.GRAY + "Traveling to the ";

            switch (input) {
                case "alderaan":
                    warpLocation = new Location(Bukkit.getWorld("Alderaan"), WarpConfig.get().getDouble("AlderaanX"), WarpConfig.get().getDouble("AlderaanY"), WarpConfig.get().getDouble("AlderaanZ"), (float) WarpConfig.get().getDouble("AlderaanYaw"), (float) WarpConfig.get().getDouble("AlderaanPitch"));
                    player.sendMessage(warpPrefix + translate("AlderaanName"));
                    break;
                case "arena":
                    warpLocation = new Location(Bukkit.getWorld("Concordia"), WarpConfig.get().getDouble("ArenaX"), WarpConfig.get().getDouble("ArenaY"), WarpConfig.get().getDouble("ArenaZ"), (float) WarpConfig.get().getDouble("ArenaYaw"), (float) WarpConfig.get().getDouble("ArenaPitch"));
                    player.sendMessage(warpPrefix + translate("ArenaName"));
                    break;
                case "blackmarket":
                    warpLocation = new Location(Bukkit.getWorld("Tatooine"), WarpConfig.get().getDouble("BlackMarketX"), WarpConfig.get().getDouble("BlackMarketY"), WarpConfig.get().getDouble("BlackMarketZ"), (float) WarpConfig.get().getDouble("BlackMarketYaw"), (float) WarpConfig.get().getDouble("BlackMarketPitch"));
                    player.sendMessage(warpPrefix + translate("BlackMarketName"));
                    break;
                case "tatooine":
                    warpLocation = new Location(Bukkit.getWorld("MosEisleyName"), WarpConfig.get().getDouble("MosEisleyX"), WarpConfig.get().getDouble("MosEisleyY"), WarpConfig.get().getDouble("MosEisleyZ"), (float) WarpConfig.get().getDouble("MosEisleYaw"), (float) WarpConfig.get().getDouble("MosEisleyPitch"));
                    player.sendMessage(warpPrefix + translate("MosEisleyName"));
                    break;
                case "dathomir":
                    warpLocation = new Location(Bukkit.getWorld("Dathomir"), WarpConfig.get().getDouble("DathomirX"), WarpConfig.get().getDouble("DathomirY"), WarpConfig.get().getDouble("DathomirZ"), (float) WarpConfig.get().getDouble("DathomirYaw"), (float) WarpConfig.get().getDouble("DathomirPitch"));
                    player.sendMessage(warpPrefix + translate("DathomirName"));
                    break;
                case "earth":
                    warpLocation = new Location(Bukkit.getWorld("Earth"), WarpConfig.get().getDouble("EarthX"), WarpConfig.get().getDouble("EarthY"), WarpConfig.get().getDouble("EarthZ"), (float) WarpConfig.get().getDouble("EarthYaw"), (float) WarpConfig.get().getDouble("EarthPitch"));
                    player.sendMessage(warpPrefix + translate("EarthName"));
                    break;
                case "geonosis":
                    warpLocation = new Location(Bukkit.getWorld("Geonosis"), WarpConfig.get().getDouble("GeonosisX"), WarpConfig.get().getDouble("GeonosisY"), WarpConfig.get().getDouble("GeonosisZ"), (float) WarpConfig.get().getDouble("GeonosisYaw"), (float) WarpConfig.get().getDouble("GeonosisPitch"));
                    player.sendMessage(warpPrefix + translate("GeonosisName"));
                    break;
                case "hoth":
                    warpLocation = new Location(Bukkit.getWorld("Hoth"), WarpConfig.get().getDouble("HothX"), WarpConfig.get().getDouble("HothY"), WarpConfig.get().getDouble("HothZ"), (float) WarpConfig.get().getDouble("HothYaw"), (float) WarpConfig.get().getDouble("HothPitch"));
                    player.sendMessage(warpPrefix + translate("HothName"));
                    break;
                case "ilum":
                    warpLocation = new Location(Bukkit.getWorld("Ilum"), WarpConfig.get().getDouble("IlumX"), WarpConfig.get().getDouble("IlumY"), WarpConfig.get().getDouble("IlumZ"), (float) WarpConfig.get().getDouble("IlumYaw"), (float) WarpConfig.get().getDouble("IlumPitch"));
                    player.sendMessage(warpPrefix + translate("IlumName"));
                    break;
                case "jabba":
                    warpLocation = new Location(Bukkit.getWorld("JabbasPalace"), WarpConfig.get().getDouble("JabbaX"), WarpConfig.get().getDouble("JabbaY"), WarpConfig.get().getDouble("JabbaZ"), (float) WarpConfig.get().getDouble("JabbaYaw"), (float) WarpConfig.get().getDouble("JabbaPitch"));
                    player.sendMessage(warpPrefix + translate("JabbaName"));
                    break;
                case "kashyyyk":
                    warpLocation = new Location(Bukkit.getWorld("Kashyyyk"), WarpConfig.get().getDouble("KashyyykX"), WarpConfig.get().getDouble("KashyyykY"), WarpConfig.get().getDouble("KashyyykZ"), (float) WarpConfig.get().getDouble("KashyyykYaw"), (float) WarpConfig.get().getDouble("KashyyykPitch"));
                    player.sendMessage(warpPrefix + translate("KashyyykName"));
                    break;
                case "mandalore":
                    warpLocation = new Location(Bukkit.getWorld("Mandalore"), WarpConfig.get().getDouble("MandaloreX"), WarpConfig.get().getDouble("MandaloreY"), WarpConfig.get().getDouble("MandaloreZ"), (float) WarpConfig.get().getDouble("MandaloreYaw"), (float) WarpConfig.get().getDouble("MandalorePitch"));
                    player.sendMessage(warpPrefix + translate("MandaloreName"));
                    break;
                case "mines":
                    warpLocation = new Location(Bukkit.getWorld("Concordia"), WarpConfig.get().getDouble("MinesX"), WarpConfig.get().getDouble("MinesY"), WarpConfig.get().getDouble("MinesZ"), (float) WarpConfig.get().getDouble("MinesYaw"), (float) WarpConfig.get().getDouble("MinesPitch"));
                    player.sendMessage(warpPrefix + translate("MinesName"));
                    break;
                case "moseisley":
                    warpLocation = new Location(Bukkit.getWorld("Tatooine"), WarpConfig.get().getDouble("MosEisleyX"), WarpConfig.get().getDouble("MosEisleyY"), WarpConfig.get().getDouble("MosEisleyZ"), (float) WarpConfig.get().getDouble("MosEisleYaw"), (float) WarpConfig.get().getDouble("MosEisleyPitch"));
                    player.sendMessage(warpPrefix + translate("MosEisleyName"));
                    break;
                case "morak":
                    warpLocation = new Location(Bukkit.getWorld("Morak"), WarpConfig.get().getDouble("MorakX"), WarpConfig.get().getDouble("MorakY"), WarpConfig.get().getDouble("MorakZ"), (float) WarpConfig.get().getDouble("MorakYaw"), (float) WarpConfig.get().getDouble("MorakPitch"));
                    player.sendMessage(warpPrefix + translate("MorakName"));
                    break;
                case "mustafar":
                    warpLocation = new Location(Bukkit.getWorld("Mustafar"), WarpConfig.get().getDouble("MustafarX"), WarpConfig.get().getDouble("MustafarY"), WarpConfig.get().getDouble("MustafarZ"), (float) WarpConfig.get().getDouble("MustafarYaw"), (float) WarpConfig.get().getDouble("MustafarPitch"));
                    player.sendMessage(warpPrefix + translate("MustafarName"));
                    break;
                case "naboo":
                    warpLocation = new Location(Bukkit.getWorld("Naboo"), WarpConfig.get().getDouble("NabooX"), WarpConfig.get().getDouble("NabooY"), WarpConfig.get().getDouble("NabooZ"), (float) WarpConfig.get().getDouble("NabooYaw"), (float) WarpConfig.get().getDouble("NabooPitch"));
                    player.sendMessage(warpPrefix + translate("NabooName"));
                    break;
                case "umbara":
                    warpLocation = new Location(Bukkit.getWorld("Umbara"), WarpConfig.get().getDouble("UmbaraX"), WarpConfig.get().getDouble("UmbaraY"), WarpConfig.get().getDouble("UmbaraZ"), (float) WarpConfig.get().getDouble("UmbaraYaw"), (float) WarpConfig.get().getDouble("UmbaraPitch"));
                    player.sendMessage(warpPrefix + translate("UmbaraName"));
                    break;
                default:
                    player.openInventory(WarpInventories.createWarp(player));
                    break;
            }
            if (warpLocation != null) {
                player.teleport(warpLocation);
            }
        } else {
            player.openInventory(WarpInventories.createWarp(player));
        }
    }
    public void startkoth(Player player){
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
        }else{
            player.sendMessage(ChatColor.RED + "The force is not with you...");
        }
    }

    public void startkoth(){
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
    }
    public void reload(Player player){
        plugin.reloadConfig();
        WarpConfig.reload();
        SaberConfig.reload();
        player.sendMessage("you reloaded mmccore. nice job!");
    }

    public void reload(){
        plugin.reloadConfig();
        WarpConfig.reload();
        SaberConfig.reload();
        Bukkit.getConsoleSender().sendMessage("MMCCore successfully reloaded!");
    }
    public void yaw(Player player){
        player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "MMCCore" + ChatColor.DARK_GRAY + " » " + ChatColor.GRAY + "Your yaw is: " + player.getLocation().getYaw() + "!");
    }

    public void pitch(Player player){
        player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "MMCCore" + ChatColor.DARK_GRAY + " » " + ChatColor.GRAY + "Your pitch is: " + player.getLocation().getPitch() + "!");
    }
    public void give(Player player, String user, String input){
        Player target = Bukkit.getServer().getPlayerExact(user);
        if(target == null){
            player.sendMessage(ChatColor.RED + "You did not provide an online player!");
        }else{
            get(target, input);
        }
    }

    public void give(Player player, String user, String input, String color){
        Player target = Bukkit.getServer().getPlayerExact(user);
        if(target == null){
            player.sendMessage(ChatColor.RED + "You did not provide an online player!");
        }else{
            get(target, input, color);
        }
    }
    public void get(Player player, String input) {
        input = input.toLowerCase();

        switch (input) {
            case "xwing":
                player.getInventory().addItem(GI.xWing(ChatColor.RED));
                break;
            case "tie":
                player.getInventory().addItem(GI.tieFighter());
                break;
            case "lightsabercore":
                player.getInventory().addItem(GI.lightsaberCore());
                break;
            case "singlebladedhilt":
                player.getInventory().addItem(GI.singleBladedHilt());
                break;
            case "doublebladedhilt":
                player.getInventory().addItem(GI.doubleBladedHilt());
                break;
            case "crossguardhilt":
                player.getInventory().addItem(GI.crossGuardHilt());
                break;
            case "dookuhilt":
                player.getInventory().addItem(GI.dookuHilt());
                break;
            case "inquisitorhilt":
                player.getInventory().addItem(GI.inquisitorHilt());
                break;
            case "dookusaber":
                player.getInventory().addItem(GI.dookuSaber());
                break;
            case "inquisitorsaber":
                player.getInventory().addItem(GI.inquisitorSaber());
                break;
            case "kyberite":
                player.getInventory().addItem(GI.kyberite());
                break;
            case "darksaber":
                player.getInventory().addItem(GI.darksaber());
                break;
            default:
                player.sendMessage(ChatColor.RED + "Incorrect Syntax! /mmcget <item> [color]");
                break;
        }
    }

    public void get(Player player, String input, String color) {
        input = input.toLowerCase();
        color = color.toLowerCase();

        switch (input) {
            case "singlebladed":
                switch (color) {
                    case "red":
                        player.getInventory().addItem(GI.singleBladedRed());
                        break;
                    case "blue":
                        player.getInventory().addItem(GI.singleBladedBlue());
                        break;
                    case "green":
                        player.getInventory().addItem(GI.singleBladedGreen());
                        break;
                    case "purple":
                        player.getInventory().addItem(GI.singleBladedPurple());
                        break;
                    case "yellow":
                        player.getInventory().addItem(GI.singleBladedYellow());
                        break;
                    case "white":
                        player.getInventory().addItem(GI.singleBladedWhite());
                        break;
                    default:
                        player.sendMessage(ChatColor.RED + "Incorrect Syntax! /mmcget <item> [color]");
                        break;
                }
                break;
            case "doublebladed":
                switch (color) {
                    case "red":
                        player.getInventory().addItem(GI.doubleBladedRed());
                        break;
                    case "blue":
                        player.getInventory().addItem(GI.doubleBladedBlue());
                        break;
                    case "green":
                        player.getInventory().addItem(GI.doubleBladedGreen());
                        break;
                    case "purple":
                        player.getInventory().addItem(GI.doubleBladedPurple());
                        break;
                    case "yellow":
                        player.getInventory().addItem(GI.doubleBladedYellow());
                        break;
                    case "white":
                        player.getInventory().addItem(GI.doubleBladedWhite());
                        break;
                    default:
                        player.sendMessage(ChatColor.RED + "Incorrect Syntax! /mmcget <item> [color]");
                        break;
                }
                break;
            case "crossguard":
                switch (color) {
                    case "red":
                        player.getInventory().addItem(GI.crossGuardRed());
                        break;
                    case "blue":
                        player.getInventory().addItem(GI.crossGuardBlue());
                        break;
                    case "green":
                        player.getInventory().addItem(GI.crossGuardGreen());
                        break;
                    case "purple":
                        player.getInventory().addItem(GI.crossGuardPurple());
                        break;
                    case "yellow":
                        player.getInventory().addItem(GI.crossGuardYellow());
                        break;
                    case "white":
                        player.getInventory().addItem(GI.crossGuardWhite());
                        break;
                    default:
                        player.sendMessage(ChatColor.RED + "Incorrect Syntax! /mmcget <item> [color]");
                        break;
                }
                break;
            case "kyber":
                switch (color) {
                    case "red":
                        player.getInventory().addItem(GI.redKyber());
                        break;
                    case "blue":
                        player.getInventory().addItem(GI.blueKyber());
                        break;
                    case "green":
                        player.getInventory().addItem(GI.greenKyber());
                        break;
                    case "purple":
                        player.getInventory().addItem(GI.purpleKyber());
                        break;
                    case "yellow":
                        player.getInventory().addItem(GI.yellowKyber());
                        break;
                    case "white":
                        player.getInventory().addItem(GI.whiteKyber());
                        break;
                    default:
                        player.sendMessage(ChatColor.RED + "Incorrect Syntax! /mmcget <item> [color]");
                        break;
                }
                break;
            default:
                player.sendMessage(ChatColor.RED + "Incorrect Syntax! /mmcget <item> [color]");
                break;
        }
    }

    public void getGUI(){

    }

    public String translate(String string) {
        return ChatColor.translateAlternateColorCodes('&', WarpConfig.get().getString(string));
    }

    @Nullable
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();
        List<String> items = Arrays.asList("xwing", "tie", "lightsaberCore", "singleBladedHilt", "doubleBladedHilt", "crossGuardHilt", "singleBladed", "doubleBladed", "crossGuard", "dookuHilt", "inquisitorHilt", "dookuSaber", "inquisitorSaber", "kyberite", "darksaber");
        List<String> colors = Arrays.asList("red", "blue", "green", "purple", "yellow", "white");
        List<String> cmds = Arrays.asList("get", "give", "yaw", "pitch", "recipes", "reload", "spawn", "startkoth", "warp");
        List<String> warps = Arrays.asList("alderaan", "arena", "blackmarket", "dathomir", "earth", "geonosis", "hoth", "ilum", "jabba", "kashyyyk", "mandalore", "mines", "moseisley", "morak", "mustafar", "naboo", "umbara");
        if (args.length == 1) {
            // Provide completions for item names
            completions.addAll(cmds);

        } else if (args.length == 2) {
            // Provide completions for colors
            switch(args[0]){
                case "get":
                    completions.addAll(items);
                    break;
                case "give":
                    for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                        completions.add(onlinePlayer.getName());
                    }
                    break;
                case "warp":
                    completions.addAll(warps);
                    break;
            }
        }else if (args.length == 3) {
            // Provide completions for colors
            if(args[1].equalsIgnoreCase("singlebladed".toLowerCase()) || args[1].equalsIgnoreCase("doublebladed".toLowerCase()) || args[1].equalsIgnoreCase("crossguard".toLowerCase())){
                completions.addAll(colors);
            }else{
                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    if(args[1].contains(onlinePlayer.toString())){
                        completions.addAll(items);
                    }
                }
            }
        }else if (args.length == 4) {
            // Provide completions for colors
            if(args[2].equalsIgnoreCase("singlebladed".toLowerCase()) || args[1].equalsIgnoreCase("doublebladed".toLowerCase()) || args[1].equalsIgnoreCase("crossguard".toLowerCase())){
                completions.addAll(colors);
            }
        }
        return completions;
    }
}
