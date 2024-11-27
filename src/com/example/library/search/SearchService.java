package com.example.library.search;

import com.example.library.LibraryItem;
import java.util.ArrayList;
import java.util.List;

public class SearchService implements Searchable {
    private List<LibraryItem> items;

    public SearchService(List<LibraryItem> items) {
        this.items = items;
    }

    @Override
    public List<LibraryItem> searchByInventoryNumber(String inventoryNumber) {
        List<LibraryItem> results = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item.getInventoryNumber().equals(inventoryNumber)) {
                results.add(item);
            }
        }
        return results;
    }

    @Override
    public List<LibraryItem> searchByAuthor(String author) {
        List<LibraryItem> results = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item.getAuthor().equalsIgnoreCase(author)) {
                results.add(item);
            }
        }
        return results;
    }
}
