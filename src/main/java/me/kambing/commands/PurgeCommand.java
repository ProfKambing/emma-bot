package me.kambing.commands;


import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.exceptions.InsufficientPermissionException;
import net.dv8tion.jda.internal.utils.PermissionUtil;

import java.time.Duration;


public class PurgeCommand extends Command {
    public PurgeCommand() {
        this.name = "purge";
        this.help = "purge messages";
        this.cooldown = 5;
    }

    @Override
    protected void execute(CommandEvent event) {
            if (PermissionUtil.checkPermission(event.getMember(), Permission.MESSAGE_MANAGE, Permission.ADMINISTRATOR)) {
                var message = event.getMessage();
                var channel = event.getChannel();

                try {
                    var s = message.getContentRaw().split(" ");
                    var purgeAmount = s[1];

                    channel.purgeMessages(channel.getHistory().retrievePast(Integer.parseInt(purgeAmount)).complete());

                    channel.sendMessage("Purged " + s[1] + "messages").queue(message1 -> {
                        message1.delete().delay(Duration.ofSeconds(1)).queue(); // idk this looks cool ahahahjsgjsg
                    });


                } catch (ArrayIndexOutOfBoundsException exception) {
                    message.reply("Please specify a number of messages to purge!").queue();
                } catch (NumberFormatException exception) {
                    message.reply("Incorrect integer").queue();
                } catch (InsufficientPermissionException exception) {
                    message.reply("Not enough permissions!").queue();
                }
            }
        }
    }
