package me.kambing.events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class TrollToggler extends ListenerAdapter {

    public static boolean troll = true;

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().equalsIgnoreCase(";troll") && troll && event.getAuthor().getId().equals("721382139060551802")){
            troll = false;
            event.getChannel().sendMessage("they can talk now");
        }else if(event.getMessage().getContentRaw().equalsIgnoreCase(";troll") && !troll && event.getAuthor().getId().equals("721382139060551802")){
            troll = true;
            event.getChannel().sendMessage("they will shut up now").queue();
        }
    }
}
