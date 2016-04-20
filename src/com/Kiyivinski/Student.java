/**
 * @author      Timothy Kiyui (4316886@students.swinburne.edu.my)
 * @version     0.1
 * @since       19.04.2016
 */

package com.Kiyivinski;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Student extends Model {
    /**
     * Resource Model for students
     * @param verbose  Enable debugging
     */
    Student(boolean verbose) {
        super(new ActiveRecordModel("students", Student.getColumns(), verbose));
    }

    /**
     * Gets all columns in resource
     * @return Columns as a list
     */
    static ArrayList<String> getColumns() {
        ArrayList<String> columns = new ArrayList<>();
        columns.add("id");
        columns.add("name");
        columns.add("identification");
        columns.add("course_id");
        return columns;
    }

    /**
     * Create resource instance
     * @param name Resource name
     * @param identification Resource student ID
     * @param course_id Resource course ID
     * @throws SQLException
     */
    public void create(String name, String identification, String course_id) throws SQLException {
        HashMap<String, String> columns = new HashMap<>();
        columns.put("name", name);
        columns.put("identification", identification);
        columns.put("course_id", course_id);
        super.create(columns);
    }

    /**
     * Create resource instance
     * @param name Resource name
     * @param identification Resource student ID
     * @param course_id Resource course ID
     * @throws SQLException
     */
    public void create(String name, String identification, Integer course_id) throws SQLException {
       this.create(name, identification, course_id.toString());
    }

    /**
     * Query with Unit where clause
     * @param id Unit ID
     * @return
     * @throws SQLException
     */
    public ArrayList<HashMap<String, String>> whereUnit(String id) throws SQLException {
        String sql = "SELECT DISTINCT students.* FROM students INNER JOIN student_units ON students.id = student_units.student_id AND student_units.unit_id = " + id;
        return super.query(sql);
    }

    /**
     * Query Semester with where clause
     * @param id Semester ID
     * @return
     * @throws SQLException
     */
    public ArrayList<HashMap<String, String>> whereSemester(String id) throws SQLException {
        String sql = "SELECT DISTINCT students.* FROM students INNER JOIN student_units ON students.id = student_units.student_id AND student_units.semester_id = " + id;
        return super.query(sql);
    }

}
