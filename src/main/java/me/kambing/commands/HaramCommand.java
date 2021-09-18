package me.kambing.commands;


import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import me.kambing.util.Blacklist;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.awt.*;
import java.util.Random;


public class HaramCommand extends Command {
    public HaramCommand() {
        this.name = "haram";
        this.help = "haram meter";
    }

    @Override
    protected void execute(CommandEvent event) {
        if (Blacklist.getClass.isRetard(event))
            return;
        Message message = event.getMessage();

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

