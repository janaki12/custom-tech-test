package step_definitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.AutomationHomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Helper.Log;


public class ArraysChallenge{
    private  WebDriver driver;
  
    public ArraysChallenge()
    {
     	driver = Hooks.openBrowser();
    }
    
    @Given("^I open automationpractice website$")
    public void i_open_automationpractice_website() throws Throwable {
    	AutomationHomePage homePage = new  AutomationHomePage(driver);
    	homePage.navigateToHomePage();
    	Log.info("Login to http://localost:3000");
    }

    @When("^I click Render Challenge$")
    public void i_click_render_challenge() throws Throwable {
    	AutomationHomePage homePage = new  AutomationHomePage(driver);
    	homePage.clickRenderChallenge();
    	Log.info("Click the Render Challenge button");
    }

    @When("^I fill the answers$")
    public void i_provide_answers_challenge() throws Throwable {
    	AutomationHomePage homePage = new  AutomationHomePage(driver);
    	homePage.provideAnswers();
    	Log.info("Fill in the answers for the Array Challenge");
    }
    
     
    @When("^click Submit answers$")
    public void click_Submit_answers() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	AutomationHomePage homePage = new  AutomationHomePage(driver);
    	homePage.clickSubmitChallenge();
    	Log.info("Submit the answers");
    }
}