package com.istimaldar.service.command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by istimaldar
 */
public interface ActionCommand {
    String execute(HttpServletRequest request);
}
