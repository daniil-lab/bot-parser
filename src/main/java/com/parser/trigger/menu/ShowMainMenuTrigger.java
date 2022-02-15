package com.parser.trigger.menu;

import com.parser.menu.MainMenu;
import com.parser.trigger.MessageTrigger;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class ShowMainMenuTrigger implements MessageTrigger {
    @Override
    public String getTriggerText() {
        return "\uD83C\uDFE0 Вернутся на главную";
    }

    @Override
    public void execute(TelegramLongPollingCommandBot bot, Long chatId) {
        try {
            SendMessage msg = new MainMenu().getMessage();

            msg.setChatId(chatId.toString());

            bot.execute(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
