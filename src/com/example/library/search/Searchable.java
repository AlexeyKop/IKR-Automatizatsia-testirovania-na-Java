package com.example.library.search;

import com.example.library.LibraryItem;
import java.util.List;

public interface Searchable {
    // Метод для поиска по инвентарному номеру
    List<LibraryItem> searchByInventoryNumber(String inventoryNumber);

    // Метод для поиска по автору
    List<LibraryItem> searchByAuthor(String author);
}
