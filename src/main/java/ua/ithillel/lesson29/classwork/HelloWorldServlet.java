package ua.ithillel.lesson29.classwork;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

// URL: scheme://host:port/path
// URL: http://localhost:8888/hello-world
@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello-world")
public class HelloWorldServlet extends HttpServlet {

    @Override
    @SneakyThrows
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        var writer = resp.getWriter();
        writer.println("Hello, world!");
        writer.close();
    }
}
