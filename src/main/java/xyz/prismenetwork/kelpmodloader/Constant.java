package xyz.prismenetwork.kelpmodloader;

import xyz.prismenetwork.kelpmodloader.Block.ModdedBlock;
import xyz.prismenetwork.kelpmodloader.Item.ModdedItem;
import xyz.prismenetwork.kelpmodloader.Mods.ModsObject;
import xyz.prismenetwork.kelpmodloader.Models.Model;
import xyz.prismenetwork.kelpmodloader.Texture.Texture;

import java.util.ArrayList;

public class Constant {
    public static int blockCount = 0;
    public static int itemCount = 0;

    public static ArrayList<ModdedBlock> Blocks = new ArrayList<>();
    public static ArrayList<ModdedItem> Items = new ArrayList<>();
    public static ArrayList<Texture> Textures = new ArrayList<>();
    public static ArrayList<Model> Models = new ArrayList<>();
    public static ArrayList<ModsObject> ModList = new ArrayList<>();
}
