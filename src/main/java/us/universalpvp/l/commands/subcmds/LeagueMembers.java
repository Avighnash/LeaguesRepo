package us.universalpvp.l.commands.subcmds;

import com.perceivedstudios.command.ChildCommand;
import com.perceivedstudios.command.Command;
import org.bukkit.entity.Player;
import us.universalpvp.l.managers.League;
import us.universalpvp.l.managers.ManageLeagues;

public class LeagueMembers extends ChildCommand {

    public LeagueMembers(Command parent) {
        super(parent, "members");
    }

    @Override
    public void execute(Player p, String[] args) {
        ManageLeagues ml = ManageLeagues.getInstance();
        if (ml.getLeague(p) != null) {
            League league = ml.getLeague(p);

            for (Player members : league.getMembers()) {
                String[] memberNames = members.getDisplayName().split(", ");
                p.sendMessage(memberNames);
            }

        }
    }

}
