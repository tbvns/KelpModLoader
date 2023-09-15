package xyz.tbvns.kelpmodloader.EventHandler;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.MultipleFacing;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.tbvns.kelpmodloader.Block.ModdedBlock;
import xyz.tbvns.kelpmodloader.Constant;
import xyz.tbvns.kelpmodloader.Utils;

import java.util.List;

public class BlockPlaceEvent implements Listener {
    @EventHandler
    public void BlockPlaceEvent(org.bukkit.event.block.BlockPlaceEvent event) {
        ItemStack item = event.getItemInHand();
        ItemMeta itemMeta = item.getItemMeta();
        try {
            if (itemMeta.getCustomModelData() > 0) {
                ModdedBlock block = Constant.Blocks.get(itemMeta.getCustomModelData() - 1);
                Block blockPlaced = event.getBlockPlaced();

                //DOWN, 0
                //UP, 1
                //EAST, 2
                //NORTH 3
                //SOUTH, 4
                //WEST, 5
                List<Boolean> faces = new Utils().faces(block.getId());

                String bin = Integer.toBinaryString(block.getId());
                while (bin.length() < 6) {
                    bin = "0" + bin;
                }

                MultipleFacing multipleFacing = (MultipleFacing) Material.BROWN_MUSHROOM_BLOCK.createBlockData();

                multipleFacing.setFace(BlockFace.DOWN, Utils.parseBool(String.valueOf(bin.charAt(0))));
                multipleFacing.setFace(BlockFace.UP, Utils.parseBool(String.valueOf(bin.charAt(1))));
                multipleFacing.setFace(BlockFace.EAST, Utils.parseBool(String.valueOf(bin.charAt(2))));
                multipleFacing.setFace(BlockFace.NORTH, Utils.parseBool(String.valueOf(bin.charAt(3))));
                multipleFacing.setFace(BlockFace.SOUTH, Utils.parseBool(String.valueOf(bin.charAt(4))));
                multipleFacing.setFace(BlockFace.WEST, Utils.parseBool(String.valueOf(bin.charAt(5))));

                World world = blockPlaced.getWorld();
                Location location = blockPlaced.getLocation();

                world.setBlockData(location, multipleFacing);
            }
        } catch (Exception e) {

        }

    }
}
