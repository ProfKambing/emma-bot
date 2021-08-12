package me.kambing.commands;

import me.kambing.Main;
import net.dv8tion.jda.api.EmbedBuilder;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.ErrorHandler;
import net.dv8tion.jda.api.requests.ErrorResponse;


import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class DmCommand {

    public static void onMessageReceived(MessageReceivedEvent event) {
            Timer spamTimer = new Timer();
            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(Color.CYAN);

            var message = event.getMessage();
        try {

                var memberToDm = message.getMentionedUsers().get(0);
                var s = message.getContentRaw().split(Main.prefix + "dm");
                eb.setAuthor(message.getAuthor().getName(), message.getAuthor().getAvatarUrl(), message.getAuthor().getAvatarUrl());
                eb.setTitle("You received a dm from " + message.getAuthor().getAsTag() + "!");
                eb.setDescription(s[1]);
                eb.setFooter("bot made by kambing#8597","https://cdn.discordapp.com/avatars/721382139060551802/3205930f9af4c952b6b10019fd752e3b.png?size=1024" );
                memberToDm.openPrivateChannel()
                        .flatMap(privateChannel -> privateChannel.sendMessage(eb.build()))
                        .queue(
                                null, new ErrorHandler().ignore(ErrorResponse.UNKNOWN_MESSAGE)
                                        .handle(ErrorResponse.CANNOT_SEND_TO_USER,  (e) -> message.reply("Unable to dm.").queue()));

                message.reply("Sending dm!").queue();

            }catch (IndexOutOfBoundsException exception) {
               message.reply("Incorrect format dumass wheres the user retarded ass nig").queue();
            }
        }
    }

