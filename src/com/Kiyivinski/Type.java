/**
 * @author      Timothy Kiyui (4316886@students.swinburne.edu.my)
 * @version     0.1
 * @since       19.04.2016
 */

package com.Kiyivinski;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Type extends Model {
    /**
     * Resource Model for types
     * @param verbose  Enable debugging
     */
    Type(boolean verbose) {
        super(new ActiveRecordModel("types", Type.getColumns(), verbose));
    }

    /**
     * Gets all columns in resource
     * @return Columns as a list
     */
    static ArrayList<String> getColumns() {
        ArrayList<String> columns = new ArrayList<>();
        columns.add("id");
        columns.add("name");
        return columns;
    }

    /**
     * Creates a resource instance
     * @param name Resource name
     * @throws SQLException
     */
    public void create(String name) throws SQLException {
        HashMap<String, String> columns = new HashMap<>();
        columns.put("name", name);
        super.create(columns);
    }
}
