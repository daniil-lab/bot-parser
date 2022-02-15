package com.parser.util;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.bots.AbsSender;

public final class MessageSender {
    public static void send(AbsSender sender, String text, Long chatId, ReplyKeyboardMarkup markup) {
        try {
            sender.execute(
                    new MessageBuilder()
                            .setChat(chatId)
                            .setText(text)
                            .replyMarkup(markup)
                            .build()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void send(AbsSender sender, String text, Long chatId) {
        try {
            sender.execute(
                    new MessageBuilder()
                            .setChat(chatId)
                            .setText(text)
                            .build()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
