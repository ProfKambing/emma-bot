package me.kambing.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import me.kambing.util.DateTime;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDAInfo;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;

import java.time.Instant;

import static me.kambing.util.MiscUtil.bytesToFriendly;


// %^stats command
public class StatsCommand extends Command {
    private final static Instant startTime = Instant.now();

    public StatsCommand() {
        this.name = "stats";
        this.help = "Cool stats about the bot!";
        this.botPermissions = new Permission[]{Permission.MESSAGE_EMBED_LINKS};
        this.guildOnly = false;
    }


    @Override
    protected void execute(CommandEvent commandEvent) {
        commandEvent.reply(generateStatsEmbed(commandEvent.getJDA()));
    }

    private MessageEmbed generateStatsEmbed(JDA jda) {
        Runtime runtime = Runtime.getRuntime();
        long memoryUsed = runtime.totalMemory() - runtime.freeMemory();
        String memoryUsage = bytesToFriendly(memoryUsed / 1024) + "/" + bytesToFriendly(runtime.totalMemory() / 1024);

        return new EmbedBuilder()
                .setTitle("emma - bot made for fun that works yes")
                .addField("Author", "<@!721382139060551802>", true)
                .addField("Library", "[JDA " + JDAInfo.VERSION + "](" + JDAInfo.GITHUB + ")", true)
                // Convert the time difference into a time ago
                .addField("Uptime", DateTime.timeAgo(Instant.now().toEpochMilli() - startTime.toEpochMilli()), true)
                // Get the server count. NOT GUILD NOT GUILD NOT GUILD
                .addField("Servers", String.valueOf(jda.getGuildCache().size()), true)
                // Memory usage
                .addField("Memory", memoryUsage, true)
                .setColor(0xd084)
                .build();
    }
}