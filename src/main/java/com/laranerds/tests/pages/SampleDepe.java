package com.laranerds.tests.pages;

import com.laranerds.tests.annotations.Page;
import com.laranerds.tests.annotations.Report;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class SampleDepe {

    @FindBy(name = "Continue")
    private WebElement searchTextBox;

    @Report("display Method is Called")
    public void displayMethod() {
//        System.out.println("Displaying the method 1");
//        searchTextBox.click();
    }

    @Report("display Method2 is Called")
    public void displayMethod2() {
        System.out.println(" ");
    }


    public void displayMethod3() {
        System.out.println(" ");
    }
}
