package org.lablyteam.marriagelab;

import org.lablyteam.marriagelab.api.Loader;
import org.lablyteam.marriagelab.loaders.CommandsLoader;
import org.lablyteam.marriagelab.loaders.FilesLoader;
import org.lablyteam.marriagelab.sqllite.loaders.SQLLoader;

public class Core implements Loader {
    private final Marriagelab plugin;
    private FilesLoader filesLoader;

    public Core(Marriagelab plugin) {
        this.plugin = plugin;
    }

    @Override
    public void load() {
        filesLoader = new FilesLoader(plugin);
        filesLoader.load();
        SQLLoader slit = new SQLLoader(this);
        slit.load();
        initLoaders(
                new CommandsLoader(this));
    }

    private void initLoaders(Loader... loaders) {
        for (Loader loader : loaders) {
            loader.load();
        }
    }

    public FilesLoader getFilesLoader() {
        return filesLoader;
    }

    public Marriagelab getPlugin() {
        return plugin;
    }
}
