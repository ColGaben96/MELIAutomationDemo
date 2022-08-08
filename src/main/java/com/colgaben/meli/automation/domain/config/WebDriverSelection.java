package com.colgaben.meli.automation.domain.config;

import com.colgaben.meli.automation.domain.utils.WebDriverManager;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;

public class WebDriverSelection implements DriverSource {

    public WebDriver selectWebDriver(String driver) {
        var webDriverSetup = new WebDriverSetup();
        switch (driver) {
            case "firefox" -> {
                Serenity.recordReportData().withTitle("Browser").andContents("firefox");
                return webDriverSetup.firefoxDriver();
            }
            case "chrome" -> {
                Serenity.recordReportData().withTitle("Browser").andContents("chrome");
                return webDriverSetup.chromeDriver();
            }
            case "edge" -> {
                Serenity.recordReportData().withTitle("Browser").andContents("edge");
                return webDriverSetup.edgeDriver();
            }
        }
        return null;
    }

    @Override
    public WebDriver newDriver() {
        return selectWebDriver(WebDriverManager.data.get("WebBrowser"));
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}

