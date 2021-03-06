package com.ssp.uxp_pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.ssp.support.Log;
import com.ssp.utils.ElementLayer;
import com.ssp.utils.GenericUtils;
import com.ssp.utils.WaitUtils;

/**
 * Home Page acts as a gateway to perform TakeCall,MakeCall and Admin task and
 * allows to select the Branch
 */
public class HomePage extends LoadableComponent<HomePage> {

	private WebDriver driver;
	private boolean isPageLoaded;
	public ElementLayer uielement;

	@FindBy(css = "a[data-toggle='dropdown']")
	WebElement cmbUserDrpDwnForLogout;

	@FindBy(css = "a[title='Take Call']")
	WebElement lnkTakeCall;

	@FindBy(css = "a[title='Make Call']")
	WebElement lnkMakeCall;

	@FindBy(css = "a.disablePassword")
	WebElement lnkChangePwd;

	@FindBy(css = "a[title='Admin Task']")
	WebElement lnkAdminTask;

	@FindBy(css = "a[data-target='#about-popup']")
	WebElement lnkAbtPopUp;

	@FindBy(css = "div[id='about-popup'] p.about_titile")
	WebElement txtAbtPopUpTitle;

	@FindBy(css = "label[for='name']")
	WebElement txtExistDetail;

	@FindBy(css = "div[id='about-popup'] p.abouts:nth-child(2)")
	WebElement txtAbtECVersion;

	@FindBy(css = "div[id='about-popup'] p.abouts:nth-child(4)")
	WebElement txtAbtECLang;

	@FindBy(css = "a[id='signOut']")
	WebElement lnkSignOut;

	@FindBy(css = "img[alt='Head Office']")
	WebElement imgHeadOff;

	@FindBy(css = "img[alt='Aldershot Branch']")
	WebElement imgAlderBran;

	@FindBy(css = "input[title='AllBrands']")
	WebElement btnAllBrands;

	@FindBy(css = "#C2__C1__FMT_CE93A4FCF8469E1D6106629 #closeModal")
	WebElement mdlMyBrndsCloseBtn;

	@FindBy(css = "button[title='Cancel']")
	WebElement mdlBrndCancelBtn;

	@FindBy(css = "h2.page-title")
	WebElement titleMyDashboard;

	@FindBy(css = "input[name='C1__CONTACTCENTRE[1].CHANGEPASSWORD[1].REENTERNEWPASSWORD']")
	WebElement fldChPwdReEnterPwd;

	@FindBy(css = "input[name='C1__CONTACTCENTRE[1].CHANGEPASSWORD[1].NEWPASSWORD']")
	WebElement fldChPwdNewPwd;

	@FindBy(css = "input[name='C1__CONTACTCENTRE[1].CHANGEPASSWORD[1].PASSWORD']")
	WebElement fldChPwdOldPwd;

	@FindBy(css = "button[title='Change my password']")
	WebElement btnChangePassword;

	@FindBy(css = "div.main-brand")
	WebElement txtBannerName;

	@FindBy(css = "div[class='brandlogo noinput']>label>img")
	List<WebElement> lstBrands;
	


	/**
	 * Constructor of the class
	 * 
	 * @param driver
	 *            : Webdriver
	 */
	public HomePage(WebDriver driver) {
		this.driver = driver;
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, WaitUtils.maxElementWait);
		PageFactory.initElements(finder, this);
	}

	@Override
	protected void isLoaded() {

		if (!isPageLoaded) {
			Assert.fail();
		}
		(new WebDriverWait(driver, 180).pollingEvery(200, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class)
				.withMessage("SIAAS Home page did not open up.")).until(ExpectedConditions.visibilityOf(lnkTakeCall));

		uielement = new ElementLayer(driver);
	}

	@Override
	protected void load() {

		isPageLoaded = true;
		WaitUtils.waitForPageLoad(driver);

	}

	/**
	 * Verify HomePage
	 * 
	 * @throws Exception
	 *             : Custom Exception Message
	 * @return boolean
	 * 
	 */
	public boolean verifyHomePage() throws Exception {
		WaitUtils.waitForSpinner(driver);
		if (!WaitUtils.waitForElement(driver, cmbUserDrpDwnForLogout))
			throw new Exception("Home Page is not loaded");
		return true;
	}

	/**
	 * Verify Take Call
	 * 
	 * @throws Exception
	 *             : Custom Exception Message
	 * @return boolean
	 * 
	 */
	public boolean verifyTakeCall() throws Exception {
		if (!WaitUtils.waitForElement(driver, lnkMakeCall))
			throw new Exception("Take call button is not visible!");
		return true;
	}

	/**
	 * Verify Make Call
	 * 
	 * @throws Exception
	 *             : Custom Exception Message
	 * @return boolean
	 * 
	 */
	public boolean verifyMakeCall() throws Exception {
		if (!WaitUtils.waitForElement(driver, lnkMakeCall))
			throw new Exception("Make call button is not visible!");
		return true;
	}

	/**
	 * Verify Admin Task
	 * 
	 * @throws Exception
	 *             : Custom Exception Message
	 * @return boolean
	 * 
	 */
	public boolean verifyAdminTask() throws Exception {
		if (!WaitUtils.waitForElement(driver, lnkAdminTask))
			throw new Exception("Admin Task button is not visible!");
		return true;
	}

	/**
	 * Do Logout
	 * 
	 * @param extentedReport
	 * @throws Exception
	 *             : Custom Exception Message
	 */
	public void doLogout(ExtentTest extentedReport) throws Exception {
		WaitUtils.waitForElement(driver, cmbUserDrpDwnForLogout, 20);
		cmbUserDrpDwnForLogout.click();
		Thread.sleep(3000);
		Log.message("Clicked on Welcome User menu", driver, extentedReport);
		if ((verifyHomePage()) && WaitUtils.waitForElement(driver, lnkSignOut)) {
			lnkSignOut.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Sign out link is clicked", driver, extentedReport);
		} else {
			throw new Exception("Log out button is not visible");
		}

	}

	/**
	 * click Take Call
	 * 
	 * @param extentedReport
	 * @throws Exception
	 *             : Custom Exception Message
	 */
	public void clickTakeCall(ExtentTest extentedReport) throws Exception {
		if (WaitUtils.waitForElement(driver, lnkTakeCall, 3)) {
			lnkTakeCall.click();
			WaitUtils.waitForPageLoad(driver);
			Log.message("Clicked on Take Call from Agent Dashboard Page", driver, extentedReport);

		} else {
			throw new Exception("Take call button is not visible!");
		}
	}

	/**
	 * click Make Call
	 * 
	 * @param extentedReport
	 * @throws Exception
	 *             : Custom Exception Message
	 */
	public void clickMakeCall(ExtentTest extentedReport) throws Exception {
		if (WaitUtils.waitForElement(driver, lnkMakeCall, 3)) {
			lnkMakeCall.click();
			Log.message("Clicked on Make Call", driver, extentedReport);
		} else {
			throw new Exception("Make call button is not visible!");
		}
		WaitUtils.waitForSpinner(driver);
	}

	/**
	 * Click ChangePassword
	 * 
	 * @param extentedReport
	 * @throws Exception
	 *             : Custom Exception Message
	 */
	public void clickChangePassword(ExtentTest extentedReport) throws Exception {
		WaitUtils.waitForElement(driver, cmbUserDrpDwnForLogout, 60);
		cmbUserDrpDwnForLogout.click();
		WaitUtils.waitForElement(driver, lnkChangePwd);
		lnkChangePwd.click();
		WaitUtils.waitForElement(driver, fldChPwdNewPwd);
		Log.message("Change Password link is clicked", driver, extentedReport);

	}

	/**
	 * Change the Password
	 * 
	 * @param oldPassword
	 * @param newPassword
	 * @param extentedReport
	 * @throws Exception
	 *             : Custom Exception Message
	 */
	public void changePassword(String oldPassword, String newPassword, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForelementToBeClickable(driver, btnChangePassword,
					"Failed to dispaly change password button");
			fldChPwdOldPwd.sendKeys(oldPassword);
			fldChPwdNewPwd.sendKeys(newPassword);
			fldChPwdReEnterPwd.sendKeys(newPassword);
			Log.message("Values entered for 'Old Password' : " + oldPassword + " 'New Password' : " + newPassword
					+ " and 'Re-Enter Password' textboxes", driver, extentedReport);
			btnChangePassword.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked on Change Password button", driver, extentedReport);

		} catch (Exception e) {
			throw new Exception("Problem when changing the password :" + e);
		}
	}

	/**
	 * click AdminTask
	 * 
	 * @param extentedReport
	 * 
	 * @throws Exception
	 *             : Custom Exception Message
	 */

	public void clickAdminTask(ExtentTest extentedReport) throws Exception {
		if (WaitUtils.waitForElement(driver, lnkAdminTask)) {
			lnkAdminTask.click();
			WaitUtils.waitForPageLoad(driver);
			Log.message("Clicked on Admin Task from Agent Dashboard page", driver, extentedReport);
		} else {
			throw new Exception("Admin Task button is not visible!");
		}
	}

	/**
	 * click About link
	 * 
	 * @param extentedReport
	 * 
	 */
	public void clickAbout(ExtentTest extentedReport) {
		lnkAbtPopUp.click();
		WaitUtils.waitForElement(driver, txtAbtPopUpTitle);
		Log.message("About link is clicked", driver, extentedReport);

	}

	/**
	 * get Engagement Center Version
	 * 
	 * @return String
	 * 
	 */
	public String getAppVersionInAbtPopUp() {
		return GenericUtils.getTextOfWebElement(txtAbtECVersion, driver);
	}

	/**
	 * get Engagement Center Default Language
	 * 
	 * @return String
	 * 
	 */
	public String getAppLangInAbtPopUp() {
		return GenericUtils.getTextOfWebElement(txtAbtECLang, driver);
	}

	/**
	 * get Engagement Center Default Language
	 * 
	 * @return String
	 * 
	 */
	public String getAppTitleInAbtPopUp() {
		return GenericUtils.getTextOfWebElement(txtAbtPopUpTitle, driver);
	}

	/**
	 * get Engagement Center Login User Name
	 * 
	 * @return String
	 * 
	 */
	public String getLoginUserName() {
		return GenericUtils.getTextOfWebElement(cmbUserDrpDwnForLogout, driver);
	}

	/**
	 * Click My Brands
	 * 
	 * @param brandname
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void clickMyBrands(String brandname, ExtentTest extentedReport) throws Exception {
		boolean status = false;
		WaitUtils.waitForElement(driver, imgHeadOff);
		WaitUtils.waitForElement(driver, imgAlderBran);
		if (brandname.contains("Head Office")) {
			imgHeadOff.click();
			status = true;
		} else if (brandname.contains("Aldershot Branch")) {
			imgAlderBran.click();
			status = true;
		} else if (brandname.contains("All Brands")) {
			// btnAllBrands.click();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", btnAllBrands);
			status = true;
		}
		if (status) {
			Log.message("Selected Brand : " + brandname, driver, extentedReport);
		}
		else {
			throw new Exception("Brand selection window did not open up, to select head / aldershot branch");
		}

		WaitUtils.waitForPageLoad(driver);
		WaitUtils.waitForSpinner(driver);
		
	}

	/**
	 * Verify Brands Popup
	 * 
	 * @throws Exception
	 * @return boolean
	 * 
	 */
	public boolean verifyBrandsPopup() throws Exception {
		boolean status = false;
		try {
			if (WaitUtils.waitForElement(driver, imgHeadOff) && WaitUtils.waitForElement(driver, imgAlderBran)) {
				status = true;
			}
		} catch (Exception e) {
			throw new Exception("Exception while verifying Popup :" + e);
		}
		return status;

	}

	/**
	 * Verify All Brands present in Popup
	 * 
	 * @throws Exception
	 * @return boolean
	 * 
	 */
	public boolean isAllBrandsPresent() throws Exception {
		boolean status = false;
		try {
			if (WaitUtils.waitForElement(driver, btnAllBrands)) {
				status = true;
			}
		} catch (Exception e) {
			throw new Exception("Exception while verifying all Brands :" + e);
		}
		return status;
	}

	/**
	 * Click Brand popup close button
	 * 
	 * @param extentedReport
	 * @param Screenshot
	 * @throws Exception
	 * 
	 */
	public void clickBrandPopupCloseBtn(ExtentTest extentedReport, boolean Screenshot) throws Exception {

		if (WaitUtils.waitForElement(driver, mdlMyBrndsCloseBtn)) {
			mdlMyBrndsCloseBtn.click();
			Thread.sleep(1000);
			Log.message("Clicked on my brand popup close button", driver, extentedReport, Screenshot);
		} else {
			throw new Exception("Close button is not visible!");
		}

	}

	/**
	 * Click Brand popup Cancel button
	 * 
	 * @param extentedReport
	 * @param Screenshot
	 * @throws Exception
	 * 
	 */
	public void clickBrandPopupCancelBtn(ExtentTest extentedReport, boolean Screenshot) throws Exception {
		if (WaitUtils.waitForElement(driver, mdlBrndCancelBtn)) {
			mdlBrndCancelBtn.click();
			Thread.sleep(1000);
			Log.message("Clicked on Cancel button from My Brands popup", driver, extentedReport, Screenshot);
		} else {
			throw new Exception("Cancel button is not visible!");
		}

	}

	/**
	 * Click outside of Brand popup
	 * 
	 * @param extentedReport
	 * @param Screenshot
	 * @throws Exception
	 * 
	 */
	public void clickOutsideBrandPopup(ExtentTest extentedReport, boolean Screenshot) throws Exception {
		if (WaitUtils.waitForElement(driver, lnkTakeCall, 3)) {
			Actions builder = new Actions(driver);
			builder.moveToElement(lnkTakeCall, 10, 25).click().build().perform();
			Thread.sleep(1000);
			WaitUtils.waitForElementPresent(driver, titleMyDashboard, "Unable to find outside popup element");
			Log.message("Clicked outside of my brand popup ", driver, extentedReport, Screenshot);
		} else {
			throw new Exception("Unable to click outside!");
		}
	}

	/**
	 * Verify Agent Dashboard
	 * 
	 * @return boolean
	 * 
	 */
	public boolean verifyAgentDashboard() {
		boolean status = false;
		if (WaitUtils.waitForElement(driver, lnkTakeCall))
			status = true;
		return status;
	}

	/**
	 * Verify MyDashboard
	 * 
	 * @throws Exception
	 *             : Custom Exception Message
	 * @return boolean
	 * 
	 */
	public boolean verifyMyDashboardTitle() throws Exception {
		return GenericUtils.verifyWebElementTextEquals(titleMyDashboard, "My Dashboard");

	}

	/**
	 * Verify banner title as Engagement Center
	 * 
	 * @param extentedReport
	 * @throws Exception
	 *             : Custom Exception Message
	 * @return boolean
	 * 
	 */

	public boolean verifyECbannertitle(ExtentTest extentedReport) throws Exception {
		try {
			return GenericUtils.verifyWebElementTextEquals(txtBannerName, "Engagement Centre");
		} catch (Exception e) {
			throw new Exception("Exception while getting banner title :" + e);
		}
	}

	/**
	 * Verify Brands in My Brands Popup
	 * 
	 * @param brandName
	 * @param extentedReport
	 * @param screenshot
	 * @return boolean
	 * 
	 */
	public boolean verifyBrandsInPopup(String brandName, ExtentTest extentedReport, boolean screenshot)
			throws Exception {
		boolean status = false;
		if (WaitUtils.waitForElement(driver, imgHeadOff) && WaitUtils.waitForElement(driver, imgAlderBran))
			for (int i = 0; i <= lstBrands.size(); i++) {
				if (lstBrands.get(i).getAttribute("alt").contains(brandName)) {
					status = true;
					break;
				} else {
					status = false;
				}
			}
		return status;
	}

}
