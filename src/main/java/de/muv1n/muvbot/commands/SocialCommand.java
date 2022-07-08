package de.muv1n.muvbot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.emoji.CustomEmoji;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.emoji.GenericEmojiEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class SocialCommand extends ListenerAdapter{

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent e) {
        if (e.getMessage().getContentStripped().toLowerCase().startsWith("!social")){
            if (e.getMessage().getContentStripped().equalsIgnoreCase("!social")){
                e.getMessage().replyEmbeds(noSocialLinked().build()).queue();
            }
            if (e.getMessage().getContentStripped().toLowerCase().startsWith("!social youtube")){
                e.getMessage().replyEmbeds(youtubeEmbed().build()).queue();
            }
            if (e.getMessage().getContentStripped().startsWith("!social twitch")){
                e.getMessage().replyEmbeds(twitchEmbed().build()).queue();
            }
        }

    }
    private EmbedBuilder youtubeEmbed(){

        EmbedBuilder eb = new EmbedBuilder();

        eb.setTitle("Social Media :mobile_phone:");
        eb.addField("Link:", "http://youtube.muv1n.de", false);
        eb.setColor(Color.RED);

        return eb;
    }
    private EmbedBuilder twitchEmbed(){

        EmbedBuilder eb = new EmbedBuilder();

        eb.setTitle("Social Media :mobile_phone:");
        eb.addField("Link:", "http://muv1n.de", false);
        eb.setColor(Color.MAGENTA);

        return eb;
    }
    private EmbedBuilder noSocialLinked(){

        EmbedBuilder eb = new EmbedBuilder();

        eb.setTitle("Social Media :mobile_phone:");
        eb.addField("Benutzung:", "", false);
        eb.addField("Twitch:", "!social twitch", false);
        eb.addField("Youtube:", "!social youtube", false);
        eb.setColor(Color.BLACK);

        return eb;
    }

    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {
        System.out.println("Emoji: " + event.getEmoji());
    }
}
