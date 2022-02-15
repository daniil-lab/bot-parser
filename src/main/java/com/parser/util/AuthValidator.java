package com.parser.util;

import com.parser.database.ChatRepository;
import com.parser.database.entity.SystemChat;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.time.Instant;
import java.util.List;

public class AuthValidator {
    public static boolean validate(Long chatId) {
        ChatRepository chatRepository = new ChatRepository();

        List<SystemChat> chatData = chatRepository.getChatByChatId(chatId);

        if(chatData.size() != 0)
            for (SystemChat c : chatData)
                if(c.getExpiresDate().isBefore(Instant.now()))
                    chatRepository.removeChat(c);
                else
                    return true;

        return false;
    }
}
