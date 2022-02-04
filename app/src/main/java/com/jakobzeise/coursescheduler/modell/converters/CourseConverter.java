package com.jakobzeise.coursescheduler.modell.converters;

import com.google.gson.Gson;
import com.jakobzeise.coursescheduler.modell.dataclasses.Course;
import com.jakobzeise.coursescheduler.modell.dataclasses.ListCourse;

import java.util.List;

public class CourseConverter {

    public static String stringFromObject(List<Course> list) {

        Gson gson = new Gson();
        return gson.toJson(list);

    }

    public static List<Course> getObjectFromString(String jsonString) {


        Gson gson = new Gson();
        ListCourse data = gson.fromJson(jsonString, ListCourse.class);

        return data.getCourseList();
    }
}
