package com.example.repository;

import com.example.entity.BookDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    private Connection conn;

    private PreparedStatement ps;

    private ResultSet rs;



    public Connection getConnect(){

        String driverClassName="com.mysql.cj.jdbc.Driver";

        String url="jdbc:mysql://localhost:3306/books";

        String username="root";

        String password="Zmfhdnwm0=";

        try{

            Class.forName(driverClassName);

            conn= DriverManager.getConnection(url, username, password);

        }catch(Exception e){

            e.printStackTrace();

        }

        return  conn;

    }

    public List<BookDTO> bookList(){

        List<BookDTO> list=new ArrayList<>();

        String SQL="select * from book order by title desc";

        conn=getConnect();

        try{

            ps=conn.prepareStatement(SQL);

            rs=ps.executeQuery();

            while (rs.next()){

                Long num=rs.getLong("num");

                String title=rs.getString("title");

                int price=rs.getInt("price");

                String author=rs.getString("author");

                int page=rs.getInt("page");

                // 묶고(DTO)->담고(List)

                BookDTO dto=new BookDTO(num, title, price, author, page);

                //dto.setNum(num);

                list.add(dto);

            }

        }catch (Exception e){

            e.printStackTrace();

        } finally {
            try {
                rs.close();
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;

    }

}