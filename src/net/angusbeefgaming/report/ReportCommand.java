package net.angusbeefgaming.report;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.command.PlayerCommand;

public class ReportCommand extends PlayerCommand
{

    public ReportCommand()
    {
        super( "report", "skycadereport.report" );
    }

    @SuppressWarnings("deprecation")
	@Override
    public void execute(CommandSender sender, String[] args)
    {
        if ( args.length < 2 )
        {
            sender.sendMessage(ChatColor.RED + "Usage: /report <Player> <Reason>");
        } else
        {
        	
        	String target = args[0];
        	String reason = combine(args, 1);
			
			ProxiedPlayer send = null;
			try {
				send = (ProxiedPlayer) sender;
			}
			catch(ClassCastException e) {
				send.sendMessage(ChatColor.RED + "Sorry, but Console is not able to file any reports!");
			}
			
			Server server = send.getServer();
			
			// First check if the player is reporting themselfs
			
			if(target.equalsIgnoreCase(send.getName())) {
				send.sendMessage(ChatColor.RED + "You can't report yourself! Why would you want to do that?");
				return;
			}
			
        	for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
        		if(player.hasPermission("skycadereport.staff")) {
        			if(SkycadeReport.toggledStaff.get(player)) {
            			player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Report " + server.getInfo().getName() + 
            					ChatColor.AQUA + " " + send.getName() + " " + ChatColor.RED + "Reported " + ChatColor.AQUA + target + ChatColor.RED + " for the reason '" + reason + "'");
        			}
        		}
        	}
        	
        	// Then send a message to the player who reported.
        	
        	send.sendMessage(ChatColor.GREEN + "Your report has been recieved by staff and will be handled shortly! Thanks for reporting!");
        }
    }
    
	public static String combine(String[] arr, int startPos) {
        StringBuilder str = new StringBuilder();

        for(int i = startPos; i < arr.length; ++i) {
           str = str.append(arr[i] + " ");
        }
        return str.toString();
	}
}
