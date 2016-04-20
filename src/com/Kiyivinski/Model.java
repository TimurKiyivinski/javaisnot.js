/**
 * @author      Timothy Kiyui (4316886@students.swinburne.edu.my)
 * @version     0.1
 * @since       19.04.2016
 */

package com.Kiyivinski;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Model {
    private ActiveRecordModel activeRecordModel;
    private static Display display;

    Model(ActiveRecordModel activeRecordModel) {
        this.activeRecordModel = activeRecordModel;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    /**
     * Connect to MariaDB instance
     * @param hostname MySQL hostname
     * @param username MySQL username
     * @param password MySQL password
     * @param database MySQL database
     * @param port MySQL port
     * @return Connection status
     */
    public Boolean connect(String hostname, String username, String password, String database, Integer port) {
        return activeRecordModel.connect(hostname, username, password, database, port);
    }

    /**
     * Run SQL query
     * @param sql Query string
     * @return Values returned by SQL
     * @throws SQLException
     */
    public ArrayList<HashMap<String, String>> query(String sql) throws SQLException {
        return activeRecordModel.query(sql);
    }

    /**
     * Get all resource instances
     * @return Values returned by SQL
     * @throws SQLException
     */
    public ArrayList<HashMap<String, String>> all() throws SQLException {
        return activeRecordModel.all();
    }

    /**
     * Find a resource instance
     * @param id Resource id
     * @return Values returned by SQL
     * @throws SQLException
     */
    public ArrayList<HashMap<String, String>> find(String id) throws SQLException {
        return activeRecordModel.find(id);
    }

    /**
     * Query with where clause
     * @param key
     * @param value
     * @return
     * @throws SQLException
     */
    public ArrayList<HashMap<String, String>> where(String key, String value) throws SQLException {
        return activeRecordModel.where(key, value);
    }

    /**
     * Query with multiple where clauses
     * @param pairs Where clauses in a HashMap
     * @return Values returned by SQL
     * @throws SQLException
     */
    public ArrayList<HashMap<String, String>> where(HashMap<String, String> pairs) throws SQLException {
        return activeRecordModel.where(pairs);
    }

    /**
     * Create a resource instance
     * @param pairs Column, value pairs
     * @return Values returned by SQL
     * @throws SQLException
     */
    protected ArrayList<HashMap<String, String>> create(HashMap<String, String> pairs) throws SQLException {
        return activeRecordModel.create(pairs);
    }

    /**
     * Updates a resource
     * @param id Resource id
     * @param pairs Column, value pairs
     * @return Values returned by SQL
     * @throws SQLException
     */
    protected ArrayList<HashMap<String, String>> update(Integer id, HashMap<String, String> pairs) throws SQLException {
        return activeRecordModel.update(id, pairs);
    }

    /**
     * Deletes a resource
     * @param id Resource id
     * @return Values returned by SQL
     * @throws SQLException
     */
    public ArrayList<HashMap<String, String>> delete(String id) throws SQLException {
        return activeRecordModel.delete(id);
    }

    /**
     * Deletes a resource
     * @param key Column
     * @param value Value
     * @return Values returned by SQL
     * @throws SQLException
     */
    public ArrayList<HashMap<String, String>> delete(String key, String value) throws SQLException {
        return activeRecordModel.delete(key, value);
    }

    /**
     * Gets ID of last inserted resource
     * @return Values returned by SQL
     * @throws SQLException
     */
    public Integer last() throws SQLException {
        ArrayList<HashMap<String, String>> lastInsert = activeRecordModel.last();
        return Integer.parseInt(lastInsert.get(0).get("id"));
    }
}
