package net.angusbeefgaming.report;

import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PlayerJoinEvents implements Listener {

    @EventHandler
    public void onPostLogin(PostLoginEvent event) {
    	// Enable report messages everytime a player joins the network
    	SkycadeReport.toggledStaff.put(event.getPlayer(), true);
    }
}
