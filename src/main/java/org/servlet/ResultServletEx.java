package org.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dto.StudentDto;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/result")
public class ResultServletEx extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProc(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProc(req, resp);
    }

    public void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ResultServletEx doProc");

        //짐풀자
        StudentDto student = (StudentDto) request.getAttribute("student");

        System.out.println(student.toString());

        //인코딩 방식을 설정 get에선 필요없지만 post에선 필요
        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html; charset=utf-8");
        PrintWriter pw = response.getWriter();

        pw.println("<html>");

        pw.println("<head>");
        pw.println("<title>Result Servlet</title>");

        pw.println("</head>");

        pw.println("<body>");

        pw.println("<h1>Result Servlet Ex</h1>");

        pw.println("<p>이름 : " + student.getName() + "</p>");
        pw.println("<p>영어의관심 : " + student.getEng() + "</p>");

        pw.println("<h3>관심있는 과목들</h3>");
        for (int i = 0; i < student.getLang().length; i++) {
            pw.println("<p>" + student.getLang()[i] + "</p>");
        }

        pw.println("<p>의견 : " + student.getComment() + "</p>");
        pw.println("<p>연령 :" + student.getAge() + "</p>");
        pw.println("</body>");
        pw.println("</html>");
        pw.close();
    }
}
