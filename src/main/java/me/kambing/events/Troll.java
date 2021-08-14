package me.kambing.events;


import me.kambing.Main;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Troll extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event) {
        Main.LOGGER.info(Main.LOGGER.getName() + " successfully started!");
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().getId().equals("823621414203686922")) {
            event.getMessage().delete().queue();
        }
    }
}

