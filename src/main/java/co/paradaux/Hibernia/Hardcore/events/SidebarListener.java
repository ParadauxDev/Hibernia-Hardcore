package co.paradaux.Hibernia.Hardcore.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import co.paradaux.Hibernia.Hardcore.api.Sidebar;

public class SidebarListener implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {

		final Player p = e.getPlayer();
		Sidebar.buildSidebar(p);

	}

}
