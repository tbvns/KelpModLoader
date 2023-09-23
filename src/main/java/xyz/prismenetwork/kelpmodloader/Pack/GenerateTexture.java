package xyz.prismenetwork.kelpmodloader.Pack;

import xyz.prismenetwork.kelpmodloader.Constant;
import xyz.prismenetwork.kelpmodloader.KelpModLoader;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class GenerateTexture {
    public void generate(File TextureFolder) {
        Constant.Textures.forEach(t -> {
            try {
                InputStream is = KelpModLoader.class.getResourceAsStream(t.path);

                File TextureTypeFolder = new File(TextureFolder.getPath() + "/" + t.textureType.getType());
                if (!TextureTypeFolder.exists()) {
                    TextureTypeFolder.createNewFile();
                }

                String path = TextureFolder.getPath() + "/" + t.textureType.getType() + "/" + t.name + ".png";

                Files.copy(is, Path.of(path), StandardCopyOption.REPLACE_EXISTING);

            } catch (Exception e) {
                e.printStackTrace();

            }
        });
    }
}
