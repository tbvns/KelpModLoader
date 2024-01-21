package xyz.prismenetwork.kelpmodloader.Item;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.prismenetwork.kelpmodloader.Constant;

public class ItemUtils {
    public static boolean isModed(ItemStack itemStack) {
        if (itemStack.hasItemMeta()) {
            ItemMeta itemMeta = itemStack.getItemMeta();
            if (itemMeta.getCustomModelData() - 1 != 0) {
                return true;
            }
        }
        return false;
    }

    public static ModdedItem getModedItem(ItemStack itemStack) {
        if (itemStack.hasItemMeta()) {
            ItemMeta itemMeta = itemStack.getItemMeta();
            assert itemMeta != null;
            if (itemMeta.getCustomModelData() - 1 != 0) {
                for (int i = 0; i < Constant.Items.size(); i++) {
                    ModdedItem item = Constant.Items.get(i);
                    if (itemMeta.getCustomModelData() == item.getId() - 1 && itemStack.getType() == item.ItemMaterial) {
                        return item;
                    }
                }
            }
        }
        return null;
    }
}
