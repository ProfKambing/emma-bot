package me.kambing.events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 * @author kambing
 * @since 21/9/2021
 */
public class Ping extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if (event.getMessage().getMentionedMembers().size() == 1) {
            if (event.getMessage().getMentionedMembers().get(0).getUser().equals(event.getJDA().getSelfUser())) {
                event.getMessage().reply("Hi im emma, a multipurpose bot developed by kambing#3091. Check out my commands by typing `;help`").queue();
            }
        }
    }

}
