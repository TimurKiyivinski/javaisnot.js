package com.Kiyivinski;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Display {
    public abstract void printModel(ArrayList<HashMap<String, String>> records, ArrayList<String> columns);
    public abstract void printError(String error);
}
