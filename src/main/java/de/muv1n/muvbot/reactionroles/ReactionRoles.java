package de.muv1n.muvbot.reactionroles;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ReactionRoles extends ListenerAdapter {

    //TODO: Reaction Roles with Buttons


    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent e) {
        if (e.getName().equals("roles")){
            e.replyEmbeds(rolesMessage().build())
                    .addActionRow(
                            Button.primary("twitch", "TWITCH Benachrichtigungen"),
                            Button.success("twitchSuccess", Emoji.fromCustom("twitch", 995994506312822874L, false))
                    ).addActionRow(
                            Button.primary("youtube", "YOUTUBE Benachrichtigungen"),
                            Button.success("youtubeSuccess", Emoji.fromCustom("youtube", 995994887436648489L, false))
                    ).addActionRow(
                            Button.primary("news", "NEWS Benachrichtigungen"),
                            Button.success("newsSuccess", Emoji.fromUnicode("U+1F4F0"))
                    ).queue();
        }
    }
    public EmbedBuilder rolesMessage(){
        EmbedBuilder e = new EmbedBuilder();

        e.setTitle("Suche dir deine Rollen aus!");
        e.addField("Was bringen die Rollen?", "Die Rollen sind dafür da, dass du Benarichtigungen bekommst, wenn diese Rolle gepingt wird z.B. wenn MuV1N auf Twitch Live geht!", true);

        return e;
    }

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent e) {
        if (e.getComponentId().equals("twitch")){
            Role role = e.getGuild().getRoleById("995776478845350009");
            if (Objects.requireNonNull(e.getMember()).getRoles().contains(role)){
                e.getGuild().removeRoleFromMember(Objects.requireNonNull(e.getGuild().getMemberById(e.getUser().getId())), role).queue();
            }else{
                e.getGuild().addRoleToMember(e.getMember(), role).queue();
            }
        }else if (e.getComponentId().equals("youtube")){
            Role role = e.getGuild().getRoleById("995776551436157048");
            if (Objects.requireNonNull(e.getMember()).getRoles().contains(role)){
                e.getGuild().removeRoleFromMember(Objects.requireNonNull(e.getGuild().getMemberById(e.getUser().getId())), role).queue();
            }else{
                e.getGuild().addRoleToMember(e.getMember(), role).queue();
            }
    }else if (e.getComponentId().equals("news")){
            Role role = e.getGuild().getRoleById("995990868790091827");
            if (Objects.requireNonNull(e.getMember()).getRoles().contains(role)){
                e.getGuild().removeRoleFromMember(Objects.requireNonNull(e.getGuild().getMemberById(e.getUser().getId())), role).queue();
            }else{
                e.getGuild().addRoleToMember(e.getMember(), role).queue();
            }
        }
    }
}
