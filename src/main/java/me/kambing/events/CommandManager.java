package me.kambing.events;

import me.kambing.Main;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;

public class CommandManager extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event) {
        Main.LOGGER.info(Main.LOGGER.getName() + " successfully started!");
    }
}

