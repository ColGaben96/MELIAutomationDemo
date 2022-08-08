package com.colgaben.meli.automation.domain.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverSetup {

    private ChromeOptions chromeOptions = new ChromeOptions();
    private FirefoxOptions firefoxOptions = new FirefoxOptions();
    private EdgeOptions edgeOptions = new EdgeOptions();

    public WebDriver chromeDriver() {
        WebDriverManager.chromedriver().setup();
        var driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver firefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        var driver = new FirefoxDriver(firefoxOptions);
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver edgeDriver() {
        WebDriverManager.edgedriver().setup();
        var driver = new EdgeDriver(edgeOptions);
        driver.manage().window().maximize();
        return driver;
    }
}

