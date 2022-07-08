package de.muv1n.muvbot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class RuleCommand extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent e) {
        TextChannel channel = e.getGuild().getTextChannelById(993820985704853604L);
        if (e.getMessage().getContentStripped().startsWith("!rules") && e.getChannel() == channel) {
            e.getMessage().delete().queue();
            e.getChannel().sendMessageEmbeds(rules().build()).queue();
        }
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
