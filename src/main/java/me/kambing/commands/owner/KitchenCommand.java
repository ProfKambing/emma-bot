package me.kambing.commands.owner;

import me.kambing.Main;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.RateLimitedException;


public class KitchenCommand {

    public static void onMessageReceived(MessageReceivedEvent event) {

        if (event.getMessage().getAuthor().getId().equals("721382139060551802")) {
                event.getMessage().reply("ok daddy i will go to kitchen and do my dishes :pleading_face: \n Turning off bot...").queue();
                System.exit(1337);
            }else{
            event.getMessage().reply("shut up u sexist").queue();
        }
        }
    }

