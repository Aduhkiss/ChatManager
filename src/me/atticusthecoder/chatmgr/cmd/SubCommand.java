package me.atticusthecoder.chatmgr.cmd;

import org.bukkit.entity.Player;

public abstract class SubCommand {
	public abstract void execute(Player caller, String[] args);
}
