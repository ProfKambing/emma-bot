package me.kambing.commands.owner;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;;


public class TrampolineCommand {

    public static void onMessageReceived(MessageReceivedEvent event) {

        if (event.getMessage().getAuthor().getId().equals("721382139060551802")) {
            event.getMessage().reply("https://tenor.com/view/anime-trampoline-blush-jump-gif-17601451").queue();
        }else{
            event.getMessage().reply("fuck off").queue();
        }
    }
}

