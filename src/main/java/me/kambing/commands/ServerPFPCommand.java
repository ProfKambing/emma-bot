package me.kambing.commands;


import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import me.kambing.util.Blacklist;


public class ServerPFPCommand extends Command {
    public ServerPFPCommand() {
        this.name = "serverpfp";
        this.help = "serverpfp";
        this.cooldown = 5;
        this.aliases = new String[]{"pfpserver"};
    }

    @Override
    protected void execute(CommandEvent event) {
        if (Blacklist.getClass.isRetard(event))
            return;
        try {
            event.getMessage().reply(event.getGuild().getIconUrl() + "?size=256").queue();
        } catch (Exception e) {
            event.getMessage().reply("masalah sial discord ni").queue();
        }
    }
}

