package com.ssp.Ec_pages;

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
import com.ssp.utils.DataUtils;
import com.ssp.utils.ElementLayer;
import com.ssp.utils.GenericUtils;
import com.ssp.utils.WaitUtils;
import com.ssp.wj_pages.BusinessDetails;
import com.ssp.wj_pages.GeneralInformation;
import com.ssp.wj_pages.PublicLiability;


public class Contact extends LoadableComponent<Contact> {

	private final WebDriver driver;
	private ExtentTest extentedReport;
	private String sspURL;
	private boolean isPageLoaded;
	public String spinner = "div.spinning-on-load-bg-table-active";
	public final String ERROR_MSG_LOGIN = "We do not recognise your details. Please re-enter your credentials";
	
	//MyDashboard Details screen objects
	
	@FindBy(css = "#C2__BUT_DB4A6646C4C5D63933681")
	WebElement BtnNewQuote;
	
	@FindBy(css = "#C2__BUT_A591663470A827D3151125")
	WebElement BtnComplete;
	
	@FindBy(css = "#C2__C1__BUT_E3C198C90C6E246847045")
	WebElement BtnManageContactDetails;
	
	@FindBy(css = "#C2__C1__BUT_5D046CA9B13A360C900257")
	WebElement BtnManageAuthorizeContactDetails;
	
	@FindBy(css = "#C2__C1__BUT_ACC55707320688F0167556_R1")
	WebElement BtnEditAddress;
	
	@FindBy(css = "#C2__C1__BUT_753975C04A0241C1630658")
	WebElement BtnAddNewAddress;
	
	@FindBy(css = "#C2__C1__BUT_753975C04A0241C1633500")
	WebElement BtnClose;
	
	@FindBy(css = "#C2__C1__QUE_1DAA4701266759AC347155")
	WebElement txtHouseNo;
	
	@FindBy(css = "#C2__C1__QUE_1DAA4701266759AC347158")
	WebElement txtPostCode;
	
	@FindBy(css = "#C2__C1__BUT_753975C04A0241C1630491")
	WebElement BtnFindAddress;
	
	@FindBy(css = "#C2__C1__BUT_753975C04A0241C1630556")
	WebElement BtnSave;
	
	@FindBy(css = "#C2__C1__BUT_753975C04A0241C1630559")
	WebElement BtnCancel;
	
	@FindBy(css = "#C2__C1__QUE_753975C04A0241C1630581")
	WebElement SelectAddressType;
	
	@FindBy(css = "#C2__C1__BUT_753975C04A0241C1630559")
	WebElement txtNewAddressHouseNo;
	
	@FindBy(css = "#C2__C1__QUE_753975C04A0241C1630594")
	WebElement txtNewAddressPostCode;
	
	@FindBy(css = "#C2__C1__BUT_753975C04A0241C1630598")
	WebElement BtnNewAddressFind;
	
	@FindBy(css = "#C2__C1__BUT_52BE0008F501490E9216894")
	WebElement BtnNewAddressSave;
	
	@FindBy(css = "#C2__C1__QUE_753975C04A0241C1630620")
	WebElement txnNewAddressLine1;
	
	@FindBy(css = "#C2__C1__BUT_753975C04A0241C1630600 ")
	WebElement BtnNewAddressEnterManually;
	
	@FindBy(css = "#C2__C1__BUT_753975C04A0241C1630778")
	WebElement BtnEditPhoneEmail;
	
	@FindBy(css = "#C2__C1__QUE_753975C04A0241C1630676 ")
	WebElement txtEditHomePhoneNo;
	
	@FindBy(css = "#C2__C1__QUE_753975C04A0241C1630680")
	WebElement txtEditMobileNo;
	
	@FindBy(css = "#C2__C1__QUE_753975C04A0241C1630684 ")
	WebElement txtEditWorkNo;
	
	@FindBy(css = "#C2__C1__QUE_753975C04A0241C1630696")
	WebElement txtEditEmail;
	
	@FindBy(css = "#C2__C1__BUT_753975C04A0241C1630702 ")
	WebElement BtnEditPhoneSave;
	
	@FindBy(css = "#C2__C1__BUT_753975C04A0241C1630705 ")
	WebElement BtnEditPhoneCancel;
	
	@FindBy(css = "#accordian_collapseThree > i.fa.fa-caret-down.pull-right ")
	WebElement BtnPreferencesCollapse;
	
	@FindBy(css = "#C2__C2__BUT_9A3F4FF3831D348F10744 ")
	WebElement BtnEditPreferencesDetails;
	
	@FindAll({
		@FindBy(xpath = "//*[@id='C2__C2__p4_QUE_323CAFD8056C194B27620']/div/div//label/span[contains(text(), 'Post')]"),
		@FindBy(xpath = "//*[@id='C2__C2__p4_QUE_323CAFD8056C194B27620']/div/div//label/span[contains(text(), 'Email')]")
	})
		
	List<WebElement> BtnEditCorrespondence_Preference;
	
	@FindAll({
		@FindBy(xpath = "//*[@id='C2__C1__p1_HEAD_B7DA19E14562CDF41088781']/div/ul/li/a[contains(text(), 'Address')]"),
		@FindBy(xpath = "//*[@id='C2__C1__p1_HEAD_B7DA19E14562CDF41088781']/div/ul/li/a[contains(text(), 'Phone/Email')]")
		})
	List<WebElement> SelectEditContactType;
	
	 @FindAll({
			@FindBy(xpath = "//*[@id='C2__C2__p4_optin']/div/div//label/span[contains(text(), 'Yes')]"),
			@FindBy(xpath = "//*[@id='C2__C2__p4_optin']/div/div//label/span[contains(text(), 'No')]")
			})
		List<WebElement> BtnEditMarketing_Preference;
	 
	 @FindAll({
			@FindBy(xpath = "//*[@id='C2__C2__p4_QUE_DAFA62E07AAB64B5148433']/div/div//label/span[contains(text(), 'Large Print')]"),
			@FindBy(xpath = "//*[@id='C2__C2__p4_QUE_DAFA62E07AAB64B5148433']/div/div//label/span[contains(text(), 'Braille')]"),
			@FindBy(xpath = "//*[@id='C2__C2__p4_QUE_DAFA62E07AAB64B5148433']/div/div//label/span[contains(text(), 'None')]")
			})
		List<WebElement> SelectImpairmentConsiderations;
	
	 @FindBy(css="#C2__C2__QUE_AE3BD4516663C76F857021_0")
	   	WebElement btnEditSMSCommunication_Preference;
	    
	    @FindBy(css="#C2__C2__save")
	   	WebElement btnSaveEditPreferences;
	    
	    @FindBy(css="#C2__C2__cancel")
	   	WebElement btnCancelEditPreferences;

	public Contact(WebDriver driver, String url, ExtentTest report) {
		this(driver, report);
		sspURL = url;
		
	}	
	
	public Contact(WebDriver driver, ExtentTest report) {
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
	
	public BusinessDetails Click_NewQuote(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnNewQuote);
			BtnNewQuote.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked BtnNewQuote", driver, extentedReport);
			return new BusinessDetails(driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking BtnNewQuote : " + e);
		}
	}
	
	public void Click_Complete(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnComplete);
			BtnComplete.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked BtnComplete", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking BtnComplete : " + e);
		}
	}
	
	public void Click_ManageContactDetails(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnManageContactDetails);
			BtnManageContactDetails.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked BtnManageContactDetails", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking BtnManageContactDetails : " + e);
		}
	}
	
	public void Click_ManageAuthorizeContactDetails(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnManageAuthorizeContactDetails);
			BtnManageAuthorizeContactDetails.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked BtnManageAuthorizeContactDetails", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking BtnManageAuthorizeContactDetails : " + e);
		}
	}
	
	public void Click_EditAddress(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnEditAddress);
			BtnEditAddress.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked BtnEditAddress", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking BtnEditAddress : " + e);
		}
	}
	
	public void Click_AddNewAddress(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnAddNewAddress);
			BtnAddNewAddress.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked BtnAddNewAddress", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking BtnAddNewAddress : " + e);
		}
	}
	
	public void Click_Close(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnClose);
			BtnClose.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked BtnClose", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking BtnClose : " + e);
		}
	}
	
	public void Click_FindAddress(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnFindAddress);
			BtnFindAddress.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked BtnFindAddress", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking BtnFindAddress : " + e);
		}
	}
	
	public void Click_Save(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnSave);
			BtnSave.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked BtnSave", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking BtnSave : " + e);
		}
	}
	public void Click_Cancel(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnCancel);
			BtnCancel.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked BtnCancel", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking BtnCancel : " + e);
		}
	}
	
	public void Click_NewAddressFind(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnNewAddressFind);
			BtnNewAddressFind.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked BtnNewAddressFind", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking BtnNewAddressFind : " + e);
		}
	}
	
	public void Click_NewAddressSave(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnNewAddressSave);
			BtnNewAddressSave.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked BtnNewAddressSave", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking BtnNewAddressSave : " + e);
		}
	}
	
	public void Click_NewAddressEnterManually(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnNewAddressEnterManually);
			BtnNewAddressEnterManually.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked BtnNewAddressEnterManually", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking BtnNewAddressEnterManually : " + e);
		}
	}
	
	public void Click_EditPhoneEmail(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnEditPhoneEmail);
			BtnEditPhoneEmail.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked BtnEditPhoneEmail", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking BtnEditPhoneEmail : " + e);
		}
	}
	
	public void Click_EditPhoneSave(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnEditPhoneSave);
			BtnEditPhoneSave.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked BtnEditPhoneSave", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking BtnEditPhoneSave : " + e);
		}
	}
	
	public void Click_EditPhoneCancel(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnEditPhoneCancel);
			BtnEditPhoneCancel.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked BtnEditPhoneCancel", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking BtnEditPhoneCancel : " + e);
		}
	}
	
	public void Click_CollapsePreferences(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnPreferencesCollapse);
			BtnPreferencesCollapse.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked BtnPreferencesCollapse", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking BtnPreferencesCollapse : " + e);
		}
	}
	
	public void Click_EditPreferencesDetails(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnEditPreferencesDetails);
			BtnEditPreferencesDetails.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked BtnEditPreferencesDetails", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking BtnEditPreferencesDetails : " + e);
		}
	}
	
	public void Click_EditSMS_Communication_Preferences(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnEditSMSCommunication_Preference);
			btnEditSMSCommunication_Preference.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked btnEditSMSCommunication_Preference", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking btnEditSMSCommunication_Preference : " + e);
		}
	}
	
	public void Click_SaveEditPreferences(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnSaveEditPreferences);
			btnSaveEditPreferences.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked btnSaveEditPreferences", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking btnSaveEditPreferences : " + e);
		}
	}
	
	public void Click_CancelEditPreferences(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnCancelEditPreferences);
			btnCancelEditPreferences.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked btnCancelEditPreferences", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking btnCancelEditPreferences : " + e);
		}
	}
	
	public void enterPostCode( String PostCode, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtPostCode);
			txtPostCode.clear();
			txtPostCode.sendKeys(PostCode);
			Log.message("Entered txtPostCode : " + PostCode, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering txtPostCode; : " + e);
		}
	}
	
	public void enterHouseNo(String HouseNo, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtHouseNo);
			txtHouseNo.clear();
			txtHouseNo.sendKeys(HouseNo);
			Log.message("Entered txtHouseNo : " + HouseNo, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering txtHouseNo; : " + e);
		}
	}
	
	public void enterNewAddressHouseNo(String SecurityCode, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtNewAddressHouseNo);
			txtNewAddressHouseNo.clear();
			txtNewAddressHouseNo.sendKeys(SecurityCode);
			Log.message("Entered txtNewAddressHouseNo : " + SecurityCode, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering txtNewAddressHouseNo; : " + e);
		}
	}
	
	public void enterNewAddressPostCode(String SecurityCode, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtNewAddressPostCode);
			txtNewAddressPostCode.clear();
			txtNewAddressPostCode.sendKeys(SecurityCode);
			Log.message("Entered txtNewAddressPostCode : " + SecurityCode, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering txtNewAddressPostCode; : " + e);
		}
	}
	
	public void enterNewAddressLine1(String SecurityCode, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txnNewAddressLine1);
			txnNewAddressLine1.clear();
			txnNewAddressLine1.sendKeys(SecurityCode);
			Log.message("Entered txnNewAddressLine1 : " + SecurityCode, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering txnNewAddressLine1; : " + e);
		}
	}
	
	public void enterEditHomePhoneNo(String SecurityCode, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtEditHomePhoneNo);
			txtEditHomePhoneNo.clear();
			txtEditHomePhoneNo.sendKeys(SecurityCode);
			Log.message("Entered txtEditHomePhoneNo : " + SecurityCode, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering txtEditHomePhoneNo; : " + e);
		}
	}
	
	public void enterEditMobileNo(String SecurityCode, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtEditMobileNo);
			txtEditMobileNo.clear();
			txtEditMobileNo.sendKeys(SecurityCode);
			Log.message("Entered txtEditMobileNo : " + SecurityCode, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering txtEditMobileNo; : " + e);
		}
	}
	
	public void enterEditWorkNo(String SecurityCode, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtEditWorkNo);
			txtEditWorkNo.clear();
			txtEditWorkNo.sendKeys(SecurityCode);
			Log.message("Entered txtEditWorkNo : " + SecurityCode, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering txtEditWorkNo; : " + e);
		}
	}
	
	public void enterEditEmail(ExtentTest extentedReport) throws Exception {
		
		try {
			WaitUtils.waitForElement(driver, txtEditEmail);
			txtEditEmail.clear();
			String Editemail = DataUtils.getEmail();
			txtEditEmail.sendKeys(Editemail);
			Log.message("Entered txtBusinessEmail : " + Editemail, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering txtBusinessEmail : " + e);
		}
	}
	
	public void SelectEditCorrespondence_Preference(String btnEditCorrespondence_Preference, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnEditCorrespondence_Preference, 2);
			ElementLayer.clickExpectedValue(BtnEditCorrespondence_Preference, btnEditCorrespondence_Preference, extentedReport, driver);
			Log.message("Selected BtnEditCorrespondence_Preference : " + btnEditCorrespondence_Preference, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnEditCorrespondence_Preference : " + e);
		}
	}
	
	public void SelectEditContactType(String EditContactType, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, SelectEditContactType, 2);
			ElementLayer.clickExpectedValue(SelectEditContactType, EditContactType, extentedReport, driver);
			Log.message("Selected SelectEditContactType : " + EditContactType, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnEditCorrespondence_Preference : " + e);
		}
	}
	
	
	public void SelectEditMarketing_Preference(String btnHeatingList, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnEditMarketing_Preference, 2);
			ElementLayer.clickExpectedValue(BtnEditMarketing_Preference, btnHeatingList, extentedReport, driver);
			Log.message("Selected BtnEditMarketing_Preference : " + btnHeatingList, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnEditMarketing_Preference : " + e);
		}
	}
	
	
	public void selectAddressType(String AddressType, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, SelectAddressType);
			new Select(SelectAddressType).selectByVisibleText(AddressType);
			Log.message("Selected SelectAddressType : " + AddressType, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting AddressType : " + e);
		}
	}
	
	public void selectImpairmentConsiderations(String impairmentconsideration, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, SelectImpairmentConsiderations, 2);
			ElementLayer.clickExpectedValue(SelectImpairmentConsiderations, impairmentconsideration, extentedReport, driver);
			Log.message("Selected SelectImpairmentConsiderations : " + impairmentconsideration, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while selecting SelectImpairmentConsiderations : " + e);
		}
	}
	
	


	
	
/*public SearchDashboard Click_Task(String btnSelectTask, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnSelectTask, 2);
			ElementLayer.clickExpectedValue(BtnSelectTask, btnSelectTask, extentedReport, driver);
			WaitUtils.waitForSpinner(driver);
			Log.message("Selected BtnSelectTask : " + btnSelectTask, driver, extentedReport);
			return new SearchDashboard(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnSelectTask : " + e);
		}
	}*/
	
	
}