package com.Kiyivinski;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    private static final int MENU_MAIN = 0;
    private static final int MENU_STUDENTS = 1;
    private static final int MENU_STUDENTS_VIEW = 12;
    private static final int MENU_UNITS = 2;
    private static final int MENU_UNITS_SEMESTER = 22;
    private static final int MENU_UNITS_SEMESTER_ASSESSMENT = 221;
    private static final int MENU_COURSES = 3;
    private static final int MENU_SEMESTER = 4;

    public static ArrayList<String> getMenu(int id) {
        ArrayList<String> menu = new ArrayList<>();
        switch (id) {
            case MENU_MAIN:
                menu.add("Students");
                menu.add("Units");
                menu.add("Assessments");
                menu.add("Semesters");
                break;
            case MENU_STUDENTS:
                menu.add("Create");
                menu.add("View");
                menu.add("Delete");
                break;
            case MENU_STUDENTS_VIEW:
                menu.add("Semester");
                menu.add("Units");
                break;
            case MENU_UNITS:
                menu.add("Create");
                menu.add("Semester");
                menu.add("Delete");
                break;
            case MENU_UNITS_SEMESTER:
                menu.add("Assessment");
                break;
            case MENU_UNITS_SEMESTER_ASSESSMENT:
                menu.add("Create");
                menu.add("Grade");
                menu.add("Report");
                break;
            case MENU_COURSES:
                menu.add("Create");
                menu.add("View");
                menu.add("Delete");
                break;
            case MENU_SEMESTER:
                menu.add("Create");
                menu.add("View");
                menu.add("Delete");
                break;
        }
        return menu;
    }

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

        boolean programRunning = true;
        int programMenu = 0;
        ArrayList<String> menuList;

        if (course.connect("192.168.99.100", "root", "password", "java", 3306)) {
            while (programRunning) {
                try {
                    menuList = Main.getMenu(programMenu);
                    myDisplay.printMenu(menuList, programMenu == MENU_MAIN);
                    /*
                    myDisplay.printModel(course.all(), Course.getColumns());
                    myDisplay.printModel(student.all(), Student.getColumns());
                    myDisplay.printModel(unit.all(), Unit.getColumns());
                    myDisplay.printModel(semester.all(), Semester.getColumns());
                    myDisplay.printModel(assessment.all(), Assessment.getColumns());
                    myDisplay.printModel(type.all(), Type.getColumns());
                    myDisplay.printModel(studentUnit.all(), StudentUnit.getColumns());
                    myDisplay.printModel(studentAssessment.all(), StudentAssessment.getColumns());
                    myDisplay.printModel(unitAsseessment.all(), UnitAssessment.getColumns());
                    */
                } catch (Exception e) {
                    myDisplay.printError("SQL Error occurred");
                    programRunning = false;
                }
            }
        }
    }
}
