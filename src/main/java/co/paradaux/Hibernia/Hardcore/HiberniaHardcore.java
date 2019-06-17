package co.paradaux.Hibernia.Hardcore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import co.paradaux.Hibernia.Hardcore.cmds.HardcoreCMD;

public class HiberniaHardcore extends JavaPlugin {

	private static Connection connection;


	@Override
	public void onEnable() {

		this.getConfig().options().copyDefaults();
		saveDefaultConfig();

		Bukkit.getLogger().info(new String[] {
				"+ ------------------------------------ +\n",
				"|   Running Hibernia Hardcore v1.0.0   |\n",
				"|       © Rían Errity (Paradaux)       |\n",
				"|         https://paradaux.co          |\n",
				"+ ------------------------------------ +\n"
		}.toString());

		getCommand("hardcore").setExecutor(new HardcoreCMD());

		try {
			openConnection();
			System.out.println("Connecing to the database");
		} catch (final SQLException e) {
			getLogger().info("Error in HiberniaHardcore! : " + e.toString());
		}


	}

	private void openConnection() throws SQLException {

		final String host = this.getConfig().getString("database-connection.host");
		final String dbname = this.getConfig().getString("database-connection.db-name");
		final String dbuser = this.getConfig().getString("database-connection.db-username");
		final String dbpw = this.getConfig().getString("database-connection.db-password");
		final int port = this.getConfig().getInt("database-connection.port");

		if (connection != null && !connection.isClosed())
			return;

		connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" +  dbname + "?autoReconnect=true", dbuser, dbpw);
	}

	public static PreparedStatement prepareStatement(String query) {

		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(query);
		} catch (final SQLException e){
			e.printStackTrace();
		}
		return ps;
	}


}
