package xyz.prismenetwork.kelpmodloader.Pack;

import xyz.prismenetwork.kelpmodloader.Constant;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class GenerateJsonModels {
    public void generate(File ModelsFolder) {
        Constant.Models.forEach(model -> {
            try {
                InputStream is = model.model;

                String path = ModelsFolder.getPath() + "/" + model.Type + "/kml_" + model.name + ".png";

                Files.copy(is, Path.of(path), StandardCopyOption.REPLACE_EXISTING);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
