package org.lablyteam.marriagelab.commands;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.lablyteam.marriagelab.Core;
import org.lablyteam.marriagelab.sqllite.managers.OptionsFhaters;

public class AddFhaterCommand implements CommandExecutor {
    private final Core pluginCore;

    public AddFhaterCommand(Core pluginCore){
        this.pluginCore = pluginCore;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if(args.length >= 0 ){


            if(!p.hasPermission("marriage.addfhater")){
                p.sendMessage("error 600");
                return true;
            }
            Player fhater = Bukkit.getPlayer(args[0]);
            if(fhater == null){
                return true;
            }
            OptionsFhaters optionsf = new OptionsFhaters(pluginCore);
            optionsf.addFhater(p,fhater);
            p.sendMessage("has agregado un padre nombre = "+fhater.getName());
            fhater.sendMessage("has sido agregado como padre");

        }else{
            p.sendMessage("as");
        }
        return false;
    }
}
