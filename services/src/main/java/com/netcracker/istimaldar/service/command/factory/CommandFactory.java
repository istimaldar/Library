package com.netcracker.istimaldar.service.command.factory;

import com.netcracker.istimaldar.service.command.ActionCommand;
import com.netcracker.istimaldar.service.command.AddAuthorCommand;

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
        if (request.getParameter("req_type").equals("addAuthor")) {
            return new AddAuthorCommand();
        }
        return null;
    }
}
