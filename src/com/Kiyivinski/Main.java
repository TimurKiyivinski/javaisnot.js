package com.Kiyivinski;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        boolean verbose = true;

        Model course = new Course(verbose);

        Display myDisplay = new CLIDisplay();

        if (course.connect("192.168.99.100", "root", "password", "java", 3306)) {
            try {
                myDisplay.printModel(course.all(), Course.getColumns());
            } catch (Exception e) {
                myDisplay.printError("SQL Error occurred");
            }
        }
    }
}
