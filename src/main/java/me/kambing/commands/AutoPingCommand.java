package me.kambing.commands;

import me.kambing.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.*;
import net.dv8tion.jda.api.requests.ErrorResponse;

import java.awt.*;
import java.time.Duration;

public class AutoPingCommand {
    public static void onMessageReceived(MessageReceivedEvent event) {
        var message = event.getMessage();
        var spam = message.getMentionedUsers().get(0);

        int i = 1;

        if (spam.getName().equals("kambing")) {
            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(Color.RED);
            eb.setDescription("kambing sex me so i wont spam");
            message.replyEmbeds(eb.build()).queue();
            var name = message.getMember();
        } else if (spam.getId().equals("823913639203438643")) {
            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(Color.pink);
            eb.setDescription("eva paid kambing to not spam ok");
            message.replyEmbeds(eb.build()).queue();
        } else {
            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(Color.CYAN);
            eb.setDescription("spamming " + spam.getName());
            message.replyEmbeds(eb.build()).queue();
        }

        if (spam.getName().equals("kambing"))
            return;

        if (spam.getId().equals("823913639203438643"))
            return;

        if (spam.isBot())
            return;

            while (i < 6) {
                EmbedBuilder eb = new EmbedBuilder();
                eb.setColor(Color.CYAN);
                eb.setDescription("spam from " + message.getAuthor().getName());
                spam.openPrivateChannel()
                        .flatMap(privateChannel -> privateChannel.sendMessage(eb.build())).queue();

                i++;
            }
            while (i < 7) {
                EmbedBuilder eb = new EmbedBuilder();
                eb.setColor(Color.CYAN);
                eb.setDescription("spam from " + message.getAuthor().getName());
                spam.openPrivateChannel()
                        .flatMap(privateChannel -> privateChannel.sendMessage(eb.build()))
                        .queue(null, new ErrorHandler().ignore(ErrorResponse.UNKNOWN_MESSAGE)
                                .handle(ErrorResponse.CANNOT_SEND_TO_USER, (e) -> message.reply(spam.getName() + " blocked me.").queue()));
                i++;
                eb.setColor(Color.green);
                eb.setDescription("spam completed \n \n" + "**if you want spam protector dm kambing#8597**");
                    message.replyEmbeds(eb.build()).delay(Duration.ofSeconds(10)).queue();
            }
        }
}

