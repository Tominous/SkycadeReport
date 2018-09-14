package net.angusbeefgaming.report;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
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
    	// If the player can recieve messages
    	if(SkycadeReport.toggledStaff.get(((ProxiedPlayer) sender))) {
    		// Disable the messages and send them a message
    		SkycadeReport.toggledStaff.put((ProxiedPlayer) sender, false);
    		ProxiedPlayer player = (ProxiedPlayer) sender;
    		player.sendMessage(ChatColor.GREEN + "You will no longer get report alerts!");
    	}
    	else {
    		// Enable the messages and send them a message
    		SkycadeReport.toggledStaff.put((ProxiedPlayer) sender, true);
    		ProxiedPlayer player = (ProxiedPlayer) sender;
    		player.sendMessage(ChatColor.GREEN + "You will now get report alerts!");
    	}
    }
    
}
