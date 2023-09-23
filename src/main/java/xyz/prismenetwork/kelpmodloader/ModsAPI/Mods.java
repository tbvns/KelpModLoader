package xyz.prismenetwork.kelpmodloader.ModsAPI;

import org.bukkit.Material;
import xyz.prismenetwork.kelpmodloader.Block.ModdedBlock;
import xyz.prismenetwork.kelpmodloader.Block.RegisterBlock;
import xyz.prismenetwork.kelpmodloader.Item.ModdedItem;
import xyz.prismenetwork.kelpmodloader.Item.RegisterItem;

import java.util.ArrayList;
import java.util.List;

public class Mods {
    public List<ArrayList<String>> Items = new ArrayList<>();
    public List<ArrayList<String>> Blocks = new ArrayList<>();
    /**
     * Allow you to register an item and add it to the KML mod.
     * @param name The name that will be used to refer to this item.
     * @param texture The name of the texture that will be displayed on this item.
     * @param material The base bukkit material of this item.
     */
    public void addItem(String name, String texture, String material) {
        ArrayList Item = new ArrayList<>();
        Item.add(name);
        Item.add(texture);
        Item.add(material);
        Items.add(Item);
    }
    /**
     * Allow you to register a block and add it to KML mod.
     * @param name The name that will be used to refer to this block.
     * @param texture The name of the texture that will be displayed on this block.
     */
    public void addBlock(String name, String texture) {
        ArrayList Block = new ArrayList<>();
        Block.add(name);
        Block.add(texture);
        Blocks.add(Block);
    }
}
