package me.kambing.events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class FilterEvent extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        if (e.getMessage().getAuthor().getId().equals("721382139060551802"))
            return;

        if (e.getMessage().getAuthor().getId().equals("823621414203686922")) {
            e.getMessage().delete().queue();
        }

        if (e.getMessage().getAuthor().isBot())
            return;

        if (FilterToggler.filterOn) {
            String[] LIST_OF_BAD_WORDS = {"anal", "anus", "arse", "ass", "motherfucker", "balls", "bastard", "bitch", "blowjob", "blow job", "buttplug", "cock", "coon", "cunt", "dildo", "fag", "dyke", "fuck", "fucking", "nigger", "Goddamn", "jizz", "nigga", "pussy", "shit", "whore", "hentai"};
            String[] message = e.getMessage().getContentRaw().split(" ");
            for (int i = 0; i < message.length; i++) {
                boolean badWord = false;
                //Check each message for each bad word
                for (int b = 0; b < LIST_OF_BAD_WORDS.length; b++) {
                    if (message[i].equalsIgnoreCase(LIST_OF_BAD_WORDS[b])) {
                        e.getMessage().delete().queue();
                        badWord = true;
                    }
                }
                System.out.println(message[i] + " " + badWord); //Just a report for console
            }
        }
    }
}


