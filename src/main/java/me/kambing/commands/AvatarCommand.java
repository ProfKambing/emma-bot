package me.kambing.commands;


import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import me.kambing.Main;


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
            event.getMessage().reply(ping.getAvatarUrl() + "?size=256").queue();
        } catch (IndexOutOfBoundsException exception) {
            try {
                var id = event.getMessage().getContentRaw().split(Main.prefix + "pfp ");
                if (id[1].length() == 18) {
                    event.getMessage().reply(event.getGuild().getMemberById(id[1]).getUser().getAvatarUrl() + "?size=256").queue();
                } else {
                    event.getMessage().reply(event.getMessage().getAuthor().getAvatarUrl() + "?size=256").queue();
                }
            }catch (NullPointerException e) {
                event.getMessage().reply("User is not on my cache/Not found.").queue();
            }
        }
    }
}

