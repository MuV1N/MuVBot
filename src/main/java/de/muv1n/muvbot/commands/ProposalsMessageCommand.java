package de.muv1n.muvbot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class ProposalsMessageCommand extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent e) {
        TextChannel v = e.getGuild().getTextChannelById("993822029860048957");
        String[] m = e.getMessage().getContentStripped().split(" ");

        if (e.getChannel() == v) {
            if (e.getMessage().getContentStripped().equalsIgnoreCase("!v")) {
                e.getChannel().sendMessageEmbeds(proposals().build()).queue();
                //e.getChannel().addReactionById(e.getChannel().getLatestMessageId(), Emoji.fromUnicode("U+1f3ab")).queue();
                e.getMessage().delete().queue();
            }
        }
    }
    private EmbedBuilder proposals(){
        EmbedBuilder eb = new EmbedBuilder();
        eb.addField(":ticket:Vorschläge Ticket:ticket:", "", false);
        eb.addField("Reagiere auf diese Nachricht mit :ticket:, um dein Raum für deinen Vorschlag zu erstellen es wird sich von Teamitgliedern aufgeschrieben und bei der nächsten besprechung aufgenommen und umgesetzt oder auch nicht!", "", false);
        eb.addField("Vielen Dank im Voraus! :heart:", "", false);
        eb.setColor(Color.CYAN);
        return eb;
    }

}
