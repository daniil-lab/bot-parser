package com.parser.menu;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

public interface BotMenu {
    ReplyKeyboardMarkup getMarkup();

    SendMessage getMessage();
}
