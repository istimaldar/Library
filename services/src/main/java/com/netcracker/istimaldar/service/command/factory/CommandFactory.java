package com.netcracker.istimaldar.service.command.factory;

import com.netcracker.istimaldar.service.command.ActionCommand;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by istimaldar
 */
public class CommandFactory implements AbstractFactory {
    private static class MySqlCommandFactorySingletonHolder {
        static final CommandFactory INSTANCE = new CommandFactory();
    }

    public static CommandFactory getInstance() {
        return  MySqlCommandFactorySingletonHolder.INSTANCE;
    }

    public ActionCommand defineCommand(HttpServletRequest request) {
        return null;
    }
}
