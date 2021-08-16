package me.kambing.util;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

// made by kambing on 16/8/21

public class EmbedUtil {

    public void createEmbed(EmbedBuilder eb, String title, String desc, Color color) {
        eb.setTitle(title);
        eb.setColor(color);
        eb.setDescription(desc);
    }
    public void createEmbed(EmbedBuilder eb, String title, String desc, String imgurl, Color color) {
        eb.setTitle(title);
        eb.setColor(color);
        eb.setDescription(desc);
        eb.setImage(imgurl);
    }
}
