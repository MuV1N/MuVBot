package de.muv1n.muvbot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class SupportMessageCommand extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        TextChannel s = e.getGuild().getTextChannelById("994702317817450516");
        if (e.getGuild().getMember(e.getMember()).getRoles().contains(e.getGuild().getRoleById("993823735129841724")) || e.getGuild().getMember(e.getMember()).getRoles().contains(e.getGuild().getRoleById("994208124972048485"))){
            if (e.getChannel() == s) {
                if (e.getMessage().getContentStripped().equalsIgnoreCase("!s")) {
                    e.getChannel().sendMessageEmbeds(support().build()).queue();

                    //TODO: MESSAGE REACTION AFTER SENDING

                    e.getMessage().delete().queue();
                }
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
}
