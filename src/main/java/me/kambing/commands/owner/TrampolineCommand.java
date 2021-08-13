package me.kambing.commands.owner;


import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import me.kambing.Main;


public class TrampolineCommand extends Command {
    public TrampolineCommand() {
        this.name = "trampoline";
        this.help = "emma loves trampolining";
        this.cooldown = 5;
        this.aliases = new String[]{"tram"};
    }

    @Override
    protected void execute(CommandEvent event) {
        if (event.getMessage().getAuthor().getId().equals("721382139060551802")) {
            event.getMessage().reply("https://tenor.com/view/anime-trampoline-blush-jump-gif-17601451").queue();
        }else{
            event.getMessage().reply("fuck off").queue();
        }
    }
}


