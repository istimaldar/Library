package com.netcracker.istimaldar.web.servlet;

import com.netcracker.istimaldar.service.command.factory.CommandFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by istimaldar
 */
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        PrintWriter out = response.getWriter();
        out.println("<html><body><p>Hello, world!</p></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CommandFactory.getInstance().defineCommand(request).execute(request);

    }

    private void printRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String[]> map = request.getParameterMap();
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            out.println("<p>" + entry.getKey() + "<br>");
            for (String param : entry.getValue()) {
                out.println(param + "<br>");
            }
            out.println("</p>");
        }
        out.println("</body></html>");
    }
}
