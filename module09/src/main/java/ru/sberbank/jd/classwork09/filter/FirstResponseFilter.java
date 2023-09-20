package ru.sberbank.jd.classwork09.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "FirstResponseFilter", servletNames = {"FirstServlet"})
public class FirstResponseFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.addHeader("response-filter-x", "some value");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
