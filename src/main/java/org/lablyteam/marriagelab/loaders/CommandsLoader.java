package org.lablyteam.marriagelab.loaders;


import org.bukkit.Bukkit;
import org.lablyteam.marriagelab.Core;
import org.lablyteam.marriagelab.api.Loader;
import org.lablyteam.marriagelab.commands.AddFhaterCommand;
import org.lablyteam.marriagelab.commands.ExecutorBuilder;
import org.lablyteam.marriagelab.commands.MarriageCommandMain;


public class CommandsLoader implements Loader {

    private final Core pluginCore;

    public CommandsLoader(Core pluginCore){
        this.pluginCore = pluginCore;
    }

    @Override
    public void load() {
        registerCommands(
                new ExecutorBuilder("marriage", new MarriageCommandMain(pluginCore)),
                new ExecutorBuilder("fhater", new AddFhaterCommand(pluginCore))
        );
    }

    public void registerCommands(ExecutorBuilder... executorBuilders){

        for (ExecutorBuilder executorBuilder : executorBuilders){
            Bukkit.getPluginCommand(executorBuilder.getCommandName()).setExecutor(executorBuilder.getCommandExecutor());
        }
    }
}
