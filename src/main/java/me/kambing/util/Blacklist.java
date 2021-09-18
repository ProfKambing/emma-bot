package me.kambing.util;

import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.entities.User;

import java.util.ArrayList;

public class Blacklist {
    public static Blacklist getClass = new Blacklist();
    public static ArrayList<String> retards = new ArrayList<>();

    public Boolean isRetard(CommandEvent event) {
        return retards.contains(event.getAuthor().getId());
    }
    public Boolean isRetard(User user) {
        return retards.contains(user.getId());
    }
}
