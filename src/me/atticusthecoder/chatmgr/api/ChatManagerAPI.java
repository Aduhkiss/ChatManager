package me.atticusthecoder.chatmgr.api;

import me.atticusthecoder.chatmgr.Main;

public class ChatManagerAPI {
	/*
	 * Chat Manager API Singleton class
	 * allows you to control chat manager from your own code
	 * Written by AtticusTheCoder
	 */
	
	public static ChatManagerAPI api;
	
	/***
	 * Gets an instance of the ChatManagerAPI object
	 * @return ChatManagerAPI
	 */
	public static ChatManagerAPI getApi() {
		if(api == null) {
			api = new ChatManagerAPI();
		}
		return api;
	}
	
	/***
	 * Returns true if the chat is silenced
	 * @return boolean
	 */
	public boolean isChatSilenced() {
		return Main.getInstance()._silenced;
	}
	
	/***
	 * Allows you to modify if the chat is silenced
	 * @param silence
	 */
	public void setChatSilenced(boolean silence) {
		Main.getInstance()._silenced = silence;
	}
	
	/***
	 * Returns true if the chat is currently slowed
	 * @return boolean
	 */
	public boolean isChatSlowed() {
		if(Main.getInstance()._chatSlow == 0) {
			return false;
		} else {
			return true;
		}
	}
	/**
	 * Will return the cooldown for the chat as a double
	 * @return double
	 */
	public double getChatCooldown() {
		return Main.getInstance()._chatSlow;
	}
}
