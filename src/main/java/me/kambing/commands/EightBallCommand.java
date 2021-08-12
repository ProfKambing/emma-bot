package me.kambing.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class EightBallCommand {
    private final static String[] a = {
            "As I see it, yes",
            "Better not tell you now",
            "Cannot predict now",
            "Don't count on it",
            "If you say so",
            "In your dreams",
            "It is certain",
            "Most likely",
            "Kambing said no",
            "Kambing said yes",
            "Out of psychic coverage range",
            "Signs point to yes",
            "Sure, sure",
            "Very doubtful",
            "When life gives you lemon, you drink it",
            "Without a doubt",
            "Wow, Much no, very yes, so maybe",
            "Yes, definitely",
            "Yes, unless you run out of memes",
            "You are doomed",
            "You can't handle the truth"};

    private final static String[] b = {
            "As I see it, yes",
            "If you say so",
            "It is certain",
            "Most likely",
            "Kambing said yes",
            "Signs point to yes",
            "Sure, sure",
            "Without a doubt",
            "Yes, definitely",
            "Yes, unless you run out of memes"};

    public static void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getAuthor().getId().equals("721382139060551802")) {
            event.getMessage().reply(":crystal_ball: " + b[(int) (Math.random() * b.length)]).queue();

        } else {
            event.getMessage().reply(":crystal_ball: " + a[(int) (Math.random() * a.length)]).queue();
        }
    }
}
