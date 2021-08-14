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
        var m = event.getAuthor();
        var u = event.getMessage();

        if (u == null)
            return;

        if (m.getId().equals("823621414203686922")) {
            u.delete().queue();
        }
    }
}

