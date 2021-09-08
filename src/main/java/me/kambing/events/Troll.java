package me.kambing.events;


import com.jagrosh.jdautilities.examples.doc.Author;
import me.kambing.Main;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
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
        User m = event.getAuthor();
        Message u = event.getMessage();

        if (u == null)
            return;
        if (TrollToggler.troll) {
            if (m.getId().equals("823621414203686922") || m.getId().equals("759889917613834250")) { //TODO
                u.delete().queue();
            }
            if (m.getId().equals("270904126974590976") && u.getContentRaw().contains("006#2805")) {
                u.delete().queue();
            }
        }
    }
}