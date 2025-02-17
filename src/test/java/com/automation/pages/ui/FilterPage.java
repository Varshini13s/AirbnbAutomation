package com.automation.pages.ui;

public interface FilterPage {
    void selectPriceRange(String minimumPrice, String maximumPrice);

    void selectAmenities(String amenitiesOption);

    void selectHostLanguage(String hostLanguage);

    void getFilterResult();
}
