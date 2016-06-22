package us.universalpvp.l.commands.subcmds;

import com.perceivedstudios.command.ChildCommand;
import com.perceivedstudios.command.Command;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import us.universalpvp.l.enums.MessageType;
import us.universalpvp.l.managers.ManageLeagues;

public class LeagueRemove extends ChildCommand {

    public LeagueRemove(Command parent) {
        super(parent, "disband");
    }

    @Override
    public void execute(Player p, String[] args) {
        ManageLeagues ml = ManageLeagues.getInstance();
        if (args.length == 1) {
            MessageType.sendMessage(p, MessageType.LEAGUE_NAME);

            return;
        } else {
            if (!ml.getLeague(args[1]).getLeader().equals(p.getUniqueId())) {
                MessageType.sendMessage(p, MessageType.NOT_LEADER);
                return;
            } else {
                ml.removeLeague(args[1]);
                p.sendMessage(ChatColor.RED + "League " + args[1] + " has been disbanded!");
            }

        }

    }

}
