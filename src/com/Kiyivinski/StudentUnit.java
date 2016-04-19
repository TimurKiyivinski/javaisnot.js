package com.Kiyivinski;

import java.util.ArrayList;

public class StudentUnit extends Model {
    StudentUnit(boolean verbose) {
        super(new ActiveRecordModel("student_units", StudentUnit.getColumns(), verbose));
    }

    static ArrayList<String> getColumns() {
        ArrayList<String> columns = new ArrayList<>();
        columns.add("id");
        columns.add("student_id");
        columns.add("unit_id");
        columns.add("semester_id");
        return columns;
    }
}
