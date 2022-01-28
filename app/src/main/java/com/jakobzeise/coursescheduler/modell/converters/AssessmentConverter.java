package com.jakobzeise.coursescheduler.modell.converters;

import com.google.gson.Gson;
import com.jakobzeise.coursescheduler.modell.dataclasses.Assessment;
import com.jakobzeise.coursescheduler.modell.dataclasses.ListAssessment;

import java.util.List;

public class AssessmentConverter {

    public static String stringFromObject(List<Assessment> list){

        Gson gson = new Gson();
        String jsonString = gson.toJson(list);
        return jsonString;

    }

    public static List<Assessment> getObjectFromString(String jsonString){


        Gson gson = new Gson();
        ListAssessment data = gson.fromJson(jsonString, ListAssessment.class);

        return data.getAssessmentList();
    }


}
