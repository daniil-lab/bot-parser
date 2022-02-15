package com.parser.trigger.menu.settings;

import com.parser.menu.settings.SettingsMenu;
import com.parser.trigger.MessageTrigger;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class ShowSettingsMenuTrigger implements MessageTrigger {
    @Override
    public String getTriggerText() {
        return "\uD83D\uDD27 Настройка парсера";
    }

    @Override
    public void execute(TelegramLongPollingCommandBot bot, Long chatId) {
        try {
            SendMessage msg = new SettingsMenu().getMessage();

            msg.setChatId(chatId.toString());

            bot.execute(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
