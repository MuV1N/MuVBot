package de.muv1n.muvbot.events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Category;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Objects;

public class MessageReactEvent extends ListenerAdapter {
    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent e) {
        TextChannel rules = e.getGuild().getTextChannelById("993820985704853604");
        TextChannel support = e.getGuild().getTextChannelById("994702317817450516");
        TextChannel vorschläge = e.getGuild().getTextChannelById("993822029860048957");
        Category ticketCategory = e.getGuild().getCategoryById("994722238748184618");
        if (e.getChannel() == rules) {
            Role community = e.getGuild().getRoleById("993824547289702401");
            if (e.getMember().getRoles().contains(community)) {
                return;
            }
            e.getGuild().addRoleToMember(Objects.requireNonNull(e.getMember()), community).queue();
            e.getGuild().getTextChannelById("994251439704645682").sendMessage(e.getMember().getAsMention() + " hat sich erfolgreich die Regeln Duechgelesen!:white_check_mark:").queue();
        }

        //TODO: SUPPORT AND PROPOSALS
        //TODO: AUTO CHANNEL CREATING
        //TODO: LEARN MYSQL FOR NAMES

        if (e.getChannel() == support && e.getEmoji().equals(Emoji.fromUnicode("U+1f3ab"))){
            e.getGuild().createTextChannel(Objects.requireNonNull(e.getGuild().getJDA().getUserById(e.getUserIdLong())).getName() + "-Support", ticketCategory).queue();
            if (!e.getUserId().equals("943541805218156624")) {
                String sc = e.getGuildChannel().getName();
                //sc.sendMessageEmbeds(supportChannelEmbed().build()).queue();
            }else{
                return;
            }
        }
    }
    private EmbedBuilder supportChannelEmbed(){
        EmbedBuilder e = new EmbedBuilder();
        e.setColor(Color.RED);
        e.addField("Wenn du ihr fertig seit, dann Reagiere mit :lock: auf diese Nachricht", "", true);
        return e;
    }

    @Override
    public void onMessageReactionRemove(MessageReactionRemoveEvent e) {
        TextChannel rules = e.getGuild().getTextChannelById("993820985704853604");
        Role community = e.getGuild().getRoleById("993824547289702401");
        if (e.getChannel() == rules) {
            if (e.getGuild().getJDA().getUserById(e.getUserIdLong()).getJDA().getRoles().contains(community)) {
                e.getGuild().removeRoleFromMember(Objects.requireNonNull(e.getGuild().getMemberById(e.getUserIdLong())), community).queue();
            } else {
                return;
            }
        }
    }
}
