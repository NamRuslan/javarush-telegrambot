package com.github.NamRuslan.jrtb.command;

import com.github.NamRuslan.jrtb.service.SendBotMessageService;
import com.google.common.collect.ImmutableMap;

import static com.github.NamRuslan.jrtb.command.CommandName.*;

public class CommandContainer {

    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer (SendBotMessageService sendBotMessageService) {
        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendBotMessageService))
                .put(STOP.getCommandName(), new StopCommand(sendBotMessageService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(NO.getCommandName(), new NoCommand(sendBotMessageService))
                .build();

        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public Command retrieveCommand(String commandId) {
        return commandMap.getOrDefault(commandId, unknownCommand);
    }
}
