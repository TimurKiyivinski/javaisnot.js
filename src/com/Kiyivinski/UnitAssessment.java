package com.Kiyivinski;

import java.util.ArrayList;

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
}
