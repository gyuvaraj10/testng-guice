package com.laranerds.tests.pages;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import com.laranerds.tests.annotations.Mobile;
import com.laranerds.tests.annotations.Page;
import com.laranerds.tests.annotations.Report;
import com.laranerds.tests.annotations.Web;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
@Web
public class SampleDepeWeb {

    @FindBy(id = "lst-ib")
    private WebElement searchTextBox;

    WebDriver driver;

    @Inject
    public SampleDepeWeb(@Web Provider<WebDriver> driver) {
        this.driver = driver.get();
    }

    @Report("display Method is Called")
    public void displayMethod() {
        searchTextBox.sendKeys("test123");
    }

    @Report("display Method2 is Called")
    public void displayMethod2() throws Exception{
        driver.get("http://youtube.com");
    }


    public void displayMethod3() {
        driver.get("http://google.com");
    }

}
