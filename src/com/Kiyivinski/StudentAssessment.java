package com.Kiyivinski;

import java.util.ArrayList;

public class StudentAssessment {
    private Integer id;
    private Integer student_id;
    private Integer assessment_id;

    StudentAssessment(Integer id, Integer student_id, Integer assessment_id) {
        this.id = id;
        this.student_id = student_id;
        this.assessment_id = assessment_id;
    }

    static ArrayList<String> getColumns() {
        ArrayList<String> columns = new ArrayList<>();
        columns.add("id");
        columns.add("student_id");
        columns.add("assessment_id");
        return columns;
    }
}
