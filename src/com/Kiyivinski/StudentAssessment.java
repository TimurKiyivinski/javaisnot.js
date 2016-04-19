package com.Kiyivinski;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

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

    void create(String student_id, String assessment_id) throws SQLException {
        HashMap<String, String> columns = new HashMap<>();
        columns.put("student_id", student_id);
        columns.put("assessment_id", assessment_id);
        super.create(columns);
    }

    void create(Integer student_id, Integer assessment_id) throws SQLException {
        this.create(student_id.toString(), assessment_id.toString());
    }
}
