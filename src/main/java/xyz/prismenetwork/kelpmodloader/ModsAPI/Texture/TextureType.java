package xyz.prismenetwork.kelpmodloader.ModsAPI.Texture;

public class TextureType {
    public static TextureType Block() {
        TextureType textureType = new TextureType();
        textureType.setType("block");
        return textureType;
    }
    public static TextureType Item() {
        TextureType textureType = new TextureType();
        textureType.setType("item");
        return textureType;
    }

    public static TextureType Gui() {
        TextureType textureType = new TextureType();
        textureType.setType("gui");
        return textureType;
    }

    public static TextureType Font() {
        TextureType textureType = new TextureType();
        textureType.setType("font");
        return textureType;
    }

    public static TextureType Environment() {
        TextureType textureType = new TextureType();
        textureType.setType("environment");
        return textureType;
    }

    public static TextureType Painting() {
        TextureType textureType = new TextureType();
        textureType.setType("painting");
        return textureType;
    }

    public static TextureType Trims() {
        TextureType textureType = new TextureType();
        textureType.setType("trims");
        return textureType;
    }

    public static TextureType Hud(Integer posX, Integer posY) {
        TextureType textureType = new TextureType();
        textureType.setType("gui");
        return textureType;
    }

    public static TextureType EffectIcon() {
        TextureType textureType = new TextureType();
        textureType.setType("mob_effect");
        return textureType;
    }
    private String CurrentType = "block";
    public void setType(String type) {
        CurrentType = type;
    }
    public String getType() {
        return CurrentType;
    }
}
