package com.example;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        CatDao crud = new CatDao();
        Cat agatha = new Cat("Agatha", "Karine", "(61)95555-5555", "A+", LocalDate.of(2022, 10, 19), false, 1);
//        try {
//            crud.registerCat(agatha);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        try {
            System.out.println(crud.getAllCats());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // System.out.println(crud.getCatById(1));

        // Cat agatha = new Cat("Agatha", "Karine", "(61)96161-6161", "A+", LocalDate.of(2022, 10, 19), false, 1);
        // crud.updateCatById(agatha);

        // crud.deleteCatById(1);

    }

}