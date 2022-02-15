package com.parser.menu.settings;

import com.parser.menu.BotMenu;
import com.parser.util.AuthValidator;
import com.parser.util.MessageBuilder;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.ArrayList;
import java.util.List;

public class SettingsMenu implements BotMenu {
    @Override
    public ReplyKeyboardMarkup getMarkup() {
        List<KeyboardRow> keyboardRows = new ArrayList<>();

        keyboardRows.add(new KeyboardRow());
        keyboardRows.add(new KeyboardRow());
        keyboardRows.add(new KeyboardRow());
        keyboardRows.add(new KeyboardRow());

        keyboardRows.get(0).add("\uD83D\uDCC5 Начальная дата");
        keyboardRows.get(0).add("\uD83D\uDCC5 Конечная дата");
        keyboardRows.get(1).add("\uD83D\uDCB0 Стартовая цена");
        keyboardRows.get(1).add("\uD83D\uDCB0 Максимальная цена");
        keyboardRows.get(2).add("\uD83D\uDC40 Минимум просмотров");
        keyboardRows.get(2).add("\uD83D\uDC40 Максимально просмотров");
        keyboardRows.get(3).add("\uD83C\uDFE0 Вернутся на главную");
        keyboardRows.get(3).add("\u27A1 Страница настроек 2");

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        markup.setSelective(true);
        markup.setOneTimeKeyboard(false);
        markup.setKeyboard(keyboardRows);

        return markup;
    }

    @Override
    public SendMessage getMessage() {
        return new MessageBuilder()
                .replyMarkup(this.getMarkup())
                .setText("\uD83D\uDD27 Вы открыли меню настроек")
                .build();
    }
}
