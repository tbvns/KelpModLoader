package xyz.prismenetwork.kelpmodloader.Block;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.MultipleFacing;

public class BlockUtils {
    public static boolean parseBool(String s) {
        if (s.equalsIgnoreCase("1")) {
            return true;
        } else {
            return false;
        }
    }

    public static String parseString(boolean b) {
        if (b) {
            return "1";
        } else {
            return "0";
        }
    }

    public static int idFromBlock(Block block) {
        if (block.getType().equals(Material.BROWN_MUSHROOM_BLOCK)) {
            MultipleFacing facing = (MultipleFacing) block.getBlockData();
            boolean DOWN = facing.hasFace(BlockFace.DOWN);
            boolean UP = facing.hasFace(BlockFace.UP);
            boolean EAST = facing.hasFace(BlockFace.EAST);
            boolean NORTH = facing.hasFace(BlockFace.NORTH);
            boolean SOUTH = facing.hasFace(BlockFace.SOUTH);
            boolean WEST = facing.hasFace(BlockFace.WEST);

            return Integer.parseInt(parseString(DOWN) + parseString(UP) + parseString(EAST) + parseString(NORTH) + parseString(SOUTH) + parseString(WEST), 2);
        }
        return 0;
    }
}
