package com.jakobzeise.coursescheduler.modell.converters;

import androidx.room.TypeConverter;

import java.util.Arrays;
import java.util.List;

public class StringListConverter {


    @TypeConverter
    public List<String> fromString(String stringListString) {
        return Arrays.asList(stringListString.split(","));
    }

    @TypeConverter
    public String toString(List<String> stringList) {
        return String.join(",", stringList);
    }

}




