package com.github.NamRuslan.jrtb.bot;

import com.github.NamRuslan.jrtb.command.CommandContainer;
import com.github.NamRuslan.jrtb.service.SendBotMessageServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static com.github.NamRuslan.jrtb.command.CommandName.NO;

@Component
public class JavaRushTelegramBot extends TelegramLongPollingBot {

    public static String COMMAND_PREFIX = "/";

    public final CommandContainer commandContainer;

    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    public JavaRushTelegramBot () {
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this));
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)) {
                String commandId = message.split(" ")[0].toLowerCase();
                commandContainer.retrieveCommand(commandId).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }
        }
    }
}
