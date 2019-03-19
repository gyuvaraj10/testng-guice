package com.laranerds.tests.configuration;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileDriverProvider implements Provider<WebDriver> {

    @Inject
    @Named("app.platform.os")
    private String browser;

    @Inject
    @Named("test.grid.url")
    private String gridUrl;

    public WebDriver get() {
        WebDriver driver = null;
        try {
            switch (browser.toLowerCase()) {
                case "chrome":  {
                    DesiredCapabilities capability = DesiredCapabilities.chrome();
                    driver = new EventFiringWebDriver(new ChromeDriver(capability));
                    break;
                }
                case "android":
                    driver = new AndroidDriver(new URL(gridUrl), getRemoteDriverCapabilities());
                    break;

                case "ios":
                    driver = new IOSDriver<>(new URL(gridUrl), getRemoteDriverCapabilities());
                    break;
                default: {
                    driver = new ChromeDriver();
                    break;
                }
            }
        } catch (MalformedURLException e) {
        }
        return driver;
    }

    /**
     * implement a strategy to read the chrome capabilities
     * @return
     */
    private Capabilities getRemoteDriverCapabilities(){
        return null;
//        Properties properties = PropertyMap.getInstance().getProperties();
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        properties.entrySet().forEach(entry -> {
//            if(entry.getKey().toString().contains(DESIRED_CAPABILITIES_KEY)) {
//                String key = entry.getKey().toString().split(DESIRED_CAPABILITIES_KEY)[1];
//                desiredCapabilities.setCapability(key, entry.getValue());
//            }
//        });
//        return desiredCapabilities;
    }

}
