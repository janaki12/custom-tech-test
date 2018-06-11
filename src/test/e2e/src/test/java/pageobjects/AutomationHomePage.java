package pageobjects;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import enums.Url;
public class AutomationHomePage extends BaseClass{
	private final By renderChallengeBtnLocator= By.cssSelector("[data-test-id=render-challenge]");
    private final By sectionChallengeLocator = By.id("challenge");
    private final By rowsLocator = By.cssSelector("[id=\"challenge\"] table tbody tr");
    private final String answerFormat= "[id^=undefined-submitchallenge%s]";
    private final By submitChallengeLocator = By.cssSelector(".challenge button");
	
	public AutomationHomePage(WebDriver driver){
		super(driver);
	}    

	 public void navigateToHomePage() {
	        String url = Url.BASEURL.getURL();
	        System.out.println("Navigating to Home Page " + url);
	        navigateToURL(url);
	    	waitUntilElementIsDisplayedOnScreen(renderChallengeBtnLocator);
	 }
	 
	 public void clickRenderChallenge() {
		 click(renderChallengeBtnLocator);
		 waitUntilElementIsDisplayedOnScreen(sectionChallengeLocator);
	 }
	 
	 public void provideAnswers() throws InterruptedException {
		 int i=0;
		 for(WebElement row:getElements(rowsLocator)) {
			 i++;
			 List<WebElement> columns = row.findElements(By.cssSelector("td"));
			 enterText(By.cssSelector(String.format(answerFormat, i)),checkIndex(toIntegerArray(columns))!=-1?String.valueOf(checkIndex(toIntegerArray(columns))):null);  
		 }
		 Thread.sleep(1000);
			
	 }
	 
	 
	 public void clickSubmitChallenge() {
		  click(submitChallengeLocator);
	 }
	
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	