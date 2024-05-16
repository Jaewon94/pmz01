package com.example.repository;

import com.example.entity.BookDTO;
import com.example.entity.CustomerDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BookDAOMyBatis {


    public List<BookDTO> bookList() {
        try(SqlSession session = MyBatisUtil.openSession()) {
            return session.selectList("bookList");

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
