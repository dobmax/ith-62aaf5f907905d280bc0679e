package ua.ithillel.lesson29.homework;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

@WebServlet(name = "GreetingServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {

    @Override
    @SneakyThrows
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        var writer = resp.getWriter();
        writer.println("Hello, world!");
        writer.close();
    }
}
