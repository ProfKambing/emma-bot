package me.kambing.events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Raden extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
            if (e.getMessage().getContentRaw().contains("raden")) {
                e.getMessage().reply("RIP Raden 2008-2021 :sob:");

            }
    }

}



