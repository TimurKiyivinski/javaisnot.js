/**
 * @author      Timothy Kiyui (4316886@students.swinburne.edu.my)
 * @version     0.1
 * @since       19.04.2016
 */

package com.Kiyivinski;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Display {
    public abstract void printModel(ArrayList<HashMap<String, String>> records, ArrayList<String> columns);
    public abstract void printError(String error);
    public abstract void printQuestion(String question);
    public abstract void printHierarchy(ArrayList<String> hierarchy);
    public abstract void printMenu(ArrayList<String> menu, boolean main);
}
