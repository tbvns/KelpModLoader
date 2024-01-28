package xyz.prismenetwork.kelpmodloader.Models;

import xyz.prismenetwork.kelpmodloader.Texture.TextureType;

public class ModelType {
    public static ModelType Block() {
        ModelType modelType = new ModelType();
        modelType.setType("block");
        return modelType;
    }
    public static ModelType Item() {
        ModelType modelType = new ModelType();
        modelType.setType("item");
        return modelType;
    }
    private String CurrentType = "item";
    public void setType(String type) {
        CurrentType = type;
    }
    public String getType() {
        return CurrentType;
    }
}
