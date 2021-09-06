package org.lablyteam.marriagelab.sqllite;

import org.jdbi.v3.core.Jdbi;
import org.lablyteam.marriagelab.Core;
import org.lablyteam.marriagelab.files.FileManager;

public class ConnectionSql {
     Core pluginCore;

    public ConnectionSql(Core pluginCore){
        this.pluginCore = pluginCore;
    }


    String table = "Marriage";
    String tableFhaters = "Fhaters";

    public String getTableFhaters() {
        return tableFhaters;
    }

    public String getTable (){
        return table;
    }

    public String getIp() {
        return ip;
    }

    public String getPort() {
        return port;
    }

    public String getDatabase() {
        return database;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    String ip;
    String port;
    String database;
    String user;
    String password;
    public Jdbi getConnection(){
        FileManager databaseConfig = pluginCore.getFilesLoader().getDatabase();
        this.ip = databaseConfig.getString("Database.ip");
        this.port = databaseConfig.getString("Database.port");
        this.database = databaseConfig.getString("Database.database");
        this.user = databaseConfig.getString("Database.user");
       this.password = databaseConfig.getString("Database.pass");
        SQLClient client = SQLClient.newSQLClient().ip(ip).port(port).database(database).user(user).password(password).build(); //agregamos los parametros de la base de datos
        Jdbi jdbi = client.getConnection(); //obtenemos la conexion
        return jdbi; //retornamos la conexcion
    }
}



