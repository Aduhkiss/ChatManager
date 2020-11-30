# Chat Manager

Plugin by AtticusTheCoder

## What is it?

ChatManager is an easy to use plugin that will allow better chat management.

At the moment, the plugin has no major features that any other chat management plugin doesn't have, however it is still a work in progress plugin, and I will work on features upon request.

## Can I help with the project development?

Of course! Feel free to make your own edits to your own forks, then create a pull request to have them added to this repo!

## Commands
* /chat - Display help for the command

* /chat silence - Silence chat for players, except those who bypass
Run command again to un-silence chat

* /chat slow <Cooldown in seconds> - Slows the chat, only lets players talk every X amount of seconds. Again, this can be bypassed.
Use /chat slow 0 to disable slow chat.

## Permission nodes

* 'chatmanager.chat' - Have access to /chat

* 'chatmanager.chatslow' - Ability to slow chat with /chat slow

* 'chatmanager.chatsilence' - Ability to silence chat with /chat silence

* 'chatmanager.bypassslowchat' - Ability to bypass slow chat

* 'chatmanager.bypasssilence' - Ability to talk when chat is silenced

* 'chatmanager.chatclear' - Ability to clear the chat with /chat clear

* 'chatmanager.chatclearbypass' - Bypass chat clears, when chat gets cleared, your chat will not get cleared.

## Chat Manager API

Chat Manager has an easy to use API that allows you to control the plugin, from your own code. Here is how you use it!

To get an instance of the api, simply use `ChatManagerAPI.getApi()` from this, you will be able to use the other methods given, to control the quickly.

`isChatSilenced()` - Will return if the chat is currently silenced.

`setChatSilenced()` - Takes a boolean as an argument, and will allow you to silence/un-silence the chat.

`isChatSlowed()` - Returns if the chat is currently slowed or not.

`getChatCooldown()` - Returns the chat delay as a double. If the chat is not slowed it will return 0

### Example use of the API

```
if(ChatManagerAPI.getApi().isChatSilenced()) {
	ChatManagerAPI.getApi().setChatSilenced(true);
	player.sendMessage("You have silenced the chat!");
}
```

## Planned Features

* Ability to clear chat

* Logging of all staff commands

## Credits

* Atticus (Aduhkiss) = Started the plugin/Base code
