package com.parser.trigger;

import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.function.Function;

public interface MessageTrigger {
    String getTriggerText();

    void execute(TelegramLongPollingCommandBot sender, Long chatId);
}
