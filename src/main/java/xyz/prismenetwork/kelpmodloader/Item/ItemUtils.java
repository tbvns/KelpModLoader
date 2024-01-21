package xyz.prismenetwork.kelpmodloader.Item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.prismenetwork.kelpmodloader.Block.ModdedBlock;
import xyz.prismenetwork.kelpmodloader.Constant;

public class ItemUtils {
    public static boolean isModed(ItemStack itemStack) {
        if (itemStack.hasItemMeta()) {
            ItemMeta itemMeta = itemStack.getItemMeta();
            if (itemMeta.getCustomModelData() != 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param itemStack The itemStack to get the Modded item from
     * @return The modded item from this itemStack (Null if not modded or block item)
     */
    public static ModdedItem getModedItem(ItemStack itemStack) {
        if (itemStack.hasItemMeta()) {
            ItemMeta itemMeta = itemStack.getItemMeta();
            if (itemMeta.getCustomModelData() != 0) {
                for (int i = 0; i < Constant.Items.size(); i++) {
                    ModdedItem item = Constant.Items.get(i);
                    if (itemMeta.getCustomModelData() - 1 == item.getId() && itemStack.getType() == item.ItemMaterial) {
                        return item;
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param itemStack The itemStack to get the Modded block from
     * @return The modded block from this itemStack (Null if not modded or item)
     */
    public static ModdedBlock getModedBlockFromItem(ItemStack itemStack) {
        if (itemStack.hasItemMeta()) {
            ItemMeta itemMeta = itemStack.getItemMeta();
            if (itemMeta.getCustomModelData() != 0) {
                for (int i = 0; i < Constant.Blocks.size(); i++) {
                    ModdedBlock moddedBlock = Constant.Blocks.get(i);
                    if (itemMeta.getCustomModelData() - 1 == moddedBlock.getId()) {
                        return moddedBlock;
                    }
                }
            }
        }
        return null;
    }
}
