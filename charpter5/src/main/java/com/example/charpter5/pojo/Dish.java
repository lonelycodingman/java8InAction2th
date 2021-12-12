package com.example.charpter5.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
    private String name;
    private boolean vegetarian;
    private int calories;
    private Type type;

    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public String toString() {
        return name;
    }

    public enum Type {META, FISH, OTHER}

    ;
}
