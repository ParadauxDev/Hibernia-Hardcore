package co.paradaux.Hibernia.Hardcore.api;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import co.paradaux.Hibernia.Hardcore.HiberniaHardcore;

public class LivesManager {

	public static void addOne (Player p) {
		final int newLives = getLifeCount(p) + 1;
		try {
			HiberniaHardcore.prepareStatement(
					"UPDATE lives SET lifeCount = '" + newLives + "' WHERE uuid = '" + p.getUniqueId() + "';").executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	public static void addMany(Player p, int amount) {
		final int newLives = getLifeCount(p) + amount;
		try {
			HiberniaHardcore.prepareStatement(
					"UPDATE lives SET lifeCount = '" + newLives + "' WHERE uuid = '" + p.getUniqueId() + "';").executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	public static void removeOne (Player p) {
		final int newLives = getLifeCount(p) - 1;
		try {
			HiberniaHardcore.prepareStatement(
					"UPDATE lives SET lifeCount = '" + newLives + "' WHERE uuid = '" + p.getUniqueId() + "';").executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	public static void removeMany (Player p, int amount) {
		final int newLives = getLifeCount(p) - amount;
		try {
			HiberniaHardcore.prepareStatement(
					"UPDATE lives SET lifeCount = '" + newLives + "' WHERE uuid = '" + p.getUniqueId() + "';").executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	public static void set(Player p, int amount) {
		try {
			HiberniaHardcore.prepareStatement(
					"UPDATE lives SET lifeCount = '" + amount + "' WHERE uuid = '" + p.getUniqueId() + "';").executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	public static int getLifeCount(Player p) {
		ResultSet lifeRS;
		try {
			lifeRS = HiberniaHardcore.prepareStatement("SELECT * FROM hiberniahardcore.lives WHERE uuid = '" + p.getUniqueId() + "';").executeQuery();
			lifeRS.next();
			final int lives = lifeRS.getInt("lifeCount");
			return lives;
		} catch (final SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static boolean hasLifeRecord(Player p) {
		ResultSet lifeRecordRS;
		try {
			lifeRecordRS = HiberniaHardcore.prepareStatement("SELECT COUNT(lifeCount) FROM lives WHERE uuid = '" + p.getUniqueId() + "'").executeQuery();
			lifeRecordRS.next();
			if (lifeRecordRS.getInt(1) == 0)
				return false;
			else
				return true;
		} catch (final SQLException e) {
			e.printStackTrace();
			return hasLifeRecord(p);
		}
	}

	public static void createNewLifeRecord(Player p) {
		final int defaultLives = 0;
		try {
			HiberniaHardcore.prepareStatement("INSERT INTO lives (uuid, lifeCount) VALUES ('" + p.getUniqueId() + "', '" + defaultLives + "');").executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	public static void setDefaultLifeRecord(OfflinePlayer p) {
		final int defaultLives = 0;
		try {
			HiberniaHardcore.prepareStatement("UPDATE lives SET lifeCount = '" + defaultLives + "' WHERE uuid = '" + p.getUniqueId() + "';").executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}
}
