package ru.netology.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone() {

    }

    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        } else if (manufacturer.equalsIgnoreCase(search) || manufacturer.contains(search)) {
            return true;
        }
        return false;
    }
}

