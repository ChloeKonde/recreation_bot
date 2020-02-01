import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

public class Bot extends AbilityBot {

    protected Bot(String botToken, String botName) {
        super(botToken, botName);
    }

    protected Bot(String botToken, String botName, DefaultBotOptions botOptions) {
        super(botToken, botName, botOptions);
    }

    @Override
    public int creatorId() {
        return 0;
    }

    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        sendMsg(update.getMessage().getChatId(), message);
    }

    public synchronized void sendMsg(long chatId, String receivedMessage) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        StringBuffer path = new StringBuffer();
        path.append("C:\\My Documents\\Web\\Recreation\\");
        switch (receivedMessage) {
            case "/start":
                sendMessage.setText("Choose your floor");
                sendMessage.setReplyMarkup(KeyboardFactory.keyboard());
                break;
            case "3 floor":
                sendPht(path.append("3.jpg"), chatId);
                break;
            case "4 floor":
                sendPht(path.append("2.jpg"), chatId);
                break;
        }

        try {
            sender.execute(sendMessage);
        } catch (TelegramApiException e) {
            System.err.println("Exception" + e.toString());
        }
    }

    public void sendPht(StringBuffer path, Long chatId) {
        File file = new File(String.valueOf(path));
        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(file);

        try {
            sender.sendPhoto(photo);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
