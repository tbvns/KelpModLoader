package xyz.prismenetwork.kelpmodloader;

import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.prismenetwork.kelpmodloader.Block.CreateBlock;
import xyz.prismenetwork.kelpmodloader.Block.RegisterBlock;
import xyz.prismenetwork.kelpmodloader.EventHandler.BlockPlaceEvent;
import xyz.prismenetwork.kelpmodloader.EventHandler.BlockUpdateEvent;
import xyz.prismenetwork.kelpmodloader.Item.RegisterItem;
import xyz.prismenetwork.kelpmodloader.Mods.ModsLoader;
import xyz.prismenetwork.kelpmodloader.Pack.CreatePack;
import xyz.prismenetwork.kelpmodloader.Texture.RegisterTexture;
import xyz.prismenetwork.kelpmodloader.Texture.TextureType;

import java.io.IOException;

public final class KelpModLoader extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage( "\n" +
                "§2---------------------------------- \n" +
                "        §2[ §aKelp Mod Loader §2]    \n" +
                "§2Status: §aStarting                 \n" +
                "§2Devloper: §atbvns                  \n" +
                "§2---------------------------------- ");

        getServer().getPluginManager().registerEvents(new BlockUpdateEvent(), this);
        getServer().getPluginManager().registerEvents(new BlockPlaceEvent(), this);

        //Blocks/Textures/Items test
        new RegisterTexture().Register("yay", "/texture/yay.png", TextureType.Block());
        new RegisterBlock().Register("Block", "yay");
        new RegisterBlock().Register("OtherBlock", "sandstone");
        new RegisterItem().register("YaY", "iron_ingot", Material.STONE_SWORD);

        new ModsLoader().load();

        getServer().getConsoleSender().sendMessage( "\n" +
                "§2---------------------------------- \n" +
                "§2Status: §aStarting                 \n" +
                "§2Task: §aGenerating texture pack      \n" +
                "§2---------------------------------- ");
        try {
            CreatePack.Create();
        } catch (IOException e) {
            e.printStackTrace();
        }
        new CreateBlock().Create(getServer());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}