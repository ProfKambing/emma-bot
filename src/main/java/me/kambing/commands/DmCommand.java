package me.kambing.commands;


import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import me.kambing.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.exceptions.ErrorHandler;
import net.dv8tion.jda.api.requests.ErrorResponse;

import java.awt.*;


public class DmCommand extends Command {
    public DmCommand() {
        this.name = "dm";
        this.help = "dm someone";
        this.cooldown = 30;
    }

    @Override
    protected void execute(CommandEvent event) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.CYAN);

        Message message = event.getMessage();
        try {

            User memberToDm = message.getMentionedUsers().get(0);
            String[] s = message.getContentRaw().split(Main.prefix + "dm");
            eb.setAuthor(message.getAuthor().getName(), message.getAuthor().getAvatarUrl(), message.getAuthor().getAvatarUrl());
            eb.setTitle("You received a dm from " + message.getAuthor().getAsTag() + "!");
            eb.setDescription(s[1]);
            eb.setFooter("bot made by kambing#8597","https://cdn.discordapp.com/avatars/721382139060551802/3205930f9af4c952b6b10019fd752e3b.png?size=1024" );
            memberToDm.openPrivateChannel()
                    .flatMap(privateChannel -> privateChannel.sendMessage(eb.build()))
                    .queue(
                            null, new ErrorHandler().ignore(ErrorResponse.UNKNOWN_MESSAGE)
                                    .handle(ErrorResponse.CANNOT_SEND_TO_USER,  (e) -> message.reply("Unable to dm.").queue()));

            message.reply("Sending dm!").queue();

        }catch (IndexOutOfBoundsException exception) {
            message.reply("Incorrect format dumass wheres the user retarded ass nig").queue();
        }
    }
}

