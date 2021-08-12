package me.kambing.commands.owner;

import me.kambing.Main;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.RateLimitedException;


public class NickCommand {

    public static void onMessageReceived(MessageReceivedEvent event) {
        try {
            var nick = event.getMessage().getContentRaw().split(Main.prefix +  "nick");

            if (event.getMessage().getAuthor().getId().equals("721382139060551802")) {
                event.getMessage().reply("ok daddy changing nickname to" + nick[1]).queue();
                event.getGuild().modifyNickname(event.getGuild().getMemberById("874148544867618848"), nick[1]).queue();
            } else {
                event.getMessage().reply("only daddy can change my name").queue();
            }
        }catch (Exception e) {
            System.out.println(e);

        }
    }
}

