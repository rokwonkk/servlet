package org.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dto.StudentDto;

import java.io.IOException;

@WebServlet("/review")
public class HelloServletEx extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("review doGet");
        doProc(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProc(request, response);
    }

    public void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //이름
        String name = request.getParameter("name");
        //영어
        String eng = request.getParameter("eng");
        //languages
        String lang[] = request.getParameterValues("anyLang");
        //comment
        String comment = request.getParameter("comment");
        //나이
        int age = Integer.parseInt(request.getParameter("age"));

        System.out.println(name);
        System.out.println(eng);
        for (String s : lang) {
            System.out.println("선택된 다른 외국어 :  " + s);
        }
        System.out.println(comment);
        System.out.println(age);

        //짐싸 !
        StudentDto student = new StudentDto(name, eng, lang, comment, age);
        request.setAttribute("student", student);

        //잘가 !
//        RequestDispatcher dispatcher = request.getRequestDispatcher("review");
//        dispatcher.forward(request, response);
        //한줄로는 이렇게 된다.
        request.getRequestDispatcher("result").forward(request, response);
    }
}