package com.expertguide.stepdefinitions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GuideSearchStepsTest {
    
    private GuideSearchSteps steps;
    
    @BeforeEach
    void setUp() {
        steps = new GuideSearchSteps();
    }
    
    @Test
    void testStringToUpperCase() {
        steps.i_have_a_string_input();
        steps.i_set_the_input("hello");
        steps.i_process_the_input();
        steps.the_output_should_be("HELLO");
    }
    
    @Test
    void testStringToUpperCaseWithMixedCase() {
        steps.i_have_a_string_input();
        steps.i_set_the_input("HeLLo");
        steps.i_process_the_input();
        steps.the_output_should_be("HELLO");
    }
    
    @Test
    void testStringToUpperCaseWithNumbers() {
        steps.i_have_a_string_input();
        steps.i_set_the_input("test123");
        steps.i_process_the_input();
        steps.the_output_should_be("TEST123");
    }
}
