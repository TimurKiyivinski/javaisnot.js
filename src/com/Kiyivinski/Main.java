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
    private static final int MENU_COURSES = 3;
    private static final int MENU_SEMESTER = 4;

    private static final int INPUT_MAIN_STUDENTS = 1;
    private static final int INPUT_MAIN_UNITS = 2;
    private static final int INPUT_MAIN_COURSES = 3;
    private static final int INPUT_MAIN_SEMESTERS = 4;
    private static final int INPUT_MAIN_EXIT = 5;

    private static final int INPUT_STUDENTS_CREATE = 1;
    private static final int INPUT_STUDENTS_VIEW = 2;
    private static final int INPUT_STUDENTS_DELETE = 3;
    private static final int INPUT_STUDENTS_BACK = 4;

    private static final int INPUT_STUDENTS_VIEW_SEMESTER = 1;
    private static final int INPUT_STUDENTS_VIEW_UNITS = 2;
    private static final int INPUT_STUDENTS_VIEW_BACK= 3;

    private static final int INPUT_UNITS_CREATE = 1;
    private static final int INPUT_UNITS_VIEW = 2;
    private static final int INPUT_UNITS_SEMESTER = 3;
    private static final int INPUT_UNITS_DELETE = 4;
    private static final int INPUT_UNITS_BACK = 5;

    private static final int INPUT_UNITS_SEMESTER_CREATE = 1;
    private static final int INPUT_UNITS_SEMESTER_GRADE = 2;
    private static final int INPUT_UNITS_SEMESTER_REPORT = 3;
    private static final int INPUT_UNITS_SEMESTER_ADD = 4;
    private static final int INPUT_UNITS_SEMESTER_ASSIGN = 5;
    private static final int INPUT_UNITS_SEMESTER_BACK = 6;

    private static final int INPUT_COURSES_CREATE = 1;
    private static final int INPUT_COURSES_VIEW = 2;
    private static final int INPUT_COURSES_DELETE = 3;
    private static final int INPUT_COURSES_BACK = 4;

    private static final int INPUT_SEMESTER_CREATE = 1;
    private static final int INPUT_SEMESTER_VIEW = 2;
    private static final int INPUT_SEMESTER_DELETE = 3;
    private static final int INPUT_SEMESTER_BACK = 4;

    public static ArrayList<String> getMenu(int id) {
        ArrayList<String> menu = new ArrayList<>();
        switch (id) {
            case MENU_MAIN:
                menu.add("Students");           // 1
                menu.add("Units");              // 2
                menu.add("Courses");            // 3
                menu.add("Semesters");          // 4
                break;
            case MENU_STUDENTS:
                menu.add("Create Student");     // 1
                menu.add("View");               // 2
                menu.add("Delete Student");     // 3
                break;
            case MENU_STUDENTS_VIEW:
                menu.add("Semester");           // 1
                menu.add("Units");              // 2
                break;
            case MENU_UNITS:
                menu.add("Create Unit");        // 1
                menu.add("View");               // 2
                menu.add("Semester");           // 3
                menu.add("Delete Unit");        // 4
                break;
            case MENU_UNITS_SEMESTER:
                menu.add("Create Assessment");  // 1
                menu.add("Grade");              // 2
                menu.add("Report");             // 3
                menu.add("Add Student");        // 4
                menu.add("Assign Student");     // 5
                break;
            case MENU_COURSES:
                menu.add("Create");             // 1
                menu.add("View");               // 2
                menu.add("Delete");             // 3
                break;
            case MENU_SEMESTER:
                menu.add("Create");             // 1
                menu.add("View");               // 2
                menu.add("Delete");             // 3
                break;
        }
        return menu;
    }

    public static ArrayList<String> getHierarchy(int id) {
        ArrayList<String> hierarchy = new ArrayList<>();
        switch (id) {
            case MENU_MAIN:
                hierarchy.add("Main");
                break;
            case MENU_STUDENTS:
                hierarchy.add("Main");
                hierarchy.add("Students");
                break;
            case MENU_STUDENTS_VIEW:
                hierarchy.add("Main");
                hierarchy.add("Students");
                hierarchy.add("View");
                break;
            case MENU_UNITS:
                hierarchy.add("Main");
                hierarchy.add("Units");
                break;
            case MENU_UNITS_SEMESTER:
                hierarchy.add("Main");
                hierarchy.add("Units");
                hierarchy.add("Semester");
                break;
            case MENU_COURSES:
                hierarchy.add("Main");
                hierarchy.add("Courses");
                break;
            case MENU_SEMESTER:
                hierarchy.add("Main");
                hierarchy.add("Semester");
                break;
        }
        return hierarchy;
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
        Input myInput = new CLIInput();

        if (course.connect("192.168.99.100", "root", "password", "java", 3306)) {
            boolean programRunning = true;
            int programMenu = 0;
            ArrayList<String> menuList;
            ArrayList<String> hierarchyList;
            String userInput;

            while (programRunning) {
                try {
                    hierarchyList = Main.getHierarchy(programMenu);
                    menuList = Main.getMenu(programMenu);
                    myDisplay.printHierarchy(hierarchyList);
                    myDisplay.printMenu(menuList, programMenu == MENU_MAIN);
                    userInput = myInput.getInput();

                    switch (programMenu) {
                        case MENU_MAIN:
                            if (Integer.parseInt(userInput) == INPUT_MAIN_STUDENTS)
                                programMenu = MENU_STUDENTS;
                            else if (Integer.parseInt(userInput) == INPUT_MAIN_UNITS)
                                programMenu = MENU_UNITS;
                            else if (Integer.parseInt(userInput) == INPUT_MAIN_COURSES)
                                programMenu = MENU_COURSES;
                            else if (Integer.parseInt(userInput) == INPUT_MAIN_SEMESTERS)
                                programMenu = MENU_SEMESTER;
                            else if (Integer.parseInt(userInput) == INPUT_MAIN_EXIT)
                                programRunning = false;
                            break;

                        case MENU_STUDENTS:
                            /* Create Student */
                            if (Integer.parseInt(userInput) == INPUT_STUDENTS_CREATE) {
                                myDisplay.printQuestion("Name:");
                                String inputName = myInput.getInput();

                                myDisplay.printQuestion("ID:");
                                String inputID = myInput.getInput();

                                myDisplay.printQuestion("Course ID:");
                                myDisplay.printModel(course.all(), Course.getColumns());
                                String inputCourse = myInput.getInput();

                                if (course.find(inputCourse).isEmpty())
                                    myDisplay.printError("No such course");
                                else
                                    student.create(inputName, inputID, inputCourse);
                            }
                            /* Navigate to Student View menu */
                            else if (Integer.parseInt(userInput) == INPUT_STUDENTS_VIEW) {
                                programMenu = MENU_STUDENTS_VIEW;
                            }
                            /* Delete Student */
                            else if (Integer.parseInt(userInput) == INPUT_STUDENTS_DELETE) {
                                myDisplay.printQuestion("Student ID:");
                                myDisplay.printModel(student.all(), Student.getColumns());
                                String inputID = myInput.getInput();

                                if (student.find(inputID).isEmpty())
                                    myDisplay.printError("The specified student does not exist.");
                                else
                                    student.delete(inputID);
                            }
                            /* Return to Main menu*/
                            else if (Integer.parseInt(userInput) == INPUT_STUDENTS_BACK) {
                                programMenu = MENU_MAIN;
                            }
                            break;

                        case MENU_STUDENTS_VIEW:
                            /* List Students by Semester */
                            if (Integer.parseInt(userInput) == INPUT_STUDENTS_VIEW_SEMESTER) {
                                myDisplay.printQuestion("Semester ID:");
                                myDisplay.printModel(semester.all(), Semester.getColumns());
                                String inputID = myInput.getInput();

                                if (semester.find(inputID).isEmpty())
                                    myDisplay.printError("The specified semester does not exist.");
                                else
                                    myDisplay.printModel(student.whereSemester(inputID), Student.getColumns());
                            }
                            /* List Students by Unit */
                            else if (Integer.parseInt(userInput) == INPUT_STUDENTS_VIEW_UNITS) {
                                myDisplay.printQuestion("Unit ID:");
                                myDisplay.printModel(unit.all(), Unit.getColumns());
                                String inputID = myInput.getInput();

                                if (unit.find(inputID).isEmpty())
                                    myDisplay.printError("The specified unit does not exist.");
                                else
                                    myDisplay.printModel(student.whereUnit(inputID), Student.getColumns());
                            }
                            /* Return to Student menu */
                            else if (Integer.parseInt(userInput) == INPUT_STUDENTS_VIEW_BACK) {
                                programMenu = MENU_STUDENTS;
                            }
                            break;

                        case MENU_UNITS:
                            /* Create Unit */
                            if (Integer.parseInt(userInput) == INPUT_UNITS_CREATE) {
                                myDisplay.printQuestion("Name:");
                                String inputName = myInput.getInput();

                                myDisplay.printQuestion("Code:");
                                String inputCode = myInput.getInput();

                                if (unit.where("code", inputCode).isEmpty())
                                    unit.create(inputName, inputCode);
                                else
                                    myDisplay.printError("A unit with that code already exists.");
                            }
                            /* Lists all Units */
                            else if (Integer.parseInt(userInput) == INPUT_UNITS_VIEW) {
                                myDisplay.printModel(unit.all(), Unit.getColumns());
                            }
                            /* Navigate to Unit Semester menu */
                            else if (Integer.parseInt(userInput) == INPUT_UNITS_SEMESTER) {
                                programMenu = MENU_UNITS_SEMESTER;
                            }
                            /* Delete Unit */
                            else if (Integer.parseInt(userInput) == INPUT_UNITS_DELETE) {
                                myDisplay.printModel(unit.all(), Unit.getColumns());
                                myDisplay.printQuestion("Unit ID:");
                                String inputID = myInput.getInput();

                                if (unit.find(inputID).isEmpty())
                                    myDisplay.printError("The specified unit does not exist.");
                                else
                                    unit.delete(inputID);
                            }
                            /* Return to Main menu*/
                            else if (Integer.parseInt(userInput) == INPUT_UNITS_BACK) {
                                programMenu = MENU_MAIN;
                            }
                            break;

                        case MENU_UNITS_SEMESTER:
                            /* Create Assessment under specific Semester */
                            if (Integer.parseInt(userInput) == INPUT_UNITS_SEMESTER_CREATE) {
                                // TODO:
                            }
                            /* Grade all Students based on an Assessment */
                            else if (Integer.parseInt(userInput) == INPUT_UNITS_SEMESTER_GRADE) {
                                // TODO:
                            }
                            /* Generate Student performance report */
                            else if (Integer.parseInt(userInput) == INPUT_UNITS_SEMESTER_REPORT) {
                                // TODO:
                            }
                            /* Add Student to Unit this Semester */
                            else if (Integer.parseInt(userInput) == INPUT_UNITS_SEMESTER_ADD) {
                                // TODO:
                            }
                            /* Assign Student to Assessment this Semester */
                            else if (Integer.parseInt(userInput) == INPUT_UNITS_SEMESTER_ASSIGN) {
                                // TODO:
                            }
                            /* Return to Unit menu */
                            else if (Integer.parseInt(userInput) == INPUT_UNITS_SEMESTER_BACK) {
                                programMenu = MENU_UNITS;
                            }
                            break;

                        case MENU_COURSES:
                            /* Create Course */
                            if (Integer.parseInt(userInput) == INPUT_COURSES_CREATE) {
                                myDisplay.printQuestion("Name:");
                                String inputName = myInput.getInput();

                                course.create(inputName);
                            }
                            /* Lists all Courses */
                            else if (Integer.parseInt(userInput) == INPUT_COURSES_VIEW) {
                                myDisplay.printModel(course.all(), Course.getColumns());
                            }
                            /* Delete Course */
                            else if (Integer.parseInt(userInput) == INPUT_COURSES_DELETE) {
                                myDisplay.printModel(course.all(), Course.getColumns());
                                myDisplay.printQuestion("Course ID:");
                                String inputID = myInput.getInput();

                                if (course.find(inputID).isEmpty())
                                    myDisplay.printError("The specified unit does not exist.");
                                else
                                    course.delete(inputID);
                            }
                            /* Return to Main menu*/
                            else if (Integer.parseInt(userInput) == INPUT_COURSES_BACK) {
                                programMenu = MENU_MAIN;
                            }
                            break;

                        case MENU_SEMESTER:
                            /* Create Semester */
                            if (Integer.parseInt(userInput) == INPUT_SEMESTER_CREATE) {
                                myDisplay.printQuestion("Name:");
                                String inputName = myInput.getInput();

                                semester.create(inputName);
                            }
                            /* Lists all Semesters */
                            else if (Integer.parseInt(userInput) == INPUT_SEMESTER_VIEW) {
                                myDisplay.printModel(semester.all(), Semester.getColumns());
                            }
                            /* Delete Semester */
                            else if (Integer.parseInt(userInput) == INPUT_SEMESTER_DELETE) {
                                myDisplay.printModel(semester.all(), Semester.getColumns());
                                myDisplay.printQuestion("Semester ID:");
                                String inputID = myInput.getInput();

                                if (semester.find(inputID).isEmpty())
                                    myDisplay.printError("The specified unit does not exist.");
                                else
                                    semester.delete(inputID);
                            }
                            /* Return to Main menu*/
                            else if (Integer.parseInt(userInput) == INPUT_SEMESTER_BACK) {
                                programMenu = MENU_MAIN;
                            }
                            break;
                    }
                } catch (SQLException e) {
                    myDisplay.printError("SQL Error occurred");
                    programRunning = false;
                }
            }
        }
    }
}
