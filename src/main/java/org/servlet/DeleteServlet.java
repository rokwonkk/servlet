package org.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/delete")
public class DeleteServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = request.getSession();

        session.removeAttribute("visited");

        session.setAttribute("myName", "rokwonkk");
        session.setAttribute("myAge", 23 + "");

        // 세션의 모든 오브젝트를 확인
        Enumeration<String> enum_session = session.getAttributeNames();
        while (enum_session.hasMoreElements()) {
            String key = enum_session.nextElement();
            String value = (String) session.getAttribute(key);

            System.out.println(key + " : " + value);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
