package pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseClass {
	private static WebDriver driver;
	public static WebDriverWait wait;
	private static int timeout = 10;

	public BaseClass(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By selector) {
		try {
			return driver.findElement(selector);
		} catch (Exception e) {
			System.out.println(String.format("Element %s does not exist - proceeding", selector));
		}
		return null;
	}

	protected void click(By selector) {
		WebElement element = getElement(selector);
		waitForElementToBeClickable(selector);
		try {
			element.click();
		} catch (Exception e) {
			throw new NoSuchElementException(
					String.format("The following element did not display: [%s] ", selector.toString()));
		}
	}

	public void waitForElementToBeClickable(By selector) {
		try {
			wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.elementToBeClickable(selector));
		} catch (Exception e) {
			throw new NoSuchElementException(
					String.format("The following element did not display: [%s] ", selector.toString()));
		}
	}
	
	public void waitForElementToBePresent(By selector) {
		try {
			wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector));
		} catch (Exception e) {
			throw new NoSuchElementException(
					String.format("The following element is not present in the DOM: [%s] ", selector.toString()));
		}
	}

	public void waitUntilElementIsDisplayedOnScreen(By selector) {
		try {
			wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
		} catch (Exception e) {
			throw new NoSuchElementException(String.format("The following element was not visible: %s ", selector));
		}
	}

	public void navigateToURL(String URL) {
		try {
			driver.navigate().to(URL);
		} catch (Exception e) {
			System.out.println("FAILURE: URL did not load: " + URL);
			e.printStackTrace();
		}
	}
	
	 public List<WebElement> getElements(By Selector) {
		   waitUntilElementIsDisplayedOnScreen(Selector);
	        try {
	            return driver.findElements(Selector);
	        } catch (Exception e) {
	            throw new NoSuchElementException(String.format("The following element did not display: [%s] ", Selector.toString()));
	        }
	    }
	 
	 public Integer[] toIntegerArray(List<WebElement> elems){
	       List<Integer> intList = new ArrayList<Integer>();
	         for(WebElement el:elems){
	             intList.add(Integer.valueOf(el.getText().trim()));
	         }
	        return intList.toArray(new Integer[intList.size()]);
	       
	   }
	 
	 protected void enterText(By selector,String value){
	        try {
	        	for(WebElement elem:driver.findElements(selector))
	        	elem.sendKeys(value);
	        } catch (Exception e) {
	            throw new NoSuchElementException(String.format("The following element did not display: [%s] ", selector.toString()));
	        }
	    }
	 
	 public Integer checkIndex(Integer[] data) {
		    Integer sum = 0;
			Integer solution = -1;
			Integer leftSum = 0;
			Integer rightSum = 0;
			for (int i = 0; i < data.length; i++)
				sum += data[i];
		    for (int i = 0; i < data.length; i++){
				rightSum = sum - leftSum - data[i];
				if(rightSum.equals(leftSum)) {
					solution = i;
				}		
				leftSum += data[i];
			}
		    return solution;
		    }
}