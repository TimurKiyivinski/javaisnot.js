package com.Kiyivinski;

import java.util.ArrayList;

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
}
