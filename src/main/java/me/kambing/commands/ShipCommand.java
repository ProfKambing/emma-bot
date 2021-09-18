package me.kambing.commands;


import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import me.kambing.util.Blacklist;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;

import java.awt.*;
import java.util.Random;


public class ShipCommand extends Command {
    public ShipCommand() {
        this.name = "ship";
        this.help = "ship people";
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
            eb.setTitle(message.getMentionedMembers().get(0).getUser().getName() + " and " + message.getMentionedMembers().get(1).getUser().getName() + " ship meter!");
            eb.setDescription(message.getMentionedMembers().get(0).getUser().getName() + " :heart:" + x + "%:heart: " + message.getMentionedMembers().get(1).getUser().getName());
            eb.setColor(Color.MAGENTA);
            message.replyEmbeds(eb.build()).queue();
        } catch (IndexOutOfBoundsException exception) {
            if (message.getAuthor().getId().equals("721382139060551802") && message.getMentionedMembers().get(0).getUser().getId().equals("823913639203438643")) {
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle(message.getAuthor().getName() + " and " + message.getMentionedMembers().get(0).getUser().getName() + " ship meter!");
                eb.setDescription(message.getAuthor().getName() + " :heart:" + "91.182701" + "%:heart: " + message.getMentionedMembers().get(0).getUser().getName());
                eb.setColor(Color.MAGENTA);
                message.replyEmbeds(eb.build()).queue();
            }else if (message.getAuthor().getId().equals("739510832043393055") && message.getMentionedMembers().get(0).getUser().getId().equals("673090816272498722")){
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle(message.getAuthor().getName() + " and " + message.getMentionedMembers().get(0).getUser().getName() + " ship meter!");
                eb.setDescription(message.getAuthor().getName() + " :heart:" + "100" + "%:heart: " + message.getMentionedMembers().get(0).getUser().getName());
                eb.setColor(Color.MAGENTA);
                message.replyEmbeds(eb.build()).queue();
            }else {
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle(message.getAuthor().getName() + " and " + message.getMentionedMembers().get(0).getUser().getName() + " ship meter!");
                eb.setDescription(message.getAuthor().getName() + " :heart:" + x + "%:heart: " + message.getMentionedMembers().get(0).getUser().getName());
                eb.setColor(Color.MAGENTA);
                message.replyEmbeds(eb.build()).queue();
            }

        }

    }
}

