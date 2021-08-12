package me.kambing.events;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class DefaultRole extends ListenerAdapter { //made this for my server
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        try {
            event.getGuild().addRoleToMember(event.getMember(), getDefaultRole(event.getGuild())).queue();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    public static Role getDefaultRole(Guild guild) { //pasted from github
        return guild.getRoles().stream().filter(r -> r.getId().equals("875206657326596147")).findFirst().orElse(null);
    }
}

