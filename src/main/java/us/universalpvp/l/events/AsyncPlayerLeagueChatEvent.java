package us.universalpvp.l.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.IllegalFormatException;
import java.util.Set;

/**
 * Created by avigh on 6/21/2016.
 */
public class AsyncPlayerLeagueChatEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private String message;
    private String format = "<%1$s> %2$s";
    private final Set<Player> recipients;
    private Player player;

    public AsyncPlayerLeagueChatEvent(Player who, String message, Set<Player> players) {
        this.player = who;
        this.message = message;
        this.recipients = players;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String format) throws IllegalFormatException, NullPointerException {
        try {
            String.format(format, new Object[]{this.player, this.message});
        } catch (RuntimeException var3) {
            var3.fillInStackTrace();
            throw var3;
        }

        this.format = format;
    }

    public Set<Player> getRecipients() {
        return this.recipients;
    }

    public boolean isCancelled() {
        return this.cancel;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
