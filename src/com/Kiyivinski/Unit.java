package com.Kiyivinski;

import java.util.ArrayList;

public class Unit {
    private Integer id;
    private String name;
    private String code;

    Unit(Integer id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    static ArrayList<String> getColumns() {
        ArrayList<String> columns = new ArrayList<>();
        columns.add("id");
        columns.add("name");
        columns.add("code");
        return columns;
    }
}
