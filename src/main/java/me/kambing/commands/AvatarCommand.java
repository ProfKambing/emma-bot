package me.kambing.commands;

import me.kambing.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.RateLimitedException;

import java.awt.*;


public class AvatarCommand {

    public static void onMessageReceived(MessageReceivedEvent event) {
            try {
                var ping = event.getMessage().getMentionedMembers().get(0).getUser();
                event.getMessage().reply(ping.getAvatarUrl()+ "?size=256").queue();
            }catch (IndexOutOfBoundsException exception) {
              event.getMessage().reply(event.getMessage().getAuthor().getAvatarUrl()+ "?size=256").queue();
            } catch (Exception e) {
                event.getMessage().reply("masalah sial discord ni").queue();
            }
        }
    }

