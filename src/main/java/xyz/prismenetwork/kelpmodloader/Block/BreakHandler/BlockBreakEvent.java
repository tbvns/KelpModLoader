package xyz.prismenetwork.kelpmodloader.Block.BreakHandler;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLib;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockDamageAbortEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import xyz.prismenetwork.kelpmodloader.Block.BlockUtils;
import xyz.prismenetwork.kelpmodloader.Block.ModdedBlock;
import xyz.prismenetwork.kelpmodloader.ModsAPI.ItemUtils;
import xyz.prismenetwork.kelpmodloader.Utils;

import java.time.Instant;
import java.util.List;
import java.util.Random;

public class BlockBreakEvent implements Listener {
    @EventHandler
    public void onBreak(BlockDamageEvent event) {
        if (event.getBlock().getType().equals(Material.BROWN_MUSHROOM_BLOCK)) {
            if (BlockUtils.idFromBlock(event.getBlock()) != 63) {
                event.setCancelled(true);
                Block block = event.getBlock();

                BreakManager.PlayerBreakingBlock.put(event.getPlayer(), block);
                BreakManager.PlayerBreakingTime.put(event.getPlayer(), Instant.now().toEpochMilli());
            }
        } else {
            if (BreakManager.PlayerBreakingBlock.containsKey(event.getPlayer())) {
                event.getPlayer().sendBlockDamage(BreakManager.PlayerBreakingBlock.get(event.getPlayer()).getLocation(), 0);
                BreakManager.PlayerBreakingBlock.remove(event.getPlayer());
            }
        }
    }
    @EventHandler
    public void onAbort(BlockDamageAbortEvent event) {
        if (BreakManager.PlayerBreakingBlock.containsKey(event.getPlayer())) {
            BreakManager.PlayerBreakingBlock.remove(event.getPlayer());
            if (!event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
                event.getPlayer().setGameMode(GameMode.SURVIVAL);
            }
        }
        if (BreakManager.PlayerBreakingTime.containsKey(event.getPlayer())) {
            BreakManager.PlayerBreakingTime.remove(event.getPlayer());
        }
    }

}
