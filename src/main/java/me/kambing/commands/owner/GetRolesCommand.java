package me.kambing.commands.owner;

import me.kambing.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.RateLimitedException;

import java.awt.*;


public class GetRolesCommand {

    public static void onMessageReceived(MessageReceivedEvent event) {

        if (event.getMessage().getAuthor().getId().equals("721382139060551802")) {
            try {
                var color = event.getMessage().getMentionedRoles().get(0).getColor();
                EmbedBuilder eb = new EmbedBuilder();
                eb.setColor(color);
                eb.setDescription(color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + " : " + color.getRGB());
                eb.setTitle("Color for " + event.getMessage().getMentionedRoles().get(0).getName());
                event.getMessage().replyEmbeds(eb.build()).queue();
            }catch (NullPointerException e) {
                EmbedBuilder eb = new EmbedBuilder();
                eb.setColor(Color.red);
                eb.setDescription("the role does not have a color!");
                eb.setTitle("Error!");
                event.getMessage().replyEmbeds(eb.build()).queue();
            }
        }
    }
}

