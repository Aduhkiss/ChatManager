package me.atticusthecoder.chatmgr.cmd.subcmds;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.atticusthecoder.chatmgr.Main;
import me.atticusthecoder.chatmgr.cmd.SubCommand;
import net.md_5.bungee.api.ChatColor;

public class SlowSubCommand extends SubCommand {
	@Override
	public void execute(Player caller, String[] args) {
		// Permission check
		if(!caller.hasPermission("chatmanager.chatslow")) {
			caller.sendMessage(ChatColor.RED + "You do not have permission to run this!");
			return;
		}
		
		if(args[1] == null) {
			caller.sendMessage(ChatColor.RED + "Usage: /chat slow <Cooldown>");
			return;
		} else {
			int cooldown = Integer.valueOf(args[1]);
			
			Main.getInstance()._chatSlow = cooldown;
			
			if(cooldown == 0) {
				caller.sendMessage(ChatColor.GREEN + "You have disabled slow chat.");
				
				for(Player pl : Bukkit.getOnlinePlayers()) {
					pl.sendMessage(ChatColor.GREEN + "Chat is no longer slowed.");
				}
				return;
			}
			
			//TODO: Add a silencer (if your vanished or use -s)
			caller.sendMessage(ChatColor.GREEN + "You have slowed the chat with a " + cooldown + " second cooldown.");
			
			for(Player pl : Bukkit.getOnlinePlayers()) {
				pl.sendMessage(ChatColor.GREEN + caller.getName() + " has slowed the chat to " + cooldown + " seconds.");
			}
			
			return;
		}
	}
}
