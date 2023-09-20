package ru.sberbank.jd.classwork09.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.sberbank.jd.classwork09.service.CalculatorService;
import ru.sberbank.jd.classwork09.service.CalculatorServiceImpl;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@WebServlet(name = "CalculatorServlet", value = {"/calc/*"})
public class CalculatorServlet extends HttpServlet {
    private CalculatorService calculatorService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.calculatorService = new CalculatorServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> params = req.getParameterMap();

        System.out.println("uri: " + req.getRequestURI());
        System.out.println("url: " + req.getRequestURL());
        System.out.println("pathInfo: " + req.getPathInfo());

        params.forEach((key, value) -> System.out.println("key: " + key + ", value: " + Arrays.toString(value)));
        params.forEach((key, value) -> System.out.println("length: " + value.length));

        if (params.size() == 2) {
            double v1 = Double.parseDouble(params.get("v1")[0]);
            double v2 = Double.parseDouble(params.get("v2")[0]);
            double result = calculatorService.sum(v1, v2);

            resp.getOutputStream().write(String.valueOf(result).getBytes());
            resp.getOutputStream().flush();
        }
    }
}
