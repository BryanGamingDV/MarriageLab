package org.lablyteam.marriagelab.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.lablyteam.marriagelab.Core;
import org.lablyteam.marriagelab.sqllite.managers.OptionsMarriage;

public class MarriageCommandMain implements CommandExecutor {
    private final Core pluginCore;

    public MarriageCommandMain(Core pluginCore){
        this.pluginCore = pluginCore;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        OptionsMarriage optionsm = new OptionsMarriage(pluginCore);
        if(args.length >= 1){
            Player husband = Bukkit.getPlayer(args[0]);
            Player fhater = Bukkit.getPlayer(args[1]);
            if(husband == null && fhater == null){
                player.sendMessage("error 130");
                return true;
            }
            optionsm.addMarriage(player,husband,fhater);
            Bukkit.getServer().broadcastMessage(player.getName()+" se ha casado con "+husband.getName()+" con la bendicion de "+fhater.getName());

        }else{
            player.sendMessage("a");
        }


        return false;
    }


}
