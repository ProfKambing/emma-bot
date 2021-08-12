package me.kambing.commands.owner;

import me.kambing.Main;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.RateLimitedException;


public class Command {

    public static void onMessageReceived(MessageReceivedEvent event) {

        if (event.getMessage().getAuthor().getId().equals("721382139060551802")) {
            event.getMessage().reply("ok daddy").queue();
        }else{
            event.getMessage().reply("fuck off").queue();
        }
    }
}

