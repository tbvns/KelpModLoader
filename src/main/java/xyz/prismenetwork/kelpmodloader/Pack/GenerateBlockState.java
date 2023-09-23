package xyz.prismenetwork.kelpmodloader.Pack;

import xyz.prismenetwork.kelpmodloader.Constant;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GenerateBlockState {
    public void Generate(File BlockStateFolder) throws IOException {
        String JSON = "{\"multipart\": [";

        List<String> BlocksStates = new ArrayList<>();

        final String[] BlockState = {""};

        Constant.Blocks.forEach(B -> {
            String BS = "{\"apply\": {\"model\": \"minecraft:block/" + B.TextureName +"\"},\"when\": " + generateWhen(B.getId());
            String Separator = ",";
            BlocksStates.add(BS);
            BlocksStates.add(Separator);
        });
        BlocksStates.remove(BlocksStates.size() - 1);

        BlocksStates.forEach(S -> {
            BlockState[0] = BlockState[0] + S;
        });

        String JSONEnd = "]}";

        File file = Path.of(Path.of(BlockStateFolder.getPath()) + "/brown_mushroom_block.json").toFile();
        if (!file.exists()) {
            file.createNewFile();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
        writer.write(JSON + BlockState[0] + JSONEnd);
        writer.close();

    }
    public String generateWhen(int ID) {
        return "{\"down\": \"" + faces(ID).get(0) + "\", \"up\": \"" + faces(ID).get(1) + "\", \"" + "east\": \"" + faces(ID).get(2) + "\", \"" + "north\": \"" + faces(ID).get(3) + "\", \"" + "south\": \"" + faces(ID).get(4) + "\", \"" + "west\": \"" + faces(ID).get(5) + "\"}}";
    }
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
    public static boolean parseBool(String s) {
        if (s.equalsIgnoreCase("1")) {
            return true;
        } else {
            return false;
        }
    }
}
