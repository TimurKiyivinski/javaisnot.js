package com.Kiyivinski;

import java.util.ArrayList;

public class Student {
    private Integer id;
    private String name;
    private String identification;
    private Integer course_id;

    Student(Integer id, String name, String identification, Integer course_id) {
        this.id = id;
        this.name = name;
        this.identification = identification;
        this.course_id = course_id;
    }

    static ArrayList<String> getColumns() {
        ArrayList<String> columns = new ArrayList<>();
        columns.add("id");
        columns.add("name");
        columns.add("identification");
        columns.add("course_id");
        return columns;
    }
}

