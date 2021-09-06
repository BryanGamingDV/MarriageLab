package org.lablyteam.marriagelab.sqllite.managers;

import org.bukkit.entity.Player;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.lablyteam.marriagelab.Core;
import org.lablyteam.marriagelab.sqllite.ConnectionSql;

public class OptionsMarriage {
    Core pluginCore;

    public OptionsMarriage(Core pluginCore) {
        this.pluginCore = pluginCore;

    }
    ConnectionSql connectionSql;
    Jdbi conn;
    public void addMarriage(Player p1, Player p2,Player p3){
        connectionSql = new ConnectionSql(pluginCore);
        conn = connectionSql.getConnection();
        OptionsFhaters datesFhaters = new OptionsFhaters(pluginCore);
        if(!datesFhaters.hasFhater(p3)){
            p1.sendMessage("error 120");
            p2.sendMessage("error 120");
            p3.sendMessage("error 120");
        return;
        }

        try (Handle h = conn.open()){
            h.createUpdate("INSERT INTO `<DATABASE>`.`<TABLENAME>` (`p1`,`p2`,`p3`) VALUES ('?', '?','?')")
                    .define("DATABASE",connectionSql.getDatabase())
                    .define("TABLENAME",connectionSql.getTable())
                    .bind(0,p1.getUniqueId().toString())
                    .bind(1,p2.getUniqueId().toString())
                    .bind(2,p3.getUniqueId().toString())
                    .execute()
            ;
        }
    }




}
