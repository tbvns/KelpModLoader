package xyz.tbvns.kelpmodloader.Mods;

import xyz.tbvns.kelpmodloader.Constant;
import xyz.tbvns.kelpmodloader.KelpModLoader;
import xyz.tbvns.kelpmodloader.Pack.CreatePack;

import java.io.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.util.List;
import java.util.jar.JarFile;

public class ModsLoader {
    public List<Mods> get() {
        File datafolder = KelpModLoader.getPlugin(KelpModLoader.class).getDataFolder();
        String path = datafolder.getPath();

        File PluginFolder = Path.of(path).toFile();
        File ModsFolder = Path.of(path + "/Mods").toFile();

        try {
            if (!ModsFolder.exists()) {
                ModsFolder.mkdir();
            }
            File[] ModsFiles = ModsFolder.listFiles();
            for (int i = 0; i < ModsFiles.length; i++) {
                File mod = ModsFiles[i];
                URLClassLoader child = new URLClassLoader(
                        new URL[] {mod.toURI().toURL()},
                        this.getClass().getClassLoader()
                );

                JarFile jarFile = new JarFile(mod);
                InputStream ModIS = jarFile.getClass().getResourceAsStream("mods.yml");
                BufferedReader ModISReader = new BufferedReader(new InputStreamReader(ModIS));

                Mods mods = new Mods();

                String[] ModMainClass = {""};
                String[] ModName = {""};
                String[] ModAuthor = {""};

                ModISReader.lines().forEach(l -> {
                    if (l.startsWith("main: ")) {
                        String value = l.replaceFirst("main: ", "");
                        ModMainClass[0] = value;
                    } else if (l.startsWith("name: ")) {
                        String value = l.replaceFirst("name: ", "");
                        ModName[0] = value;
                    } else if (l.startsWith("author: ")) {
                        String value = l.replaceFirst("author: ", "");
                        ModAuthor[0] = value;
                    }
                });

                mods.mainClass = ModMainClass[0];
                mods.name = ModName[0];
                mods.author = ModName[0];

                Constant.ModList.add(mods);

            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
