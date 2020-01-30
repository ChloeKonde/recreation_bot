import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.Locality;
import org.telegram.abilitybots.api.objects.Privacy;
import org.telegram.telegrambots.bots.DefaultBotOptions;

public class Bot extends AbilityBot {
    protected Bot(String botToken, String botName, DefaultBotOptions botOptions){
        super(botToken, botName, botOptions);
    }

    protected Bot(String botToken, String botName) {
        super(botToken, botName);
    }

    @Override
    public int creatorId() {
        return 0;
    }

    public Ability sayHelloWorld() {
        return Ability
                .builder()
                .name("hello")
                .info("Says hello")
                .locality(Locality.ALL)
                .privacy(Privacy.PUBLIC)
                .action(ctx -> silent.send("Hello, world", ctx.chatId()))
                .build();
    }
}
