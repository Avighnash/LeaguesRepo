package us.universalpvp.l.commands.subcmds;

import com.perceivedstudios.command.ChildCommand;
import com.perceivedstudios.command.Command;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import us.universalpvp.l.enums.MessageType;
import us.universalpvp.l.managers.League;
import us.universalpvp.l.managers.ManageLeagues;

public class LeagueTransfer extends ChildCommand {

    public LeagueTransfer(Command parent) {
        super(parent, "transfer");
    }

    @Override
    public void execute(Player p, String[] args) {
        if (args.length == 1) {
            MessageType.sendMessage(p, MessageType.SPECIFY_OFFICER);
            return;
        } else {
            Player transferee = Bukkit.getPlayerExact(args[1]);
            ManageLeagues ml = ManageLeagues.getInstance();
            if (ml.getLeague(p) != null) {
                League league = ml.getLeague(p);
                if (league.isLeader(p.getUniqueId())) {
                    if (league.getMembers().contains(transferee)) {
                        league.setLeader(transferee.getUniqueId());
                    }
                }
            }
        }

    }

}