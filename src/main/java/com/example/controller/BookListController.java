package com.example.controller;

import com.example.entity.BookDTO;
import com.example.repository.BookDAOMyBatis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class BookListController implements Controller{ // POJO

    public String requestHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


//        BookDAO dao = new BookDAO();

        BookDAOMyBatis dao = new BookDAOMyBatis();
        List<BookDTO> list = dao.bookList();

        // 객체 바인딩 기술
        req.setAttribute("list", list);

//        // forward, dispatcher
//        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/list.jsp");
//        rd.forward(req, resp);

        return "list"; ///WEB-INF/views/list.jsp
    }
}