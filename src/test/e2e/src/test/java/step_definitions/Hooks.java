package step_definitions;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	private static WebDriver driver;
    private static final String WEB_DRIVER_FOLDER = "webdrivers";
    
	@Before
	/**
	 * Delete all cookies at the start of each scenario to avoid shared state
	 * between tests
	 */
	public static WebDriver openBrowser() {
	    if (driver == null) {
	       	 Properties props = System.getProperties();
			        props.setProperty("webdriver.gecko.driver",
			            driversFolder(new File("").getAbsolutePath()) + "geckodriver-64-win.exe");
			    
	           driver = new FirefoxDriver();
	           driver.manage().deleteAllCookies();
	   	       driver.manage().window().setSize(new Dimension(1920, 1080));
	   		
	        }
		return driver;
	}

	// screenshot if scenario is failed
	@After
	public static void embedScreenshot(Scenario scenario) {

		if (scenario.isFailed()) {
			try {
				scenario.write("Current Page URL is " + driver.getCurrentUrl());
				// byte[] screenshot = getScreenshotAs(OutputType.BYTES);
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots.getMessage());
			}

		}
		closeWebBrowser();

	}
	
	public static void closeWebBrowser(){
        if (null != driver){
            driver.quit();
        }
        driver = null;
    }
	
    private static String driversFolder(String path) {
        File file = new File(path);
        for (String item : file.list()) {
            if (WEB_DRIVER_FOLDER.equals(item)) {
                return file.getAbsolutePath() + "/" + WEB_DRIVER_FOLDER + "/";
            }
        }
        return driversFolder(file.getParent());
    }

}