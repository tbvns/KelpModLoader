package xyz.tbvns.kelpmodloader.Mods;

import xyz.tbvns.kelpmodloader.Constant;
import xyz.tbvns.kelpmodloader.KelpModLoader;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.util.jar.JarFile;

public class ModsLoader {
    public void load() {
        File datafolder = KelpModLoader.getPlugin(KelpModLoader.class).getDataFolder();
        String path = datafolder.getPath();

        File ModsFolder = Path.of(path + "/Mods").toFile();

        try {
            if (!ModsFolder.exists()) {
                ModsFolder.mkdir();
            }
            File[] ModsFiles = ModsFolder.listFiles();
            for (int i = 0; i < ModsFiles.length; i++) {
                File mod = ModsFiles[i];

                JarFile jarFile = new JarFile(mod);
                InputStream ModIS = jarFile.getInputStream(jarFile.getEntry("mods.yml"));
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
                mods.file = mod;

                Constant.ModList.add(mods);
            }

            Constant.ModList.forEach(Mod -> {
                try {
                    File ModFile = Mod.file;
                    URLClassLoader ModCL = new URLClassLoader(
                            new URL[] {ModFile.toURI().toURL()},
                            this.getClass().getClassLoader()
                    );
                    Class classToLoad = Class.forName(Mod.mainClass, true, ModCL);
                    Method method = classToLoad.getDeclaredMethod("load");
                    Object instance = classToLoad.newInstance();
                    Object result = method.invoke(instance);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
