package me.kambing.commands;


import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import me.kambing.util.Blacklist;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.internal.utils.PermissionUtil;

import static me.kambing.commands.MuteCommand.getMutedRole;


public class UnmuteCommand extends Command {
    public UnmuteCommand() {
        this.name = "unmute";
        this.help = "unmute people";
        this.cooldown = 5;
    }

    @Override
    protected void execute(CommandEvent event) {
        if (Blacklist.getClass.isRetard(event))
            return;
        try {
            Member mute= event.getMessage().getMentionedMembers().get(0);
            if(PermissionUtil.checkPermission(event.getMember(), Permission.MESSAGE_MANAGE, Permission.ADMINISTRATOR)) {
                event.getGuild().removeRoleFromMember(mute, getMutedRole(event.getGuild())).queue();
                if (mute.getRoles().contains(getMutedRole(event.getGuild()))) {
                    event.getMessage().addReaction("\u2705").queue();
                }else {
                    event.getMessage().addReaction("\uD83D\uDEAB").queue();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
