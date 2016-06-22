package us.universalpvp.l.commands;


import com.perceivedstudios.command.Command;
import org.bukkit.entity.Player;
import us.universalpvp.l.commands.subcmds.*;

public class LeaguesCmd extends Command {

    public LeaguesCmd() {
        super("league");

        addChild(new LeagueCreate(this));
        addChild(new LeagueDemote(this));
        addChild(new LeagueMemberAdd(this));
        addChild(new LeagueMemberKick(this));
        addChild(new LeagueMembers(this));
        addChild(new LeagueModt(this));
        addChild(new LeaguePromote(this));
        addChild(new LeagueRemove(this));
        addChild(new LeagueRename(this));
        addChild(new LeagueTag(this));
        addChild(new LeagueTransfer(this));

    }

    @Override
    public void execute(Player player, String[] args) {
        attemptChildCommand(player, args);
    }

}
