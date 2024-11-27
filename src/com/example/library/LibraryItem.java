package com.example.library;

// Абстрактный класс для описания общих свойств библиотечных объектов
public abstract class LibraryItem {
    private String inventoryNumber;
    private String author;

    public LibraryItem(String inventoryNumber, String author) {
        this.inventoryNumber = inventoryNumber;
        this.author = author;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public String getAuthor() {
        return author;
    }

    public abstract String getInfo();
}
