package me.kambing;

import me.kambing.events.DefaultRole;
import me.kambing.events.FilterEvent;
import me.kambing.events.CommandManager;
import me.kambing.events.FilterToggler;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    public static final Main INSTANCE;
    private JDA jda;
    private static final String TOKEN = "ODc0MTQ4NTQ0ODY3NjE4ODQ4.YRCwRQ.17Oo3BdIaaRLPoF9ID9nfKb1EFs";
    public static final Logger LOGGER = LoggerFactory.getLogger("emma");
    public static final String prefix = ";";
    public static final String name = "emmaa";
    public static String activity = "watching";


    public static void main(String[] args) {
        start();
    }

    private static void start() {
        try {
            JDA jda = JDABuilder.createLight(TOKEN)
                    .addEventListeners(new CommandManager())
                    .setActivity(Activity.playing(INSTANCE.activity))
                    .build();

            jda.addEventListener(new FilterEvent());
            jda.addEventListener(new FilterToggler());
            jda.addEventListener(new DefaultRole());


        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }


    public JDA getJDA() {
        return jda;
    }
    static {
        INSTANCE = new Main();
    }
}
