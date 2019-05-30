package me.atticusthecoder.chatmgr;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.atticusthecoder.chatmgr.cmd.ChatCommand;
import me.atticusthecoder.chatmgr.common.MessageData;
import me.atticusthecoder.chatmgr.listener.ChatListener;

public class Main extends JavaPlugin {
	
	static Main me;
	
	public boolean _silenced;
	public int _chatSlow;
	public HashMap<UUID, MessageData> _playerLastMessage = new HashMap<UUID, MessageData>();
	
	@Override
	public void onEnable() {
		_silenced = false;
		me = this;
		
		// Register the handlers
		Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
		
		// Register the commands
		getCommand("chat").setExecutor(new ChatCommand());
	}
	
	@Override
	public void onDisable() {
		// nothing here...
		
	}
	
	public static Main getInstance() {
		return me;
	}

}
