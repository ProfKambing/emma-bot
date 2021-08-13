package me.kambing.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;

import me.kambing.Main;


public class SayCommand extends Command
{
    private final EventWaiter waiter;
    public SayCommand(EventWaiter waiter)
    {
        this.waiter = waiter;
        this.name = "say";
        this.help = "say things";
    }

    @Override
    protected void execute(CommandEvent event) {
        var message = event.getMessage().getContentRaw().split(Main.prefix +  "say");
        event.getChannel().sendMessage(message[1]).queue();
    }

}