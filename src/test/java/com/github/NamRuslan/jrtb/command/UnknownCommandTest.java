package com.github.NamRuslan.jrtb.command;

import org.junit.jupiter.api.DisplayName;

import static com.github.NamRuslan.jrtb.command.UnknownCommand.UNKNOWN_MESSAGE;

@DisplayName("Unit-level testing for UnknownCommand")
public class UnknownCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return "/asdasdasdas";
    }

    @Override
    String getCommandMessage() {
        return UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendBotMessageService);
    }
}
