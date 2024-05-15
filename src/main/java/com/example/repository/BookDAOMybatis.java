package com.example.repository;

import com.example.entity.BookDTO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.awt.print.Book;
import java.io.InputStream;
import java.util.List;

public class BookDAOMybatis {


    public List<BookDTO> bookList() {
        try(SqlSession session = MyBatisUtil.openSession()) {
            return session.selectList("com.example.repository.BookDAO.bookList");

        }
    }

    public int bookDelete(int num) {
        try(SqlSession session = MyBatisUtil.openSession()) {
            int cnt = session.delete("bookDelete", num);
            session.commit();
            return cnt;
        }
    }

    public int bookInsert(BookDTO dto) {
        try(SqlSession session = MyBatisUtil.openSession()) {
            int cnt = session.insert("bookInsert", dto);
            session.commit();
            return cnt;
        }
    }

    public BookDTO bookView(Long num) {
        try(SqlSession session = MyBatisUtil.openSession()) {
            return session.selectOne("bookView", num);
        }

    }

    public int bookUpdate(BookDTO dto) {
        try(SqlSession session = MyBatisUtil.openSession()) {
            int cnt = session.update("bookUpdate", dto);
            session.commit();
            return cnt;

        }
    }
}
