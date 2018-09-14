package net.angusbeefgaming.report;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.command.PlayerCommand;

public class ToggleReportSystemCommand extends PlayerCommand
{

    public ToggleReportSystemCommand()
    {
        super( "togglereportsystem", "skycadereport.admin" );
    }

    @SuppressWarnings("deprecation")
	@Override
    public void execute(CommandSender sender, String[] args)
    {
    	ProxiedPlayer send = (ProxiedPlayer) sender;
    	Server server = send.getServer();
    	
    	if(SkycadeReport.reportSystemEnabled) {
    		SkycadeReport.reportSystemEnabled = false;
    		ProxiedPlayer player = (ProxiedPlayer) sender;
        	for(ProxiedPlayer pla : ProxyServer.getInstance().getPlayers()) {
        		if(pla.hasPermission("skycadereport.staff")) {
    				pla.sendMessage(ChatColor.RED + "Global Report system has been disabled by " + player.getName());
        		}
        	}
    	}
    	else {
    		SkycadeReport.reportSystemEnabled = true;
    		ProxiedPlayer player = (ProxiedPlayer) sender;
        	for(ProxiedPlayer pla : ProxyServer.getInstance().getPlayers()) {
        		if(pla.hasPermission("skycadereport.staff")) {
    				pla.sendMessage(ChatColor.RED + "Global Report system has been enabled by " + player.getName());
        		}
        	}
    	}
    }
    
}
