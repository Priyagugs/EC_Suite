package com.ssp.wj_pages;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class BusinessProperty extends LoadableComponent<BusinessProperty> {

	private final WebDriver driver;
	private ExtentTest extentedReport;
	private String sspURL;
	private boolean isPageLoaded;
	public String spinner = "div.spinning-on-load-bg-table-active";
	public final String ERROR_MSG_LOGIN = "We do not recognise your details. Please re-enter your credentials";

	// Business Details screen objects
	@FindBy(css = "#C9__p1_QUE_C6DF722AF30BABC9946077 > div > label")
	WebElement LblLikeToInsureYourBelonging;
	
	@FindAll({
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_C6DF722AF30BABC9946073']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_C6DF722AF30BABC9946073']//span[contains(text(), 'No')]")
		})
	List<WebElement> BtnLikeToInsureTools;
	
	@FindAll({
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_C6DF722AF30BABC9946081']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_C6DF722AF30BABC9946081']//span[contains(text(), 'No')]")
		})
	List<WebElement> BtnLikeToInsureStock;

	
	@FindAll({
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_C6DF722AF30BABC9946085']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_C6DF722AF30BABC9946085']//span[contains(text(), 'No')]")
		})
	List<WebElement> BtnLikeToInsureStockInTransit;
	
	
	@FindBy(css = "#C9__QUE_C6DF722AF30BABC9946075")
	WebElement TxtToolsMaximumTakeAwayValue;
	
	@FindBy(css = "#C9__QUE_C6DF722AF30BABC9946083")
	WebElement TxtStockMaximumTakeAwayValue;
	
	public BusinessProperty(WebDriver driver, String url, ExtentTest report) {
		this(driver, report);
		sspURL = url;

	}

	public BusinessProperty(WebDriver driver, ExtentTest report) {
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

	/*
	 * public void openURL(){ driver.get(sspURL); }
	 */
	
	public void ToolsMaximumTakeAwayValue(String txtToolsMaximumTakeAwayValue, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, TxtToolsMaximumTakeAwayValue);
			TxtToolsMaximumTakeAwayValue.clear();
			TxtToolsMaximumTakeAwayValue.sendKeys(txtToolsMaximumTakeAwayValue, "\t");
			WaitUtils.waitForSpinner(driver);
			Log.message("Entered TxtToolsMaximumTakeAwayValue : " + txtToolsMaximumTakeAwayValue, driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while entering TxtToolsMaximumTakeAwayValue : " + e);
		}
	}
	
	public void StockMaximumTakeAwayValue(String txtStockMaximumTakeAwayValue, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, TxtStockMaximumTakeAwayValue);
			TxtStockMaximumTakeAwayValue.clear();
			TxtStockMaximumTakeAwayValue.sendKeys(txtStockMaximumTakeAwayValue, "\t");
			WaitUtils.waitForSpinner(driver);
			Log.message("Entered TxtStockMaximumTakeAwayValue : " + txtStockMaximumTakeAwayValue, driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while entering TxtStockMaximumTakeAwayValue : " + e);
		}
	}
	
	public void DoYouLikeToInsureTools(String LiketoInsureTools, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnLikeToInsureTools, 2);
			ElementLayer.clickExpectedValue(BtnLikeToInsureTools, LiketoInsureTools, extentedReport, driver);
			WaitUtils.waitForSpinner(driver);
			Log.message("Selected BtnLikeToInsureTools : " + LiketoInsureTools, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnLikeToInsureTools button : " + e);
		}
	}
	
	public void DoYouLikeToInsureYourStock(String Liketoinsureyourstock, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnLikeToInsureStock, 2);
			ElementLayer.clickExpectedValue(BtnLikeToInsureStock, Liketoinsureyourstock, extentedReport, driver);
			WaitUtils.waitForSpinner(driver);
			Log.message("Selected BtnLiketoinsureyourstock : " + Liketoinsureyourstock, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnLiketoinsureyourstock button : " + e);
		}
	}
	
	public void DoYouLikeToInsureYourStockInTransit(String LikeToInsureYourStockInTransit, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnLikeToInsureStockInTransit, 2);
			ElementLayer.clickExpectedValue(BtnLikeToInsureStockInTransit, LikeToInsureYourStockInTransit, extentedReport, driver);
			WaitUtils.waitForSpinner(driver);
			Log.message("Selected BtnLiketoinsureyourstockintransit : " + LikeToInsureYourStockInTransit, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnLiketoinsureyourstockintransit button : " + e);
		}
	}

	public void VerifyLabelLiketoInsureYourBelongings(ExtentTest extentedReport) throws Exception {
		try {
			//WaitUtils.waitForElement(driver, LblLikeToInsureYourBelonging);
			if (!LblLikeToInsureYourBelonging.isDisplayed()) {
				Log.message(
						"Verified 'Would you like to insure your personal belongings when you take them away from your home?' is not displaying if place of Business has changed from home to Mobile ");
			} else {
				Log.message(
						"'Would you like to insure your personal belongings when you take them away from your home?' is still displaying if place of Business has changed from home to Mobile ",
						driver, extentedReport);
				throw new Exception("Failed");

			}
		}

		catch (Exception e) {
			throw new Exception(
					"Error while Verfying Would you like to insure your personal belongings when you take them away from your home? : "
							+ e);
		}
	}
}