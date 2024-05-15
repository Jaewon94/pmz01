package com.example.controller;

import com.example.entity.BookDTO;
import com.example.repository.BookDAO;
import com.example.repository.BookDAOMybatis;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/list")
public class BookListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


//        BookDAO dao = new BookDAO();

        BookDAOMybatis dao = new BookDAOMybatis();
        List<BookDTO> list = dao.bookList();

        // 객체 바인딩 기술
        req.setAttribute("list", list);

        // forward, dispatcher
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/list.jsp");
        rd.forward(req, resp);
    }
}