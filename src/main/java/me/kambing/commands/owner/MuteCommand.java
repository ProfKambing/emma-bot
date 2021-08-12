package me.kambing.commands.owner;


import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;



public class MuteCommand {

    public static void onMessageReceived(MessageReceivedEvent event) {
        try {
            if (event.getMessage().getAuthor().getId().equals("721382139060551802")) {
                event.getGuild().addRoleToMember(event.getMessage().getMentionedMembers().get(0), getMutedRole(event.getGuild())).queue();
                event.getMessage().addReaction("\u2705").queue();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Role getMutedRole(Guild guild) { //pasted from github
        return guild.getRoles().stream().filter(r -> r.getName().equalsIgnoreCase("Muted")).findFirst().orElse(null);
    }
}

