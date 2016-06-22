package us.universalpvp.l.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import us.universalpvp.l.managers.League;

/**
 * Created by avigh on 6/21/2016.
 */
public class PlayerLeagueLeaveEvent extends Event {

    private Player player;
    private League league;
    private boolean cancelled;
    private static final HandlerList handlers = new HandlerList();

    public PlayerLeagueLeaveEvent(Player player) {
        this.player = player;

    }

    public Player getPlayer() {
        return player;
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
