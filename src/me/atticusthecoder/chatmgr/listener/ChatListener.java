package me.atticusthecoder.chatmgr.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.atticusthecoder.chatmgr.Main;
import me.atticusthecoder.chatmgr.common.MessageData;
import me.atticusthecoder.chatmgr.common.UtilTime;
import net.md_5.bungee.api.ChatColor;

public class ChatListener implements Listener {

	@EventHandler
	public void slowChatCheck(AsyncPlayerChatEvent e) {
		
		Player player = e.getPlayer();
		
		if(Main.getInstance()._playerLastMessage.containsKey(e.getPlayer().getUniqueId())) {
			MessageData lastMessage = Main.getInstance()._playerLastMessage.get(e.getPlayer().getUniqueId());
			long slowChatTime = 1000L * Main.getInstance()._chatSlow;
			long timeDiff = System.currentTimeMillis() - lastMessage.getTimeSent();
			
			if(timeDiff < slowChatTime && (!player.hasPermission("chatmanager.bypassslowchat"))) {
				player.sendMessage(ChatColor.RED + "Chat is currently slowed! Please wait " + UtilTime.convertString(slowChatTime - timeDiff, 1, UtilTime.TimeUnit.FIT));
				e.setCancelled(true);
				return;
			}
		}
		
		Main.getInstance()._playerLastMessage.put(e.getPlayer().getUniqueId(), new MessageData(e.getMessage()));
		
	}
	
	@EventHandler
	public void silencedChatCheck(AsyncPlayerChatEvent e) {
		
		Player player = e.getPlayer();
		
		if(Main.getInstance()._silenced) {
			if(!player.hasPermission("chatmanager.bypasssilence")) {
				player.sendMessage(ChatColor.RED + "Chat is currently silenced right now!");
				e.setCancelled(true);
			}
		}
		
	}
	
}
