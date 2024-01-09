package org.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dto.Human;

import java.io.IOException;

public class HelloServlet5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //front의 데이터를 받는다
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        double height = Double.parseDouble(request.getParameter("height"));

        //데이터를 묶는다(object)
        Human human = new Human(name, age, height);

        request.setAttribute("human", human);

        //전송
        RequestDispatcher dispatch = request.getRequestDispatcher("world");
        dispatch.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}