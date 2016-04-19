package com.Kiyivinski;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class UnitAssessment extends Model {
    UnitAssessment(boolean verbose) {
        super(new ActiveRecordModel("unit_assessments", UnitAssessment.getColumns(), verbose));
    }

    static ArrayList<String> getColumns() {
        ArrayList<String> columns = new ArrayList<>();
        columns.add("id");
        columns.add("unit_id");
        columns.add("assessment_id");
        return columns;
    }

    public void create(String unit_id, String assessment_id) throws SQLException {
        HashMap<String, String> columns = new HashMap<>();
        columns.put("unit_id", unit_id);
        columns.put("assessment_id", assessment_id);
        super.create(columns);
    }

    public void create(Integer unit_id, Integer assessment_id) throws SQLException {
        this.create(unit_id.toString(), assessment_id.toString());
    }
}
