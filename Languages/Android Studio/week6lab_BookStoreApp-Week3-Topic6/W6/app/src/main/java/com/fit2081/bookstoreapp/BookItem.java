package com.fit2081.bookstoreapp;

public class BookItem {
    private String id;
    private String title;
    private String isbn;
    private String author;
    private String description;
    private double price;

    public BookItem(String id, String title, String isbn, String author, String description, double price) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.description = description;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}
