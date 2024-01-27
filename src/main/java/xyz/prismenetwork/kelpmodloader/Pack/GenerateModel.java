package xyz.prismenetwork.kelpmodloader.Pack;

import org.bukkit.Material;
import xyz.prismenetwork.kelpmodloader.Block.ModdedBlock;
import xyz.prismenetwork.kelpmodloader.Constant;
import xyz.prismenetwork.kelpmodloader.Item.ModdedItem;
import xyz.prismenetwork.kelpmodloader.KelpModLoader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GenerateModel {
    public void Generate(File blockModelFile, File itemModelFile) throws IOException {
        List<ModdedBlock> Blocks = Constant.Blocks;
        List<ModdedItem> Items = Constant.Items;

        final String[] ModelData = {""};

        String BlocksJsonStart = "{\"parent\": \"minecraft:block/cube_all\",\"textures\": {\"all\": \"minecraft:block/stone\"}, \"overrides\": [";
        String BlocksJsonEnd = "]}";

        List<String> ModelDataStrings = new ArrayList<>();

        //Generate bloc models:
        Blocks.forEach(B -> {
            String middle = "{\"predicate\": {\"custom_model_data\":" + (B.getId() + 1) +"}, \"model\": \"block/kml_" + B.TextureName +"\"}";
            String separator = ",";

            ModelDataStrings.add(middle);
            ModelDataStrings.add(separator);

            File BlockItemModels = new File(itemModelFile.getPath() + "/kml_" + B.TextureName + ".json");
            File BlockModels = new File(blockModelFile.getPath() + "/kml_" + B.TextureName + ".json");
            if (!BlockItemModels.exists()) {
                try {
                    BlockItemModels.createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            String JsonModel = "{\"parent\": \"minecraft:block/cube_all\",\"textures\": {\"all\": \"minecraft:block/kml_" + B.TextureName + "\"}}";
            try {
                BufferedWriter writer1 = new BufferedWriter(new FileWriter(BlockItemModels, false));
                writer1.write(JsonModel);
                writer1.close();

                BufferedWriter writer2 = new BufferedWriter(new FileWriter(BlockModels, false));
                writer2.write(JsonModel);
                writer2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        ModelDataStrings.remove(ModelDataStrings.size() - 1);

        ModelData[0] = BlocksJsonStart;

        ModelDataStrings.forEach( S -> {
            ModelData[0] = ModelData[0] + S;
        });

        ModelData[0] = ModelData[0] + BlocksJsonEnd;

        File file = new File(itemModelFile.getPath() + "/stone.json");
        if (!file.exists()) {
            file.createNewFile();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
        writer.write(ModelData[0]);
        writer.close();

        //Generate Item models
        HashMap<Material, String> MaterialsJson = new HashMap<>();
        Items.forEach(I -> {
            System.out.println(I.Name + " - "+ I.getId());
            if (I.ItemMaterial.equals(Material.STONE)) {
                KelpModLoader.getPlugin(KelpModLoader.class).getLogger().warning("You are using \"STONE\" as a material for item \"" + I.Name + "\". This will cause issue.");
            }
            if (I.ModelsName == null) {
                if (MaterialsJson.containsKey(I.ItemMaterial)) {
                    String s = "{\"predicate\": {\"custom_model_data\":" + (I.getId() + 1) +"}, \"model\": \"item/kml_" + I.TextureName +"\"}";
                    MaterialsJson.put(I.ItemMaterial, MaterialsJson.get(I.ItemMaterial) + "," + s);
                } else {
                    String s = "{\"predicate\": {\"custom_model_data\":" + (I.getId() + 1) +"}, \"model\": \"item/kml_" + I.TextureName +"\"}";
                    MaterialsJson.put(I.ItemMaterial, s);
                }

                String path = itemModelFile.getPath() + "/kml_" + I.TextureName + ".json";
                File ModelsFile = new File(path);
                try {
                    if (!ModelsFile.exists()) {
                        ModelsFile.createNewFile();
                    }

                    BufferedWriter FileWriter = new BufferedWriter(new FileWriter(ModelsFile, false));
                    FileWriter.write("{\"parent\": \""+ I.itemType +"\",\"textures\": {\"layer0\": \"minecraft:item/kml_" + I.TextureName +"\"}}");
                    FileWriter.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                if (MaterialsJson.containsKey(I.ItemMaterial)) {
                    String s = "{\"predicate\": {\"custom_model_data\":" + (I.getId() + 1) +"}, \"model\": \"models/kml_" + I.ModelsName +"\"}";
                    MaterialsJson.put(I.ItemMaterial, MaterialsJson.get(I.ItemMaterial) + "," + s);
                } else {
                    String s = "{\"predicate\": {\"custom_model_data\":" + (I.getId() + 1) +"}, \"model\": \"models/kml_" + I.ModelsName +"\"}";
                    MaterialsJson.put(I.ItemMaterial, s);
                }
            }
        });
        MaterialsJson.forEach((M, S) -> {
            String ItemJsonStart = "{\"parent\": \"minecraft:item/generated\",\"textures\": {\"layer0\": \"minecraft:item/" + M.toString().toLowerCase() + "\"}, \"overrides\": [";
            String ItemJsonEnd = "]}";
            String full = ItemJsonStart + S + ItemJsonEnd;

            try {
                String path = itemModelFile.getPath() + "/" + M.toString().toLowerCase() + ".json";
                File ModelFile = new File(path);
                if (!ModelFile.exists()) {
                    ModelFile.createNewFile();
                }

                BufferedWriter FileWriter = new BufferedWriter(new FileWriter(ModelFile, false));
                FileWriter.write(full);
                FileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }
}
