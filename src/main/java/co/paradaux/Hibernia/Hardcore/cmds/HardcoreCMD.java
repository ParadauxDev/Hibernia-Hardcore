package co.paradaux.Hibernia.Hardcore.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import co.paradaux.Hibernia.Hardcore.api.LivesManager;

public class HardcoreCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		final LivesManager l = new LivesManager();
		l.getLives((Player) sender);
		return true;
	}

}
