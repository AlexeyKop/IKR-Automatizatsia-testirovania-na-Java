package com.example.library;

public class Microfilm extends LibraryItem {
    private String contentDescription; // Описание содержания микрофильма

    public Microfilm(String inventoryNumber, String author, String contentDescription) {
        super(inventoryNumber, author);
        this.contentDescription = contentDescription;
    }

    @Override
    public String getInfo() {
        return "Microfilm [Inventory Number: " + getInventoryNumber() +
                ", Author: " + getAuthor() +
                ", Content: " + contentDescription + "]";
    }
}
