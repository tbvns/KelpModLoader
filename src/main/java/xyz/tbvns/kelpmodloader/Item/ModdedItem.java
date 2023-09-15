package xyz.tbvns.kelpmodloader.Item;

import org.bukkit.Material;

public class ModdedItem {
    private int id;
    public String TextureName = "";
    public String Name = "";
    public Material ItemMaterial = Material.STICK;
    /**
     * Return the id of the item.
     */
    public int getId() {
        return id;
    }
    /**
     * Allow you to change the ID of the item.
     * @apiNote /!\ THIS IS A NON-API METHODE, USE IT AT YOUR OWN RISK
     * @param nID The new id of this item
     */
    public void setID(int nID) {
        id = nID;
    }

}