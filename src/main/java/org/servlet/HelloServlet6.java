package org.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

//annotation(주석문, 지시어)

@WebServlet("/hello")
public class HelloServlet6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //인코딩 방식을 설정 get에선 필요없지만 post에선 필요
        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html; charset=utf-8");
        PrintWriter pw = response.getWriter();

        pw.println("<html>");

        pw.println("<head>");
        pw.println("<title>Hello Servlet</title>");

        pw.println("</head>");

        pw.println("<body>");

        pw.println("<h1>Hello Servlet6 Session사용</h1>");

        HttpSession session = request.getSession(false);
        /*
        *   getSession(false) -> 제일 많이 사용한다함
        *   session object가 존재하면, 현재 HttpSession을 반환한다.
        *   존재하지 않으면, null을 반환한다.
        *
        *   getSession(true)
        *   session object가 존재하면, 현재 HttpSession을 반환한다.
        *   존재하지 않으면, 새로 생성한다.
        */

        if (session == null) {
            session = request.getSession(true);         // 세션 객체를 생성.
            session.setMaxInactiveInterval(2 * 60 * 60);        //  기한설정 365 * 24 * 60 * 60
            session.setAttribute("visited", "1"); // key : value

            pw.println("<p>첫번째 방문입니다</p>");
        } else {
            String visited = (String)session.getAttribute("visited");
            int count = Integer.parseInt(visited);

            count++;

            pw.println("<p>방문 횟수는 " + count  +" 번째 입니다</p>");
            session.setAttribute("visited", count + "");
        }
        // visited object의 삭제
        pw.println("<a href='delete'>세션오브젝트 삭제</a>");

        pw.println("<br/>");
        pw.println("<br/>");

        // session 삭제
        pw.println("<a href='sessionDelete'>세션 삭제</a>");

        pw.println("</body>");
        pw.println("</html>");
        pw.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}