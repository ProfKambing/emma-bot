package me.kambing.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.time.Duration;

public class HackCommand {

    public static void onMessageReceived(MessageReceivedEvent event) {

        var message = event.getMessage();

        message.reply("Hacking...").delay(Duration.ofSeconds(2)).queue(message1 -> {
            message1.editMessageFormat("Password: 2131299nsajj02").delay(Duration.ofSeconds(1)).queue(message2 -> {
                message2.editMessageFormat("searching for hentai folder : FOUND!").delay(Duration.ofSeconds(2)).queue(message3 -> {
                    message3.editMessageFormat("sending da folder to kambing").delay(Duration.ofSeconds(1)).queue(message4 -> {
                        message4.editMessageFormat("detecting any sus messages").delay(Duration.ofSeconds(2)).queue(message5 -> {
                           message5.editMessageFormat("Found! : \n kambing is such a sussy baka \n kambing is so cute ").queue();
                        });
                    });
                });
            });
        });

    }
}
