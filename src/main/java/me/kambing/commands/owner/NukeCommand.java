package me.kambing.commands.owner;


import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;



public class NukeCommand extends Command {
    public NukeCommand() {
        this.name = "nuke";
        this.help = "kebaboom";
        this.cooldown = 5;
        this.ownerCommand = true;
        this.hidden = true;
    }

    @Override
    protected void execute(CommandEvent event) {
         //TODO
        }
    }



