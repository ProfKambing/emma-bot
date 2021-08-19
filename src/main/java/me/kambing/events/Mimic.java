package me.kambing.events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

//made by kambing 19/8/2021

public class Mimic extends ListenerAdapter {

    public static boolean filterOn = true;

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        var mimicing = event.getMessage().getMentionedMembers().get(0);

        if (event.getMessage().getContentRaw().equalsIgnoreCase(";mimicstop") && filterOn && event.getAuthor().getId().equals("721382139060551802")){
            filterOn = false;
            event.getChannel().sendMessage("stop mimicing").queue();
        }else if(event.getMessage().getContentRaw().equalsIgnoreCase(";mimic") && !filterOn && event.getAuthor().getId().equals("721382139060551802")){
            filterOn = true;
            event.getChannel().sendMessage("mimicing " + mimicing).queue();
        }
        if (filterOn && event.getAuthor().getId().equals(mimicing.getId()) ) {
            event.getChannel().sendMessage(event.getMessage().getContentRaw()).queue();
        }
    }
}
