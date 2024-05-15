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

@WebServlet("/view")
public class BookViewController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long num = Long.parseLong(req.getParameter("num"));


        BookDAOMybatis dao = new BookDAOMybatis();
        BookDTO dto = dao.bookView(num);

        req.setAttribute("book", dto);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/view.jsp");
        rd.forward(req, resp);
    }
}
