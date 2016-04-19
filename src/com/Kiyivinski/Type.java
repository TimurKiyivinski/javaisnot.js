package com.Kiyivinski;

import java.util.ArrayList;

public class Type extends Model {
    Type(boolean verbose) {
        super(new ActiveRecordModel("types", Type.getColumns(), verbose));
    }

    static ArrayList<String> getColumns() {
        ArrayList<String> columns = new ArrayList<>();
        columns.add("id");
        columns.add("name");
        return columns;
    }
}
