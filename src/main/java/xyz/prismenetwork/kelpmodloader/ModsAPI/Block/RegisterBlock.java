package xyz.prismenetwork.kelpmodloader.ModsAPI.Block;

import xyz.prismenetwork.kelpmodloader.Constant;

public class RegisterBlock {
    /**
     * Allow you to register a block and add it to KML mod.
     * @param name The name that will be used to refer to this block.
     * @param texture The name of the texture that will be displayed on this block.
     */
    public void Register(String name, String texture) {
        int id = Constant.blockCount;
        Constant.blockCount++;
        ModdedBlock block = new ModdedBlock();
        block.setID(id);
        block.TextureName = texture;
        block.name = name;
        Constant.Blocks.add(block);

    }
}
