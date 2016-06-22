package us.universalpvp.l.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import us.universalpvp.l.managers.League;

/**
 * Created by avigh on 6/21/2016.
 */
public class PlayerLeagueInviteEvent extends Event {

    private Player inviter;
    private Player invitee;
    private League league;
    private boolean cancelled;
    private static final HandlerList handlers = new HandlerList();

    public PlayerLeagueInviteEvent(Player invitee, Player inviter) {
        this.invitee = invitee;
        this.inviter = inviter;

    }

    public Player getInvitee() {
        return invitee;
    }

    public Player getInviter() {
        return inviter;
    }

    public League getLeague() {
        return league;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public String getEventName() {
        return super.getEventName();
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
