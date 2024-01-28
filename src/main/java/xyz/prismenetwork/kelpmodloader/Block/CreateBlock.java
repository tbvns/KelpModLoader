package xyz.prismenetwork.kelpmodloader.Block;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.MultipleFacing;
import xyz.prismenetwork.kelpmodloader.Constant;

public class CreateBlock {
    public void Create(Server server) {
        Constant.blockCount = 0;
        int pos = 200;
        for (int i = 0; i < 63; i++) {
            String bin = Integer.toBinaryString(Constant.blockCount);
            Constant.blockCount++;
            if (bin.length() > 6) {
                break;
            }
            while (bin.length() < 6) {
                bin = "0" + bin;
            }

            MultipleFacing multipleFacing = (MultipleFacing) Material.BROWN_MUSHROOM_BLOCK.createBlockData();
            multipleFacing.setFace(BlockFace.DOWN, parseBool(String.valueOf(bin.charAt(0))));
            multipleFacing.setFace(BlockFace.UP, parseBool(String.valueOf(bin.charAt(1))));
            multipleFacing.setFace(BlockFace.EAST, parseBool(String.valueOf(bin.charAt(2))));
            multipleFacing.setFace(BlockFace.NORTH, parseBool(String.valueOf(bin.charAt(3))));
            multipleFacing.setFace(BlockFace.SOUTH, parseBool(String.valueOf(bin.charAt(4))));
            multipleFacing.setFace(BlockFace.WEST, parseBool(String.valueOf(bin.charAt(5))));

            pos = pos + 2;

            server.getWorld("world").setBlockData(200, 200, pos, multipleFacing);
        }
    }
    public static boolean parseBool(String s) {
        if (s.equalsIgnoreCase("1")) {
            return true;
        } else {
            return false;
        }
    }
}
