package xyz.prismenetwork.kelpmodloader;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.prismenetwork.kelpmodloader.Block.CreateBlock;
import xyz.prismenetwork.kelpmodloader.Dependency.DependencyManager;
import xyz.prismenetwork.kelpmodloader.EventHandler.BlockPlaceEvent;
import xyz.prismenetwork.kelpmodloader.EventHandler.BlockUpdateEvent;
import xyz.prismenetwork.kelpmodloader.Item.GenerateBlockItems;
import xyz.prismenetwork.kelpmodloader.Mods.ModsLoader;
import xyz.prismenetwork.kelpmodloader.Pack.CreatePack;
import xyz.prismenetwork.kelpmodloader.Dependency.Downloader;

import java.io.IOException;

public final class KelpModLoader extends JavaPlugin {
    public static KelpModLoader getInstance = null;

    @Override
    public void onEnable() {
        getInstance = this;

        DependencyManager.check();

        getServer().getConsoleSender().sendMessage( "\n" +
                "§2---------------------------------- \n" +
                "        §2[ §aKelp Mod Loader §2]    \n" +
                "§2Status: §aStarting                 \n" +
                "§2Devloper: §atbvns                  \n" +
                "§2---------------------------------- ");
        //Register event
        getServer().getPluginManager().registerEvents(new BlockUpdateEvent(), this);
        getServer().getPluginManager().registerEvents(new BlockPlaceEvent(), this);

        //Load mods
        new ModsLoader().load();

        getServer().getConsoleSender().sendMessage( "\n" +
                "§2---------------------------------- \n" +
                "§2Status: §aStarting                 \n" +
                "§2Task: §aGenerating texture pack      \n" +
                "§2---------------------------------- ");
        //Generate texture pack
        try {
            CreatePack.Create();
        } catch (IOException e) {
            e.printStackTrace();
        }
        new CreateBlock().Create(getServer());
        getServer().getConsoleSender().sendMessage( "\n" +
                "§2---------------------------------- \n" +
                "§2Status: §aStarting                \n" +
                "§2Task: §aGenerating block items      \n" +
                "§2---------------------------------- ");
        //Generate block-items
        GenerateBlockItems.generate();

        //KML is loaded \o/
        getServer().getConsoleSender().sendMessage( "\n" +
                "§2---------------------------------- \n" +
                "§2Status: §aStarted                \n" +
                "§2Task: §aKML is loaded!      \n" +
                "§2---------------------------------- ");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
