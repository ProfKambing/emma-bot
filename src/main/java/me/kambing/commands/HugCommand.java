package me.kambing.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Color;
import java.time.Duration;

import me.kambing.Main;
import me.kambing.util.Blacklist;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.ChannelType;


public class HugCommand extends Command {
    public HugCommand() {
        this.name = "hug";
        this.help = "shows random anime hugging";
        this.botPermissions = new Permission[]{Permission.MESSAGE_EMBED_LINKS};
        this.cooldown = 2;
    }

    @Override
    protected void execute(CommandEvent event) {
        if (Blacklist.getClass.isRetard(event))
            return;
        String[] items = event.getArgs().split("\\s+");
        try {
            Unirest.get("https://nekos.life/api/v2/img/hug").asJsonAsync(new Callback<JsonNode>() {

                // The API call was successful
                @Override
                public void completed(HttpResponse<JsonNode> hr) {
                    event.reply(new EmbedBuilder()
                            .setTitle(event.getAuthor().getName() + " hugs " + event.getMessage().getMentionedMembers().get(0).getUser().getName())
                            .setColor(event.isFromType(ChannelType.TEXT) ? event.getSelfMember().getColor() : Color.GREEN)
                            .setImage(hr.getBody().getObject().getString("url"))
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

        } catch (IndexOutOfBoundsException exception) {
            if (items[1].isEmpty()) {
                event.getMessage().reply("Who are you hugging?").queue();
            }else{
                Unirest.get("https://nekos.life/api/v2/img/hug").asJsonAsync(new Callback<JsonNode>() {

                    // The API call was successful
                    @Override
                    public void completed(HttpResponse<JsonNode> hr) {
                        event.reply(new EmbedBuilder()
                                .setTitle(event.getAuthor().getName() + " hugs " + items[1])
                                .setColor(event.isFromType(ChannelType.TEXT) ? event.getSelfMember().getColor() : Color.GREEN)
                                .setImage(hr.getBody().getObject().getString("url"))
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

            }
        }
    }
}