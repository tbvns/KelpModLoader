package xyz.prismenetwork.kelpmodloader.Models;

import xyz.prismenetwork.kelpmodloader.Texture.Texture;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;

public class Model {
    public String name;
    public String Type;
    public InputStream model;
    public HashMap<String, Texture> Textures;
    public void setTexture(String internalName, Texture texture) {

    }
}
