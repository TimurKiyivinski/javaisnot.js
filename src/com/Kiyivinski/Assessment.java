package com.Kiyivinski;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Assessment extends Model {
    Assessment(boolean verbose) {
        super(new ActiveRecordModel("assessments", Assessment.getColumns(), verbose));
    }

    static ArrayList<String> getColumns() {
        ArrayList<String> columns = new ArrayList<>();
        columns.add("id");
        columns.add("name");
        columns.add("mark");
        columns.add("type_id");
        columns.add("semester_id");
        return columns;
    }

    public void create(String name, String mark, String type_id, String semester_id) throws SQLException {
        HashMap<String, String> columns = new HashMap<>();
        columns.put("name", name);
        columns.put("mark", mark);
        columns.put("type_id", type_id);
        columns.put("semester_id", semester_id);
        super.create(columns);
    }

    public void create(String name, Integer mark, Integer type_id, Integer semester_id)  throws SQLException {
        this.create(name, mark.toString(), type_id.toString(), semester_id.toString());
    }
}
