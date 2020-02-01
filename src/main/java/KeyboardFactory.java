import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class KeyboardFactory {
        public static ReplyKeyboard inlineKeyboard() {
            InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup();
            List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
            List<InlineKeyboardButton> rowInline = new ArrayList<>();
            rowInline.add(new InlineKeyboardButton().setText("3 floor").setCallbackData("third"));
            rowInline.add(new InlineKeyboardButton().setText("4 floor").setCallbackData("/fourth"));
            rowsInline.add(rowInline);
            inlineKeyboard.setKeyboard(rowsInline);
            return inlineKeyboard;
    }

    public static ReplyKeyboard keyboard() {
            ReplyKeyboardMarkup replyKeyboard = new ReplyKeyboardMarkup();
            List<KeyboardRow>  row = new ArrayList<>();
            KeyboardRow keyboardRow = new KeyboardRow();
            keyboardRow.add("/third");
            keyboardRow.add("/fourth");
            row.add(keyboardRow);
            replyKeyboard.setResizeKeyboard(Boolean.TRUE);
            return replyKeyboard.setKeyboard(row);
    }

}
