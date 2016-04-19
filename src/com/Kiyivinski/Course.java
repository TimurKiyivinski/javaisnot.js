package com.Kiyivinski;

import java.util.ArrayList;

public class Course extends Model {
    Course(boolean verbose) {
        super(new ActiveRecordModel("courses", Course.getColumns(), verbose));
    }

    public static ArrayList<String> getColumns() {
        ArrayList<String> columns = new ArrayList<>();
        columns.add("id");
        columns.add("name");
        return columns;
    }
}
