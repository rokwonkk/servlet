package org.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet doPost");

        //인코딩 방식을 설정 get에선 필요없지만 post에선 필요
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));

        response.setContentType("text/html; charset=utf-8");
        PrintWriter pw = response.getWriter();

        pw.println("<html>");

        pw.println("<head>");
        pw.println("<title>Hello Servlet</title>");

        pw.println("</head>");

        pw.println("<body>");

        pw.println("<h1>Hello Servlet4</h1>");

        pw.println("<p>이름:" + name + "</p>");
        pw.println("<p>나이:" + age + "</p>");

        pw.println("</body>");
        pw.println("</html>");
        pw.close();

    }
}