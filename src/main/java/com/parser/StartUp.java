package com.parser;

import com.parser.auth.JwtUtil;
import com.parser.database.DatabaseConnector;
import com.parser.trigger.MessageTriggerManager;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class StartUp {
    public static void main(String[] args) {
        try {
            DatabaseConnector.connect();

            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);

            System.out.println(JwtUtil.generateToken("456556"));

            MessageTriggerManager.init();

            botsApi.registerBot(new Bot());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
