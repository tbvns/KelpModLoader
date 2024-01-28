package xyz.prismenetwork.kelpmodloader.Models;

import org.bukkit.Material;
import xyz.prismenetwork.kelpmodloader.Constant;
import xyz.prismenetwork.kelpmodloader.Item.ModdedItem;

import java.io.File;
import java.io.InputStream;

public class RegisterModels {
    /**
     * Allow you to register a model and add it to the KML mod.
     * @param name The name that will be used to refer to this model.
     * @param jsonModel The InputStream of the model.
     * @param modelType The model type of the model (e.g block/item).
     */
    public void Register(String name, InputStream jsonModel, ModelType modelType) {
        Model model = new Model();
        model.name = name;
        model.model = jsonModel;
        model.Type = modelType.getType();

        Constant.Models.add(model);
    }
}
