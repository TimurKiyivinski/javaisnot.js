package com.Kiyivinski;

import java.util.ArrayList;

public class StudentAssessment extends Model {
    StudentAssessment(boolean verbose) {
        super(new ActiveRecordModel("student_assessments", StudentAssessment.getColumns(), verbose));
    }

    static ArrayList<String> getColumns() {
        ArrayList<String> columns = new ArrayList<>();
        columns.add("id");
        columns.add("student_id");
        columns.add("assessment_id");
        return columns;
    }
}
