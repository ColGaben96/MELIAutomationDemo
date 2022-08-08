package com.colgaben.meli.automation.domain.utils;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;

public class WebDriverManager extends PageObject {

    public static Map<String, String> data = new HashMap<>();

    public static void refreshNavigation() {
        Serenity.getDriver().navigate().refresh();
    }

    public static void goBackwards() {
        Serenity.getDriver().navigate().back();
    }

    public static void goForward() {
        Serenity.getDriver().navigate().forward();
    }

    public static void switchToWindow(String windowHandle) {
        Serenity.getDriver().switchTo().window(windowHandle);
    }
    public static void switchToFrame(WebElement iframe) {
        Serenity.getDriver().switchTo().frame(iframe);
    }
    public static void switchToOriginalContent() {Serenity.getDriver().switchTo().defaultContent();}

    public static void newTab() {
        Serenity.getDriver().switchTo().newWindow(WindowType.TAB);
    }

    public static void newWindow() {
        Serenity.getDriver().switchTo().newWindow(WindowType.WINDOW);
    }

    public static void closeCurrentTab() {
        Serenity.getDriver().close();
    }

    public static void hoverToElement(WebElementFacade element) {
        var actions = new Actions(Serenity.getDriver());
        actions.moveToElement(element).perform();
    }

    public static void goToUrl(String url) {
        Serenity.getDriver().navigate().to(url);
    }
}

