package xyz.prismenetwork.kelpmodloader.ModsAPI.Models;

import xyz.prismenetwork.kelpmodloader.ModsAPI.Texture.Texture;

import java.io.InputStream;
import java.util.HashMap;

public class Model {
    public String name;
    public String Type;
    public InputStream model;
    public String path;
    public HashMap<String, Texture> Textures;

    public static final Model item_generated(){
        Model model = new Model();
        model.name = "item/generated";
        model.path = "item/generated";
        return model;
    }
    public static final Model item_handheld(){
        Model model = new Model();
        model.name = "item/handheld";
        model.path = "item/handheld";
        return model;
    }
}
