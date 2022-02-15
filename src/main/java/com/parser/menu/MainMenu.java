package com.parser.menu;

import com.parser.util.MessageBuilder;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class MainMenu implements BotMenu {
    @Override
    public ReplyKeyboardMarkup getMarkup() {
        List<KeyboardRow> keyboardRows = new ArrayList<>();

        keyboardRows.add(new KeyboardRow());
        keyboardRows.add(new KeyboardRow());
        keyboardRows.add(new KeyboardRow());

        keyboardRows.get(0).add("\uD83D\uDD0D Поиск");
        keyboardRows.get(0).add("\uD83D\uDD27 Настройка парсера");
        keyboardRows.get(1).add("\uD83D\uDEC2 Настройка фильтров");
        keyboardRows.get(1).add("\uD83D\uDCF5 Черные списки");
        keyboardRows.get(1).add("\uD83D\uDD26 Текущие настройки");
        keyboardRows.get(2).add("\uD83C\uDF10 Помощь");

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
                .setText("\uD83C\uDFE0 Добро пожаловать на главный экран")
                .build();
    }
}
