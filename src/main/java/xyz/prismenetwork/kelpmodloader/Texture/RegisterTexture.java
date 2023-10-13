package xyz.prismenetwork.kelpmodloader.Texture;

import xyz.prismenetwork.kelpmodloader.Constant;

import java.io.File;
import java.io.InputStream;

public class RegisterTexture {
    /**
     * Allow you to register a texture and add it to the resource pack.
     * @param name The name that will ve used to refer to this texture.
     * @param image The input stream from the resources.
     * @param textureType Describe what this texture will be used for.
     */
    public void Register(String name, File image, TextureType textureType) {
        Textures textures = new Textures();
        textures.name = name;
        textures.image = image;
        textures.textureType = textureType;

        Constant.Textures.add(textures);
    }
}
