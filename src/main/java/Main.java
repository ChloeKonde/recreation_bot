import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class Main {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        String botToken = "1071478348:AAFgZHE-x_cUz9fc2WTvwtv2HNhZzTURr4o";
        String botName = "lolkek_cheburek_bot";

        DefaultBotOptions botOptions = new DefaultBotOptions();
        botOptions.setProxyHost("5.9.198.243");
        botOptions.setProxyPort(1080);
        botOptions.setProxyType(DefaultBotOptions.ProxyType.SOCKS5);
        try {
            telegramBotsApi.registerBot(new Bot(botToken, botName, botOptions));
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}
