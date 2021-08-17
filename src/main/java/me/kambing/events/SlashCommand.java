package me.kambing.events;

import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SlashCommand extends ListenerAdapter {
    @Override
    public void onSlashCommand(SlashCommandEvent event) {
        if (event.getName().equals("say")) {
            event.reply(event.getOption("content").getAsString()).queue(); // reply immediately
        }
    }
}
