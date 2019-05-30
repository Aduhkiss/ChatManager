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

## Chat Manager API

Chat Manager has an easy to use API that allows you to control the plugin, from your own code. Here is how you use it!

## Credits

* AtticusTheCoder (MrBeefSteak) = Started the plugin/Base code
