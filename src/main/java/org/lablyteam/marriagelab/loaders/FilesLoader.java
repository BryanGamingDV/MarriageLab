package org.lablyteam.marriagelab.loaders;


import org.lablyteam.marriagelab.Core;
import org.lablyteam.marriagelab.Marriagelab;
import org.lablyteam.marriagelab.api.Loader;
import org.lablyteam.marriagelab.files.FileManager;

public class FilesLoader implements Loader {

    private final Marriagelab plugin;
    private FileManager config;
    private FileManager database;


    public FilesLoader(Marriagelab plugin){
        this.plugin = plugin;
    }

    @Override
    public void load() {
        // config.yml file
        config = new FileManager(plugin, "config.yml");
        database = new FileManager(plugin, "database.yml");
        // messages.yml file

    }

    public FileManager getConfig() {
        return config;
    }
    public FileManager getDatabase(){
        return database;
    }

}
