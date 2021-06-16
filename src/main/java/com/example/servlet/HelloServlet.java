package com.example.servlet;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        ApplicationContext applicationContext = (ApplicationContext) request.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        System.out.println(applicationContext.getClass());
        HelloService helloService = applicationContext.getBean("helloService", HelloService.class);
        //class org.springframework.web.context.support.AnnotationConfigWebApplicationContext

        // Hello
        PrintWriter out = response.getWriter();
        String lastname = this.getServletContext().getInitParameter("lastname");
        String firstname = this.getServletConfig().getInitParameter("firstname");

        out.println("<html><body>");
        out.println("<h1>" + message + helloService.getHelloName() + "</h1>");
        out.println("<h1>" + lastname + "</h1>");
        out.println("<h1>" + firstname + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
