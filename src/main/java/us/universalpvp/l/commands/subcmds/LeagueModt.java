package us.universalpvp.l.commands.subcmds;

import com.perceivedstudios.command.ChildCommand;
import com.perceivedstudios.command.Command;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import us.universalpvp.l.enums.MessageType;
import us.universalpvp.l.managers.League;
import us.universalpvp.l.managers.ManageLeagues;

import java.util.ArrayList;
import java.util.List;

public class LeagueModt extends ChildCommand {

    public LeagueModt(Command parent) {
        super(parent, "modt");
    }

    @Override
    public void execute(Player p, String[] args) {
        if (args.length == 1) {
            MessageType.sendMessage(p, MessageType.SPECIFY_MODT);

            return;
        } else {
            ManageLeagues ml = ManageLeagues.getInstance();
            if (ml.getLeague(p) != null) {
                League league = ml.getLeague(p);
                if (league.getOfficers().contains(p) || league.getLeader() == p.getUniqueId()) {
                    List<String> msgArgs = new ArrayList<String>();
                    for (int i = 1; i < args.length; i++) {
                        msgArgs.add(args[i]);
                    }
                    String modt = StringUtils.join(msgArgs, " ");
                    league.setModt(modt);
                }
            }
        }

    }

}
