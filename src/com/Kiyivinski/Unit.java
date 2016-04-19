package com.Kiyivinski;

import java.util.ArrayList;

public class Unit extends Model {
    Unit(boolean verbose) {
        super(new ActiveRecordModel("units", Unit.getColumns(), verbose));
    }

    static ArrayList<String> getColumns() {
        ArrayList<String> columns = new ArrayList<>();
        columns.add("id");
        columns.add("name");
        columns.add("code");
        return columns;
    }
}
