package mandomc.mmccore.vehicles;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.flags.Flags;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldguard.protection.regions.RegionQuery;
import mandomc.mmccore.MMCCore;
import mandomc.mmccore.handlers.GI;
import mandomc.mmccore.listeners.Vehicles;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;
import org.spigotmc.event.entity.EntityDismountEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class XWing implements Listener {

    private static List<Vehicle> allXWings = new ArrayList<>();
    public final HashMap<UUID, Long> torpedosCooldown = new HashMap<>();

    Vehicle xWing;

    public static List<Vehicle> getAllXWings(){
        return allXWings;
    }

    @EventHandler
    public void onPlayerInteractXWing(PlayerInteractEvent event){

        Player player = event.getPlayer();

        if ((event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) && player.getItemInHand().getType() == Material.WOODEN_SWORD && player.getItemInHand().getItemMeta().hasCustomModelData() && player.getItemInHand().getItemMeta() != null) {
            //checks if player spawns in a ship
            ItemMeta itemMeta = player.getItemInHand().getItemMeta();
            if (itemMeta != null) {
                if (itemMeta.getDisplayName().equals(ChatColor.RED + "Red Squadron X-Wing")) {
                    createShip(player, ChatColor.RED);
                } else if (itemMeta.getDisplayName().equals(ChatColor.DARK_GREEN + "Green Squadron X-Wing")) {
                    if (player.hasPermission("mmc.greenxwing")) {
                        createShip(player, ChatColor.DARK_GREEN);
                    } else {
                        player.sendMessage(ChatColor.RED + "The force is not with you...");
                    }
                } else if (itemMeta.getDisplayName().equals(ChatColor.DARK_AQUA + "Blue Squadron X-Wing")) {
                    if (player.hasPermission("mmc.bluexwing")) {
                        createShip(player, ChatColor.DARK_AQUA);
                    } else {
                        player.sendMessage(ChatColor.RED + "The force is not with you...");
                    }
                }
            }
        }

        if (event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
            for (Vehicle xWing : getAllXWings()){
                if(xWing.getPilot() == player){
                    shootTorpedos(player);
                }
            }
        }
    }

    public void createShip(Player player, ChatColor color){

        if(isMobSpawningEnabled(player.getLocation(), player) && !player.getWorld().getName().equals("JabbasPalace")){

            xWing = new Vehicle();

            Location loc = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ());

            Entity seat1 = player.getWorld().spawnEntity(loc, EntityType.PHANTOM);
            Entity model = player.getPlayer().getWorld().spawnEntity(loc, EntityType.ZOMBIE);

            int slot = player.getInventory().getHeldItemSlot();
            player.getInventory().setItem(slot, new ItemStack(Material.AIR));

            LivingEntity seat1Living = (Phantom) seat1;
            LivingEntity modelLiving = (Zombie) model;

            seat1Living.setAI(false);
            seat1Living.setSilent(true);
            seat1Living.setInvisible(true);
            seat1Living.setCollidable(true);
            seat1Living.setPersistent(true); // could be a problem!
            seat1Living.setRemoveWhenFarAway(false);
            seat1Living.setRotation(player.getLocation().getYaw(), 0);

            modelLiving.setAI(false);
            modelLiving.setSilent(true);
            modelLiving.setInvisible(true);
            modelLiving.setCollidable(true);
            seat1Living.setPersistent(true); // could be a problem!
            seat1Living.setRemoveWhenFarAway(false);
            modelLiving.setRotation(player.getLocation().getYaw(), 0);
            modelLiving.getEquipment().setHelmet(GI.xWing(color));

            xWing.setSeat1(seat1);
            xWing.setModel(model);

            getAllXWings().add(xWing);

            Vehicles.entitiesInShip.add(xWing.getSeat1());
            Vehicles.entitiesInShip.add(xWing.getModel());

            rideShip(player, xWing);
        }else{
            player.sendMessage(MMCCore.prefix + ChatColor.GRAY + "You cannot spawn in your " + color + "X-Wing Starfighter" + ChatColor.GRAY + " here!");
        }
    }

    public void rideShip(Player player, Vehicle xWing){

        Entity model = xWing.getModel();
        LivingEntity livingModel = (Zombie) model;
        int customModelData = livingModel.getEquipment().getHelmet().getItemMeta().getCustomModelData();

        Entity seat1 = xWing.getSeat1();
        LivingEntity seat1Living = (Phantom) seat1;
        seat1Living.addPassenger(player);

        xWing.setPilot(player);

        Vehicles.playersInShip.add(xWing.getPilot());

        switch(customModelData){
            case 6:
                player.sendMessage(MMCCore.prefix + ChatColor.GRAY + "You mounted your " + ChatColor.RED + "X-Wing Starfighter!");
                break;
            case 7:
                player.sendMessage(MMCCore.prefix + ChatColor.GRAY + "You mounted your " + ChatColor.DARK_GREEN + "X-Wing Starfighter!");
                break;
            case 9:
                player.sendMessage(MMCCore.prefix + ChatColor.GRAY + "You mounted your " + ChatColor.DARK_AQUA + "X-Wing Starfighter!");
                break;

        }
    }

    public static void removeShip(Player player, Vehicle xWing){

        Entity seat1 = xWing.getSeat1();
        Entity model = xWing.getModel();

        LivingEntity modelLiving = (Zombie) model;
        int customModelData = modelLiving.getEquipment().getHelmet().getItemMeta().getCustomModelData();

        Vehicles.entitiesInShip.remove(seat1);
        Vehicles.entitiesInShip.remove(model);

        seat1.remove();
        model.remove();

        xWing.setPilot(null);
        xWing.setGunner(null);
        xWing.setSeat1(null);
        xWing.setSeat2(null);
        xWing.setModel(null);

        allXWings.remove(xWing);

        switch(customModelData){
            case 6:
                player.getInventory().addItem(GI.xWing(ChatColor.RED));
                player.sendMessage(MMCCore.prefix + ChatColor.GRAY + "You dismounted your " + ChatColor.RED + "Red Squadron X-Wing" + ChatColor.GRAY + "!");
                break;
            case 7:
                player.getInventory().addItem(GI.xWing(ChatColor.DARK_GREEN));
                player.sendMessage(MMCCore.prefix + ChatColor.GRAY + "You dismounted your " + ChatColor.DARK_GREEN + "Green Squadron X-Wing" + ChatColor.GRAY + "!");
                break;
            case 9:
                player.getInventory().addItem(GI.xWing(ChatColor.DARK_AQUA));
                player.sendMessage(MMCCore.prefix + ChatColor.GRAY + "You dismounted your " + ChatColor.DARK_AQUA + "Blue Squadron X-Wing" + ChatColor.GRAY + "!");
                break;
        }
    }

    public void shootTorpedos(Player player) {

        if (!this.torpedosCooldown.containsKey(player.getUniqueId())) {
            this.torpedosCooldown.put(player.getUniqueId(), System.currentTimeMillis());
            player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "MMCITEMS" + ChatColor.DARK_GRAY + " » " + ChatColor.GOLD + "You shot your proton torpedos!");
            Location loc = player.getLocation();
            Vector direction = loc.getDirection();

            for (double t = 0; t < 128; t++) {
                loc.add(direction);

                player.getWorld().spawnParticle(Particle.REDSTONE, loc, 30, new Particle.DustOptions(Color.RED, 1F));

                if (loc.getBlock().getType().isSolid() || t == 127) {
                    player.getWorld().spawnParticle(Particle.CLOUD, loc, 30);
                    player.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, loc, 30);
                    if (isMobSpawningEnabled(loc, player)) {
                        loc.getWorld().createExplosion(loc, 1);
                    }
                }
            }
        } else {
            long timeElapsed = System.currentTimeMillis() - torpedosCooldown.get(player.getUniqueId());
            if (timeElapsed >= 60000) {
                this.torpedosCooldown.remove(player.getUniqueId());
            } else {
                player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "MMCITEMS" + ChatColor.DARK_GRAY + " » " + ChatColor.GOLD + "You are out of proton torpedos, try again in " + ChatColor.RED + "" + ((60000 - timeElapsed) / 1000) + "" + ChatColor.GOLD + " seconds!");

            }
        }
    }

    @EventHandler
    public void dismountXWing(EntityDismountEvent event){

        Entity entity = event.getDismounted();

        List<Vehicle> allXWingsCopy = new ArrayList<>(getAllXWings());
        for(Vehicle xWing: allXWingsCopy){
            if(xWing.getSeat1() == entity && event.getEntity() instanceof Player){
                Player player = (Player) event.getEntity();

                removeShip(player, xWing);
            }
        }
    }

    public static boolean isMobSpawningEnabled(Location location, Player player){
        LocalPlayer localPlayer = WorldGuardPlugin.inst().wrapPlayer(player);
        RegionContainer regionContainer = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionQuery query = regionContainer.createQuery();

        com.sk89q.worldedit.util.Location loc = BukkitAdapter.adapt(location);

        return query.testState(loc, localPlayer, Flags.MOB_SPAWNING);
    }

}
