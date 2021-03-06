package com.github.NamRuslan.jrtb.command;

import org.junit.jupiter.api.DisplayName;

import static com.github.NamRuslan.jrtb.command.CommandName.START;
import static com.github.NamRuslan.jrtb.command.StartCommand.START_MESSAGE;

@DisplayName("Unit-level test for StartCommand")
public class StartCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return START_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StartCommand(sendBotMessageService);
    }
}
