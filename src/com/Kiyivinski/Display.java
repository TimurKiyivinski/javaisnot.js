/**
 * @author      Timothy Kiyui (4316886@students.swinburne.edu.my)
 * @version     0.1
 * @since       19.04.2016
 */

package com.Kiyivinski;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Display {
    /**
     * Prints a Model/Resource instance
     * @param records List of records
     * @param columns Columns to print
     */
    public abstract void printModel(ArrayList<HashMap<String, String>> records, ArrayList<String> columns);

    /**
     * Prints an error
     * @param error Error string
     */
    public abstract void printError(String error);

    /**
     * Prints a question
     * @param question Question string
     */
    public abstract void printQuestion(String question);

    /**
     * Generates menu hierarchy
     * @param hierarchy Hierarchy list
     */
    public abstract void printHierarchy(ArrayList<String> hierarchy);

    /**
     * Prints a menu
     * @param menu Menu list
     * @param main Control option for switching between main menu and submenu
     */
    public abstract void printMenu(ArrayList<String> menu, boolean main);
}
