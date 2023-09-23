package xyz.prismenetwork.kelpmodloader;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    /**
     * Return all the face that will be enabled/disabled to show the texture on the block.
     */
    public List<Boolean> faces(int id) {
        String bin = Integer.toBinaryString(id);
        while (bin.length() < 6) {
            bin = "0" + bin;
        }
        //DOWN, 0
        //UP, 1
        //EAST, 2
        //NORTH 3
        //SOUTH, 4
        //WEST, 5
        List<Boolean> list = new ArrayList<>();
        list.add(parseBool(String.valueOf(bin.charAt(0))));
        list.add(parseBool(String.valueOf(bin.charAt(1))));
        list.add(parseBool(String.valueOf(bin.charAt(2))));
        list.add(parseBool(String.valueOf(bin.charAt(3))));
        list.add(parseBool(String.valueOf(bin.charAt(4))));
        list.add(parseBool(String.valueOf(bin.charAt(5))));
        return list;
    }
    /**
     * Parse a string to a boolean
     * (0 = false, 1 = true)
     * @param s The string that will be parsed to boolean
     */
    public static boolean parseBool(String s) {
        if (s.equalsIgnoreCase("1")) {
            return true;
        } else {
            return false;
        }
    }

}
