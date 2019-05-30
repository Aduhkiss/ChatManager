package me.atticusthecoder.chatmgr.cmd.subcmds;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.atticusthecoder.chatmgr.Main;
import me.atticusthecoder.chatmgr.cmd.SubCommand;
import me.atticusthecoder.chatmgr.common.ChatLogger;
import net.md_5.bungee.api.ChatColor;

public class SilenceSubCommand extends SubCommand {

	@Override
	public void execute(Player caller, String[] args) {
		// Permission check
		if(!caller.hasPermission("chatmanager.chatsilence")) {
			caller.sendMessage(ChatColor.RED + "You do not have permission to run this!");
			return;
		}
		
		if(Main.getInstance()._silenced) {
			// Its silenced
			Main.getInstance()._silenced = false;
			caller.sendMessage(ChatColor.DARK_AQUA + "You have un-silenced the chat.");
			
			for(Player p : Bukkit.getOnlinePlayers()) {
				p.sendMessage(ChatColor.GREEN + caller.getName() + " has un-silenced the chat.");
			}
			ChatLogger.log(caller.getName() + " has un-silenced the chat.");
			return;
		} else {
			// Not
			Main.getInstance()._silenced = true;
			caller.sendMessage(ChatColor.DARK_AQUA + "You have silenced the chat.");
			for(Player p : Bukkit.getOnlinePlayers()) {
				p.sendMessage(ChatColor.GREEN + caller.getName() + " has silenced the chat.");
			}
			ChatLogger.log(caller.getName() + " has silenced the chat.");
			return;
		}
	}
}
