package com.example.controller;

import com.example.entity.BookDTO;
import com.example.repository.BookDAOMybatis;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/delete")
public class BookDeleteController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int num = Integer.parseInt(req.getParameter("num"));
        BookDAOMybatis dao = new BookDAOMybatis();
        int cnt = dao.bookDelete(num);

        if (cnt > 0) {
            resp.sendRedirect("/MF01/list");
        }else {
            System.out.println("삭제 실패");
        }

    }
}