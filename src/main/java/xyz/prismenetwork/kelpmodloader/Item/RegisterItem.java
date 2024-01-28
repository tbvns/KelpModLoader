package xyz.prismenetwork.kelpmodloader.Item;

import org.bukkit.Material;
import xyz.prismenetwork.kelpmodloader.Constant;

public class RegisterItem {
    /**
     * Allow you to register an item and add it to the KML mod.
     * @param name The name that will be used to refer to this item.
     * @param texture The name of the texture that will be displayed on this item.
     * @param material The base bukkit material of this item.
     */
    public void register(String name, String texture, Material material, String itemType) {
        ModdedItem item = new ModdedItem();
        item.Name = name;
        item.TextureName = texture;
        item.ItemMaterial = material;
        item.itemType = itemType;
        item.setID(Constant.itemCount);
        Constant.Items.add(item);

        Constant.itemCount++;
    }

    public void register(String name, String lore,String texture, Material material, String itemType) {
        ModdedItem item = new ModdedItem();
        item.Name = name;
        item.Lore = lore;
        item.TextureName = texture;
        item.ItemMaterial = material;
        item.itemType = itemType;
        item.setID(Constant.itemCount);
        Constant.Items.add(item);

        Constant.itemCount++;
    }
}
