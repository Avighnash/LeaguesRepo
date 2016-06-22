package us.universalpvp.l.managers;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ManageLeagues {

    private Map<League, String> leagues = new HashMap<>();

    private static ManageLeagues instance = null;

    protected ManageLeagues() {
        instance = this;
    }

    public Map<League, String> getLeagues() {
        return leagues;
    }

    public List<String> getLeagueNames() {
        List<String> names = (List<String>) leagues.values();
        return names;
    }

    public League getLeague(String leagueName) {
        for (Map.Entry<League, String> e : leagues.entrySet()) {
            League league = e.getKey();
            if (e.getValue().equals(leagueName)) {
                return league;
            }

        }
        return null;
    }

    public void createLeague(UUID leader, String name) {
        if (getLeagues().containsValue(name)) {
            return;
        } else {
            League newLeague = new League(leader, name);
            leagues.put(newLeague, name);
        }
    }

    public void removeLeague(String name) {
        if (!leagues.containsValue(name)) {
            return;
        } else {
            leagues.values().remove(name);
        }
    }

    public League getLeague(Player member) {
        for (League league : leagues.keySet()) {
            if (league.isMember(member)) {
                return league;
            }
        }
        return null;
    }

    public static ManageLeagues getInstance() {
        return instance;
    }


}
