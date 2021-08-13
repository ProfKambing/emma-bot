package me.kambing.commands.owner;


import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import me.kambing.Main;


public class NickCommand extends Command {
    public NickCommand() {
        this.name = "nick";
        this.help = "nick the bot (only for kambing)";
        this.cooldown = 5;
        this.aliases = new String[]{"nickname"};
    }

    @Override
    protected void execute(CommandEvent event) {
        try {
            var nick = event.getMessage().getContentRaw().split(Main.prefix +  "nick");

            if (event.getMessage().getAuthor().getId().equals("721382139060551802")) {
                event.getMessage().reply("ok daddy changing nickname to" + nick[1]).queue();
                event.getGuild().modifyNickname(event.getGuild().getMemberById("874148544867618848"), nick[1]).queue();
            } else {
                event.getMessage().reply("only daddy can change my name").queue();
            }
        }catch (Exception e) {
            System.out.println(e);

        }
    }
}


