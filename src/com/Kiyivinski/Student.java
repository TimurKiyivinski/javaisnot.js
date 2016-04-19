package com.Kiyivinski;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Student extends Model {
    Student(boolean verbose) {
        super(new ActiveRecordModel("students", Student.getColumns(), verbose));
    }

    static ArrayList<String> getColumns() {
        ArrayList<String> columns = new ArrayList<>();
        columns.add("id");
        columns.add("name");
        columns.add("identification");
        columns.add("course_id");
        return columns;
    }

    public void create(String name, String identification, String course_id) throws SQLException {
        HashMap<String, String> columns = new HashMap<>();
        columns.put("name", name);
        columns.put("identification", identification);
        columns.put("course_id", course_id);
        super.create(columns);
    }

    public void create(String name, String identification, Integer course_id) throws SQLException {
       this.create(name, identification, course_id.toString());
    }

    public ArrayList<HashMap<String, String>> whereUnit(String id) throws SQLException {
        String sql = "SELECT DISTINCT students.* FROM students INNER JOIN student_units ON students.id = student_units.student_id AND student_units.unit_id = " + id;
        return super.query(sql);
    }

    public ArrayList<HashMap<String, String>> whereSemester(String id) throws SQLException {
        String sql = "SELECT DISTINCT students.* FROM students INNER JOIN student_units ON students.id = student_units.student_id AND student_units.semester_id = " + id;
        return super.query(sql);
    }

}

