package us.universalpvp.l.enums;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by avigh on 6/21/2016.
 */
public enum MessageType {

    PLAYER_NULL(ChatColor.RED + "Player does not exist!"),
    OFFICER_NULL(ChatColor.RED + "Officer does not exist!"),
    LEAGUE_NAME(ChatColor.RED + "Please specify the name for the league!"),
    SPECIFY_PLAYER(ChatColor.RED + "Please specify a player!"),
    SPECIFY_OFFICER(ChatColor.RED + "Please specify an officer!"),
    SPECIFY_MODT(ChatColor.RED + "Please specify a valid modt!"),
    SPECIFY_MEMBER(ChatColor.RED + "Please specify a member!"),
    LEAGUE_RENAME(ChatColor.RED + "Please specify a new name for the league!"),
    TAG_NAME(ChatColor.RED + "Please specify a tag!"),
    NOT_LEADER(ChatColor.RED + "You are not the leader of the league!");

    private final String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static void sendMessage(Player p, MessageType messageType) {
        p.sendMessage(messageType.toString());
    }

}

