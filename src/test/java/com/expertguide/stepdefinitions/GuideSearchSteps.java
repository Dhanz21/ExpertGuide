package com.expertguide.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.*;

public class GuideSearchSteps {
    
    private String input;
    private String output;
    
    @Given("I have a string input")
    public void i_have_a_string_input() {
        this.input = "";
    }
    
    @When("I set the input to {string}")
    public void i_set_the_input(String value) {
        this.input = value;
    }
    
    @When("I process the input")
    public void i_process_the_input() {
        this.output = input.toUpperCase();
    }
    
    @Then("the output should be {string}")
    public void the_output_should_be(String expected) {
        assertEquals(expected, this.output);
    }
}
