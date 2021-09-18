package me.kambing.commands.owner;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import me.kambing.util.Blacklist;
import net.dv8tion.jda.api.entities.User;

public class BlacklistCommand extends Command {
    public BlacklistCommand() {
        this.name = "blacklist";
        this.help = "retards";
        this.hidden = true;
        this.ownerCommand = true;
        this.cooldown = 5;
        this.aliases = new String[]{"b"};
    }
    @Override
    protected void execute(CommandEvent event) {
        try {
            User retard = event.getMessage().getMentionedMembers().get(0).getUser();
                if (Blacklist.getClass.isRetard(retard)) {
                    Blacklist.retards.remove(retard.getId());
                    event.getMessage().reply("User blacklist removed").queue();
                } else {
                    Blacklist.retards.add(retard.getId());
                    event.getMessage().reply("User " + retard.getAsMention() + " has been blacklisted").queue();
                }

        }catch (Exception e) {
            event.getMessage().reply("" + e).queue();
        }

    }
}
