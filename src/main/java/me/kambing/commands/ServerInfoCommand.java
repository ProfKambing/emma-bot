package me.kambing.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import me.kambing.util.Blacklist;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;

import java.awt.*;
import java.time.format.DateTimeFormatter;

/**
 * @author John Grosh (jagrosh)
 */
public class ServerInfoCommand extends Command {
    private final static String LINESTART = "\u25AB"; //
    private final static String GUILD_EMOJI = "\uD83D\uDDA5"; //
    private final static String NO_REGION = "\u2754"; //

    public ServerInfoCommand() {
        this.name = "serverinfo";
        this.aliases = new String[]{"server", "guildinfo"};
        this.help = "shows server info";
        this.botPermissions = new Permission[]{Permission.MESSAGE_EMBED_LINKS};
        this.guildOnly = true;
    }

    @Override
    protected void execute(CommandEvent event) {
        if (Blacklist.getClass.isRetard(event))
            return;
        int me = 0;
        int ome = 0;
        int bot = 0;
        for (Member member : event.getGuild().getMembers()) {
            me++;
        }
        for (Member member : event.getGuild().getMembers()) {
            if (member.getOnlineStatus() != OnlineStatus.OFFLINE) {
                ome++;
            }
        }
        for (Member member : event.getGuild().getMembers()) {
            if (member.getUser().isBot()) {
                bot++;
            }
        }
        Guild guild = event.getGuild();
        Member owner = guild.getOwner();
        EmbedBuilder builder = new EmbedBuilder();
        String title = (GUILD_EMOJI + " Information about **" + guild.getName() + "**:")
                .replace("@everyone", "@\u0435veryone") // cyrillic e
                .replace("@here", "@h\u0435re") // cyrillic e
                .replace("discord.gg/", "dis\u0441ord.gg/"); // cyrillic c;
        String verif;
        switch (guild.getVerificationLevel()) {
            case VERY_HIGH:
                verif = "MAX";
                break;
            case HIGH:
                verif = "HIGH";
                break;
            default:
                verif = guild.getVerificationLevel().name();
                break;
        }
        String str = LINESTART + "ID: **" + guild.getId() + "**\n"
                + LINESTART + "Owner: " + (owner == null ? "Unknown" : "**" + owner.getUser().getName() + "**#" + owner.getUser().getDiscriminator()) + "\n"
                + LINESTART + "Location: " + (guild.getRegion().getEmoji().isEmpty() ? NO_REGION : guild.getRegion().getEmoji()) + " **" + guild.getRegion().getName() + "**\n"
                + LINESTART + "Creation: **" + guild.getTimeCreated().format(DateTimeFormatter.RFC_1123_DATE_TIME) + "**\n"
                + LINESTART + "Users: **" + me + "** (" + ome + " online, " + bot + " bots)\n"
                + LINESTART + "Channels: **" + guild.getTextChannelCache().size() + "** Text, **" + guild.getVoiceChannelCache().size() + "** Voice, **" + guild.getCategoryCache().size() + "** Categories\n"
                + LINESTART + "Verification: **" + verif + "**";
        if (!guild.getFeatures().isEmpty())
            str += "\n" + LINESTART + "Features: **" + String.join("**, **", guild.getFeatures()) + "**";
        if (guild.getSplashId() != null) {
            builder.setImage(guild.getSplashUrl() + "?size=1024");
            str += "\n" + LINESTART + "Splash: ";
        }
        if (guild.getIconUrl() != null)
            builder.setThumbnail(guild.getIconUrl());
        builder.setColor(Color.CYAN);
        builder.setDescription(str);
        event.reply(new MessageBuilder().append(title).setEmbed(builder.build()).build());
    }
}
