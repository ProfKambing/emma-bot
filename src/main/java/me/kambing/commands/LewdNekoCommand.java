package me.kambing.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Color;

import me.kambing.util.Blacklist;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.ChannelType;


public class LewdNekoCommand extends Command {
    public LewdNekoCommand() {
        this.name = "lewdcatgirl";
        this.help = "shows a random NSFW catgirl";
        this.botPermissions = new Permission[]{Permission.MESSAGE_EMBED_LINKS};
        this.guildOnly = false;
        this.aliases = new String[]{"lcg"};
    }

    @Override
    protected void execute(CommandEvent event) {
        if (Blacklist.getClass.isRetard(event))
            return;
        if (event.isFromType(ChannelType.PRIVATE) || event.getTextChannel().isNSFW()) {
            // use Unirest to poll an API
            Unirest.get("https://nekos.life/api/lewd/neko").asJsonAsync(new Callback<JsonNode>() {

                // The API call was successful
                @Override
                public void completed(HttpResponse<JsonNode> hr) {
                    event.reply(new EmbedBuilder()
                            .setColor(event.isFromType(ChannelType.TEXT) ? event.getSelfMember().getColor() : Color.GREEN)
                            .setImage(hr.getBody().getObject().getString("neko"))
                            .build());
                }

                // The API call failed
                @Override
                public void failed(UnirestException ue) {
                    event.reactError();
                }

                // The API call was cancelled (this should never happen)
                @Override
                public void cancelled() {
                    event.reactError();
                }
            });
        }else{
            event.getMessage().reply("This channel is not nsfw, you can also run this command in my dms :wink:").queue();
        }
    }
}
