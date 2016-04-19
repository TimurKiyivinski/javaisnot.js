package com.Kiyivinski;

import java.util.ArrayList;
import java.util.HashMap;

public class CLIDisplay extends Display{
    public void print(String s) {
        System.out.print(s);
    }

    public void prints(String s) {
        this.print(s + "\t");
    }

    public void println(String s) {
        System.out.println(s);
    }

    public void line() {
        this.println("");
    }

    public void printError(String error) {
        System.err.println(error);
    }

    public void printModel(ArrayList<HashMap<String, String>> records, ArrayList<String> columns) {
        for (String column: columns) {
            this.prints(column);
        }
        this.line();
        for (HashMap<String, String> record: records) {
            for (String column: columns) {
                this.prints(record.get(column));
            }
            this.line();
        }
    }
}
