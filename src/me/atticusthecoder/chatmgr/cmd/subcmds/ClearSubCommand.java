package me.atticusthecoder.chatmgr.cmd.subcmds;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.atticusthecoder.chatmgr.cmd.SubCommand;
import me.atticusthecoder.chatmgr.common.ChatLogger;
import net.md_5.bungee.api.ChatColor;

public class ClearSubCommand extends SubCommand {
	
	@Override
	public void execute(Player caller, String[] args) {
		// Permission check
		if(!caller.hasPermission("chatmanager.chatclear")) {
			caller.sendMessage(ChatColor.RED + "You do not have permission to run this!");
			return;
		}
		
		// Then clear the chat
		
		for(Player pl : Bukkit.getOnlinePlayers()) {
			for(int i = 0; i < 200; i++) {
				if(!pl.hasPermission("chatmanager.chatclearbypass")) {
					pl.sendMessage("\n");
				}
			}
			pl.sendMessage(ChatColor.RED + "The Chat was cleared by " + caller.getName());
		}
		// log the action
		ChatLogger.log(caller.getName() + " has cleared the chat.");
		return;
	}

}
