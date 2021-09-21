package me.kambing.events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

/**
@author kambing
@since 30/8/21
 */

public class Lock extends ListenerAdapter {

    static boolean lock = false;

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().equalsIgnoreCase(";unlock") && lock && event.getAuthor().getId().equals("721382139060551802")) {
            lock = false;
            event.getChannel().sendMessage("Server unlocked! They can join now.").queue();
        } else if (event.getMessage().getContentRaw().equalsIgnoreCase(";lock") && !lock && event.getAuthor().getId().equals("721382139060551802")) {
            lock = true;
            event.getChannel().sendMessage("Server locked. new members will be kicked.").queue();
        }
    }

    public static class Locked extends ListenerAdapter {
        public void onGuildMemberJoin(GuildMemberJoinEvent event) {
          if (lock) {
             event.getMember().getUser().openPrivateChannel()
                     .flatMap(privateChannel -> privateChannel.sendMessage(
                             new EmbedBuilder().setColor(Color.CYAN)
                                     .setTitle("You were kicked from " + event.getGuild().getName()).setDescription("The server is locked! ask kambing#8597 to unlock it").setThumbnail("https://cdn.discordapp.com/attachments/875201293721927762/881744340072935454/580b585b2edbce24c47b2a2a.png").build()))
                      .queue();
              event.getGuild().kick(event.getMember()).queue();
              System.out.println("[LockEvent] kicked " + event.getMember().getUser().getAsMention() + " | " + event.getMember().getUser().getId());
          }
        }
    }
}

