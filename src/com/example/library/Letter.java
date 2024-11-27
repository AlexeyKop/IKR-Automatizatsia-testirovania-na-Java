package com.example.library;

public class Letter extends LibraryItem {
    private String recipient; // Получатель письма

    public Letter(String inventoryNumber, String author, String recipient) {
        super(inventoryNumber, author);
        this.recipient = recipient;
    }

    @Override
    public String getInfo() {
        return "Letter [Inventory Number: " + getInventoryNumber() +
                ", Author: " + getAuthor() +
                ", Recipient: " + recipient + "]";
    }
}
