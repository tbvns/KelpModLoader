package xyz.prismenetwork.kelpmodloader.Texture;

import xyz.prismenetwork.kelpmodloader.Constant;

import java.io.InputStream;

public class RegisterTexture {
    /**
     * Allow you to register a texture and add it to the resource pack.
     * @param name The name that will ve used to refer to this texture.
     * @param image The input stream from the resources.
     * @param textureType Describe what this texture will be used for.
     */
    public void Register(String name, InputStream image, TextureType textureType) {
        Texture texture = new Texture();
        texture.name = name;
        texture.image = image;
        texture.textureType = textureType;

        Constant.Textures.add(texture);
    }
}
