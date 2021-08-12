package me.kambing.events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class FilterToggler extends ListenerAdapter {

    public static boolean filterOn = true;

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().equalsIgnoreCase(";togglefilter") && filterOn && event.getAuthor().getId().equals("721382139060551802")){
            filterOn = false;
            event.getChannel().sendMessage("Message Filter has been disabled by " + event.getMember().getUser().getName()).queue();
        }else if(event.getMessage().getContentRaw().equalsIgnoreCase(";togglefilter") && !filterOn && event.getAuthor().getId().equals("721382139060551802")){
            filterOn = true;
            event.getChannel().sendMessage("Message Filter has been enabled by " + event.getMember().getUser().getName()).queue();
        }
    }
}
