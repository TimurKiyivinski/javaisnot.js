package com.Kiyivinski;

import java.util.ArrayList;

public class Student extends Model {
    Student(boolean verbose) {
        super(new ActiveRecordModel("students", Student.getColumns(), verbose));
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

