package de.muv1n.muvbot.messgaes;

import lombok.Getter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;

public class MessageRule {
    @Getter
    public static MessageRule instance;

    public MessageRule(){
        instance = this;
    }
    public void ruleMessage(TextChannel textChannel){

        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle(":red_circle: Regeln :red_circle:");
        eb.setColor(Color.RED);
        eb.setDescription("Das Verstoßen der Regeln wird beim ersten verstoß mit einem Timeout, der länge von einem Tag, Bestraft und beim erneuten verstoßen wird man mit einem höheren Timeout bestraft, wenn man zu häufig verstößt, wird man Permanent vom Discord Server Gebannt!");
        eb.addField("§1: Sei Nett und Freundlich zu jedem.", "", false);
        eb.addField("§2: Beleidige niemanden.", "", false);
        eb.addField("§3: Pinge keine Teammitglieder. Hierbei variiert die Strafe je nach ermessen des Teammitglied welches gepinngt wurde ausgewählt!", "", false);
        eb.addField("§4: Wenn Probleme bestehen klärt diese bitte untereinander, sodass keine Teammitglieder benötigt werden um euch zu helfen.", "", false);

        textChannel.sendMessageEmbeds(eb.build()).queue();

    }
}
