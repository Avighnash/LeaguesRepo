package us.universalpvp.l.commands.subcmds;

import com.perceivedstudios.command.ChildCommand;
import com.perceivedstudios.command.Command;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import us.universalpvp.l.enums.MessageType;
import us.universalpvp.l.managers.League;
import us.universalpvp.l.managers.ManageLeagues;

public class LeagueMemberKick extends ChildCommand {

	public LeagueMemberKick(Command parent) {
		super(parent, "kick");
	}

	@Override
	public void execute(Player p, String[] args) {
		if (args.length == 1) {
			MessageType.sendMessage(p, MessageType.SPECIFY_PLAYER);

			return;
		} else {
			Player kick = Bukkit.getPlayerExact(args[1]);
			ManageLeagues ml = ManageLeagues.getInstance();
			if (ml.getLeague(p) != null) {
				League league = ml.getLeague(p);
				if (league.isLeader(p.getUniqueId())) {
					if (league.getAllMembers().contains(kick)) {
						if (league.isOfficer(kick)) {
							league.kickOfficer(kick);
						}
						if (league.isMember(kick)) {
							league.removeMember(kick);
						}
					}
				}
			}
		}

	}

}
