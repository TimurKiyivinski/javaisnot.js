package com.Kiyivinski;

import java.util.ArrayList;
import java.util.HashMap;

public class Grade {
    private String id;
    private String name;
    private ArrayList<HashMap<String, String>> assessments;

    Grade(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void add(HashMap<String, String> assessment) {
        assessments.add(assessment);
    }

    public Integer total() {
        Integer total = 0;
        for (HashMap<String, String> assessment: assessments) {
            total += assessment.get('mark');
        }
        return total;
    }

    public Integer percent(Integer overall) {
        return (this.total() / overall) * 100;
    }

    public String grade(Integer overall) {
        Integer percent = this.percent(overall);
        if (percent >= 80)
            return "HD";
        else if (percent >= 70)
            return "D";
        else if (percent >= 60)
            return "C";
        else if (percent >= 50)
            return "P";
        else return "N";
    }

    public static void write(ArrayList<Grade> grades) {
        for (Grade grade: grades) {
            System.out
        }
    }
}
