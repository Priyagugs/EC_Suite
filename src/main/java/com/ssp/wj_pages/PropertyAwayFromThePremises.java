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

public class PropertyAwayFromThePremises extends LoadableComponent<PropertyAwayFromThePremises> {

	private final WebDriver driver;
	private ExtentTest extentedReport;
	private String sspURL;
	private boolean isPageLoaded;
	public String spinner = "div.spinning-on-load-bg-table-active";
	public final String ERROR_MSG_LOGIN = "We do not recognise your details. Please re-enter your credentials";

	//Property Away From The Premises screen objects

	@FindAll({
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_C6DF722AF30BABC9946073']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_C6DF722AF30BABC9946073']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'radio_C10__QUE_C6DF722AF30BABC9946073']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C10__QUE_C6DF722AF30BABC9946073']//span[contains(text(), 'No')]")
		})
	List<WebElement> BtnPropertyAwayFromPremises;
	
	@FindAll({
		@FindBy(xpath = "//div[@id = 'C9__row_QUE_C6DF722AF30BABC9946077']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'C9__row_QUE_C6DF722AF30BABC9946077']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'C10__row_QUE_C6DF722AF30BABC9946077']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'C10__row_QUE_C6DF722AF30BABC9946077']//span[contains(text(), 'No')]")
		})
	List<WebElement> BtnLiketoInsurePersonalbelongigns;
	
	@FindAll({
		@FindBy(xpath = "//div[@id = 'C9__row_QUE_C6DF722AF30BABC9946081']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'C9__row_QUE_C6DF722AF30BABC9946081']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'C10__row_QUE_C6DF722AF30BABC9946081']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'C10__row_QUE_C6DF722AF30BABC9946081']//span[contains(text(), 'No')]")
		})
	List<WebElement> BtnLiketoinsureyourstock;
	
	@FindAll({
		@FindBy(xpath = "//div[@id = 'C9__row_QUE_C6DF722AF30BABC9946085']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'C9__row_QUE_C6DF722AF30BABC9946085']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'C10__row_QUE_C6DF722AF30BABC9946085']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'C10__row_QUE_C6DF722AF30BABC9946085']//span[contains(text(), 'No')]")
		})
	List<WebElement> BtnLiketoinsureyourstockintransit;
	
	@FindBy(css = "#C9__QUE_C6DF722AF30BABC9946075,#C10__QUE_C6DF722AF30BABC9946075")
	WebElement TxtMaximumTakeAwayValue;
	
	@FindAll({
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_661D54578C2C788A275830']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_661D54578C2C788A275830']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'radio_C10__QUE_661D54578C2C788A275830']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C10__QUE_661D54578C2C788A275830']//span[contains(text(), 'No')]")
		})
	List<WebElement> BtnItemMoreThanWorth2500;
	
	@FindBy(css = "#C9__BUT_006AB5B0B0C7206C1539605,#C10__BUT_006AB5B0B0C7206C1539605")
	WebElement BtnNext;
	
	@FindBy(css = "#C9__QUE_C6DF722AF30BABC9946083,#C10__QUE_C6DF722AF30BABC9946083")
	WebElement TxtMaximumTakeAwayValueofStock;
	


	public PropertyAwayFromThePremises(WebDriver driver, String url, ExtentTest report) {
		this(driver, report);
		sspURL = url;
		
	}	
	
	public PropertyAwayFromThePremises(WebDriver driver, ExtentTest report) {
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
	
	public void PropertyAwayFromPremises(String btnPropertyAwayFromPremises, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnPropertyAwayFromPremises, 5);
			ElementLayer.clickExpectedValue(BtnPropertyAwayFromPremises, btnPropertyAwayFromPremises, extentedReport, driver);
			WaitUtils.waitForSpinner(driver);
			Log.message("Selected BtnPropertyAwayFromPremises : " + btnPropertyAwayFromPremises, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnPropertyAwayFromPremises button : " + e);
		}
	}
	
	public void DoYouLikeToInsurePersonalBelongigs(String LiketoInsurePersonalbelongigns, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnPropertyAwayFromPremises, 2);
			ElementLayer.clickExpectedValue(BtnLiketoInsurePersonalbelongigns, LiketoInsurePersonalbelongigns, extentedReport, driver);
			WaitUtils.waitForSpinner(driver);
			Log.message("Selected BtnLiketoInsurePersonalbelongigns : " + LiketoInsurePersonalbelongigns, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnLiketoInsurePersonalbelongigns button : " + e);
		}
	}
	
	public void DoYouLikeToInsureYourStock(String Liketoinsureyourstock, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnLiketoinsureyourstock, 2);
			ElementLayer.clickExpectedValue(BtnLiketoinsureyourstock, Liketoinsureyourstock, extentedReport, driver);
			WaitUtils.waitForSpinner(driver);
			Log.message("Selected BtnLiketoinsureyourstock : " + Liketoinsureyourstock, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnLiketoinsureyourstock button : " + e);
		}
	}
	
	public void DoYouLikeToInsureYourStockInTransit(String LikeToInsureYourStockInTransit, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnLiketoinsureyourstockintransit, 2);
			ElementLayer.clickExpectedValue(BtnLiketoinsureyourstockintransit, LikeToInsureYourStockInTransit, extentedReport, driver);
			WaitUtils.waitForSpinner(driver);
			Log.message("Selected BtnLiketoinsureyourstockintransit : " + LikeToInsureYourStockInTransit, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnLiketoinsureyourstockintransit button : " + e);
		}
	}
	
	public void MaximumTakeAwayValue(String txtMaximumTakeAwayValue, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, TxtMaximumTakeAwayValue);
			TxtMaximumTakeAwayValue.clear();
			TxtMaximumTakeAwayValue.sendKeys(txtMaximumTakeAwayValue, "\t");
			WaitUtils.waitForSpinner(driver);
			Log.message("Entered TxtMaximumTakeAwayValue : " + txtMaximumTakeAwayValue, driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while entering TxtMaximumTakeAwayValue : " + e);
		}
	}
	
	public void StockMaximumTakeAwayValue(String txtStockMaximumTakeAwayValue, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, TxtMaximumTakeAwayValueofStock);
			TxtMaximumTakeAwayValueofStock.clear();
			TxtMaximumTakeAwayValueofStock.sendKeys(txtStockMaximumTakeAwayValue, "\t");
			WaitUtils.waitForSpinner(driver);
			Log.message("Entered TxtMaximumTakeAwayValueofStock : " + txtStockMaximumTakeAwayValue, driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while entering TxtMaximumTakeAwayValue : " + e);
		}
	}
	
	public void ItemMoreThanWorth2500(String btnItemMoreThanWorth2500, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnItemMoreThanWorth2500, 2);
			ElementLayer.clickExpectedValue(BtnItemMoreThanWorth2500, btnItemMoreThanWorth2500, extentedReport, driver);
			Log.message("Selected BtnItemMoreThanWorth2500 : " + btnItemMoreThanWorth2500, driver, extentedReport);
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnItemMoreThanWorth2500 button : " + e);
		}
	}
	
	public ImportantStatements clickNext(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnNext);
			Actions action = new Actions(driver);
	        action.moveToElement(BtnNext).click().perform();
			WaitUtils.waitForSpinner(driver);
			Log.message("Message - Clicked Next button", driver, extentedReport);
			return new ImportantStatements(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking Next button: " + e);
		}
	}
}