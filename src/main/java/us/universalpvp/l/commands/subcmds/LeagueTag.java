package us.universalpvp.l.commands.subcmds;

import com.perceivedstudios.command.ChildCommand;
import com.perceivedstudios.command.Command;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import us.universalpvp.l.enums.MessageType;
import us.universalpvp.l.managers.League;
import us.universalpvp.l.managers.ManageLeagues;

public class LeagueTag extends ChildCommand {

    public LeagueTag(Command parent) {
        super(parent, "tag");
    }

    @Override
    public void execute(Player p, String[] args) {
        if (args.length == 1) {
            MessageType.sendMessage(p, MessageType.TAG_NAME);

            return;
        } else {
            ManageLeagues ml = ManageLeagues.getInstance();
            if (ml.getLeague(p) != null) {
                League league = ml.getLeague(p);
                if (league.isLeader(p.getUniqueId())) {
                    league.setTag(args[1]);
                }
            }
        }

    }

}
