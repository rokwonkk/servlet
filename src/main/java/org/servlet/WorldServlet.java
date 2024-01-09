package org.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dto.Human;

import java.io.IOException;
import java.io.PrintWriter;

public class WorldServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 데이터를 푼다 강제 캐스트변환해줘야함.
        // java <-> java 로 데이터를 넘겨줌.
        Human human = (Human) request.getAttribute("human");

        response.setContentType("text/html; charset=utf-8");
        PrintWriter pw = response.getWriter();

        pw.println("<html>");

        pw.println("<head>");
        pw.println("<title>Hello Servlet5</title>");

        pw.println("</head>");

        pw.println("<body>");

        pw.println("<h1>Hello Servlet5</h1>");

        pw.println("<p>"+ human.toString() +"</p>");

        pw.println("</body>");
        pw.println("</html>");
        pw.close();
    }
}
