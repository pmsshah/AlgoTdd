package com.example.demo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoodAnalyserTest {
    @Test
    void testMoodAnalysis() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood = moodAnalyser.analyseMood("This is a sad message");
        Assert.assertEquals("SAD", mood);
    }

    @ParameterizedTest
    @ValueSource(strings = { "Really sad", "sad?", "sad message is.." })
    void testSadMood(String input) {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood = moodAnalyser.analyseMood(input);
        Assert.assertEquals("SAD", mood);
    }

    @ParameterizedTest
    @ValueSource(strings = { "Happy", "Happy?", "really we are" })
    void testHappyMood(String input) {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood = moodAnalyser.analyseMood(input);
        Assert.assertEquals("HAPPY", mood);
    }

}
