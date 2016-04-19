package com.Kiyivinski;

import java.util.ArrayList;

public class StudentUnit {
    private Integer id;
    private Integer student_id;
    private Integer unit_id;
    private Integer semester_id;

    StudentUnit(Integer id, Integer student_id, Integer unit_id, Integer semester_id) {
        this.id = id;
        this.student_id = student_id;
        this.unit_id = unit_id;
        this.semester_id = semester_id;
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
