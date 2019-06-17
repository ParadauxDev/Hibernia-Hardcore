package co.paradaux.Hibernia.Hardcore.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HardcoreCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		sender.sendMessage("Hello World! Welcome to live Debug!");
		sender.sendMessage("Another Message!");
		return true;
	}

}
