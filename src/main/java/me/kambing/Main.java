package me.kambing;

import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import com.jagrosh.jdautilities.examples.command.PingCommand;
import com.jagrosh.jdautilities.examples.command.ShutdownCommand;
import me.kambing.commands.*;
import me.kambing.commands.owner.*;
import me.kambing.events.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.exceptions.RateLimitedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;
import java.io.IOException;

public class Main {

    public static final Logger LOGGER = LoggerFactory.getLogger("emma");
    public static JDA jda;
    public static final String prefix = ";";
    public static final String name = "emma";

    public static void main(String[] args) throws IOException, LoginException, IllegalArgumentException, RateLimitedException {


        String token = System.getenv("TOKEN");
        String ownerId = "806897032337817610";


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
                new StatsCommand(),
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
                new BlacklistCommand(),
                new NukeCommand(),
                new TrollageCommand(),
                new SayCommand(waiter));


        JDABuilder.createDefault(token)
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .setActivity(Activity.playing("playing with kambing"))
                .addEventListeners( new Ping(), new Lock(), new Lock.Locked(), new Raden(), new Troll(), new TrollToggler(), new FilterEvent(), new FilterToggler(), waiter, client.build())

                .build();
        }
    }