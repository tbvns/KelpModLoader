package xyz.prismenetwork.kelpmodloader.Dependency;

import xyz.prismenetwork.kelpmodloader.KelpModLoader;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Downloader {
    static File pluginFolder = KelpModLoader.getPlugin(KelpModLoader.class).getDataFolder().getParentFile();
    public static void download(String name, String link) {

        if (KelpModLoader.getPlugin(KelpModLoader.class).getServer().getPluginManager().getPlugin(name)!=null) return;

        KelpModLoader.getPlugin(KelpModLoader.class).getLogger().warning(name + " is not installed, downloading ProtocolLib from " + link);

        try {
            InputStream in = new URL(link).openStream();
             Files.copy(in, Path.of(pluginFolder.getPath() + "/"+ name + ".jar"), StandardCopyOption.REPLACE_EXISTING);

            KelpModLoader.getInstance.getPluginLoader().loadPlugin(new File(pluginFolder.getPath() + "/" + name + ".jar"));

            } catch (Exception e) {
            KelpModLoader.getPlugin(KelpModLoader.class).getLogger().warning("Could not download protocolLib:");
            e.printStackTrace();
        }

    }
}
