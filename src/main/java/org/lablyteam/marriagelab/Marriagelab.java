package org.lablyteam.marriagelab;

import org.bukkit.plugin.java.JavaPlugin;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.lablyteam.marriagelab.sqllite.ConnectionSql;

public final class Marriagelab extends JavaPlugin {

    @Override
    public void onEnable() {
        Core Core = new Core(this);
        Core.load();



    }

    @Override
    public void onDisable() {



    }
}
