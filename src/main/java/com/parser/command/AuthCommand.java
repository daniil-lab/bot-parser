package com.parser.command;

import com.parser.auth.JwtUtil;
import com.parser.database.ChatRepository;
import com.parser.database.UsedTokenRepository;
import com.parser.database.entity.SystemChat;
import com.parser.database.entity.UsedToken;
import com.parser.menu.MainMenu;
import com.parser.util.AuthValidator;
import com.parser.util.MessageBuilder;
import com.parser.util.MessageSender;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwt;
import org.checkerframework.checker.units.qual.A;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class AuthCommand extends BotCommand {
    public AuthCommand(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }

    @Override
    public void processMessage(AbsSender absSender, Message message, String[] arguments) {
        try {
            if(arguments.length != 1) {
                return;
            }

//            ChatRepository chatRepository = new ChatRepository();
//            UsedTokenRepository usedTokenRepository = new UsedTokenRepository();

//            String token = arguments[0];

//            if(AuthValidator.validate(message.getChat().getId())) {
//                MessageSender.send(absSender, "\uD83D\uDCDB Вы уже авторизованы", message.getChatId());
//                return;
//            }
//
//            if(usedTokenRepository.checkToken(token)) {
//                MessageSender.send(absSender, "\uD83D\uDCDBТокен уже был использован", message.getChatId());
//                return;
//            }
//
//            if(!JwtUtil.validateToken(token)) {
//                MessageSender.send(absSender, "\uD83D\uDCDBНевалидный токен", message.getChatId());
//                return;
//            }
//
//            Jwt<Header, Claims> tokenData = JwtUtil.getTokenData(token);
//
//            SystemChat systemChat = new SystemChat();
//
//            systemChat.setChatId(message.getChatId());
//            systemChat.setExpiresDate(tokenData.getBody().getExpiration().toInstant());
//            systemChat.setRegisterDate(Instant.now());
//            systemChat.setToken(token);
//
//            chatRepository.saveChat(systemChat);
//            usedTokenRepository.saveToken(new UsedToken(token));

            MainMenu markup = new MainMenu();

            MessageSender.send(absSender, "\u2705 Вы успешно авторизовались", message.getChatId(), markup.getMarkup());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {

    }
}
