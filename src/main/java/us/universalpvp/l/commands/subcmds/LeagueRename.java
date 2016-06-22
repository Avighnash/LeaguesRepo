package us.universalpvp.l.commands.subcmds;

import com.perceivedstudios.command.ChildCommand;
import com.perceivedstudios.command.Command;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import us.universalpvp.l.enums.MessageType;
import us.universalpvp.l.managers.League;
import us.universalpvp.l.managers.ManageLeagues;

public class LeagueRename extends ChildCommand {

	public LeagueRename(Command parent) {
		super(parent, "rename");
	}

	@Override
	public void execute(Player p, String[] args) {
		if (args.length == 1) {
			MessageType.sendMessage(p, MessageType.LEAGUE_NAME);

			return;
		} else {
			ManageLeagues ml = ManageLeagues.getInstance();
			if (ml.getLeague(p) != null) {
				League league = ml.getLeague(p);
				if (league.isLeader(p.getUniqueId())) {
					if (args[1].length() > 8 && args[1].length() < 3) {
						return;
					} else {
						league.setName(args[1]);
					}
				}
			}
		}

	}

}
