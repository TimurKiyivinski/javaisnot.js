package com.Kiyivinski;

import java.util.ArrayList;

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

        ActiveRecordModel modelCourses = new ActiveRecordModel("courses", columnCourses, true);
        ActiveRecordModel modelStudents = new ActiveRecordModel("students", columnStudents, true);
        ActiveRecordModel modelSemesters = new ActiveRecordModel("semesters", columnSemesters, true);
        ActiveRecordModel modelAssessments = new ActiveRecordModel("assessments", columnAssessments, true);
        ActiveRecordModel modelTypes = new ActiveRecordModel("types", columnTypes, true);
        ActiveRecordModel modelUnits = new ActiveRecordModel("units", columnUnits, true);
        ActiveRecordModel modelStudentUnits = new ActiveRecordModel("student_units", columnStudentUnits, true);
        ActiveRecordModel modelStudentAssessments = new ActiveRecordModel("student_assessments", columnStudentAssessments, true);
        ActiveRecordModel modelUnitAssessments = new ActiveRecordModel("unit_assessments", columnUnitAssessments, true);
    }
}
