package de.muv1n.muvbot;

import de.muv1n.muvbot.commands.ProposalsMessageCommand;
import de.muv1n.muvbot.commands.RuleCommand;
import de.muv1n.muvbot.commands.SocialCommand;
import de.muv1n.muvbot.commands.SupportMessageCommand;
import de.muv1n.muvbot.events.MemberGuildJoin;
import de.muv1n.muvbot.events.MessageReactEvent;
import de.muv1n.muvbot.util.Token;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import javax.security.auth.login.LoginException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BotMain {
    public static JDABuilder builder;
    public static JDA shardMan;

    public BotMain() throws LoginException, IOException {

        //TODO: TWITCH INTEGRATION (TWITCH4J)
        //TODO: YOUTUBE INTEGRATION (EASY-YOUTUBE)

        //TODO: MORE COMMANDS
        //TODO: HELP COMMAND

        builder = JDABuilder.createDefault(Token.getToken());
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS);
        builder.enableIntents(GatewayIntent.GUILD_MESSAGE_REACTIONS, GatewayIntent.GUILD_MESSAGE_TYPING, GatewayIntent.GUILD_MESSAGES);
        builder.setMemberCachePolicy(MemberCachePolicy.ALL);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.streaming("Schau MuV1N beim Zocken oder Programmieren auf Twitch zu", "https://twitch.tv/muv1n"));
        builder.addEventListeners(new MessageReactEvent(), new MemberGuildJoin(), new SupportMessageCommand(), new ProposalsMessageCommand(), new RuleCommand(), new SocialCommand());
        shardMan = builder.build();
        System.out.println("[Bot] Online");
        stop();
    }

    public static void main(String[] args) {
        try{
            BotMain bot = new BotMain();
        }catch (LoginException | IOException e){
            e.printStackTrace();
        }
    }


    public static void stop() throws IOException, LoginException {
        while (true){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            if (reader.readLine().equals("stop")){
                builder.setStatus(OnlineStatus.OFFLINE);
                reader.close();
                shardMan.shutdown();
                System.out.println("[BOT] Offline!");
                System.exit(0);
            }
        }
    }

    public static JDA getShardMan() {
        return shardMan;
    }
}
