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

@WebServlet("/registerPost")
public class BookRegisterPostController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        try {
            // 폼에서 넘어온 파라미터를 수집(DTO)
            // 유효성 검사
            String title = req.getParameter("title");
            String reqPrice = req.getParameter("price");
            String author = req.getParameter("author");
            String reqPage = req.getParameter("page");

            if(title==null || title.trim().isEmpty() || author==null || author.trim().isEmpty()) {
                System.out.println("1.제목과 저자는 필수 입력항목입니다.");
                resp.sendRedirect("/MF01/error?msg=1");
                return;
            }

            int price = 0;
            int page = 0;

            try{
                 price =Integer.parseInt(reqPrice);
                 page = Integer.parseInt(reqPage);
            }catch (NumberFormatException e){
                System.out.println("2.숫자 형식의 입력이 잘못되었습니다.");
                resp.sendRedirect("/MF01/error?msg=2");
                return;
            }
            if (price <= 0 || page <= 0 ) {
                System.out.println("3.가격과 페이지 수는 양의 정수여야 합니다.");
                resp.sendRedirect("/MF01/error?msg=3");
                return;
            }


            BookDTO dto = new BookDTO(null, title, price, author, page);

            BookDAOMybatis dao = new BookDAOMybatis();
            int cnt = dao.bookInsert(dto);

            if (cnt > 0) {
                resp.sendRedirect("/MF01/list");
            } else {
                System.out.println("등록 실패");
                resp.sendRedirect("/MF01/errorPage"); // 실패 시 에러 페이지로 리다이렉트
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("/MF01/error");
        }
    }
}