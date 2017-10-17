package com.laranerds.tests.pages;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.laranerds.tests.annotations.Page;
import com.laranerds.tests.annotations.Report;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class SampleDepe {

    @FindBy(name = "Continue")
    private WebElement searchTextBox;

    @Inject
    Provider<WebDriver> driver;

    @Report("display Method is Called")
    public void displayMethod() {
        driver.get().get("http://amazon.com");
    }

    @Report("display Method2 is Called")
    public void displayMethod2() throws Exception{
        driver.get().get("http://youtube.com");
    }


    public void displayMethod3() {
        driver.get().get("http://google.com");
    }
}
