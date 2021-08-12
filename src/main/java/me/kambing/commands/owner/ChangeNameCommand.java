package me.kambing.commands.owner;

import me.kambing.Main;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.RateLimitedException;


public class ChangeNameCommand {

    public static void onMessageReceived(MessageReceivedEvent event) {

        if (event.getMessage().getAuthor().getId().equals("721382139060551802")) {
            try {
                var message = event.getMessage().getContentRaw().split(Main.prefix + "name");
                event.getJDA().getSelfUser().getManager().setName(message[1]).complete(false);
                event.getMessage().reply(" Name changed from `" + event.getJDA().getSelfUser().getName() + "` to `" + message[1] + "`").queue();
            } catch (RateLimitedException e) {
                event.getMessage().reply("Name can only be changed twice per hour!").queue();
            } catch (Exception e) {
                event.getMessage().reply("That name is not valid!").queue();
            }
        }
    }
}
