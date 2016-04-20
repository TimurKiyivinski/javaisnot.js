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

    public Boolean connect(String hostname, String username, String password, String database, Integer port) {
        return activeRecordModel.connect(hostname, username, password, database, port);
    }

    public ArrayList<HashMap<String, String>> query(String sql) throws SQLException {
        return activeRecordModel.query(sql);
    }

    public ArrayList<HashMap<String, String>> all() throws SQLException {
        return activeRecordModel.all();
    }

    public ArrayList<HashMap<String, String>> find(String id) throws SQLException {
        return activeRecordModel.find(id);
    }

    public ArrayList<HashMap<String, String>> where(String key, String value) throws SQLException {
        return activeRecordModel.where(key, value);
    }

    protected ArrayList<HashMap<String, String>> create(HashMap<String, String> pairs) throws SQLException {
        return activeRecordModel.create(pairs);
    }

    protected ArrayList<HashMap<String, String>> update(Integer id, HashMap<String, String> pairs) throws SQLException {
        return activeRecordModel.update(id, pairs);
    }

    public ArrayList<HashMap<String, String>> delete(String id) throws SQLException {
        return activeRecordModel.delete(id);
    }

    public ArrayList<HashMap<String, String>> delete(String key, String value) throws SQLException {
        return activeRecordModel.delete(key, value);
    }

    public Integer last() throws SQLException {
        ArrayList<HashMap<String, String>> lastInsert = activeRecordModel.last();
        return Integer.parseInt(lastInsert.get(0).get("id"));
    }
}
