package de.muv1n.muvbot;

import de.muv1n.muvbot.events.MemberGuildJoin;
import de.muv1n.muvbot.events.MessageReactEvent;
import de.muv1n.muvbot.events.MessageRecive;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import javax.security.auth.login.LoginException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BotMain {

    public static JDABuilder builder;
    public static JDA shardMan;
    public static User user;

    public BotMain() throws LoginException, IOException {

        //TODO: TWITCH INTEGRATION (TWITCH4J)
        //TODO: YOUTUBE INTEGRATION (EASY-YOUTUBE)
        //TODO: EXPORT TO AN JAR FILE

        Dotenv config;
        config = Dotenv.configure().load();
        builder = JDABuilder.createDefault(config.get("TOKEN"));
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS);
        builder.enableIntents(GatewayIntent.GUILD_MESSAGE_REACTIONS, GatewayIntent.GUILD_MESSAGE_TYPING, GatewayIntent.GUILD_MESSAGES);
        builder.setMemberCachePolicy(MemberCachePolicy.ALL);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.addEventListeners(new MessageReactEvent());
        builder.addEventListeners(new MemberGuildJoin());
        builder.addEventListeners(new MessageRecive());
        shardMan = builder.build();
        stop();
    }

    public static void main(String[] args) {
        try{
            BotMain bot = new BotMain();
        }catch (LoginException | IOException e){
            e.printStackTrace();
        }
    }


    public static void stop() throws IOException {
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
