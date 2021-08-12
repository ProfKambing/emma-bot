package me.kambing.commands.owner;


import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import static me.kambing.commands.owner.MuteCommand.getMutedRole;


public class UnmuteCommand {

    public static void onMessageReceived(MessageReceivedEvent event) {
        try {
            if (event.getMessage().getAuthor().getId().equals("721382139060551802")) {
                event.getGuild().removeRoleFromMember(event.getMessage().getMentionedMembers().get(0), getMutedRole(event.getGuild())).queue();
                event.getMessage().addReaction(":white_check_mark:").queue();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

