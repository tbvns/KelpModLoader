package xyz.prismenetwork.kelpmodloader.ModsAPI;

import org.bukkit.Server;
import xyz.prismenetwork.kelpmodloader.Constant;
import xyz.prismenetwork.kelpmodloader.Item.ItemType;
import xyz.prismenetwork.kelpmodloader.KelpModLoader;
import xyz.prismenetwork.kelpmodloader.Models.ModelType;
import xyz.prismenetwork.kelpmodloader.Texture.TextureType;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Mods {
    public List<ArrayList<String>> Items = new ArrayList<>();
    public List<ArrayList<String>> Blocks = new ArrayList<>();
    public List<ArrayList> Textures = new ArrayList<>();
    public List<ArrayList> Models = new ArrayList<>();
    private Server server = KelpModLoader.getPlugin(KelpModLoader.class).getServer();

    /**
     * @return The running server instance
     */
    public Server getServer() {
        return server;
    }

    /**
     * Allow you to register an item and add it to the KML mod.
     * @param name The name that will be used to refer to this item.
     * @param lore The lore that will be displayed on the item.
     * @param texture The name of the texture that will be displayed on this item.
     * @param material The base bukkit material of this item.
     */
    public void addItem(String name, String lore, String texture, String material) {
        ArrayList Item = new ArrayList<>();
        Item.add(name);
        Item.add(texture);
        Item.add(material);
        Item.add(lore);
        Items.add(Item);
    }
    /**
     * Allow you to register an item and add it to the KML mod.
     * @param name The name that will be used to refer to this item.
     * @param lore The lore that will be displayed on the item.
     * @param texture The name of the texture that will be displayed on this item.
     * @param material The base bukkit material of this item.
     * @param itemType The type of item to use.
     */
    public void addItem(String name, String lore, String texture, String material, String itemType) {
        ArrayList Item = new ArrayList<>();
        Item.add(name);
        Item.add(texture);
        Item.add(material);
        Item.add(lore);
        Item.add(itemType);
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
     * Allow you to register a texture and add it to KML mod.
     * @param name The name that will be used to refer to this texture.
     * @param type The type of texture that will be loaded.
     * @param path The path of the image file (e.g "/texture/yay.png" referring to "src/main/resources/texture/yay.png").
     */
    public void addTexture(String name, TextureType type, String path) {
        ArrayList Texture = new ArrayList<>();
        Texture.add(name);
        Texture.add(type);
        Texture.add(path);
        Textures.add(Texture);
    }
    /**
     * Allow you to register a model and add it to KML mod.
     * @param name The name that will be used to refer to this model.
     * @param path The path of the image file (e.g "/models/yay.json" referring to "src/main/resources/models/yay.json").
     */
    public void addModel(String name, String path, ModelType modelType) {
        ArrayList Model = new ArrayList<>();
        Model.add(name);
        Model.add(path);
        Model.add(modelType.getType());
        Models.add(Model);
    }
}
