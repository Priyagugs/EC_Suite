package com.ssp.wj_pages;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
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
import com.ssp.utils.ElementLayer;
import com.ssp.utils.GenericUtils;
import com.ssp.utils.WaitUtils;

public class DeclinedPage extends LoadableComponent<DeclinedPage> {

	private final WebDriver driver;
	private ExtentTest extentedReport;
	private String sspURL;
	private boolean isPageLoaded;
	public String spinner = "div.spinning-on-load-bg-table-active";
	public final String ERROR_MSG_LOGIN = "We do not recognise your details. Please re-enter your credentials";

	//Previous Loss screen objects
	@FindBy(xpath = "//button[@id='C1__BUT_2913A5FDBA5243B93675222']")
	WebElement BtnGoBackAndEditMyQuote;

	@FindBy(css = "C1__BUT_2913A5FDBA5243B93675229")
	WebElement BtnSaveAndExit;
	
	@FindBy(xpath = "//*[@id='C1__TXT_2913A5FDBA5243B93297212']//strong")
	WebElement TxtDeclinedQuote;

	public DeclinedPage(WebDriver driver, String url, ExtentTest report) {
		this(driver, report);
		sspURL = url;
		
	}	
	
	public DeclinedPage(WebDriver driver, ExtentTest report) {
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
	
	public void DeclinedQuote(ExtentTest extentedReport) throws Exception {
			try{
				if(TxtDeclinedQuote.isDisplayed()){
				Log.message("Displayed TxtDeclinedQuote" + TxtDeclinedQuote.getText(), driver, extentedReport);
				}else{
				Log.message("TxtDeclinedQuote is not displayed ", driver, extentedReport);	
				throw new Exception("Failure");
				}
			}catch (Exception e) {
				throw new Exception("Error while checking TxtDeclinedQuote : " + e);
			}
	}
	
	public void SaveAndExit(ExtentTest extentedReport) throws Exception {
		try{
			WaitUtils.waitForElement(driver, BtnSaveAndExit);
			BtnSaveAndExit.click();
			Log.message("Clicked BtnSaveAndExit", driver, extentedReport);	
		}catch (Exception e) {
			throw new Exception("Error while clicking BtnSaveAndExit : " + e);
		}
}
	
	public GeneralInformation click_GoBackAndEditMyQuote(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnGoBackAndEditMyQuote);
			Actions action = new Actions(driver);
	        action.moveToElement(BtnGoBackAndEditMyQuote).click().perform();
			WaitUtils.waitForSpinner(driver);
			Log.message("Message - Clicked BtnGoBackAndEditMyQuote", driver, extentedReport);
			return new GeneralInformation(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking BtnGoBackAndEditMyQuote " + e);
		}
	}
}