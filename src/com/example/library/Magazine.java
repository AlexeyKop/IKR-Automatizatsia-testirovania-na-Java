package com.example.library;

public class Magazine extends LibraryItem {
    private int issueNumber; // Номер выпуска

    public Magazine(String inventoryNumber, String author, int issueNumber) {
        super(inventoryNumber, author);
        this.issueNumber = issueNumber;
    }

    @Override
    public String getInfo() {
        return "Magazine [Inventory Number: " + getInventoryNumber() +
                ", Author: " + getAuthor() +
                ", Issue Number: " + issueNumber + "]";
    }
}
