/**
 * @author      Timothy Kiyui (4316886@students.swinburne.edu.my)
 * @version     0.1
 * @since       19.04.2016
 */

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
        columns.add("mark");
        return columns;
    }

    void create(String student_id, String assessment_id) throws SQLException {
        HashMap<String, String> columns = new HashMap<>();
        columns.put("student_id", student_id);
        columns.put("assessment_id", assessment_id);
        columns.put("mark", "0");
        super.create(columns);
    }

    void create(Integer student_id, Integer assessment_id) throws SQLException {
        this.create(student_id.toString(), assessment_id.toString());
    }

    void assign(String assessmentID, String semesterID, String unitID, StudentUnit studentUnit)  throws SQLException {
        HashMap<String, String> constraints = new HashMap<>();
        constraints.put("unit_id", unitID);
        constraints.put("semester_id", semesterID);
        ArrayList<HashMap<String, String>> students = studentUnit.where(constraints);
        for (HashMap<String, String> student: students) {
            this.create(student.get("student_id"), assessmentID);
        }
    }
}
