package com.netcracker.istimaldar.service.command.factory;

import com.netcracker.istimaldar.service.command.ActionCommand;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by istimaldar
 */
public interface AbstractFactory {
    ActionCommand defineCommand(HttpServletRequest request);

}
