package ru.netology.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    private int id;
    private String name;
    private int price;


    public boolean matches(String search) {
        if (name.equalsIgnoreCase(search) || name.contains(search)) {
            return true;
        }
        return false;
    }
}
