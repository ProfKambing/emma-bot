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
            if (urmom(event)[1].equals("add ")) {
                if (Blacklist.getClass.isRetard(retard)) {
                    event.getMessage().reply("User is already a retard").queue();
                } else {
                    Blacklist.retards.add(retard.getId());
                    event.getMessage().reply("User " + retard.getAsMention() + " has been blacklisted").queue();
                }
            }else if (urmom(event)[1].equals("del ")){
                if (Blacklist.getClass.isRetard(retard)) {
                    Blacklist.retards.remove(retard.getId());
                    event.getMessage().reply("User removed from retards list.");
                }
            }

        }catch (Exception e) {

        }

    }

    private String[] urmom(CommandEvent event) {
        String[] split = event.getMessage().getContentRaw().split(" ");
        if (split[0].equals(";b")) {
            return event.getMessage().getContentRaw().split(";b ");
        }
    return event.getMessage().getContentRaw().split(";blacklist ");}
}
