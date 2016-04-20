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
    /**
     * Resource Model for student_assessments
     * @param verbose  Enable debugging
     */
    StudentAssessment(boolean verbose) {
        super(new ActiveRecordModel("student_assessments", StudentAssessment.getColumns(), verbose));
    }

    /**
     * Gets all columns in resource
     * @return Columns as a list
     */
    static ArrayList<String> getColumns() {
        ArrayList<String> columns = new ArrayList<>();
        columns.add("id");
        columns.add("student_id");
        columns.add("assessment_id");
        columns.add("mark");
        return columns;
    }

    /**
     * Create resource instance
     * @param student_id Resource student ID
     * @param assessment_id Resource assessment ID
     * @throws SQLException
     */
    void create(String student_id, String assessment_id) throws SQLException {
        HashMap<String, String> columns = new HashMap<>();
        columns.put("student_id", student_id);
        columns.put("assessment_id", assessment_id);
        columns.put("mark", "0");
        super.create(columns);
    }

    /**
     * Create resource instance
     * @param student_id Resource student ID
     * @param assessment_id Resource assessment ID
     * @throws SQLException
     */
    void create(Integer student_id, Integer assessment_id) throws SQLException {
        this.create(student_id.toString(), assessment_id.toString());
    }

    /**
     * Assigns assessment to students
     * @param assessmentID Assessment ID
     * @param semesterID Semester ID
     * @param unitID Unit ID
     * @param studentUnit student_units Model
     * @throws SQLException
     */
    public void assign(String assessmentID, String semesterID, String unitID, StudentUnit studentUnit)  throws SQLException {
        HashMap<String, String> constraints = new HashMap<>();
        constraints.put("unit_id", unitID);
        constraints.put("semester_id", semesterID);
        ArrayList<HashMap<String, String>> students = studentUnit.where(constraints);
        for (HashMap<String, String> student: students) {
            this.create(student.get("student_id"), assessmentID);
        }
    }

    /**
     * Grades a student by updating resource
     * @param mark Student mark
     * @param studentID Student ID
     * @param assessmentID Assessment ID
     * @throws SQLException
     */
    public void grade(String mark, String studentID, String assessmentID) throws SQLException {
        HashMap<String, String> constraints = new HashMap<>();
        constraints.put("student_id", studentID);
        constraints.put("assessment_id", assessmentID);
        ArrayList<HashMap<String, String>> results = this.where(constraints);
        HashMap<String, String> pairs = results.get(0);
        pairs.put("mark", mark);
        this.update(Integer.parseInt(pairs.get("id")), pairs);
    }

    /**
     * Gets a student's grade
     * @param mark Student Mark
     * @param studentID Student ID
     * @param assessmentID Assessment ID
     * @return
     * @throws SQLException
     */
    public String getGrade(String mark, String studentID, String assessmentID) throws SQLException {
        HashMap<String, String> constraints = new HashMap<>();
        constraints.put("student_id", studentID);
        constraints.put("assessment_id", assessmentID);
        ArrayList<HashMap<String, String>> results = this.where(constraints);
        HashMap<String, String> pairs = results.get(0);
        return pairs.get("mark");
    }
}
