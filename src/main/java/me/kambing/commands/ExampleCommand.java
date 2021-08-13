package me.kambing.commands;


import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;


//example for my dumbass
public class ExampleCommand extends Command {
    public ExampleCommand() {
        this.name = "example";
        this.help = "example";
        this.cooldown = 5;
        this.aliases = new String[]{"test"};
    }

    @Override
    protected void execute(CommandEvent event) {

    }
}

