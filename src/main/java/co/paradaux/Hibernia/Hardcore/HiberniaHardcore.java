package co.paradaux.Hibernia.Hardcore;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.zaxxer.hikari.HikariConfig;

import co.aikar.taskchain.BukkitTaskChainFactory;
import co.aikar.taskchain.TaskChain;
import co.aikar.taskchain.TaskChainFactory;
import co.paradaux.Hibernia.Hardcore.cmds.HardcoreCMD;
import ninja.egg82.sql.SQL;

public class HiberniaHardcore extends JavaPlugin {

	private static TaskChainFactory taskChainFactory;
	public static <T> TaskChain<T> newChain() {
		return taskChainFactory.newChain();
	}
	public static <T> TaskChain<T> newSharedChain(String name) {
		return taskChainFactory.newSharedChain(name);
	}




	@Override
	public void onEnable() {

		taskChainFactory = BukkitTaskChainFactory.create(this);

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

	}

	public static SQL getSQL(Plugin plugin) {

		final String host = plugin.getConfig().getString("database-connection.host");
		final String dbname = plugin.getConfig().getString("database-connection.db-name");
		final String dbuser = plugin.getConfig().getString("database-connection.db-username");
		final String dbpw = plugin.getConfig().getString("database-connection.db-password");
		final int port = plugin.getConfig().getInt("database-connection.port");

		final HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setJdbcUrl("jdbc:mysql://" + host + ":" + port + "/" +  dbname);
		hikariConfig.setConnectionTestQuery("SELECT 1;");

		hikariConfig.setUsername(dbuser);
		hikariConfig.setPassword(dbpw);
		hikariConfig.setMaximumPoolSize(2);
		hikariConfig.setMinimumIdle(2);
		hikariConfig.setMaxLifetime(1800000L);
		hikariConfig.setConnectionTimeout(5000L);
		hikariConfig.addDataSourceProperty("useUnicode", true);
		hikariConfig.addDataSourceProperty("characterEncoding", "utf8");
		hikariConfig.addDataSourceProperty("useLegacyDatetimeCode", false);
		hikariConfig.addDataSourceProperty("serverTimezone", "UTC");
		hikariConfig.setAutoCommit(true);
		hikariConfig.addDataSourceProperty("useSSL", false);
		hikariConfig.addDataSourceProperty("cacheServerConfiguration", "true");
		hikariConfig.addDataSourceProperty("useLocalSessionState", "true");
		hikariConfig.addDataSourceProperty("useLocalTransactionState", "true");
		hikariConfig.addDataSourceProperty("rewriteBatchedStatements", "true");
		hikariConfig.addDataSourceProperty("useServerPrepStmts", "true");
		hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
		hikariConfig.addDataSourceProperty("maintainTimeStats", "false");
		hikariConfig.addDataSourceProperty("useUnbufferedIO", "false");
		hikariConfig.addDataSourceProperty("useReadAheadInput", "false");
		hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
		hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		hikariConfig.addDataSourceProperty("cacheResultSetMetadata", "true");
		hikariConfig.addDataSourceProperty("elideSetAutoCommits", "true");
		return new SQL(hikariConfig);
	}



}
