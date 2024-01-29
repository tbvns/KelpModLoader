package xyz.prismenetwork.kelpmodloader.Block.BreakHandler;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.*;
import com.comphenix.protocol.wrappers.BlockPosition;
import org.bukkit.GameMode;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;
import xyz.prismenetwork.kelpmodloader.Block.BlockUtils;
import xyz.prismenetwork.kelpmodloader.Block.ModdedBlock;
import xyz.prismenetwork.kelpmodloader.Constant;
import xyz.prismenetwork.kelpmodloader.KelpModLoader;

import javax.swing.plaf.nimbus.State;
import java.time.Instant;
import java.time.temporal.TemporalField;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class BreakManager {
    public static HashMap<Player, Block> PlayerBreakingBlock = new HashMap<>();
    public static HashMap<Player, Long> PlayerBreakingTime = new HashMap<>();
    public static void Setup() {
        BukkitScheduler scheduler = KelpModLoader.getInstance.getServer().getScheduler();
        ProtocolManager manager = ProtocolLibrary.getProtocolManager();

        //manager.addPacketListener(new PacketAdapter(KelpModLoader.getInstance, ListenerPriority.HIGHEST, PacketType.Play.Server.BLOCK_BREAK_ANIMATION){
        //    @Override
        //    public void onPacketSending(PacketEvent event) {
        //        event.setCancelled(true);
        //    }
        //});

        scheduler.scheduleSyncRepeatingTask(KelpModLoader.getInstance, new Runnable() {
            @Override
            public void run() {
                PlayerBreakingBlock.forEach((p, b) -> {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 5+((p.getPing()/40)), 200, true, false));
                    float breakstage = 0;

                    ModdedBlock[] block = {new ModdedBlock()};

                    Constant.Blocks.forEach(blck -> {
                        if (blck.getId() == BlockUtils.idFromBlock(b)) {
                            block[0] = blck;
                        }
                    });

                    breakstage = ((((Instant.now().toEpochMilli() - PlayerBreakingTime.get(p)))/20f)*9)/block[0].getBreakTime();

                    PacketContainer container = new PacketContainer(PacketType.Play.Server.BLOCK_BREAK_ANIMATION);
                    container.getIntegers().write(0, p.getEntityId()*1000);
                    container.getIntegers().write(1, Math.round(breakstage));
                    container.getBlockPositionModifier().write(0, new BlockPosition(b.getX(), b.getY(), b.getZ()));

                    if (breakstage > 9) {
                        b.breakNaturally();

                        PacketContainer container2 = new PacketContainer(PacketType.Play.Server.BLOCK_BREAK_ANIMATION);
                        container2.getIntegers().write(0, p.getEntityId()*1000);
                        container2.getIntegers().write(1, 10);
                        container2.getBlockPositionModifier().write(0, new BlockPosition(b.getX(), b.getY(), b.getZ()));
                    }

                    ProtocolLibrary.getProtocolManager().sendServerPacket(p, container);
                });
            }
        }, 0L, 0L);
    }
}
