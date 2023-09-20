package ru.sberbank.jd.classwork09.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// GET https://localhost:8080/context_app/hello?param1=value1&param2=value2
@WebServlet(name = "FirstServlet", value = "/hello")
public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String helloString = "Hello!";
        StringBuilder resBuilder = new StringBuilder();

        var param1 = req.getParameter("param1");
        var param2 = req.getParameter("param2");

        resBuilder.append(param1);
        resBuilder.append(param2);

        resp.getOutputStream().write(helloString.getBytes());
        resp.getOutputStream().write(param1.getBytes());
        resp.getOutputStream().write(param2.getBytes());
        resp.getOutputStream().flush();
    }
}
