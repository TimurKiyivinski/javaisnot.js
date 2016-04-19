package com.Kiyivinski;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> columnCourses = Course.getColumns();
        ArrayList<String> columnStudents = Student.getColumns();
        ArrayList<String> columnSemesters = Semester.getColumns();
        ArrayList<String> columnAssessments = Assessment.getColumns();
        ArrayList<String> columnTypes = Type.getColumns();
        ArrayList<String> columnUnits = Unit.getColumns();
        ArrayList<String> columnStudentUnits = StudentUnit.getColumns();
        ArrayList<String> columnStudentAssessments = StudentAssessment.getColumns();
        ArrayList<String> columnUnitAssessments = UnitAssessment.getColumns();

        boolean verbose = true;

        ActiveRecordModel modelCourses = new ActiveRecordModel("courses", columnCourses, verbose);
        ActiveRecordModel modelStudents = new ActiveRecordModel("students", columnStudents, verbose);
        ActiveRecordModel modelSemesters = new ActiveRecordModel("semesters", columnSemesters, verbose);
        ActiveRecordModel modelAssessments = new ActiveRecordModel("assessments", columnAssessments, verbose);
        ActiveRecordModel modelTypes = new ActiveRecordModel("types", columnTypes, verbose);
        ActiveRecordModel modelUnits = new ActiveRecordModel("units", columnUnits, verbose);
        ActiveRecordModel modelStudentUnits = new ActiveRecordModel("student_units", columnStudentUnits, verbose);
        ActiveRecordModel modelStudentAssessments = new ActiveRecordModel("student_assessments", columnStudentAssessments, verbose);
        ActiveRecordModel modelUnitAssessments = new ActiveRecordModel("unit_assessments", columnUnitAssessments, verbose);

        Display myDisplay = new CLIDisplay();

        if (modelCourses.connect("192.168.99.100", "root", "password", "java", 3306)) {
            try {
                HashMap<String, String> course = new HashMap<>();
                course.put("name", "Business Science");
                modelCourses.update(1, course);
                myDisplay.printModel(modelCourses.all(), columnCourses);
            } catch (SQLException e) {
                myDisplay.printError("SQL Error occurred");
            }
        }
    }
}
