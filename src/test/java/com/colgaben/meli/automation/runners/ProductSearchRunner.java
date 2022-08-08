package com.colgaben.meli.automation.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/ProductSearch.feature",
        glue = "com.colgaben.meli.automation.stepsdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@search-menu"
)
public class ProductSearchRunner {
}
