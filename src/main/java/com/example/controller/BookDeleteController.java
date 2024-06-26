package com.example.controller;

import com.example.repository.BookDAOMyBatis;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookDeleteController implements Controller {

    public String requestHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int num = Integer.parseInt(req.getParameter("num"));
        BookDAOMyBatis dao = new BookDAOMyBatis();
        int cnt = dao.bookDelete(num);
        return "redirect:/list.do";

    }
}