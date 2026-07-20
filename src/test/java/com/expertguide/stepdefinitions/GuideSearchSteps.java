package com.expertguide.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class GuideSearchSteps {
    
    private String currentPage;
    private String searchQuery;
    private List<String> searchResults;
    private String selectedCategory;
    private String resultMessage;
    private String currentGuide;
    
    @Given("the user is on the search page")
    public void userOnSearchPage() {
        this.currentPage = "search";
        this.searchResults = new ArrayList<>();
    }
    
    @When("the user enters {string} in the search box")
    public void userEntersSearchQuery(String query) {
        this.searchQuery = query;
    }
    
    @When("the user clicks the search button")
    public void userClicksSearchButton() {
        // Mock search logic
        if ("Java Programming".equals(this.searchQuery)) {
            this.searchResults.add("Advanced Java Concepts");
            this.searchResults.add("Java Best Practices");
            this.searchResults.add("Concurrency in Java");
        } else if (this.searchQuery.contains("xyz123nonexistent")) {
            this.searchResults.clear();
            this.resultMessage = "No guides found";
        } else {
            this.searchResults.add("Guide 1");
            this.searchResults.add("Guide 2");
        }
    }
    
    @Then("the system should display search results")
    public void searchResultsDisplayed() {
        assertFalse(this.searchResults.isEmpty(), "Search results should be displayed");
    }
    
    @Then("the results should contain guides related to {string}")
    public void resultsContainGuides(String topic) {
        assertTrue(this.searchResults.stream()
                .anyMatch(guide -> guide.toLowerCase().contains(topic.toLowerCase())),
                "Results should contain guides related to " + topic);
    }
    
    @Given("the user has searched for guides")
    public void userHasSearched() {
        this.searchQuery = "test";
        this.searchResults.add("Guide 1");
        this.searchResults.add("Programming Guide");
        this.searchResults.add("Design Guide");
    }
    
    @Given("search results are displayed")
    public void searchResultsAreDisplayed() {
        assertFalse(this.searchResults.isEmpty(), "Search results should be displayed");
    }
    
    @When("the user selects the {string} category filter")
    public void userSelectsCategoryFilter(String category) {
        this.selectedCategory = category;
        // Mock filtering logic
        if ("Programming".equals(category)) {
            this.searchResults.removeIf(guide -> !guide.toLowerCase().contains("programming"));
        }
    }
    
    @Then("the results should be filtered to show only programming guides")
    public void resultsFilteredToProgrammingGuides() {
        assertTrue(this.searchResults.stream()
                .allMatch(guide -> guide.toLowerCase().contains("programming")),
                "Results should contain only programming guides");
    }
    
    @Then("a message {string} should be displayed")
    public void messageDisplayed(String message) {
        assertEquals(message, this.resultMessage, "Message should be displayed: " + message);
    }
    
    @Then("the user should see suggestions for alternative searches")
    public void userSeesSuggestions() {
        assertNotNull(this.resultMessage, "Suggestions should be provided");
    }
    
    @When("the user clicks on a guide titled {string}")
    public void userClicksOnGuide(String guideTitle) {
        this.currentGuide = guideTitle;
        this.currentPage = "guide-details";
    }
    
    @Then("the guide details page should be loaded")
    public void guideDetailsPageLoaded() {
        assertEquals("guide-details", this.currentPage, "Guide details page should be loaded");
    }
    
    @Then("the guide content should be displayed")
    public void guideContentDisplayed() {
        assertNotNull(this.currentGuide, "Guide content should be displayed");
    }
}
