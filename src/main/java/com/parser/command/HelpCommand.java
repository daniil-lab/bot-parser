package com.parser.command;

import com.parser.util.MessageBuilder;
import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class HelpCommand extends BotCommand {
    public HelpCommand(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }

    @Override
    public void processMessage(AbsSender absSender, Message message, String[] arguments) {
        super.processMessage(absSender, message, arguments);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        try {
            SendMessage msg = new MessageBuilder()
                    .setText("\u2755Основная информация\u2755\n\n" +
                            "\u274CДля получения к функционалу бота требуется авторизоваться с помощью токена\u274C.\n\n" +
                            "\u27A1Для приобретения токена: @dev_daniil\n\n" +
                            "\u2728Как получили токен, используем команду /auth TOKEN и наслаждаемся\u2728\n\n\n" +
                            "Прайс-лист\n\n" +
                            "6 часов - $\n" +
                            "12 часов - $\n" +
                            "24 часа - $\n" +
                            "3 дня - $\n" +
                            "7 дней - $\n")
                    .setChat(chat.getId())
                    .build();

            absSender.execute(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
