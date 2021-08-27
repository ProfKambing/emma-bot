package me.kambing.commands;


import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import me.kambing.Main;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;


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
            User ping = event.getMessage().getMentionedMembers().get(0).getUser();
            event.getMessage().reply(ping.getAvatarUrl() + "?size=256").queue();
        } catch (IndexOutOfBoundsException exception) {
                    event.getMessage().reply(event.getMessage().getAuthor().getAvatarUrl() + "?size=256").queue();
            }
        }
    }