package com.parser.util;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class MessageBuilder {
    private SendMessage msg = new SendMessage();


    public MessageBuilder() {
    }


    public MessageBuilder setText(String text) {
        msg.setText(text);

        return this;
    }

    public MessageBuilder setChat(Long chatId) {
        msg.setChatId(chatId.toString());

        return this;
    }

    public MessageBuilder replyMarkup(ReplyKeyboardMarkup markup) {
        msg.setReplyMarkup(markup);

        return this;
    }

    public SendMessage build() {
        return msg;
    }
}
