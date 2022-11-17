package ua.ithillel.lesson29.classwork;

import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
