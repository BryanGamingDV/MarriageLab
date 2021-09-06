package org.lablyteam.marriagelab.sqllite.loaders;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.lablyteam.marriagelab.Core;
import org.lablyteam.marriagelab.api.Loader;
import org.lablyteam.marriagelab.sqllite.ConnectionSql;

public class SQLLoader implements Loader {
        Core pluginCore;

        public SQLLoader(Core pluginCore) {
            this.pluginCore = pluginCore;

        }


        @Override
        public void load() {
            ConnectionSql connectionSql = new ConnectionSql(pluginCore);
            Jdbi connection = connectionSql.getConnection();
            try (Handle handle = connection.open()) {
                handle.execute(
                        "CREATE TABLE IF NOT EXISTS `"+connectionSql.getDatabase()+"`.`" + connectionSql.getTable() + "`(" +
                                "`id` INT NOT NULL auto_increment, " +
                                "`p1` VARCHAR(45) NOT NULL," +
                                "`p2` VARCHAR(45) NULL," +
                                "`p3` VARCHAR(45) NULL, PRIMARY KEY (`id`))"
                );
                handle.execute(
                        "CREATE TABLE IF NOT EXISTS `"+connectionSql.getDatabase()+"`.`" + connectionSql.getTableFhaters() + "`(" +
                                "  `id` INT NOT NULL AUTO_INCREMENT," +
                                "  `uuid` VARCHAR(45) NOT NULL," +
                                "  PRIMARY KEY (`id`))"
                );
            }
        }
    }


