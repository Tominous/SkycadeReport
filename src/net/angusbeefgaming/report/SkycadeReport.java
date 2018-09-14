package net.angusbeefgaming.report;

import java.util.HashMap;
import java.util.Map;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;

public class SkycadeReport extends Plugin {
	/*
	 * Report System built by Atticus Zambrana (MrBeefSteak)
	 * 
	 * For the Skycade Network
	 */
	
	// LOL just put a hashmap here to hold if the staff member has reports toggled
	public static Map<ProxiedPlayer, Boolean> toggledStaff = new HashMap<ProxiedPlayer, Boolean>();
	
	@Override
	public void onEnable() {
		getProxy().getPluginManager().registerCommand(this, new ReportCommand());
	}

}
