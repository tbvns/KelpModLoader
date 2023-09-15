package xyz.tbvns.kelpmodloader.EventHandler;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;

public class BlockUpdateEvent implements Listener {
    @EventHandler
    public void BlockUpdateEvent(BlockPhysicsEvent event) {
        if (event.getBlock().getType().equals(Material.BROWN_MUSHROOM_BLOCK)) {
            event.setCancelled(true);
        }
    }
}
