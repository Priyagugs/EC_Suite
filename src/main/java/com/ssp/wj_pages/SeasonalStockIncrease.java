package com.ssp.wj_pages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentTest;
import com.ssp.support.Log;
import com.ssp.support.StopWatch;
import com.ssp.utils.GenericUtils;
import com.ssp.utils.WaitUtils;

public class SeasonalStockIncrease extends LoadableComponent<SeasonalStockIncrease> {

	private final WebDriver driver;
	private ExtentTest extentedReport;
	private String sspURL;
	private boolean isPageLoaded;
	public String spinner = "div.spinning-on-load-bg-table-active";
	public final String ERROR_MSG_LOGIN = "We do not recognise your details. Please re-enter your credentials";

	//Your Public Liability Cover screen objects
	@FindBy(xpath = "//*[@id='C1__QUE_48BDF1EEA3569326412782']")
	WebElement FirstMonthChoice;

	@FindBy(xpath = "//*[@id='C1__QUE_48BDF1EEA3569326412785']")
	WebElement SecondMonthChoice;
	
	@FindBy(css = "#C1__BUT_48BDF1EEA3569326413916")
	WebElement btnCheckOut;

	public SeasonalStockIncrease(WebDriver driver, String url, ExtentTest report) {
		this(driver, report);
		sspURL = url;
		
	}	
	
	public SeasonalStockIncrease(WebDriver driver, ExtentTest report) {
		this.driver = driver;
		this.extentedReport = report;
		PageFactory.initElements(driver, this);
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		isPageLoaded = true;
	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		if (!isPageLoaded) {
			Assert.fail();
		}
	}
	
	/*public void openURL(){
		driver.get(sspURL);
	}*/
	
	
	public void SelectFirstMonthChoice(String firstMonthChoice, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, FirstMonthChoice);
			new Select(FirstMonthChoice).selectByVisibleText(firstMonthChoice);
			Log.message("Selected FirstMonthChoice : " + firstMonthChoice, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting FirstMonthChoice detail : " + e);
		}
	}
	public void SelectSecondMonthChoice(String secondMonthChoice, ExtentTest extentedReport) throws Exception {
		try {
			
			WaitUtils.waitForElement(driver, SecondMonthChoice);
			Thread.sleep(3000);
			new Select(SecondMonthChoice).selectByVisibleText(secondMonthChoice);
			Log.message("Selected secondMonthChoice : " + secondMonthChoice, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting secondMonthChoice detail : " + e);
		}
	}
	
	public void VerifyPageDisplaying(ExtentTest extentedReport) throws Exception {
		try {
		
			WaitUtils.waitForElement(driver, FirstMonthChoice);
			if(!FirstMonthChoice.isDisplayed())
			{
				
				Log.message("Verified SeasonalStockIncrease Page is not displaying for Mobile Business", driver, extentedReport);
				
			}
			else{
				Log.message("Error while Verifying SeasonalStockIncrease Page for Mobile Business", driver, extentedReport);
				throw new Exception("Failed");
				}
			 }
			
		catch (Exception e) {
			throw new Exception("Error while Verifying SeasonalStockIncrease Page for Mobile Business : " + e);
		}

	}
			
	
public Payment click_GoToCheckOut(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnCheckOut);
			Thread.sleep(3000);
			Actions actions = new Actions(driver);
			actions.moveToElement(btnCheckOut).click().perform();
			// btnSignIn.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Message - Clicked btnCheckOut button", driver, extentedReport);
		
			return new Payment(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking btnCheckOut button: " + e);
		}
	}

}