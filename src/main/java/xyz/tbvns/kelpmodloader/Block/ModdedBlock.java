package xyz.tbvns.kelpmodloader.Block;

import com.google.errorprone.annotations.DoNotCall;
import org.bukkit.Warning;
import org.checkerframework.checker.builder.qual.NotCalledMethods;

public class ModdedBlock {
    public String name;
    public String TextureName;
    private int ID;
    /**
     * Return the id of the block.
     */
    public int getId() {
        return ID;
    }
    /**
     * Allow you to change the ID of the block.
     * @apiNote /!\ THIS IS A NON-API METHODE, USE IT AT YOUR OWN RISK
     * @param nID The new id of this block
     */
    @Deprecated
    public void setID(int nID) {
        ID = nID;
    }
}
