package org.lablyteam.marriagelab.loaders;


import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.lablyteam.marriagelab.Core;
import org.lablyteam.marriagelab.Marriagelab;
import org.lablyteam.marriagelab.api.Loader;


public class ListenersLoader implements Loader {

    private final Core pluginCore;

    public ListenersLoader(Core pluginCore){
        this.pluginCore = pluginCore;
    }

    @Override
    public void load() {
        registerListeners(

        );
    }

    public void registerListeners(Listener... listeners){
        PluginManager pluginManager = Bukkit.getPluginManager();
        Marriagelab pluginModel = pluginCore.getPlugin();


        for (Listener listener : listeners){
            pluginManager.registerEvents(listener, pluginModel);
        }
    }
}
