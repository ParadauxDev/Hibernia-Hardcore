package co.paradaux.Hibernia.Hardcore.api;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class Sidebar {

	public static void buildSidebar(Player p) {

		System.out.println("buildSidebar() called.");
		final Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		final Objective obj = board.registerNewObjective("HardcoreScoreboard", "dummy", "HardcoreScoreboard");

		obj.setDisplayName(ChatColor.GRAY + "- = [" + ChatColor.RED + ChatColor.BOLD + " The Hinterlands. " + ChatColor.GRAY + "] = -");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);

		// Dynamic Data
		final Team lives = board.registerNewTeam("lives");
		lives.addEntry(ChatColor.GRAY.toString());
		lives.setPrefix(ChatColor.RED + "Lives: ");
		lives.setSuffix("");

		// Static Data
		final Score empty1 = obj.getScore("");
		final Score empty2 = obj.getScore(" ");

		final Score web1 = obj.getScore(ChatColor.RED + "You are a Beta Tester!");
		final Score web2 = obj.getScore(ChatColor.GRAY + "--------------------");
		final Score web3 = obj.getScore(ChatColor.RED + "IP: play.HiberniaMC.com");

		// Set Placement

		empty1.setScore(6);
		obj.getScore(ChatColor.GRAY.toString()).setScore(5);
		empty2.setScore(4);

		web1.setScore(3);
		web2.setScore(3);
		web3.setScore(1);

		p.setScoreboard(board);

	}

	public static void updateSidebar(Player p) {
		p.getScoreboard().getTeam("lives").setSuffix("");
	}


}
