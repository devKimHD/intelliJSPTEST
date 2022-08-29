package solvice.khd.jsptest;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    //<editor-fold desc="Description 접기">
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        response.setContentType("text/html; charset=utf-8");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<html><body>");
        out.println("추가해서 push");
        out.println("추가해서 push");
        out.println("save test");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
        // TODO: 2022-08-29 ??? 이게머지 ?
        // TODO: 2022-08-29 커밋전에 체크하시오


    }
    //</editor-fold>

    public void destroy() {
    }
}