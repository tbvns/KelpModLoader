package xyz.prismenetwork.kelpmodloader;

import xyz.prismenetwork.kelpmodloader.Block.ModdedBlock;
import xyz.prismenetwork.kelpmodloader.Item.ModdedItem;
import xyz.prismenetwork.kelpmodloader.Mods.ModsObject;
import xyz.prismenetwork.kelpmodloader.Texture.Textures;

import java.util.ArrayList;

public class Constant {
    public static int blockCount = 0;
    public static int itemCount = 0;

    public static ArrayList<ModdedBlock> Blocks = new ArrayList<>();
    public static ArrayList<ModdedItem> Items = new ArrayList<>();
    public static ArrayList<Textures> Textures = new ArrayList<>();
    public static ArrayList<ModsObject> ModList = new ArrayList<>();
}
