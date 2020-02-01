import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.*;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

public class Bot extends AbilityBot {

    protected Bot(String botToken, String botName) {
        super(botToken, botName);
    }

    protected Bot(String botToken, String botName, DefaultBotOptions botOptions){
        super(botToken, botName, botOptions);
    }

    @Override
    public int creatorId() {
        return 0;
    }

    public Ability replyToStart() {
        return Ability
                .builder()
                .name("start")
                .locality(Locality.ALL)
                .privacy(Privacy.PUBLIC)
                .action(ctx -> { ReplyKeyboard kb = KeyboardFactory.keyboard();
                    try {
                        sender.execute(new SendMessage()
                                .setChatId(ctx.chatId())
                                .setText("Choose your floor")
                                .setReplyMarkup(kb));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                })
                .build();
    }

    public Ability replyToThree() {
        return Ability
                .builder()
                .name("third")
                .locality(Locality.ALL)
                .privacy(Privacy.PUBLIC)
                .action(ctx -> {
                    String path = "C:\\My Documents\\Web\\Recreation\\3.jpg";
                    try {
                        sender.sendPhoto(addPhoto(path, ctx.chatId()));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                })
                .build();
    }

    public Ability replyToFour() {
        return Ability
                .builder()
                .name("fourth")
                .locality(Locality.ALL)
                .privacy(Privacy.PUBLIC)
                .action(ctx -> {
                    String path = "C:\\My Documents\\Web\\Recreation\\2.jpg";
                    try {
                        sender.sendPhoto(addPhoto(path, ctx.chatId()));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                })
                .build();
    }

    public SendPhoto addPhoto(String path, Long chatId) {
        File file = new File(path);
        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(file);
        return photo;
    }
}
