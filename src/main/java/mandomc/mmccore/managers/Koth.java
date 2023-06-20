package mandomc.mmccore.managers;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Koth {

    private UUID uuid;
    private HashMap<Player, Integer> playersInKothTime = new HashMap<>();

    public Koth(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public HashMap<Player, Integer> getPlayersInKothTime() {
        return playersInKothTime;
    }

    public void setPlayersInKothTime(HashMap<Player, Integer> playersInKothTime) {
        this.playersInKothTime = playersInKothTime;
    }

}
