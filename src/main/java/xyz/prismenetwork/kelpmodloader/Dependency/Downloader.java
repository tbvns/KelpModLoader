package xyz.prismenetwork.kelpmodloader.Dependency;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import xyz.prismenetwork.kelpmodloader.KelpModLoader;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Downloader {
    static File pluginFolder = KelpModLoader.getInstance.getDataFolder().getParentFile();
    public static void download(String name, String link) {

        if (KelpModLoader.getInstance.getServer().getPluginManager().getPlugin(name)!=null) return;

        KelpModLoader.getInstance.getLogger().warning(name + " is not installed, downloading ProtocolLib from " + link);

        try {
            InputStream in = new URL(link).openStream();
             Files.copy(in, Path.of(pluginFolder.getPath() + "/"+ name + ".jar"), StandardCopyOption.REPLACE_EXISTING);

            KelpModLoader.getInstance.getPluginLoader().loadPlugin(new File(pluginFolder.getPath() + "/" + name + ".jar"));
            KelpModLoader.getInstance.getPluginLoader().enablePlugin(Bukkit.getPluginManager().getPlugin(name));

        } catch (Exception e) {
            KelpModLoader.getInstance.getLogger().warning("Could not download " + name + ":");
            e.printStackTrace();
            KelpModLoader.getInstance.getServer().shutdown();
        }

    }
}
