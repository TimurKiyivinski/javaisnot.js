package com.Kiyivinski;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        boolean verbose = false;

        Course course = new Course(verbose);
        Student student = new Student(verbose);
        Unit unit = new Unit(verbose);
        Semester semester = new Semester(verbose);
        Assessment assessment = new Assessment(verbose);
        Type type = new Type(verbose);
        StudentUnit studentUnit = new StudentUnit(verbose);
        StudentAssessment studentAssessment = new StudentAssessment(verbose);
        UnitAssessment unitAsseessment = new UnitAssessment(verbose);

        Display myDisplay = new CLIDisplay();

        if (course.connect("192.168.99.100", "root", "password", "java", 3306)) {
            try {
                myDisplay.printModel(course.all(), Course.getColumns());
                myDisplay.printModel(student.all(), Student.getColumns());
                myDisplay.printModel(unit.all(), Unit.getColumns());
                myDisplay.printModel(semester.all(), Semester.getColumns());
                myDisplay.printModel(assessment.all(), Assessment.getColumns());
                myDisplay.printModel(type.all(), Type.getColumns());
                myDisplay.printModel(studentUnit.all(), StudentUnit.getColumns());
                myDisplay.printModel(studentAssessment.all(), StudentAssessment.getColumns());
                myDisplay.printModel(unitAsseessment.all(), UnitAssessment.getColumns());
            } catch (Exception e) {
                myDisplay.printError("SQL Error occurred");
            }
        }
    }
}
