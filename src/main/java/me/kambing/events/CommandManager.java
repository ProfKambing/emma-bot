package me.kambing.events;

import me.kambing.Main;
import me.kambing.commands.*;
import me.kambing.commands.owner.*;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;

public class CommandManager extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event) {
        Main.LOGGER.info(Main.LOGGER.getName() + " successfully started!");
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {


        if (event.getAuthor().isBot())
            return;

        if (event.getAuthor().getId().equals("823621414203686922"))
            return;

        if (event.getAuthor().getId().equals("659695378370658305"))
            return;

        if (event.getMessage().getContentRaw().startsWith(Main.prefix)) {
            var commandName = event.getMessage().getContentRaw().substring(1).toLowerCase();

            //register all commands

            if (commandName.startsWith("ping")) {
                PingCommand.onMessageReceived(event);

            } else if (commandName.startsWith("purge")) {
                PurgeCommand.onMessageReceived(event);

            } else if (commandName.startsWith("say")) {
                SayCommand.onMessageReceived(event);

            } else if (commandName.startsWith("ban")) {
                BanCommand.onMessageReceived(event);

            } else if (commandName.startsWith("hack")) {
                HackCommand.onMessageReceived(event);

            } else if (commandName.startsWith("help")) {
                HelpCommand.onMessageReceived(event);

            } else if (commandName.startsWith("spam")) {
                AutoPingCommand.onMessageReceived(event);

            } else if (commandName.startsWith("haram")) {
               HaramCommand.onMessageReceived(event);

            } else if (commandName.startsWith("dm")) {
                DmCommand.onMessageReceived(event);

            } else if (commandName.startsWith("name")) {
                ChangeNameCommand.onMessageReceived(event);

            } else if (commandName.startsWith("pfp") || commandName.startsWith("avatar")) {
                AvatarCommand.onMessageReceived(event);

            } else if (commandName.startsWith("serverpfp") || commandName.startsWith("pfpserver")) {
                ServerPFPCommand.onMessageReceived(event);

            } else if (commandName.startsWith("kitchen")) {
                KitchenCommand.onMessageReceived(event);

            } else if (commandName.startsWith("rolecolor")) {
                GetRolesCommand.onMessageReceived(event);

            } else if (commandName.startsWith("ship")) {
                ShipCommand.onMessageReceived(event);

            } else if (commandName.startsWith("8ball")) {
                EightBallCommand.onMessageReceived(event);

            } else if (commandName.startsWith("sex")) {
                Command.onMessageReceived(event);

            } else if (commandName.startsWith("nick")) {
                NickCommand.onMessageReceived(event);

            } else if (commandName.startsWith("serverinfo")) {
                ServerInfoCommand.onMessageReceived(event);

            } else if (commandName.startsWith("trampoline") || commandName.startsWith("tram")) {
                TrampolineCommand.onMessageReceived(event);


            }
        }
    }
}

