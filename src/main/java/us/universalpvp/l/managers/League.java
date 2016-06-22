package us.universalpvp.l.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class League {

	private UUID leader;
	private List<Player> officers;
	private List<Player> members;
	private List<Player> allMembers;
	private String name;
	private String tag;
	private String modt;

	public League(UUID leader, String name) {
		this.leader = leader;
		this.name = name;
		this.members = new ArrayList<>();
		this.officers = new ArrayList<>();
		this.allMembers = new ArrayList<>();
	}

	public List<Player> getAllMembers() {
		return allMembers;
	}

	public UUID getLeader() {
		return leader;
	}

	public void setLeader(UUID leader) {
		this.leader = leader;
		this.allMembers.add(Bukkit.getPlayer(leader));
	}

	public boolean isLeader(UUID leader) {
		if (this.leader == leader) {
			return true;
		}
		return false;
	}

	public List<Player> getMembers() {
		return members;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Player> getOfficers() {
		return officers;
	}

	public void addOfficer(Player officer) {
		if (this.isMember(officer)) {
			if (getOfficers().contains(officer)) {
				return;
			} else {
				this.officers.add(officer);
				this.members.remove(officer);
				this.allMembers.add(officer);
			}
		}
	}

	public void demoteOfficer(Player officer) {
		if (getOfficers().contains(officer)) {
			this.officers.remove(officer);
			this.members.add(officer);
		} else {
			return;
		}
	}

	public void kickOfficer(Player officer) {
		if (this.isOfficer(officer)) {
			demoteOfficer(officer);
			removeMember(officer);
		}
	}

	public void addMember(Player player) {
		if (getMembers().contains(player)) {
			return;
		} else {
			this.members.add(player);
		}
	}

	public void removeMember(Player player) {
		if (getMembers().contains(player)) {
			if (!this.isLeader(player.getUniqueId()) || !this.isOfficer(player)) {
				members.remove(player);
				this.allMembers.remove(player);
			}
		} else {
			return;
		}
	}

	public Player getMember(Player member) {
		if (getMembers().contains(member)) {
			return member;
		} else {
			return null;
		}
	}

	public boolean isMember(Player member) {
		if (getMembers().contains(member)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isOfficer(Player officer) {
		if (!getOfficers().contains(officer)) {
			return false;
		} else {
			return true;
		}
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = ChatColor.GRAY + "[" + tag + "]";
	}

	public String getModt() {
		return modt;
	}

	public void setModt(String modt) {
		this.modt = modt;
	}

}
