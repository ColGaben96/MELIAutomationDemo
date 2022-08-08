package com.colgaben.meli.automation.stepsdefinitions;

import com.colgaben.meli.automation.data.pages.LandingPage;
import com.colgaben.meli.automation.domain.config.GoogleDataDriver;
import com.colgaben.meli.automation.domain.constants.WebEndpointConstants;
import com.colgaben.meli.automation.domain.utils.WebDriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class CookiesStepsDefinition {

    @Steps
    private LandingPage landingPage;

    @Steps
    private GoogleDataDriver googleDataDriver;

    @Given("^I load the Cookies configuration variables (.*)$")
    public void iLoadTheCookiesConfigurationVariablesRow(int row, DataTable gSheet) {
        googleDataDriver.getDataFromWorkbook(row, gSheet);
    }

    @Given("^Cookies Banner appeared on browser (.*)$")
    public void cookiesBannerAppearedOnBrowser(int row, DataTable gSheet) {
        googleDataDriver.getDataFromWorkbook(row, gSheet);
        WebDriverManager.goToUrl(WebEndpointConstants.HOME_URL);
        Assert.assertTrue(landingPage.cookiesBannerIsVisible());
        Assert.assertFalse(landingPage.cookiesDialogIsVisible());
    }

    @Then("Banner dissapear")
    public void bannerDissapear() {
        Assert.assertFalse(landingPage.cookiesBannerIsVisible());
        Assert.assertFalse(landingPage.cookiesDialogIsVisible());
    }

    @When("I click Understood")
    public void iClickUnderstood() {
        Assert.assertTrue(landingPage.acceptCookiesFromBanner());
    }

    @When("I click Customize Cookies")
    public void iClickCustomizeCookies() {
        Assert.assertTrue(landingPage.customizeCookiesFromBanner());
    }

    @And("I click Save")
    public void iClickSave() {
        Assert.assertTrue(landingPage.saveCookiesOptionsFromDialog());
    }

    @And("I disable Personal Cookies")
    public void iDisablePersonalCookies() {
        Assert.assertFalse(landingPage.disablePersonalCookies());
    }

    @And("I click Close")
    public void iClickClose() {
        Assert.assertTrue(landingPage.closeCookiesDialog());
    }
}
