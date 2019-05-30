package me.atticusthecoder.chatmgr.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.atticusthecoder.chatmgr.cmd.subcmds.SilenceSubCommand;
import me.atticusthecoder.chatmgr.cmd.subcmds.SlowSubCommand;
import net.md_5.bungee.api.ChatColor;

public class ChatCommand implements CommandExecutor {
	
	private SilenceSubCommand silenceSubCommand;
	private SlowSubCommand slowSubCommand;
	
	public ChatCommand() {
		silenceSubCommand = new SilenceSubCommand();
		slowSubCommand = new SlowSubCommand();
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "You can only run this command in-game!");
			return false;
		}
		
		// Permission check
		if(!sender.hasPermission("chatmanager.chat")) {
			sender.sendMessage(ChatColor.RED + "You do not have permission to run this!");
			return false;
		}
		
		if(args == null || args.length == 0) {
			sendHelp((Player) sender);
			return true;
		}
		
		if(args[0].equalsIgnoreCase("silence")) {
			silenceSubCommand.execute((Player) sender, args);
			return true;
		}
		if(args[0].equalsIgnoreCase("slow")) {
			if(args.length != 2) {
				sender.sendMessage(ChatColor.RED + "Usage: /chat slow <Cooldown>");
				return false;
			}
			slowSubCommand.execute((Player) sender, args);
			return true;
		}
		
		sendHelp((Player) sender);
		return true;
	}
	
	public void sendHelp(Player player) {
		player.sendMessage(ChatColor.RED + "Usage: /chat <silence, slow>");
	}

}
