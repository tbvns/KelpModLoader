package xyz.prismenetwork.kelpmodloader.Pack;

import org.zeroturnaround.zip.ZipUtil;
import xyz.prismenetwork.kelpmodloader.KelpModLoader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class CreatePack {
    public static void Create() throws IOException {
        File datafolder = KelpModLoader.getPlugin(KelpModLoader.class).getDataFolder();
        String path = datafolder.getPath();

        File PluginFolder = Path.of(path).toFile();
        File PackFolder = Path.of(path + "/pack").toFile();
        File AssetFolder = Path.of(path + "/pack/assets").toFile();
        File MinecraftFolder = Path.of(path + "/pack/assets/minecraft").toFile();
        File BlockStateFolder = Path.of(path + "/pack/assets/minecraft/blockstates").toFile();
        File TexturesFolder = Path.of(path + "/pack/assets/minecraft/textures").toFile();
        File BlockFolder = Path.of(path + "/pack/assets/minecraft/textures/block").toFile();
        File ModelsFolder = Path.of(path + "/pack/assets/minecraft/models").toFile();
        File ItemModelsFolder = Path.of(path + "/pack/assets/minecraft/models/item").toFile();
        File BlockModelsFolder = Path.of(path + "/pack/assets/minecraft/models/block").toFile();
        CreateFileIfNotExiste(PluginFolder ,PackFolder, AssetFolder, MinecraftFolder, BlockStateFolder, TexturesFolder, BlockFolder, ModelsFolder, ItemModelsFolder, BlockModelsFolder);

        InputStream meta = KelpModLoader.class.getResourceAsStream("/Pack/pack.mcmeta");
        InputStream png = KelpModLoader.class.getResourceAsStream("/Pack/pack.png");
        File newmeta = new File(PackFolder.getPath() + "/pack.mcmeta");
        File newpng = new File(PackFolder.getPath() + "/pack.png");
        if (!newmeta.exists()) {
            newmeta.createNewFile();
        }
        if (!newpng.exists()) {
            newpng.createNewFile();
        }

        new GenerateBlockState().Generate(BlockStateFolder);
        new GenerateModel().Generate(BlockModelsFolder, ItemModelsFolder);
        new GenerateTexture().generate(TexturesFolder);



        Files.copy(meta, newmeta.toPath(), StandardCopyOption.REPLACE_EXISTING);
        Files.copy(png, newpng.toPath(), StandardCopyOption.REPLACE_EXISTING);


        File zip = new File(PluginFolder.getPath() + "/Kelp-Generated-Pack.zip");
        Zip(PackFolder, zip);

    }
    public static void CreateFileIfNotExiste(File PluginFolder, File PackFolder, File AssetFolder, File MinecraftFolder, File BlockStateFolder, File TexturesFolder, File BlockFolder, File ModelsFolder, File ItemModelsFolder, File BlockModelsFolder) throws IOException {
        if (!PluginFolder.exists()) {
            PluginFolder.mkdir();
        }
        if (!PackFolder.exists()) {
            PackFolder.mkdir();
        }
        if (!AssetFolder.exists()) {
            AssetFolder.mkdir();
        }
        if (!MinecraftFolder.exists()) {
            MinecraftFolder.mkdir();
        }
        if (!BlockStateFolder.exists()) {
            BlockStateFolder.mkdir();
        }
        if (!TexturesFolder.exists()) {
            TexturesFolder.mkdir();
        }
        if (!BlockFolder.exists()) {
            BlockFolder.mkdir();
        }
        if (!ModelsFolder.exists()) {
            ModelsFolder.mkdir();
        }
        if (!ItemModelsFolder.exists()) {
            ItemModelsFolder.mkdir();
        }
        if (!BlockModelsFolder.exists()) {
            BlockModelsFolder.mkdir();
        }
    }
    public static void Zip(File file, File zipedPack) throws IOException {
        ZipUtil.pack(file, zipedPack);
        file.deleteOnExit();
    }
}
