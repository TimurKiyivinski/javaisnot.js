package com.Kiyivinski;

import java.util.ArrayList;

public class Type {
    private Integer id;
    private String name;

    Type(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    static ArrayList<String> getColumns() {
        ArrayList<String> columns = new ArrayList<>();
        columns.add("id");
        columns.add("name");
        return columns;
    }
}
