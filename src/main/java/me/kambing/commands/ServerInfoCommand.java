package me.kambing.commands;


import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Member;

import java.awt.*;
import java.time.format.DateTimeFormatter;


public class ServerInfoCommand extends Command {
    public ServerInfoCommand() {
        this.name = "serverinfo";
        this.help = "get server info";
        this.cooldown = 10;
    }

    @Override
    protected void execute(CommandEvent event) {

        EmbedBuilder builder = new EmbedBuilder();
        builder.setAuthor("Server Info", null, "https://cdn.discordapp.com/avatars/721382139060551802/3205930f9af4c952b6b10019fd752e3b.png?size=256");
        builder.setThumbnail(event.getGuild().getIconUrl());
        builder.setColor(Color.CYAN);
        builder.setThumbnail(event.getGuild().getIconUrl());
        builder.addField("Name", event.getGuild().getName(), true);
        builder.addBlankField(true);
        builder.addField("Server ID", event.getGuild().getId(), true);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm a");
        builder.addField("Creation Date", event.getGuild().getTimeCreated().format(formatter), true);
        builder.addField("Total Members", String.valueOf(event.getGuild().getMembers().size()), true);
        int online = 0;
        for (Member member : event.getGuild().getMembers()) {
            if (!member.getOnlineStatus().equals(OnlineStatus.OFFLINE)) {
                ++online;
            }
        }
        builder.addField("Online Members", String.valueOf(online), true);

        event.getTextChannel().sendMessage(builder.build()).queue();

        }
}