package me.kambing.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class HelpCommand {

    public static void onMessageReceived(MessageReceivedEvent event) {

        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.CYAN);

        var message = event.getMessage();


        eb.setTitle("Commands");
        eb.setThumbnail("https://cdn.discordapp.com/avatars/721382139060551802/3205930f9af4c952b6b10019fd752e3b.png?size=1024");
        eb.setColor(Color.CYAN);
        eb.setFooter("requested by " + message.getAuthor().getAsTag(), message.getAuthor().getAvatarUrl());
        eb.setDescription(
                "**hack** - hack people \n" +
                "**purge** - purge messages \n" +
                "**ban** - ban people \n" +
                "**ping** - check bot ping \n" +
                "**say** - bot says something \n" +
                "**haram** - haram meter \n" +
                "**spam** - spam someone's dm \n" +
                "**dm** - if someone block u, u can use this command \n" +
                "**ship** - ship people \n");
        event.getChannel().sendMessageEmbeds(eb.build()).queue();

    }
}
