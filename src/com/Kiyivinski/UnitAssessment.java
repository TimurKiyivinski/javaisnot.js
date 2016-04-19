package com.Kiyivinski;

import java.util.ArrayList;

public class UnitAssessment {
    private Integer id;
    private Integer unit_id;
    private Integer assessment_id;

    UnitAssessment(Integer id, Integer unit_id, Integer assessment_id) {
        this.id = id;
        this.unit_id = unit_id;
        this.assessment_id = assessment_id;
    }

    static ArrayList<String> getColumns() {
        ArrayList<String> columns = new ArrayList<>();
        columns.add("id");
        columns.add("unit_id");
        columns.add("assessment_id");
        return columns;
    }
}
