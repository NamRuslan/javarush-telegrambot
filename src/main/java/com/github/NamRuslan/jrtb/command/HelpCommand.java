package com.github.NamRuslan.jrtb.command;

import com.github.NamRuslan.jrtb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.NamRuslan.jrtb.command.CommandName.*;

public class HelpCommand implements Command {

    private SendBotMessageService sendBotMessageService;

    public final static String HELP_MESSAGE = String.format("<b>Available commands</b>\n\n" +
            "<b>Start\\End work with bot</b>\n" +
            "%s - start working with me\n" +
            "%s - pause working with me\n\n" +
            "%s - get help working with me\n",
            START.getCommandName(), STOP.getCommandName(), HELP.getCommandName()
            );

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
