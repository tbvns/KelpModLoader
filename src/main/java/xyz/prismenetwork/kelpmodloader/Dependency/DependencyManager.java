package xyz.prismenetwork.kelpmodloader.Dependency;

import java.util.HashMap;

public class DependencyManager {
    public static HashMap<String, String> dependency = new HashMap<>();
    public static void check() {
        //List of all dependency
        dependency.put("ProtocolLib", "https://github.com/dmulloy2/ProtocolLib/releases/latest/download/ProtocolLib.jar");

        dependency.forEach((n, l) -> {
            Downloader.download(n, l);
        });

    }
}
