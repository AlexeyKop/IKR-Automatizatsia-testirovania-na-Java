package com.example.library;

public class Book extends LibraryItem {
    private String title; // Название книги

    public Book(String inventoryNumber, String author, String title) {
        super(inventoryNumber, author);
        this.title = title;
    }

    @Override
    public String getInfo() {
        return "Book [Inventory Number: " + getInventoryNumber() +
                ", Author: " + getAuthor() +
                ", Title: " + title + "]";
    }
}
