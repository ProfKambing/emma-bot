package me.kambing;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import com.jagrosh.jdautilities.examples.command.*;
import java.io.IOException;
import javax.security.auth.login.LoginException;

import me.kambing.commands.*;
import me.kambing.commands.owner.NickCommand;
import me.kambing.commands.owner.TrampolineCommand;
import me.kambing.events.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.exceptions.RateLimitedException;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    public static final Logger LOGGER = LoggerFactory.getLogger("emma");
    private static JDA jda;
    public static final String prefix = ";";
    public static final String name = "emma";

    public static void main(String[] args) throws IOException, LoginException, IllegalArgumentException, RateLimitedException {


        String token = "ODc0MTQ4NTQ0ODY3NjE4ODQ4.YRCwRQ.17Oo3BdIaaRLPoF9ID9nfKb1EFs";
        String ownerId = "721382139060551802";


        EventWaiter waiter = new EventWaiter();
        CommandClientBuilder client = new CommandClientBuilder();
        client.useDefaultGame();
        client.setOwnerId(ownerId);
        client.setActivity(Activity.playing("with kambing"));
        client.setStatus(OnlineStatus.DO_NOT_DISTURB);
        client.setEmojis("\u2705", "\u26A0", "\uD83D\uDEAB");
        client.setPrefix(";");
        client.addCommands( //register all da commands
                new PingCommand(),
                new ShutdownCommand(),
                new CatCommand(),
                new SpamCommand(),
                new BanCommand(),
                new MuteCommand(),
                new UnmuteCommand(),
                new DmCommand(),
                new HaramCommand(),
                new NickCommand(),
                new TrampolineCommand(),
                new ShipCommand(),
                new ServerPFPCommand(),
                new AvatarCommand(),
                new HackCommand(),
                new CatgirlCommand(),
                new LewdNekoCommand(),
                new PurgeCommand(),
                new KissCommand(),
                new HugCommand(),
                new ServerInfoCommand(),
                new EmbedCommand(),
                new SayCommand(waiter));


        JDABuilder.createDefault(token)
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .setActivity(Activity.playing("playing with kambing"))
                .addEventListeners(new SlashCommand(), new Raden(), new Troll(), new TrollToggler(), new FilterEvent(), new FilterToggler(), waiter, client.build())

                .build();
        try {


            jda.awaitReady().upsertCommand("say", "make me say something").queue();

        }catch (InterruptedException e) {
            //empty catch block go brrrrrr LOL
        }
    }
}