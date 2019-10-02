package com.ssp.wj_pages;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class People extends LoadableComponent<People> {

	private final WebDriver driver;
	private ExtentTest extentedReport;
	private String sspURL;
	private boolean isPageLoaded;
	public String spinner = "div.spinning-on-load-bg-table-active";
	public final String ERROR_MSG_LOGIN = "We do not recognise your details. Please re-enter your credentials";

	//The People in your business screen objects
	@FindBy(xpath = "//*[@id='C3__p4_BUT_5847B0D83AF0F962230553']//button")
	WebElement btnNext;

	@FindBy(css = "#C3__QUE_5847B0D83AF0F962230497")
	WebElement EmployeesInBusiness;
	
	@FindBy(css = "#C3__QUE_5847B0D83AF0F962230504")
	WebElement PartnersDoAdministrativeWork;
	
	@FindBy(css = "#C3__QUE_5847B0D83AF0F962230522")
	WebElement TxtEmployeesInBusiness;
	
	@FindBy(css = "#C3__QUE_5847B0D83AF0F962230504")
	WebElement TxtDirectorsOrPartnersInBusiness;
	
	@FindBy(css = "#C3__QUE_5847B0D83AF0F962230506")
	WebElement TxtDirectorsOrPartnersDoAdministrativeWork;
	
	@FindAll({
		@FindBy(xpath = "//*[@id='radio_C3__QUE_5847B0D83AF0F962230508']//span[contains(text(),'Yes')]"),
		@FindBy(xpath = "//*[@id='radio_C3__QUE_5847B0D83AF0F962230508']//span[contains(text(),'No')]")
		})
	List<WebElement> BtnPartnersInjuryCover;

	@FindAll({
		@FindBy(xpath = "//*[@id='radio_C3__QUE_5847B0D83AF0F962230499']//span[contains(text(),'Yes')]"),
		@FindBy(xpath = "//*[@id='radio_C3__QUE_5847B0D83AF0F962230499']//span[contains(text(),'No')]")
		})
	List<WebElement> BtnEmployersLiabilityCover;
	
	@FindBy(css = "#C3__QUE_5847B0D83AF0F962230532")
	WebElement TxtAdministrativeEmployees;	
	
	@FindAll({
		@FindBy(xpath = "//div[@id='radio_C3__QUE_5847B0D83AF0F962230540']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id='radio_C3__QUE_5847B0D83AF0F962230540']//span[contains(text(), 'No')]")
	})
	List<WebElement> BtnPremisesUsedByEmployees;
	
	@FindBy(css = "#C3__QUE_5847B0D83AF0F962230543")
	WebElement TxtNumberOfEmployeesUsedPremises;
	
	@FindBy(xpath = "//*[@id='C3__p1_QUE_5847B0D83AF0F962230543']//label[contains(text(), 'How many self-employed people use your premises?')]")
	WebElement QuestionNumberOfEmployeesUsedPremises;
	
	@FindBy(xpath = "//*[@id='C3__TXT_5847B0D83AF0F962230502']//div[contains(text(), ' Employers Liability insurance is legally required if you have employees. There are a few exceptions which can be found here:')]")
	WebElement ErrorMsgOnELCover;
	
	public People(WebDriver driver, String url, ExtentTest report) {
		this(driver, report);
		sspURL = url;
		
	}	
	
	public People(WebDriver driver, ExtentTest report) {
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
	
	public void BusinessEmployees(String employeesInBusiness, ExtentTest extentedReport) throws Exception {
		try {
			//WaitUtils.waitForElement(driver, EmployeesInBusiness);
			new Select(EmployeesInBusiness).selectByVisibleText(employeesInBusiness);
			Log.message("Selected BusinessEemployees : " + employeesInBusiness, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting BusinessEemployees : " + e);
		}
	}
	
	public void EmployeesInBusiness(String txtEmployeesInBusiness, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, TxtEmployeesInBusiness);
			TxtEmployeesInBusiness.clear();
			TxtEmployeesInBusiness.sendKeys(txtEmployeesInBusiness);
			WaitUtils.waitForSpinner(driver);
			Log.message("Entered TxtEmployeesInBusiness : " + txtEmployeesInBusiness, driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while entering TxtEmployeesInBusiness : " + e);
		}
	}
	
	public void AdministrativeEmployees(String txtAdministrativeEmployees, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, TxtAdministrativeEmployees);
			TxtAdministrativeEmployees.clear();
			TxtAdministrativeEmployees.sendKeys(txtAdministrativeEmployees, "\t");
			WaitUtils.waitForSpinner(driver);
			Log.message("Entered TxtAdministrativeEmployees : " + txtAdministrativeEmployees, driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while entering TxtAdministrativeEmployees : " + e);
		}
	}
	
	public void EmployersLiabilityCover(String btnEmployersLiabilityCover, ExtentTest extentedReport) throws Exception {
		try{	
			WaitUtils.waitForListElement(driver, BtnEmployersLiabilityCover, 2);
			ElementLayer.clickExpectedValue(BtnEmployersLiabilityCover, btnEmployersLiabilityCover, extentedReport, driver);
			Log.message("Selected BtnEmployersLiabilityCover : " + btnEmployersLiabilityCover, driver, extentedReport);
			WaitUtils.waitForSpinner(driver);
		}catch (Exception e) {
			throw new Exception("Error while selecting BtnEmployersLiabilityCover : " + e);
		}	
	}
	
	public void ErrorMsgOnELCoverDisplayed(ExtentTest extentedReport) throws Exception {
		try{	
			if(ErrorMsgOnELCover.isDisplayed()){
			Log.message("ErrorMsgOnELCover Displayed" , driver, extentedReport);
			}else{
			Log.message("ErrorMsgOnELCover is not Displayed " , driver, extentedReport);
			throw new Exception("failure");
			}
		}catch (Exception e) {
			throw new Exception("Error while selecting BtnEmployersLiabilityCover : " + e);
		}	
	}

	public void PartnersInjuryCover(String btnPartnersInjuryCover, ExtentTest extentedReport) throws Exception {
		try{	
			
			WaitUtils.waitForListElement(driver, BtnPartnersInjuryCover, 2);
			ElementLayer.clickExpectedValue(BtnPartnersInjuryCover, btnPartnersInjuryCover, extentedReport, driver);
			Log.message("Selected BtnPartnersInjuryCover : " + btnPartnersInjuryCover, driver, extentedReport);
			WaitUtils.waitForSpinner(driver);
		}catch (Exception e) {
			throw new Exception("Error while selecting BtnPartnersInjuryCover : " + e);
		}	
	}

	
	public void PremisesUsedByEmployees(String btnPremisesUsedByEmployees, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnPremisesUsedByEmployees, 2);
			ElementLayer.clickExpectedValue(BtnPremisesUsedByEmployees, btnPremisesUsedByEmployees, extentedReport, driver);
			WaitUtils.waitForSpinner(driver);
			Log.message("Selected BtnPremisesUsedByEmployees : " + btnPremisesUsedByEmployees, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnPremisesUsedByEmployees : " + e);
		}
	}
	
	public void NumberOfEmployeesUsedPremises(String txtNumberOfEmployeesUsedPremises, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, TxtNumberOfEmployeesUsedPremises);
			TxtNumberOfEmployeesUsedPremises.clear();
			TxtNumberOfEmployeesUsedPremises.sendKeys(txtNumberOfEmployeesUsedPremises);
			WaitUtils.waitForSpinner(driver);
			Log.message("Entered TxtNumberOfEmployeesUsedPremises : " + txtNumberOfEmployeesUsedPremises, driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while entering TxtNumberOfEmployeesUsedPremises : " + e);
		}
	}
	
	public void DirectorsOrPartnersInBusiness(String txtDirectorsOrPartnersInBusiness, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, TxtDirectorsOrPartnersInBusiness);
			TxtDirectorsOrPartnersInBusiness.clear();
			TxtDirectorsOrPartnersInBusiness.sendKeys(txtDirectorsOrPartnersInBusiness);
			WaitUtils.waitForSpinner(driver);
			Log.message("Entered TxtDirectorsOrPartnersInBusiness : " + txtDirectorsOrPartnersInBusiness, driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while entering TxtDirectorsOrPartnersInBusiness : " + e);
		}
	}
	
	public void DirectorsOrPartnersDoAdministrativeWork(String txtDirectorsOrPartnersDoAdministrativeWork, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, TxtDirectorsOrPartnersDoAdministrativeWork);
			TxtDirectorsOrPartnersDoAdministrativeWork.clear();
			TxtDirectorsOrPartnersDoAdministrativeWork.sendKeys(txtDirectorsOrPartnersDoAdministrativeWork);
			WaitUtils.waitForSpinner(driver);
			Log.message("Entered TxtDirectorsOrPartnersDoAdministrativeWork : " + txtDirectorsOrPartnersDoAdministrativeWork, driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while entering TxtDirectorsOrPartnersDoAdministrativeWork : " + e);
		}
	}
	
	public void QuestionNumberOfEmployeesUsedPremises(ExtentTest extentedReport) throws Exception {
		try {
			String a = QuestionNumberOfEmployeesUsedPremises.getText();
			System.out.println(a);
			if(!QuestionNumberOfEmployeesUsedPremises.isDisplayed()){
			Log.message("Checked QuestionNumberOfEmployeesUsedPremises is not displaying", driver, extentedReport);
			}else{
			Log.message("Checked QuestionNumberOfEmployeesUsedPremises is displaying", driver, extentedReport);
			throw new Exception("Failed");
			}
			}catch (Exception e) {
			Log.message("Falied on QuestionNumberOfEmployeesUsedPremises", driver, extentedReport);
			throw new Exception("Error while checking visibilty QuestionNumberOfEmployeesUsedPremises question " + e);
		}
	}
	public PublicLiability clickNext(ExtentTest extentedReport) throws Exception {
		try {
			btnNext.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Message - Clicked next button", driver, extentedReport);
			return new PublicLiability(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking next button: " + e);
		}
	}
}