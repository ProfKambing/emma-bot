package me.kambing.commands;

import me.kambing.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.time.Duration;
import java.util.Random;

public class HaramCommand {

    public static void onMessageReceived(MessageReceivedEvent event) {

        var message = event.getMessage();

        Random random = new Random();

        int x = random.nextInt(100);


        try {
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle(message.getMentionedMembers().get(0).getUser().getName() + " Haram meter");
            eb.setDescription(message.getMentionedMembers().get(0).getUser().getName() + " is " + x + "% haram :kaaba:");
            eb.setColor(new Color(100, 100, 100));
            message.replyEmbeds(eb.build()).queue();
        } catch (IndexOutOfBoundsException exception) {
            if (message.getAuthor().getId().equals("721382139060551802")) {
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle(message.getAuthor().getName() + " Haram meter");
                eb.setDescription("you" + " are " + "0" + "% haram :kaaba:");
                eb.setColor(new Color(100, 100, 100));
                message.replyEmbeds(eb.build()).queue();
            }else {
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle(message.getAuthor().getName() + " Haram meter");
                eb.setDescription("you" + " are " + x + "% haram :kaaba:");
                eb.setColor(new Color(100, 100, 100));
                message.replyEmbeds(eb.build()).queue();
            }

        }

    }
}