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

            event.getChannel().sendMessageEmbeds(new EmbedBuilder().setTitle(message[0]).setDescription(message[1]).setColor(message[2] == null ? event.getSelfMember().getColor() : new Color(Integer.parseInt(message[2]))).build()).queue();

        }catch (IndexOutOfBoundsException e) {
            event.reply(new EmbedBuilder().setTitle("Incorrect Format!").setDescription("Format:\n;embed <title>,<description>,<hexcolor(optional)>\nyou doesnt need to space between the \u0022,\u0022").setColor(Color.CYAN).build());
        }
    }
}



