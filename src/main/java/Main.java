import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class Main {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        String botToken = "912658745:AAEvvAGV-L5ajB_wkAW74eZq52K7rPtZSSM";
        String botName = "recreation_nsu_bot";

//        DefaultBotOptions botOptions = ApiContext.getInstance(DefaultBotOptions.class);
//        botOptions.setProxyHost("198.27.75.152");
//        botOptions.setProxyPort(1080);
//        botOptions.setProxyType(DefaultBotOptions.ProxyType.SOCKS5);
        try {
            telegramBotsApi.registerBot(new Bot(botToken, botName));
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}
