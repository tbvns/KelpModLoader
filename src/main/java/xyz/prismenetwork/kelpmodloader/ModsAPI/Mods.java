package xyz.prismenetwork.kelpmodloader.ModsAPI;

import org.bukkit.Material;
import xyz.prismenetwork.kelpmodloader.Block.ModdedBlock;
import xyz.prismenetwork.kelpmodloader.Block.RegisterBlock;
import xyz.prismenetwork.kelpmodloader.Item.ModdedItem;
import xyz.prismenetwork.kelpmodloader.Item.RegisterItem;
import xyz.prismenetwork.kelpmodloader.Texture.TextureType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Mods {
    public List<ArrayList<String>> Items = new ArrayList<>();
    public List<ArrayList<String>> Blocks = new ArrayList<>();
    public List<ArrayList> Textures = new ArrayList<>();
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
    /**
     * Allow you to register a block and add it to KML mod.
     * @param name The name that will be used to refer to this texture.
     * @param type The type of texture that will be loaded.
     * @param path The path of the image file (e.g "/texture/yay.png" referring to "src/main/resources/texture/yay.png").
     */
    public void addTexture(String name, TextureType type, String path) {
        ArrayList Texture = new ArrayList<>();
        Texture.add(name);
        Texture.add(type);
        Texture.add(this.getClass().getResourceAsStream(path));
        Blocks.add(Texture);
    }
}
