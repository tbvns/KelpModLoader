package xyz.prismenetwork.kelpmodloader.Pack;

import xyz.prismenetwork.kelpmodloader.Constant;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class GenerateTexture {
    public void generate(File TextureFolder) {
        Constant.Textures.forEach(t -> {
            try {
                InputStream is =t.image;

                File TextureTypeFolder = new File(TextureFolder.getPath() + "/" + t.textureType.getType());
                if (!TextureTypeFolder.exists()) {
                    TextureTypeFolder.mkdir();
                }

                String path = TextureFolder.getPath() + "/" + t.textureType.getType() + "/kml_" + t.name + ".png";

                Files.copy(is, Path.of(path), StandardCopyOption.REPLACE_EXISTING);

            } catch (Exception e) {
                e.printStackTrace();

            }
        });
    }
}
