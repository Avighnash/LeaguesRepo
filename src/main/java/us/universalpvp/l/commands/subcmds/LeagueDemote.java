package us.universalpvp.l.commands.subcmds;

import com.perceivedstudios.command.ChildCommand;
import com.perceivedstudios.command.Command;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import us.universalpvp.l.enums.MessageType;
import us.universalpvp.l.managers.League;
import us.universalpvp.l.managers.ManageLeagues;

public class LeagueDemote extends ChildCommand {

    public LeagueDemote(Command parent) {
        super(parent, "demote");
    }

    @Override
    public void execute(Player p, String[] args) {
        if (args.length == 1) {
            MessageType.sendMessage(p, MessageType.SPECIFY_OFFICER);
            return;
        } else {
            Player officer = Bukkit.getPlayerExact(args[1]);
            ManageLeagues ml = ManageLeagues.getInstance();
            if (ml.getLeague(p) != null) {
                League league = ml.getLeague(p);
                if (league.isLeader(p.getUniqueId())) {
                    if (league.getAllMembers().contains(officer)) {
                        if (league.isOfficer(officer)) {
                            league.demoteOfficer(officer);
                        }
                    }
                }
            }
        }

    }

}
