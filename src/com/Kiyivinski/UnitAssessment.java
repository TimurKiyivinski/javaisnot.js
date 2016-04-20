/**
 * @author      Timothy Kiyui (4316886@students.swinburne.edu.my)
 * @version     0.1
 * @since       19.04.2016
 */

package com.Kiyivinski;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class UnitAssessment extends Model {
    /**
     * Resource Model for unit_assessments
     * @param verbose  Enable debugging
     */
    UnitAssessment(boolean verbose) {
        super(new ActiveRecordModel("unit_assessments", UnitAssessment.getColumns(), verbose));
    }

    /**
     * Gets all columns in resource
     * @return Columns as a list
     */
    static ArrayList<String> getColumns() {
        ArrayList<String> columns = new ArrayList<>();
        columns.add("id");
        columns.add("unit_id");
        columns.add("assessment_id");
        return columns;
    }

    /**
     * Creates resource instance
     * @param unit_id Resource Unit ID
     * @param assessment_id Resource Assessment ID
     * @throws SQLException
     */
    public void create(String unit_id, String assessment_id) throws SQLException {
        HashMap<String, String> columns = new HashMap<>();
        columns.put("unit_id", unit_id);
        columns.put("assessment_id", assessment_id);
        super.create(columns);
    }

    /**
     * Creates resource instance
     * @param unit_id Resource Unit ID
     * @param assessment_id Resource Assessment ID
     * @throws SQLException
     */
    public void create(Integer unit_id, Integer assessment_id) throws SQLException {
        this.create(unit_id.toString(), assessment_id.toString());
    }
}
