package com.Kiyivinski;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Course extends Model {
    Course(boolean verbose) {
        super(new ActiveRecordModel("courses", Course.getColumns(), verbose));
    }

    public static ArrayList<String> getColumns() {
        ArrayList<String> columns = new ArrayList<>();
        columns.add("id");
        columns.add("name");
        return columns;
    }

    public void create(String name) throws SQLException {
        HashMap<String, String> columns = new HashMap<>();
        columns.put("name", name);
        super.create(columns);
    }
}
