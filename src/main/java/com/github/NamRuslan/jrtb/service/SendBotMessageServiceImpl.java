package com.github.NamRuslan.jrtb.service;

import com.github.NamRuslan.jrtb.bot.JavaRushTelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class SendBotMessageServiceImpl implements SendBotMessageService {
    private final JavaRushTelegramBot jrBot;

    @Autowired
    public SendBotMessageServiceImpl(JavaRushTelegramBot jrBot) {
        this.jrBot = jrBot;
    }


    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            jrBot.execute(sendMessage);
        } catch (TelegramApiException e) { e.printStackTrace(); }
    }
}
