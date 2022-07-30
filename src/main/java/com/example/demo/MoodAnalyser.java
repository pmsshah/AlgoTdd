package com.example.demo;

public class MoodAnalyser {
    public static void main(String[] args) {
        System.out.println("Hello Mood Analyser");
    }

    public String analyseMood(String message) {
        if (message.contains(("sad"))) {
            return "SAD";
        }
        return "HAPPY";
    }
}
