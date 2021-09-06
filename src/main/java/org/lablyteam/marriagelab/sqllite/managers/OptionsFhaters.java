package org.lablyteam.marriagelab.sqllite.managers;

import org.bukkit.entity.Player;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.lablyteam.marriagelab.Core;
import org.lablyteam.marriagelab.sqllite.ConnectionSql;

public class OptionsFhaters {
    Core pluginCore;

    public OptionsFhaters(Core pluginCore) {
        this.pluginCore = pluginCore;

    }

    ConnectionSql connectionSql;
    Jdbi conn;

    public void addFhater(Player p, Player fhater) {
        if(!hasFhater(fhater)){
            connectionSql = new ConnectionSql(pluginCore);
            conn = connectionSql.getConnection();
            String uuidFhater = fhater.getUniqueId().toString();
            try (Handle h = conn.open()) {
                h.createUpdate("INSERT INTO `<DATABASE>`.`<TABLENAME>` (`uuid`) VALUES ('?')")
                        .define("DATABASE", connectionSql.getDatabase())
                        .define("TABLENAME", connectionSql.getTableFhaters())
                        .bind(0, uuidFhater)
                        .execute()
                ;
            }
        }else{
            p.sendMessage("Ese jugador ya es padre");
        }

    }

    public boolean hasFhater(Player fhater) {
        connectionSql = new ConnectionSql(pluginCore);
        conn = connectionSql.getConnection();
        try (Handle handle = conn.open()) {
            return handle.select("SELECT `uuid` FROM <TABLE> WHERE `uuid`= ? ")
                    .define("TABLE", connectionSql.getTableFhaters())
                    .bind(0, fhater.getUniqueId().toString())
                    .mapTo(String.class)
                    .findFirst()
                    .isPresent();
        }
    }
}
