package com.Kiyivinski;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

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

    public void create(String name, String code) throws SQLException {
        HashMap<String, String> columns = new HashMap<>();
        columns.put("name", name);
        columns.put("code", code);
        super.create(columns);
    }
}
