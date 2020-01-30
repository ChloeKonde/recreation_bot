import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.Locality;
import org.telegram.abilitybots.api.objects.Privacy;
import org.telegram.telegrambots.bots.DefaultBotOptions;

public class Bot extends AbilityBot {
    private static String BOT_TOKEN = "912658745:AAEvvAGV-L5ajB_wkAW74eZq52K7rPtZSSM";
    private static String BOT_NAME = "recreation_nsu_bot";

    protected Bot(DefaultBotOptions botOptions){
        super(BOT_TOKEN, BOT_NAME, botOptions);
    }

    @Override
    public int creatorId() {
        return 0;
    }

    public Ability sayHelloWorld() {
        return Ability.builder().name("hello").info("Says hello").locality(Locality.ALL).privacy(Privacy.PUBLIC)
                .action(ctx -> silent.send("Hello, world", ctx.chatId())).build();
    }
}
