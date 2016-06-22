package us.universalpvp.l.commands.subcmds;

import com.google.common.base.Optional;
import com.perceivedstudios.command.ChildCommand;
import com.perceivedstudios.command.Command;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import us.universalpvp.l.enums.MessageType;
import us.universalpvp.l.managers.League;
import us.universalpvp.l.managers.ManageLeagues;

public class LeagueCreate extends ChildCommand {

    public LeagueCreate(Command parent) {
        super(parent, "create");
    }

    @Override
    public void execute(Player p, String[] args) {
        if (args.length == 1) {
            MessageType.sendMessage(p, MessageType.LEAGUE_NAME);
            return;
        } else {
            ManageLeagues ml = ManageLeagues.getInstance();
            ml.createLeague(p.getUniqueId(), args[1]);


        }

    }

}
