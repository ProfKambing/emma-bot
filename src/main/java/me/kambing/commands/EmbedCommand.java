package me.kambing.commands;


import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import me.kambing.util.Blacklist;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;

import java.awt.*;


public class EmbedCommand extends Command {

    public EmbedCommand() {
        this.name = "embed";
        this.help = "creates embed message";
        this.cooldown = 5;
        this.aliases = new String[]{"eb"};
    }

    @Override
    protected void execute(CommandEvent event) {
        if (Blacklist.getClass.isRetard(event))
            return;
        try {
            String[] message = event.getMessage().getContentRaw().split(",");


            event.getMessage().delete().queue();
            event.getChannel().sendMessageEmbeds(new EmbedBuilder().setTitle(message[1]).setDescription(message[2]).setColor(message[3] == null ? event.getSelfMember().getColor() : Color.decode(message[3])).build()).queue();

        }catch (IndexOutOfBoundsException e) {
            event.getMessage().replyEmbeds(new EmbedBuilder().setTitle("Incorrect Format!").setDescription("Format:\n;embed ,<title>,<description>,<hexcolor>\nyou doesnt need to space between the ,").setColor(Color.CYAN).build()).queue();
        }
    }
}



