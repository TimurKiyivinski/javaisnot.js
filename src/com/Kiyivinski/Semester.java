package com.Kiyivinski;

import java.util.ArrayList;

public class Semester extends Model {
    Semester(boolean verbose) {
        super(new ActiveRecordModel("semesters", Semester.getColumns(), verbose));
    }

    static ArrayList<String> getColumns() {
        ArrayList<String> columns = new ArrayList<>();
        columns.add("id");
        columns.add("name");
        return columns;
    }
}
