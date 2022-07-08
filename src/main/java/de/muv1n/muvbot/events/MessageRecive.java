package de.muv1n.muvbot.events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionComponent;
import net.dv8tion.jda.api.interactions.components.Component;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class MessageRecive extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent e) {
        TextChannel channel = e.getGuild().getTextChannelById(993820985704853604L);
        if (e.getMessage().getContentStripped().startsWith("!rules") && e.getChannel() == channel) {
            e.getMessage().delete().queue();
            //e.getChannel().sendMessageEmbeds(rules().build()).queue();
        }
        TextChannel s = e.getGuild().getTextChannelById("994702317817450516");
        TextChannel v = e.getGuild().getTextChannelById("993822029860048957");
        String[] m = e.getMessage().getContentStripped().split(" ");
        if (e.getChannel() == s) {
                if (e.getMessage().getContentStripped().startsWith("!s")) {
                    e.getChannel().sendMessageEmbeds(support().build()).queueAfter(3, TimeUnit.SECONDS);

                    //TODO: MESSAGE REACTION AFTER SENDING

                    e.getMessage().delete().queue();
                }
            }
        if (e.getChannel() == v) {
                    if (e.getMessage().getContentStripped().startsWith("!v")) {
                    e.getChannel().sendMessageEmbeds(vorschläge().build()).queue();
                    e.getChannel().addReactionById(e.getChannel().getLatestMessageId(), Emoji.fromUnicode("U+1f3ab"));
                    e.getMessage().delete().queue();
            }
        }
    }
    private EmbedBuilder support(){
        EmbedBuilder eb = new EmbedBuilder();
        eb.addField(":ticket:Support Ticket:ticket:", "", false);
        eb.addField("Reagiere auf diese Nachricht mit :ticket:, um dein Support Raum zu öffnen, dir wird schnellstmöglich ein Teammitglied helfen!", "", false);
        eb.setColor(Color.CYAN);
        return eb;
    }
    private EmbedBuilder vorschläge(){
        EmbedBuilder eb = new EmbedBuilder();
        eb.addField(":ticket:Vorschläge Ticket:ticket:", "", false);
        eb.addField("Reagiere auf diese Nachricht mit :ticket:, um dein Raum für deinen Vorschlag zu erstellen es wird sich von Teamitgliedern aufgeschrieben und bei der nächsten besprechung aufgenommen und umgesetzt oder auch nicht!", "", false);
        eb.addField("Vielen Dank im Voraus! :heart:", "", false);
        eb.setColor(Color.CYAN);
        return eb;
    }
    private EmbedBuilder rules(){
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle(":red_circle: Regeln :red_circle:");
        eb.setColor(Color.RED);
        eb.setDescription("Das Verstoßen der Regeln wird beim ersten verstoß mit einem Timeout, der länge von einem Tag, Bestraft und beim erneuten verstoßen wird man mit einem höheren Timeout bestraft, wenn man zu häufig verstößt, wird man Permanent vom Discord Server Gebannt!");
        eb.addField("§1: Sei Nett und Freundlich zu jedem.", "", false);
        eb.addField("§2: Beleidige niemanden.", "", false);
        eb.addField("§3: Pinge keine Teammitglieder. Hierbei variiert die Strafe je nach ermessen des Teammitglied welches gepinngt wurde ausgewählt!", "", false);
        eb.addField("§4: Wenn Probleme bestehen klärt diese bitte untereinander, sodass keine Teammitglieder benötigt werden um euch zu helfen.", "", false);
        return eb;
    }
}
