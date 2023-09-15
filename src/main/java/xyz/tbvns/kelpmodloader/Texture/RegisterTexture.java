package xyz.tbvns.kelpmodloader.Texture;

import xyz.tbvns.kelpmodloader.Constant;

public class RegisterTexture {
    /**
     * Allow you to register a texture and add it to the resource pack.
     * @param name The name that will ve used to refer to this texture.
     * @param path Where the file will be saved in the resource pack.
     * @param textureType Describe what this texture will be used for.
     */
    public void Register(String name, String path, TextureType textureType) {
        Textures textures = new Textures();
        textures.name = name;
        textures.path = path;
        textures.textureType = textureType;

        Constant.Textures.add(textures);
    }
}
