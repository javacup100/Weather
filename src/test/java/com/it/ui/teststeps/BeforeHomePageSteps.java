package com.it.ui.teststeps;

//import com.it.hooks.Hooks;
import com.it.ui.pages.DisclaimerPage;
//import com.it.pages.HomePage;
import com.it.ui.pages.LocationAccessPromptPage;
import com.it.ui.pages.PromotionPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class BeforeHomePageSteps extends BaseTest {
    private DisclaimerPage disclaimerPage;
    private LocationAccessPromptPage locationAccessPromptPage;
    private PromotionPage promotionPage;
    public BeforeHomePageSteps() {
    }
    @Given("the app is launched")
    public void launchApp() {
        this.disclaimerPage = new DisclaimerPage(getTestContext().getDriver());
    }

    @When("the disclaimer page appears")
    public void handleDisclaimerPage() {
        Assert.assertTrue(this.disclaimerPage.isDisplayed());
    }

    @Then("the user should accept the disclaimer")
    public void acceptDisclaimerAndProceed() {
            this.disclaimerPage.acceptDisclaimer();
    }

    @Then("location access prompt displayes")
    public void verifyLocationAccessPromptLoaded() {
        this.locationAccessPromptPage = new LocationAccessPromptPage(getTestContext().getDriver());
        Assert.assertTrue(this.locationAccessPromptPage.isDisplayed());
    }
    @Then("the user close the prompt")
    public void closeLocationAccessPrompt() {
        this.locationAccessPromptPage.close();
    }
    @Then("promotion page displayes")
    public void verifyPromotionPageLoaded() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.promotionPage = new PromotionPage(getTestContext().getDriver());
        Assert.assertTrue(this.promotionPage.isDisplayed());
    }
    @Then("the user close the promotion page")
    public void closePromotionPage() {
        this.promotionPage.close();
    }

}

