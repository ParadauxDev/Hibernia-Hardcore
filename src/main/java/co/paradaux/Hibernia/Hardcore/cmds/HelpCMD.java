package co.paradaux.Hibernia.Hardcore.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)) {
			System.out.println("Why Can I Not Use Bukkit in here? HELP ME PARA");
		}
		
		
		return false;
	}

}
