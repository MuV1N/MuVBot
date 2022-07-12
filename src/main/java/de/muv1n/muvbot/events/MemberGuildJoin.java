package de.muv1n.muvbot.events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Category;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Objects;
import java.util.Random;

public class MemberGuildJoin extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent e) {
        Random i = new Random();
        int upperbound = 13;
        int random = i.nextInt(upperbound);
        Color[] colors = {Color.GREEN, Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.LIGHT_GRAY, Color.GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK,
        Color.RED, Color.WHITE, Color.YELLOW};
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(colors[random]);
        eb.setDescription(":wave: " + e.getMember().getAsMention() + "ist erfolgreich auf diesem Discord gelanded:partying_face:!");
        eb.setThumbnail(e.getUser().getEffectiveAvatarUrl());
        eb.setTitle(":heart:-Wilkommen :wave:");
        eb.addField("Du bist der " + e.getGuild().getMemberCount() + " :technologist: Nutzer auf diesem server!", "",false);
        Role verifizieren = e.getGuild().getRoleById("995772937330233374");
        int memberCount = e.getGuild().getMemberCount();
        e.getGuild().addRoleToMember(Objects.requireNonNull(e.getMember()), verifizieren).queue();
        Objects.requireNonNull(e.getGuild().getTextChannelById("993818825374040105")).sendMessageEmbeds(eb.build()).queue();
        Objects.requireNonNull(e.getGuild().getVoiceChannelById("995775427631120495")).getManager().setName("Midglieder: " + memberCount).queue();


    }

}
