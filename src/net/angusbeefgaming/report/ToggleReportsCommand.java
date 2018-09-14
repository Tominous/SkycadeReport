package net.angusbeefgaming.report;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.command.PlayerCommand;

public class ToggleReportsCommand extends PlayerCommand
{

    public ToggleReportsCommand()
    {
        super( "togglereports", "skycadereport.staff" );
    }

    @SuppressWarnings("deprecation")
	@Override
    public void execute(CommandSender sender, String[] args)
    {
    	
    }
    
}
