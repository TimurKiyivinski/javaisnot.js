package com.Kiyivinski;

public class Assessment {
    private Integer id;
    private String name;
    private Integer mark;
    private Integer type_id;
    private Integer semester_id;

    Assessment(Integer id, String name, Integer mark, Integer type_id, Integer semester_id) {
        this.id = id;
        this.name = name;
        this.mark = mark;
        this.type_id = type_id;
        this.semester_id = semester_id;
    }
}
