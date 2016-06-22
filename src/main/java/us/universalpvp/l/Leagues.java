package us.universalpvp.l;

import com.perceivedstudios.command.CommandHandler;
import org.bukkit.plugin.java.JavaPlugin;
import us.universalpvp.l.commands.LeaguesCmd;

public class Leagues extends JavaPlugin {

    public void onEnable() {
        CommandHandler handler = new CommandHandler(this);
        handler.addCommand(new LeaguesCmd());
    }

    public void onDisable() {
    }

}
