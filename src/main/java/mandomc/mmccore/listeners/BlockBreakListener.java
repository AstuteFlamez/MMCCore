package mandomc.mmccore.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BlockBreakListener implements Listener {

    private final Random random = new Random();
    private static final double ANCIENT_DEBRIS_CHANCE = 0.1;
    private static final Set<String> ALLOWED_WORLDS = new HashSet<>(Arrays.asList("Concordia", "Mandalore"));

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();

        if (ALLOWED_WORLDS.contains(player.getWorld().getName())
                && block.getType() == Material.DIAMOND_ORE
                && isUsingIronPickaxeOrHigher(player)) {

            if (random.nextDouble() < ANCIENT_DEBRIS_CHANCE) {
                // Give the player ancient debris
                player.getInventory().addItem(new ItemStack(Material.ANCIENT_DEBRIS));
                player.sendMessage("You obtained ancient debris!");
            }
        }
    }

    private boolean isUsingIronPickaxeOrHigher(Player player) {
        ItemStack itemInHand = player.getInventory().getItemInMainHand();
        Material itemType = itemInHand.getType();
        return itemType == Material.IRON_PICKAXE || itemType == Material.DIAMOND_PICKAXE;
    }
}
