package com.parser;

import com.parser.command.AuthCommand;
import com.parser.command.HelpCommand;
import com.parser.menu.settings.SettingsMenu;
import com.parser.trigger.MessageTrigger;
import com.parser.trigger.MessageTriggerManager;
import com.parser.util.AuthValidator;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingCommandBot {
    @PersistenceContext
    private EntityManager entityManager;

    public Bot() {
        super();

        register(new AuthCommand("auth", "Авторизация"));
        register(new HelpCommand("help", "Помощь"));
    }

    @Override
    public String getBotUsername() {
        return "PolandVintedParserBot";
    }

    @Override
    public void processNonCommandUpdate(Update update) {

    }

    @Override
    public String getBotToken() {
        return "5231379216:AAERVoABy4tTvM5pmuYILydVT32JUT3wluM";
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }

    private String getUserName(Message msg) {
        User user = msg.getFrom();
        String userName = user.getUserName();
        return (userName != null) ? userName : String.format("%s %s", user.getLastName(), user.getFirstName());
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
//        for (Update u : updates)
//            AuthValidator.validate(u);
//
        for (Update u : updates) {
            if(u.getMessage() != null) {
                for (MessageTrigger trigger : MessageTriggerManager.triggers) {
                    if(trigger.getTriggerText().equals(u.getMessage().getText())) {
                        trigger.execute(this, u.getMessage().getChatId());
                    }
                }
            }
        }

        super.onUpdatesReceived(updates);
    }

    private void setAnswer(Long chatId, String userName, String text) {
        SendMessage answer = new SendMessage();
        answer.setText(text);
        answer.setChatId(chatId.toString());
        try {
            execute(answer);
        } catch (TelegramApiException e) {
            //логируем сбой Telegram Bot API, используя userName
        }
    }
}
