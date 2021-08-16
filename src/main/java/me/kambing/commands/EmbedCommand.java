package me.kambing.commands;


import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

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
        try {
            var message = event.getMessage().getContentRaw().split(",");

            event.getChannel().sendMessageEmbeds(new EmbedBuilder().setTitle(message[1]).setDescription(message[2]).setColor(message[3] == null ? event.getSelfMember().getColor() : new Color(Integer.parseInt(message[2]))).build()).queue();

        }catch (IndexOutOfBoundsException e) {
            event.getMessage().replyEmbeds(new EmbedBuilder().setTitle("Incorrect Format!").setDescription("Format:\n;embed ,<title>,<description>,<hexcolor>\nyou doesnt need to space between the ,").setColor(Color.CYAN).build()).queue();
        }
    }
}



