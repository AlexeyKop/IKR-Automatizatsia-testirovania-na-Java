package com.example.library;

import com.example.library.search.Searchable;
import com.example.library.search.SearchService;

import java.util.ArrayList;
import java.util.List;

public class MainLibraryRegistry {
    public static void main(String[] args) {
        // Создание списка объектов
        List<LibraryItem> libraryItems = new ArrayList<>();
        libraryItems.add(new Book("B001", "Федор Достоевский", "Преступление и наказание"));
        libraryItems.add(new Book("B002", "Лев Толстой", "Война и мир"));
        libraryItems.add(new Book("B003", "Михаил Булгаков", "Мастер и Маргарита"));
        libraryItems.add(new Magazine("M001", "Вокруг Света", 2024));
        libraryItems.add(new Magazine("M002", "Веселые картинки", 1015));
        libraryItems.add(new Letter("L001", "Петр Петров", "Анна Иванова"));
        libraryItems.add(new Letter("L002", "Сергей Сидоров", "Ольга Мошкина"));
        libraryItems.add(new Microfilm("MF001", "Дикие звери", "Животные"));
        libraryItems.add(new Microfilm("MF002", "Дикая природа", "Природа"));


        Searchable searchService = new SearchService(libraryItems);

        // Поиск по автору
        System.out.println("Поиск результатов по автору: 'Лев Толстой':");
        for (LibraryItem item : searchService.searchByAuthor("Лев Толстой")) {
            System.out.println(item.getInfo());
        }

        System.out.println("Поиск результатов по автору: 'Веселые картинки':");
        for (LibraryItem item : searchService.searchByAuthor("Веселые картинки")) {
            System.out.println(item.getInfo());
        }

        // Поиск по инвентарному номеру
        System.out.println("Поиск результатов по инвентарному номеру: 'MF001':");
        for (LibraryItem item : searchService.searchByInventoryNumber("MF001")) {
            System.out.println(item.getInfo());
        }
        System.out.println("Поиск результатов по инвентарному номеру: 'B003':");
        for (LibraryItem item : searchService.searchByInventoryNumber("B003")) {
            System.out.println(item.getInfo());
        }


        System.out.println("\nAll library items:");
        for (LibraryItem item : libraryItems) {
            System.out.println(item.getInfo());
        }
    }
}
