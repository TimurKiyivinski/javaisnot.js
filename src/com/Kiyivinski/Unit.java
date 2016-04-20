/**
 * @author      Timothy Kiyui (4316886@students.swinburne.edu.my)
 * @version     0.1
 * @since       19.04.2016
 */

package com.Kiyivinski;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Unit extends Model {
    /**
     * Resource Model for units
     * @param verbose  Enable debugging
     */
    Unit(boolean verbose) {
        super(new ActiveRecordModel("units", Unit.getColumns(), verbose));
    }

    /**
     * Gets all columns in resource
     * @return Columns as a list
     */
    static ArrayList<String> getColumns() {
        ArrayList<String> columns = new ArrayList<>();
        columns.add("id");
        columns.add("name");
        columns.add("code");
        return columns;
    }

    /**
     * Creates a resource instance
     * @param name Resource name
     * @param code Resource Unit Code
     * @throws SQLException
     */
    public void create(String name, String code) throws SQLException {
        HashMap<String, String> columns = new HashMap<>();
        columns.put("name", name);
        columns.put("code", code);
        super.create(columns);
    }
}
