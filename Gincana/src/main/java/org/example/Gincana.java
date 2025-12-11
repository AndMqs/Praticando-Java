package org.example;

import java.util.ArrayList;

public class Gincana {

    public static String[] substringStr(String[] input){
        ArrayList<String> substrings = new ArrayList<>();

        for(int i = 0; i < input.length;i++){
            for(String str : input) {
                if (!str.equals(input[i]) && str.contains(input[i])) {
                    substrings.add(input[i]);
                    break;
                }
            }
        }
        return substrings.toArray(new String[0]);
    }
}