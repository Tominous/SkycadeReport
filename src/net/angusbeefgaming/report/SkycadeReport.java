package net.angusbeefgaming.report;

import net.md_5.bungee.api.plugin.Plugin;

public class SkycadeReport extends Plugin {
	/*
	 * Report System built by Atticus Zambrana (MrBeefSteak)
	 * 
	 * For the Skycade Network
	 */
	
	@Override
	public void onEnable() {
		getProxy().getPluginManager().registerCommand(this, new ReportCommand());
	}

}
