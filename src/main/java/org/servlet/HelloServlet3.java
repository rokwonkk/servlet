package org.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet3 extends HttpServlet {

    /*parameter가 보인다*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet doGet");

        //Java(html) => servlet
        //HTML(java) => JSP => Spring

        //http://localhost:8080/servlet_war_exploded/hello?name=%ED%99%8D%EA%B8%B8%EB%8F%99&age=24&height=172.2

        // (client로 부터) 데이터 받기
        String name = request.getParameter("name");

        String sage = request.getParameter("age");
        int age = Integer.parseInt(sage);

        String sheight = request.getParameter("height");
        double height = Double.parseDouble(sheight);

        String fruit[] = request.getParameterValues("fruit");

        response.setContentType("text/html; charset=utf-8");
        PrintWriter pw = response.getWriter();

        pw.println("<html>");

        pw.println("<head>");
        pw.println("<title>Hello Servlet</title>");

        pw.println("</head>");

        pw.println("<body>");

        pw.println("<h1>Hello Servlet</h1>");

        pw.println("<p>이름 : " + name + "</p>");
        pw.println("<p>나이 : " + age + "</p>");
        pw.println("<p>키 : " + height + "</p>");

        for (int i = 0; i < fruit.length; i++) {
            pw.println("<p>좋아하는 과일: " + fruit[i] + "</p>");
        }

        String hobby[] = request.getParameterValues("hobby");

        if (hobby != null){
            for (int i = 0; i < hobby.length; i++) {
                pw.println("<p>취미: " + hobby[i] + "</p>");
            }
        } else {
            pw.println("<p>취미: 없음</p>");
        }

        pw.println("</body>");
        pw.println("</html>");
        pw.close();
    }

    /*parameter가 보이지않는다 (보안을 필요로 하는 경우)*/
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet doPost");
    }
}