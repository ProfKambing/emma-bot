package me.kambing.events;

import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

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
              event.getGuild().kick(event.getMember()).queue();
              System.out.println("[LockEvent] kicked " + event.getMember().getUser().getAsMention() + " | " + event.getMember().getUser().getId());
          }
        }
    }
}

