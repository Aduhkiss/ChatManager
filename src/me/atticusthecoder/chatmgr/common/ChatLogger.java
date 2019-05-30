package me.atticusthecoder.chatmgr.common;

import org.bukkit.Bukkit;

public class ChatLogger {
	public static void log(String msg) {
		Bukkit.getLogger().info("[Chat Manager Logger] " + msg);
	}
}
