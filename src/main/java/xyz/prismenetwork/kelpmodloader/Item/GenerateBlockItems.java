package xyz.prismenetwork.kelpmodloader.Item;

import org.bukkit.Material;
import xyz.prismenetwork.kelpmodloader.Block.ModdedBlock;
import xyz.prismenetwork.kelpmodloader.Constant;

import java.util.List;

public class GenerateBlockItems {
    public static void generate() {
        List<ModdedBlock> blocks = Constant.Blocks;
        blocks.forEach(b -> {
            ModdedItem item = new ModdedItem();
            item.Name = b.name;
            item.TextureName = b.TextureName;
            item.isBlockItem = true;
            item.setID(b.getId());
            Constant.Items.add(item);
        });
    }
}
