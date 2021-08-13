package me.kambing.commands;


import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;


public class AvatarCommand extends Command {
    public AvatarCommand() {
        this.name = "pfp";
        this.help = "profile picture";
        this.cooldown = 5;
        this.aliases = new String[]{"avatar"};
    }

    @Override
    protected void execute(CommandEvent event) {
        try {
            var ping = event.getMessage().getMentionedMembers().get(0).getUser();
            event.getMessage().reply(ping.getAvatarUrl()+ "?size=256").queue();
        }catch (IndexOutOfBoundsException exception) {
            event.getMessage().reply(event.getMessage().getAuthor().getAvatarUrl()+ "?size=256").queue();
        } catch (Exception e) {
            event.getMessage().reply("masalah sial discord ni").queue();
        }
    }
}

