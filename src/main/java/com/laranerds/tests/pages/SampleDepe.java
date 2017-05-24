package com.laranerds.tests.pages;

import com.laranerds.tests.annotations.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class SampleDepe {

    @FindBy(name = "Continue")
    private WebElement searchTextBox;

    public void displayMethod() {
        System.out.println("Displaying the method 1");
        searchTextBox.click();
    }
}
