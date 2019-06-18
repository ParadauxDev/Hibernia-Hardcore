package co.paradaux.Hibernia.Hardcore.api;

import org.bukkit.entity.Player;

import co.paradaux.Hibernia.Hardcore.HiberniaHardcore;

public class LivesManager {


	public int getLives(Player p) {

		final int amount = 5;
		HiberniaHardcore.newChain().sync(() -> p.sendMessage(amount + "")).execute();

		return amount;

	}


}
