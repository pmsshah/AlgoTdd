package com.example.demo;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

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

    @ParameterizedTest
    @MethodSource
    void addTwoNumbers(int val1, int val2, int expected) {
        //System.out.println("addTwoNumbers");
        Assertions.assertEquals(expected, val1+val2);
    }

    private static Stream<Arguments> addTwoNumbers() {
        return Stream.of(
                arguments(10, 10, 20),
                arguments(20, 20, 40),
                arguments(30, 30, 60)
        );
    }
}
