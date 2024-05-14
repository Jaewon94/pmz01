package com.example.entity;

import lombok.Data;

@Data
public class BookDTO {

    private int num;
    private String title;
    private int price;
    private String author;
    private int page;

    public BookDTO(int num, String title, int price, String author, int page) {
        this.num = num;
        this.title = title;
        this.price = price;
        this.author = author;
        this.page = page;
    }
}
