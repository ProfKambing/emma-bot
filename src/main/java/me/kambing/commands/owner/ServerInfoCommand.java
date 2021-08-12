package me.kambing.commands.owner;

import me.kambing.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.RateLimitedException;

import java.awt.*;


public class ServerInfoCommand {

    public static void onMessageReceived(MessageReceivedEvent event) {

        if (event.getMessage().getAuthor().getId().equals("721382139060551802")) {
            try {
                String[] test = new String[event.getGuild().getMembers().size()];
                for(int i = 0; i < event.getGuild().getMembers().size();i++) {
                    test[i] = event.getGuild().getMembers().get(i).getEffectiveName();
                }
                EmbedBuilder eb = new EmbedBuilder();
                eb.setColor(Color.RED);
                eb.setAuthor(event.getGuild().getName());
                eb.setThumbnail(event.getGuild().getIconUrl());
                eb.addField("Member Count:", Integer.toString(event.getGuild().getMembers().size()),true);
                eb.addField("Members:", test.toString(), true);
                event.getMessage().replyEmbeds(eb.build()).queue();

            }catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

