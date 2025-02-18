package com.automation.pages.ui;

public interface ExperiencesFilterPage {

    void selectPriceRange(String minimumPrice, String maximumPrice);

    default void selectActivityType(String activityType){

    }
}
