package me.kambing.commands;


import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.internal.utils.PermissionUtil;


public class MuteCommand extends Command {
    public MuteCommand() {
        this.name = "mute";
        this.help = "mute people";
        this.cooldown = 5;
    }

    @Override
    protected void execute(CommandEvent event) {
        try {
            Member mute= event.getMessage().getMentionedMembers().get(0);
            if(PermissionUtil.checkPermission(event.getMember(), Permission.MESSAGE_MANAGE, Permission.ADMINISTRATOR)) {
                event.getGuild().addRoleToMember(event.getMessage().getMentionedMembers().get(0), getMutedRole(event.getGuild())).queue();
                if (!mute.getRoles().contains(getMutedRole(event.getGuild()))) {
                    event.getMessage().addReaction("\u2705").queue();
                }else {
                    event.getMessage().addReaction("\uD83D\uDEAB").queue();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Role getMutedRole(Guild guild) { //pasted from github
        return guild.getRoles().stream().filter(r -> r.getName().equalsIgnoreCase("Muted")).findFirst().orElse(null);
    }
}
