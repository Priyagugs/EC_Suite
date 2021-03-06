package com.ssp.uxp_pages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
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
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentTest;
import com.ssp.support.DateTimeUtility;
import com.ssp.support.Log;
import com.ssp.utils.ElementLayer;
import com.ssp.utils.GenericUtils;
import com.ssp.utils.WaitUtils;

/**
 * Customer Dashboard Page consists all the policy/premium related documents *
 */
public class CustDashboardPage extends LoadableComponent<CustDashboardPage> {

	private final WebDriver driver;
	private boolean isPageLoaded;
	private ExtentTest extentedReport;
	// public String policyURNelement =
	// "table[id*='3B87415692E0F10617428']>tbody>tr:first-child>td>span";
	public int policyNo = 0;
	public String docviewClick = "td[id*='p4_BUT_BD388A52554BC5E73641765_R1']>div>div>div>a.btn.btn-default.page-spinner:not([title='Find Address'])";
	public String PolicyNumber = "tr.run-inner-rule-policy-view.table-row-active.polices-row.odd>td+td+td.Text";
	public String policyStatus = "table[id*='3B87415692E0F10617428']>tbody>tr>td.List";
	public String but_complete = "#C2__BUT_DB4A6646C4C5D63933610";
	public String mtaStartDate = "input[id*='QUE_4F6C7E1EA3A0DE0E1111397']";
	public String staStartDate = "input[id*='QUE_4E9E6DEC4AB0C369160959']";
	public String baStartDate = "input[id*='2F09F20DA3B36B74205865']";
	public String staExpiryDate = "input[id*='QUE_4E9E6DEC4AB0C369160965']";
	public String mtaReasonPopup = "div[id*='GRP_4F6C7E1EA3A0DE0E1059120']";
	public String spinner = "div.spinning-on-load-bg-table-active";
	public String butManagePolicyAddressEditcss = "#C2__C1__BUT_E3C198C90C6E246847045";
	public String txtEditAddressHouseNameOrNumcss = "#C2__C1__QUE_1DAA4701266759AC347155";
	public String txtEditAddressPostCodecss = "#C2__C1__QUE_1DAA4701266759AC347158";
	public String btnEditAddFindAddresscss = "#C2__C1__BUT_753975C04A0241C1630491";
	public String btnEditAddClosecss = "#C2__C1__BUT_753975C04A0241C1633500";

	public String butManagePolicyDetailcss = "#C2__C1__BUT_E3C198C90C6E246847045";
	public ElementLayer uielement;
	public String docviewFirst = "td[id*='p4_BUT_BD388A52554BC5E73641765_R1']";
	public String docviewLast = "']>div>div>div>a.btn.btn-default.page-spinner:not([title='Find Address'])";
	public String docviewbuttoncounter = "div>div>div>a.btn.btn-default.page-spinner:not([title='Find Address'])";

	public String Confirmbtn = "button[id*='99ADFDA008E513D23844180']";
	public String rad_cancel = "div[id*='TXT_C1866409B7CE50882210760']>div>div>div.policy_drpdwn>ul.navbar-nav>li>a";

	public String butCancl = "button[id*='99ADFDA008E513D23696578']";
	public String popup_cancl = "div[id*='99ADFDA008E513D23844048']";
	public String cancl_row = "div[id*='TXT_DE45AB1316E2D65D45375']";
	public String popup_Reinst = "input[id*='8CCBDF000A9E86F7115680']";
	public String but_resinst = "button[id*='8CCBDF000A9E86F7115692']";

	public String but_expand = ".fa.fa-caret-down.pull-right[title='Click to Expand']";
	public String but_collapse = ".fa.fa-caret-up.pull-right[title='Click to Collapse']";
	public String policyDetailstab_list = "ul>li>a";

	public String tab_sections = ".panel-title.clearfix";

	public String AdressTabHeadfields = "tr#C2__C1__p1_HDR_TBL_753975C04A0241C1630453>th";
	public String AdressTabBodyfields = "tr#C2__C1__p0_TBL_753975C04A0241C1630453_R1>td";
	public String adrsDetailFields = "div#C2__C1__FMT_753975C04A0241C1630467 label";
	public String policyDates = "table[id*='3B87415692E0F10617428']>tbody>tr>td.Date";
	public String tab_policyNotesTitle = "#C2__TXT_A8DEA467261EF91372329 a div";
	public String chkBox_PolQuotes = "#C2__C4__TXT_DE45AB1316E2D65D16964>div>div";

	public String cssTransactionstatus = ".Text";
	public String cssMainHolderPolicy = "#C2__C6__TXT_5C0FAA1035A3C71C4038211>div>b";
	public String cssViewTransaction = "[title='View Transaction']";
	final static String datepicker = "#dp1494307342717 .glyphicon-calendar";
	public String insurance_covers_CNT = "div[id*='FMT_728A190A046539421182844']>div>div>div>div>table.table.table-hover.table-striped>tbody>tr";
	public String insurance_covers_Bld = "div[id*='FMT_728A190A04653942826973']>div>div>div>div>table.table.table-hover.table-striped>tbody>tr";
	public String insurnace_covers_AddOns = "div[id*='FMT_728A190A046539421184112']>div>div>div>div>table.table.table-hover.table-striped>tbody>tr";

	public String modal_headerSTA = "#C2__C6__p1_GRP_4E9E6DEC4AB0C369160940 h4";

	public String cssCloseButton = "button[title='Close']";

	public String lstQuotevariations = ".clearfix.renewalQuoteVariations";
	public String tblPolicydetails = "#C2__C4__TBL_3B87415692E0F10617428 tbody tr";
	public String cssTableVals = "#C2__C4__TBL_3B87415692E0F10617428 tbody tr:nth-child(1) td:not([class*='hidden'])";
	public String cssbusinAddres = "#C2__C1__p0_TBL_5D046CA9B13A360C850049_R1 td";
	public String cssQuoteVariaList = ".clearfix.renewalQuoteVariations span:nth-child(3)";
	public String strPostCode = "AB10 1AH";

	/**********************************************************************************************
	 ********************************* WebElements of Login Page **********************************
	 **********************************************************************************************/

	@FindBy(css = "button[title='Passed Verification']")
	WebElement btnPassVerification;

	@FindBy(css = "button[title='Failed Verification']")
	WebElement btnFailVerification;

	@FindBy(css = "#C2__C1__QUE_1DAA4701266759AC347158")
	WebElement txtEditAddressPostCode;
	@FindBy(css="a[id*='BUT_BD388A52554BC5E73641765_R1']")
	WebElement viewbuttons;

	@FindBy(css = "#C2__C1__QUE_753975C04A0241C1630497")
	WebElement listBxAddressListEditAddress;

	@FindBy(css = "#C2__C1__BUT_4E3BCB6B5201A369249686")
	WebElement lnkEnterManuallyAddrEdit;

	@FindBy(css = "#a_viewPolicyCover")
	WebElement drpDwn_polCover;

	@FindBy(css = "span#a_viewPolicy")
	WebElement drpDwn_PolDetails;

	@FindBy(css = "#C2__C1__BUT_4E3BCB6B5201A369249686>span")
	WebElement lnkEditAddressEnterManually;

	@FindBy(css = "#C2__C1__BUT_753975C04A0241C1630491>span")
	WebElement btnEditAddressFindAddress;

	@FindBy(css = "#C2__C1__QUE_1DAA4701266759AC347049")
	WebElement txtTypeAddressTab;

	@FindBy(css = "#C2__C1__BUT_753975C04A0241C1630491")
	WebElement btnEditAddFindAddress;

	@FindBy(css = "#C2__C1__QUE_1DAA4701266759AC347158_ERRORMESSAGE")
	WebElement txtEditAddressPostCodeErrMsg;

	@FindBy(css = "#C2__C1__QUE_753975C04A0241C1630497")
	WebElement addressListSelect;

	@FindBy(css = "#C2__C1__QUE_1DAA4701266759AC346320")
	WebElement addressLineOne;

	@FindBy(css = "#C2__C1__BUT_753975C04A0241C1630559")
	WebElement btnAddressEditCancel;

	@FindBy(css = "#C2__C1__BUT_753975C04A0241C1633500")
	WebElement btnEditAddClose;

	@FindBy(css = "#C2__C1__QUE_1DAA4701266759AC347155")
	WebElement txtEditAddressHouseNameOrNum;

	@FindBy(css = "#C2__FMT_8E8C16BFDF38773D121613 h4:not([class='panel-title'])")
	WebElement tab_PolicyHolder_details;

	@FindBy(css = "button[title='New Quote'][id*='BUT_DB4A6646C4C5D63933681']")
	WebElement btnNewQuote;

	@FindBy(css = "button[title='Complete'][value='Complete']")
	WebElement btnComplete;

	@FindBy(css = "#C2__TXT_5C23FDA7E8A7DE4447492 > div > h2")//"h2.page-title")
	WebElement txtContactName;

	@FindBy(css = "div#FMT_8E8C16BFDF38773D121873")
	WebElement txtPolicyNotes;

	@FindBy(css = "a[id*='BUT_58CF1F8E16D428CA38036'][title='Edit Details']")
	WebElement lnkEditDetails;

	@FindBy(css = "button[id*='BUT_DB4A6646C4C5D63933681'][title='New Quote']")
	WebElement lnkNewQuote;

	@FindBy(css = "div[id*='FMT_9AF9ECE9A7A9E74D1066716']")
	WebElement popup_NewQuote;

	@FindBy(css = "input[placeholder='Start Date'][type='text']")
	WebElement datePicker;

	@FindBy(css = "#date-picker-QUE_8D734F2AC91F8FEB325795")
	WebElement cancellationdatePicker;

	@FindBy(css = "button#BUT_E7B607645443AA0846027[title='Manage User Account']")
	WebElement lnkMngAccount;

	@FindBy(css = "input[name*='PERSONALDETAILS'][name*='LASTNAME']")
	WebElement txtLastName;

	@FindBy(css = "button#BUT_C6487216B270AC9D626037")
	WebElement editperson_Save;

	@FindBy(css = "select[name*='INTERMEDIARY']")
	WebElement selectintermediary;

	@FindBy(css = "select[name*='PRODUCT']")
	WebElement selectproduct;

	@FindBy(css = "select[name*='SCHEME']")
	WebElement selectscheme;

	@FindBy(css = "#C2__BUT_9AF9ECE9A7A9E74D1066764[title='Continue']:not([disabled='disabled'])")
	WebElement createnewQuote;

	@FindBy(css = "#C2__C6__ITM_32BF5DA7372009F11482915")
	WebElement documenttab;

	@FindBy(css = "div>div>div>a.btn.btn-default.page-spinner:not([title='Find Address'])")
	WebElement docViewButtons;

	@FindBy(css = "div>p+p>span.normal")
	WebElement htmldocPolicynumber;

	@FindBy(css = "div>p+p>span.normal")
	WebElement pdfdocument;

	@FindBy(css = "th[id*='QUE_BD388A52554BC5E72766692']>div")
	WebElement docdescription;

	@FindBy(css = "#C2__C1__BUT_E3C198C90C6E246847045")
	WebElement btnManagePolicyDetails;

	@FindBy(css = "span[id*='BD388A52554BC5E72766692_R1'].GlobalFont")
	WebElement NBdescription;

	@FindBy(css = "span[id*='BD388A52554BC5E72766692_R2'].GlobalFont")
	WebElement Quotedescription;

	@FindBy(css = "a.stdcancelation")
	WebElement standardCancellation;

	@FindBy(css = "input[id*='8D734F2AC91F8FEB325795']:not([name*='EFFECTIVEDATE'])")
	WebElement effectiveDate;

	@FindBy(css = "select[id*='5B8AB516B3EACBF5217872'].form-control")
	WebElement effectiveTime;

	@FindBy(css = "select[id*='99ADFDA008E513D23696576']")
	WebElement cancelReason;

	@FindBy(css = "select[id*='99ADFDA008E513D23844242']")
	WebElement cancelPremiumType;

	@FindBy(css = "button[id*='99ADFDA008E513D23696578']")
	WebElement btnCalculateCancel;

	@FindBy(css = "button[id*='99ADFDA008E513D23844180']")
	WebElement btnConfirmCancel;

	@FindBy(css = "div[id*='E27EEAA35FDE73D3218642']>div>h4>div+div.col-md-6.text-bold.text-right.panel-title")
	WebElement policyStatusCancelled;

	@FindBy(css = "select[id='C2__C6__QUE_8CCBDF000A9E86F7115619']")
	WebElement drpReinstateReason;

	@FindBy(css = "#C2__C6__QUE_8CCBDF000A9E86F7115619>option")
	List<WebElement> drpoptReinstateReason;

	@FindBy(css = "#C2__C6__QUE_8CCBDF000A9E86F7115664[name*='COMMENTS']")
	WebElement fldReinstateReason;

	@FindBy(css = "button[id*='8CCBDF000A9E86F7115686']")
	WebElement btnCalculateReinstate;

	@FindBy(css = "button[id*='8CCBDF000A9E86F7115692']")
	WebElement btnConfirmReinstate;

	@FindBy(css = "div[id*='DEEBCDC6353AB592938762'] div.col-md-6.text-bold.text-right.panel-title")
	WebElement policyStatusReinstate;

	@FindBy(css = ".coolingoff")
	WebElement coolingOff;

	@FindBy(css = "#C1__Header-Complete")//"button[id*='DB4A6646C4C5D63933610']")
	WebElement completeButon;

	@FindBy(css = "#C2__C1__BUT_ACC55707320688F0167556_R1")
	WebElement btnManagePolicyAddressEdit;

	@FindBy(css = "span[id*='BD388A52554BC5E72766692_R1'].GlobalFont")
	WebElement documentdescription;

	@FindBy(css = "#C2__FMT_8E8C16BFDF38773D121894 a")
	WebElement getPolicyTab;

	@FindBy(css = "div[id*='C2__C6__TXT_C1866409B7CE50882210760']>div>div>ul>li:nth-child(2)>ul>li>a.midtermadjust")
	WebElement midTermAdj;

	@FindBy(css = "div[id*='C2__C6__TXT_C1866409B7CE50882210760']>div>div>ul>li:nth-child(2)>ul>li:nth-child(2)>a.shortadjust")
	WebElement shortTermAdj;

	@FindBy(css = "div[id*='C2__C6__TXT_C1866409B7CE50882210760']>div>div>ul>li:nth-child(2)>ul>li:nth-child(3)>a.billingadjust")
	WebElement billingAdj;

	@FindBy(css = "div[id*='C2__C6__TXT_C1866409B7CE50882210760']>div>div>ul>li:nth-child(8) li")
	WebElement newComplaint;

	@FindBy(css = "div[id*='4F6C7E1EA3A0DE0E1059120']")
	WebElement MTAPopUp;

	@FindBy(css = "div[id*='4E9E6DEC4AB0C369161075']")
	WebElement STAPopUp;

	@FindBy(css = "div[id*='FE2EAB6B4303D974579679']")
	WebElement BAPopUp;

	@FindBy(css = "select[name*='MTA[1].ADJUSTMENTREASON']")
	WebElement mtaReason;

	@FindBy(css = "select[name*='STA[1].ADJUSTMENTREASON']")
	WebElement staReason;

	@FindBy(css = "select[name*='BA[1].ADJUSTMENTREASON']")
	WebElement baReason;

	@FindBy(css = "button[id*='4F6C7E1EA3A0DE0E1111409']")
	WebElement mtaContinueBut;

	@FindBy(css = "button[id*='758B1448D2A3095B454380']")
	WebElement staContinueBut;

	@FindBy(css = "button[id*='FE2EAB6B4303D974579702']")
	WebElement baContinueBut;

	@FindBy(css = "div[id*='TXT_C1866409B7CE50882210760']>div>div>div.policy_drpdwn>ul.navbar-nav>li>a")
	WebElement PolicyAdminPane;

	@FindBy(css = "button[id*='3516874A7C1460DF1409566']")
	WebElement btnDashboard;

	@FindBy(css = "table[id*='3B87415692E0F10617428']>tbody>tr>td.Text>span.Text")
	WebElement cust_dashboard_PolicyUrn;

	@FindBy(css = "#C2__BUT_DB4A6646C4C5D63933610")
	WebElement cmpltBtn;

	@FindBy(css = ".panel-title #accordian_collapseFour")//".panel-title #accordian_collapseFour") //#accordian_collapseFour > i.fa.fa-caret-down.pull-right
	WebElement tab_viewQuotPolicies;

	@FindBy(css = "#C2__FMT_8E8C16BFDF38773D121873 h4 a")
	WebElement tab_viewPolicyNotes;

	@FindBy(css = "#C2__FMT_94042EAB8F6BD655359967 h4 a")
	WebElement tab_contacts;

	@FindBy(css = "#C2__FMT_94042EAB8F6BD655360042 h4 a")
	WebElement tab_preferences;

	@FindBy(css = "#C2__FMT_8E8C16BFDF38773D121943 h4 a")
	WebElement tab_system_Audit_History;

	@FindBy(css = "#C2__FMT_8E8C16BFDF38773D121613 h4")
	WebElement tab_PolicyHolder;

	@FindBy(css = "#a_viewPolicyDetails")
	WebElement tab_viewPolDetails;

	@FindBy(css = "#finance")
	WebElement tab_finance;

	@FindBy(css = ".dropdown-toggle.retrieve-complaints.page-spinner")
	WebElement tab_complaints;

	@FindBy(css = "#C2__C6__TXT_C1866409B7CE50882210760 > div > div > ul > li:nth-child(2) > a")
	WebElement tab_manage_policy;

	@FindBy(css = "button[title='Manage Contact Details']")
	WebElement manageCustDetails;

	@FindBy(css = "input[name*='CUSTOMERDASHBOARD[1].PERSON[1].CONTACT[1].CONTACTDETAILS[1].ADDRESS[1].ADDRESSLINE1']")
	WebElement addrsLine1;

	@FindBy(css = "#C2__C1__BUT_4E3BCB6B5201A369249686>span")
	WebElement enterManuallyLnk;

	@FindBy(css = "input[name*='REPLACEADDRESS[1].HOUSENUMBER']")
	WebElement replaceAdrss;

	@FindBy(css = "div#C2__C1__FMT_753975C04A0241C1630467 label")
	WebElement AddrsDetail;

	@FindBy(css = "div#C2__C1__FMT_753975C04A0241C1630467 label")
	WebElement adrsDetailFields1;

	@FindBy(css = "#C2__C6__FMT_89ED8F82775D82BB1069062")
	WebElement tab_finance_section_finance_billing_details;

	@FindBy(css = "#C2__C6__FMT_89ED8F82775D82BB1163763")
	WebElement tab_finance_section_account;

	@FindBy(css = "#C2__C6__COL_89ED8F82775D82BB1352887")
	WebElement finTabAccountSecnIncludeReversalField;

	@FindBy(css = "#C2__C6__COL_89ED8F82775D82BB1258439")
	WebElement finTabAccountSecnOutstandingField;

	@FindBy(css = "#C2__C6__COL_89ED8F82775D82BB1352902")
	WebElement finTabAccountSecnOutstandingAmtField;

	@FindBy(css = "#C2__C6__p1_TBL_89ED8F82775D82BB1448023")
	WebElement finTabAccountSecnFinanceTbl;

	@FindBy(css = "#C2__C6__takepayment")
	WebElement finTabAccountSecnTakePaymentBtn;

	@FindBy(css = "#finance_table > thead > tr > th:nth-child(1)")
	WebElement finTabFinTblEntryDate;

	@FindBy(css = "#finance_table > thead > tr > th:nth-child(2)")
	WebElement finTabFinTblDueDate;

	@FindBy(css = "#finance_table > thead > tr > th:nth-child(3)")
	WebElement finTabFinTblType;

	@FindBy(css = "#finance_table > thead > tr > th:nth-child(4)")
	WebElement finTabFinTblDue;

	@FindBy(css = "#finance_table > thead > tr > th:nth-child(5)")
	WebElement finTabFinTblPaid;

	@FindBy(css = "#finance_table > thead > tr > th:nth-child(6)")
	WebElement finTabFinTblBalance;

	@FindBy(css = "a#a_viewPolicyCover")
	WebElement dropdwn_polCover;

	@FindBy(css = "div#C2__C6__p4_QUE_24F4D09ABF5D5E60315856>div>div")
	WebElement txtfld_PolicyNo;

	@FindBy(css = "div#C2__C6__p4_QUE_24F4D09ABF5D5E60315860>div>div")
	WebElement txtfld_product;

	@FindBy(css = "div#C2__C6__p4_QUE_24F4D09ABF5D5E60315862>div>div")
	WebElement txtfld_scheme;
	@FindBy(css = "div#C2__C6__p4_QUE_24F4D09ABF5D5E60315864>div")
	WebElement txtFld_status;

	@FindBy(css = "#C2__C6__p4_QUE_24F4D09ABF5D5E60315870>div>div")
	WebElement txtFld_inceptiondate;

	@FindBy(css = "#C2__C6__row_QUE_24F4D09ABF5D5E60315860 .col-sm-7")
	WebElement txtFld_product;

	@FindBy(css = "#C2__C6__p4_QUE_24F4D09ABF5D5E60315862 .col-sm-7")
	WebElement txtFld_scheme;

	@FindBy(css = "#C2__C6__p4_QUE_24F4D09ABF5D5E60315872>div>div")
	WebElement txtFld_expirydate;

	@FindBy(css = "div#C2__C4__TXT_DE45AB1316E2D65D16964>div>div>input#Polices")
	WebElement chkbx_viewmorePolicies;

	@FindBy(css = "div#C2__C4__TXT_DE45AB1316E2D65D16964>div>div>input#Quotes")
	WebElement chkbx_viewmoreQuotes;

	@FindBy(css = "div#C2__C6__C1__p1_TBL_86346BDD86A498D8279031 table tbody tr:nth-child(1)>td:nth-child(1)")
	WebElement fld_bldCover;

	@FindBy(css = "#C2__SPC_F0BA0583F559E7131988481")
	WebElement tab_PolicyNotes;

	@FindBy(css = "button#C2__BUT_DB4A6646C4C5D63933610[Value='Complete']")
	WebElement btn_custComplete;

	@FindBy(css = "#C2__C1__TXT_E3C198C90C6E246837187")
	WebElement sectionContactDetails;

	@FindBy(css = "#C2__C6__TXT_5C0FAA1035A3C71C4038211")
	WebElement txtAreaPolicyHolder;

	@FindBy(css = "table[id='C2__C6__TBL_19504DF73EA7BBF571855'] tbody tr")
	List<WebElement> lstTransactionTable;

	@FindBy(css = "button[title='Edit Transaction']")
	WebElement btnEditTransaction;

	@FindBy(css = ".editQuotePolicy")
	WebElement dropDownOptionEdit;

	@FindBy(css = "[title='View Transaction']")
	WebElement linkViewTransaction;

	@FindBy(css = ".inviterenewal")
	WebElement optionInviteRenewal;

	@FindBy(css = ".midtermadjust")
	WebElement lnkMidTermAdjust;

	@FindBy(css = ".reverseTransaction")
	WebElement lnkReverseTransaction;

	@FindBy(css = ".nav.navbar-nav :nth-child(2) a[data-toggle='dropdown'][aria-expanded='false'],.nav.navbar-nav :nth-child(3) a[data-toggle='dropdown']")
	WebElement drpManagePolicy;

	@FindBy(css = "#C2__BUT_FE031EDBB6A4EA08804112")
	WebElement btnAcceptMTA;

	@FindBy(css = "#C2__ID_DIRECT_DEBIT_CONFIRM")
	WebElement btnConfirmMTA;

	@FindBy(css = "#C2__B1_QUE_FD051A198CB3861E1713415[title='ADD']")
	WebElement btnAddMTA;

	@FindBy(css = "#C2__B2_QUE_FD051A198CB3861E1713415[title='ADD ALL']")
	WebElement btnAddAllMTA;

	@FindBy(css = "#C2__BUT_FD051A198CB3861E1713417[title='Next']")
	WebElement btnAddAllMTANext;

	@FindBy(css = "#C2__UNSEL_QUE_FD051A198CB3861E1713415>option")
	List<WebElement> lstAdjReasons;

	@FindBy(css = "#C2__BUT_728A190A046539422616673[title='Buy']")
	WebElement btnBuyMTA;

	@FindBy(css = "#C2__C6__BUT_4F6C7E1EA3A0DE0E1111409")
	WebElement btnMidTermContinue;

	@FindBy(css = "#date-picker-C2__C6__QUE_4F6C7E1EA3A0DE0E1111397")
	WebElement txtMidTermDate;

	@FindBy(css = "div[for*='date-picker-C2__C6__QUE_4F6C7E1EA3A0DE0E1111397'] .glyphicon-calendar")
	WebElement imgEffectiveDateIcon;

	@FindBy(css = ".bootstrap-datetimepicker-widget.dropdown-menu.up.down .day.active:not(new)")
	WebElement dateCurrentActiveDay;

	@FindBy(css = "#C2__C6__QUE_4F6C7E1EA3A0DE0E1111400")
	WebElement cmbMidTermAdjReason;

	@FindBy(css = ".run-inner-rule-transact .Text.sorting_1")
	List<WebElement> textMTAPosition;

	@FindBy(css = "#C2__C6__QUE_F8495CB9C6ABE93A260890[name*='PERSON[1].REVERSETRANSACTION[1]'] option")
	List<WebElement> optReverseTransactionType;

	@FindBy(css = "#C2__C6__BUT_F8495CB9C6ABE93A260632")
	WebElement btnConfirmReversal;

	@FindBy(css = ".run-inner-rule-transact.even :nth-child(3)")
	List<WebElement> txtMTAFromDate;

	@FindBy(css = ".run-inner-rule-transact td:nth-child(2)")
	List<WebElement> txtMTAStatus;

	@FindBy(css = ".reverseTransaction.disable_attr")
	WebElement lnkReverseTransactionDisabled;

	@FindBy(css = ".nav.navbar-nav :nth-child(5) a[data-toggle='dropdown']")
	WebElement drpCancelPolicy;

	@FindBy(css = ".stdcancelation")
	WebElement drpoptStandardCancel;

	@FindBy(css = "#date-picker-C2__C6__QUE_8D734F2AC91F8FEB325795")
	WebElement txtCancelPolicyDate;

	@FindBy(css = "#C2__C6__BUT_99ADFDA008E513D23696578[title='Calculate']")
	WebElement brnCalculate;

	@FindBy(css = "div.main-brand")
	WebElement txtBannerName;

	@FindBy(css = "#C2__C6__QUE_99ADFDA008E513D23844242[name*='RETURNPREMIUMTYPE']")
	WebElement drpCancelType;

	@FindBy(css = "#C2__C6__QUE_99ADFDA008E513D23844242>option")
	List<WebElement> drpoptCancelType;

	@FindBy(css = ".run-inner-rule-transact.odd :nth-child(7)")
	List<WebElement> txtMTAPremium;

	@FindBy(css = "#C2__C6__p1_GRP_4E9E6DEC4AB0C369160940 h4")
	WebElement modal_STA;

	@FindBy(css = "date-picker-C2__C6__QUE_4E9E6DEC4AB0C369160959")
	WebElement date_StaEffctvdate;

	@FindBy(css = "#a_viewTermsAndConditions")
	WebElement dropdownViewTandC;

	@FindBy(css = ".suspendBilling")
	WebElement drpdwnSuspendBilling;

	@FindBy(css = "#C2__C6__TXT_34712C947A99D37B680416")
	WebElement titleSuspendBilling;

	@FindBy(css = ".unsuspendBilling")
	WebElement drpdwnUnsuspendBilling;

	@FindBy(css = "#C2__C6__TXT_DEEBCDC6353AB592938762")
	WebElement titleUnsuspendBilling;

	@FindBy(css = ".dropdown-toggle.manageRenewals")
	WebElement drpManageRenewals;

	// .inviterenewal
	@FindBy(css = "li[class='dropdown open']>ul>li>a[class*='inviterenewal']")
	WebElement drpoptInviteRenewals;

	@FindBy(css = ".renewalQuoteVariations")
	WebElement drpoptLapseQuote;

	@FindBy(css = "#C2__C6__HEAD_D4DBB0F898735EB62007691")
	WebElement msgWarningLapseQte;

	@FindBy(css = "#C2__C6__BUT_D4DBB0F898735EB62007699")
	WebElement btnCancelLapseQuote;

	@FindBy(css = "#C2__C6__BUT_D4DBB0F898735EB62007696")
	WebElement btnContinueLapseQuote;

	@FindBy(css = "#C2__C6__ViewDataCapture")
	WebElement btnWarningContinue;

	@FindBy(css = "div[id*='C2__C6__TXT_C1866409B7CE50882210760']>div>div>ul>li:nth-child(8) li a")
	WebElement drpDwn_newComplaint;

	@FindBy(css = "#C2__C6__row_QUE_24F4D09ABF5D5E60316288")
	WebElement txtPayementCard;

	@FindBy(css = "#C2__C3__ATTACHEMENT_R1")
	WebElement btnView1;

	@FindBy(css = "#C2__C3__discussion_R1")
	WebElement txtpaneSystemAudit;

	@FindBy(css = ".dropdown-toggle.view-variations.page-spinner")
	WebElement drpRenewQotVariations;

	@FindBy(css = ".clearfix.renewalQuoteVariations")
	WebElement drpoptRenewQotVariations;

	@FindBy(css = "#C2__C4__TBL_3B87415692E0F10617428 tbody tr:nth-child(1) td:nth-child(8)>span>span")
	WebElement txt_ReviewStatus;

	@FindBy(css = "div[id='C2__C6__p4_QUE_24F4D09ABF5D5E60316284'] div div")
	WebElement divTotalPaid;

	@FindBy(css = "div[id='C2__C6__p4_QUE_24F4D09ABF5D5E60316286'] div div")
	WebElement divTotalBalance;
	@FindBy(css = "C2__C2__QUE_9A3F4FF3831D348F10659_0")
	WebElement radPostpref;

	@FindBy(css = "C2__C2__QUE_9A3F4FF3831D348F10659_1")
	WebElement radEmailpref;

	@FindBy(css = "#C2__C6__p4_QUE_24F4D09ABF5D5E60316278 div")
	WebElement txtPremiumAmt;

	@FindBy(css = "#C2__C1__BUT_B5B6AE7C4A613B1F511661")
	WebElement btnManageBusinsDetails;

	@FindBy(css = "#C2__C1__TXT_B5B6AE7C4A613B1F511781 li:nth-child(2)")
	WebElement tabBusiAddress;

	@FindBy(css = "#C2__C1__QUE_62DA036383BAD41B2554143")
	WebElement txtBusinsPostCode;

	@FindBy(css = "#C2__C1__BUT_6FCDCDB0C9B806C4658415")
	WebElement btnFindAdd;

	@FindBy(css = "select[name*='ADDRESSLIST']")
	WebElement cn_AddressList;

	@FindBy(css = "#C2__C1__QUE_62DA036383BAD41B2554174")
	WebElement cn_AddressLine;

	@FindBy(css = "#C2__C1__BUT_6FCDCDB0C9B806C4680454[title='Save']")
	WebElement btnSaveAddres;

	@FindBy(css = "#C2__C1__BUT_5D046CA9B13A360C850179")
	WebElement btnClose;

	@FindBy(css = "#C2__C1__p4_QUE_5D046CA9B13A360C850033>div")
	WebElement txtAddressCustPage;

	@FindBy(css = "#C2__C1__QUE_5D046CA9B13A360C850051_R1")
	WebElement txtAddress;

	@FindBy(css = "h4#C2__C6__HEAD_D0A6055897B292B61723338")
	WebElement txtWarningMsg;

	@FindBy(css = "button#C2__C6__ViewDataCapture")
	WebElement btnContnToInvRenwal;

	@FindBy(css = "img[src*='Head Office']")
	WebElement imgHeadOfficeInHeader;

	@FindBy(css = "#C2__C4__TBL_3B87415692E0F10617428 img")
	WebElement txtBlockRenwal;

	@FindBy(css = "li[class*=\"open\"]>ul[class=\"dropdown-menu\"]>li>a")
	List<WebElement> lstOptionInManageRenewals;

	@FindBy(css = ".clearfix.renewalQuoteVariations >span[class*='col-md-4']")
	List<WebElement> lstVariationInQuoteVariations;

	@FindBy(css = "div[class='container-fluid policy_drpdwn'] > ul> li > a")
	List<WebElement> lstTabUnderPolicyHolder;

	@FindBy(css = "#C2__C1__p1_GRP_62DA036383BAD41B2554130[style*='relative']")
	WebElement sectionReplaceAddress;


	/**********************************************************************************************
	 ********************************* WebElements of Search Page - Ends ***************************
	 **********************************************************************************************/

	/**
	 * 
	 * Constructor class for Customer Dashboard Page Here we initializing the
	 * driver for page factory objects. For ajax element waiting time has added
	 * while initialization
	 * 
	 * @param driver
	 *            : Webdriver
	 */
	public CustDashboardPage(WebDriver driver, ExtentTest report) {
		this.driver = driver;
		this.extentedReport = report;
		PageFactory.initElements(driver, this);
		uielement = new ElementLayer(driver);
	}

	@Override
	protected void isLoaded() {

		if (!isPageLoaded) {
			Assert.fail();
		}

		if (isPageLoaded && !driver.getTitle().contains("CustomerDashboard")) {
			Log.fail("SSP Customer Dashboard Page did not open up. Site might be down.", driver,extentedReport);
		}
	}

	@Override
	protected void load() {

		isPageLoaded = true;
		WaitUtils.waitForPageLoad(driver, 60);
		WaitUtils.waitForElement(driver, lnkEditDetails);

	}

	/**
	 * To verify customer dashboard page
	 * 
	 * @return boolean
	 * @throws Exception
	 * 
	 */
	public boolean verifyCustomerDashboardPage() throws Exception {
		try {
			boolean status = false;
			(new WebDriverWait(driver, 180).pollingEvery(200, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.withMessage("Unable to Switch to Windows"))
							.until(ExpectedConditions.invisibilityOfElementLocated(
									By.cssSelector("div.spinning-on-load-bg-table-active")));
			WaitUtils.waitForelementToBeClickable(driver, lnkEditDetails, "Unable to find Edit Details Link");
			if (WaitUtils.waitForElement(driver, lnkEditDetails)) {
				status = true;
			}
			return status;
		} catch (Exception e) {
			throw new Exception("Error while verifying customer Dashboard page : " + e);
		}
	}

	/**
	 * To verify customer dash board page Contact details
	 * 
	 * @param address
	 * @return boolean
	 * @throws Exception
	 * 
	 */
	public boolean verifyContactAddressDetails(String address) throws Exception {
		try {
			boolean status = false;
			if (GenericUtils.verifyWebElementTextContains(sectionContactDetails, address))
				status = true;
			return status;
		} catch (Exception e) {
			throw new Exception("Error while verifying ContactDetails : " + e);
		}
	}

	/**
	 * To click pass verification button
	 * 
	 * @param Screenshot
	 * @param extentReport
	 * @throws Exception
	 * 
	 */
	public void clickPassVerification(ExtentTest extentReport, boolean Screenshot) throws Exception {
		try {
			if (WaitUtils.waitForElement(driver, btnPassVerification)) {
				btnPassVerification.click();
				WaitUtils.waitForSpinner(driver);
				Log.message("Clicked on Passed Verification", driver, extentReport, Screenshot);
			}
		} catch (Exception e) {
			throw new Exception("Unable to click on Pass Verification button : " + e);
		}

	}

	/**
	 * To click failed verification button
	 * 
	 * @param extentReport
	 * @param Screenshot
	 * @throws Exception
	 * 
	 */
	public void clickFailVerification(ExtentTest extentReport, boolean Screenshot) throws Exception {
		try {
			btnFailVerification.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked on Failed Verification", driver, extentReport, Screenshot);
		} catch (Exception e) {
			throw new Error("Error while clicking fail verification button : " + e);
		}
	}

	/**
	 * To click EditDetails
	 * 
	 * @param extentReport
	 * @param Screenshot
	 * @throws Exception
	 * 
	 */
	public void clickEditDetails(boolean Screenshot, ExtentTest extentReport) throws Exception {
		try {
			lnkEditDetails.click();
			WaitUtils.waitForElement(driver, txtLastName);
			Log.message("Clicked on Edit Details", driver, extentReport, Screenshot);
			txtLastName.clear();
			txtLastName.sendKeys("Madarapu");
			editperson_Save.click();
		} catch (Exception e) {
			throw new Exception("Unable to Edit Customer Details : " + e);
		}
	}

	/**
	 * To click New Quote button
	 * 
	 * @param extentReport
	 * @param Screenshot
	 * @throws Exception
	 * 
	 */
	public void clickNewQuote(boolean Screenshot, ExtentTest extentReport) throws Exception {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", lnkNewQuote);
			Thread.sleep(2000);
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked on New Quote button", driver, extentReport, Screenshot);
		} catch (Exception e) {
			throw new Exception("Unable to click on New Quote button : " + e);
		}
	}

	/**
	 * To click Manage Policy
	 * 
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void clickManagePolicy(ExtentTest extentedReport) throws Exception {

		try {
			WaitUtils.waitForElement(driver, drpManagePolicy);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", drpManagePolicy);
			Log.message("Clicked on Manage Policy", driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Unable to click on Manage Policy Button : " + e);
		}
	}

	/**
	 * To click MidTermAdjustment
	 * 
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void clickMidTermAdjustment(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, lnkMidTermAdjust);
			lnkMidTermAdjust.click();
			WaitUtils.waitForElement(driver, txtMidTermDate);
			Log.message("Clicked on Mid Term Adjustment", driver, extentedReport, true);
		} catch (Exception e) {
			throw new Exception("Unable to click on Mid Term Adjustment Button : " + e);
		}
	}

	/**
	 * To enter Date For MTA
	 * 
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void enterDateForMTA(ExtentTest extentedReport) throws Exception {
		try {
			SimpleDateFormat formDate = new SimpleDateFormat("dd/MM/yyyy");
			String strDate = formDate.format(new Date());
			txtMidTermDate.clear();
			txtMidTermDate.sendKeys(strDate);
			txtMidTermDate.click();
			Thread.sleep(2000);
			Log.message("Entered the Date : " + strDate, driver, extentedReport);
		}

		catch (Exception e) {
			throw new Exception("Date is not entered", e);
		}
	}

	/**
	 * To enter future Date For MTA
	 * 
	 * @param extentedReport
	 * @param Screenshot
	 * @throws Exception
	 * @return String
	 * 
	 */
	public String enterfutureDateForMTA(ExtentTest extentedReport, boolean Screenshot) throws Exception {
		try {
			String futureDate = null;
			futureDate = GenericUtils.setDate("future", txtMidTermDate, 2, 0);
			Log.message("Entered the Date : " + futureDate, driver, extentedReport, Screenshot);
			return futureDate;
		} catch (Exception e) {
			throw new Exception("Date is not entered : " + e);
		}

	}

	/**
	 * To select MidTerm AdjReason
	 * 
	 * @param MTAcreationReason
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void selectMidTermAdjReason(String MTAcreationReason, ExtentTest extentedReport) throws Exception {
		try {

			Select titledrpDown = new Select(cmbMidTermAdjReason);
			titledrpDown.selectByVisibleText(MTAcreationReason);
			Thread.sleep(2000);
			Log.message("Selected MidTerm Reason : " + MTAcreationReason, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Date is not entered : " + e);
		}
	}

	/**
	 * select Insurance item
	 *
	 * @param coverDetails
	 * @param Screenshot
	 * @param extentedReport
	 * @throws Exception
	 * @return String
	 * 
	 */
	public String SelectInsuranceItem(String coverDetails, boolean screenshot, ExtentTest extentedReport)
			throws Exception {
		try {

			String RowToValidate = null;
			String insurance_covers = "";
			String tagToFind = "a";
			String[] coversToAdd = coverDetails.split("_");
			String inputcoverToSelect = coversToAdd[0];
			String coverSection = coversToAdd[1];
			String addRemove = coversToAdd[2];
			if (coverSection.equalsIgnoreCase("CNT")) {
				insurance_covers = insurance_covers_CNT;

			} else if (coverSection.equalsIgnoreCase("BLD")) {
				insurance_covers = insurance_covers_Bld;
			} else {
				insurance_covers = insurnace_covers_AddOns;
				if (addRemove.equalsIgnoreCase("Add")) {
					tagToFind = "button";
				}
			}

			List<WebElement> inscoverRows = driver.findElements(By.cssSelector(insurance_covers));

			for (int i = 0; i < inscoverRows.size(); i++) {
				List<WebElement> cover_Name = inscoverRows.get(i).findElements(By.tagName("td"));
				for (int j = 0; j < cover_Name.size(); j++) {

					if ((!(cover_Name.get(j).getText().toString() == null)) && (inputcoverToSelect.trim()
							.equalsIgnoreCase(cover_Name.get(j).getText().toString().trim()))) {
						RowToValidate = insurance_covers;
						List<WebElement> buttonToClick = inscoverRows.get(i).findElements(By.tagName(tagToFind));
						for (int k = 0; k < buttonToClick.size(); k++) {
							if (buttonToClick.get(k).isDisplayed()
									&& buttonToClick.get(k).getText().equalsIgnoreCase(addRemove)) {
								buttonToClick.get(k).sendKeys(Keys.ENTER);
								return RowToValidate;
							}
						}
					}

				}
			}

			if (RowToValidate != null) {
				Log.message("Clicked on " + inputcoverToSelect + "covers button successfully, to " + addRemove + " "
						+ coverSection + " cover", driver, extentedReport, true);
			}
			return RowToValidate;

		} catch (Exception e) {
			throw new Exception("Error while Selecting Insurance Item : " + e);
		}
	}

	/**
	 * To verify MTA TransactionStatus
	 *
	 * @return boolean
	 * @throws Exception
	 * 
	 */
	public boolean verifyMTATransactionStatus() throws Exception {
		if (GenericUtils.verifyListInAlphabeticalOrder(textMTAPosition)) {
			return false;
		}
		return true;
	}

	/**
	 * To verify MTAT StatusAndDate
	 *
	 * @param MTAstatus
	 * @return boolean
	 * @throws Exception
	 * 
	 */
	public boolean verifyMTATStatusAndDate(String MTAstatus) throws Exception {
		boolean status = false;
		if (GenericUtils.verifyMatchingTextContainsElementFromList(txtMTAStatus, MTAstatus))
			status = true;
		return status;

	}

	/**
	 * To select ReverseTransType
	 *
	 * @param reason
	 * @param extentedReport
	 * @param screenshot
	 * @throws Exception
	 * 
	 */
	public void selectReverseTransType(String reason, ExtentTest extentedReport, boolean screenshot) throws Exception {
		try {
			GenericUtils.getMatchingTextElementFromList(optReverseTransactionType, reason).click();
			Log.message("Selected " + reason + " from Reversal Transaction type reason", driver, extentedReport,
					screenshot);

		} catch (Exception e) {
			throw new Exception("Unable to Select Reversal Transaction type reason : " + e);
		}
	}

	/**
	 * To click Confirm Reversal Button
	 *
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void clickConfirmReversalButton(ExtentTest extentedReport) throws Exception {
		try {
			btnConfirmReversal.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked on Confirm Reversal button", driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Confirm Reversal button not clicked : " + e);
		}
	}

	/**
	 * To click ReverseTransaction
	 *
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void clickReverseTransaction(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForSpinner(driver);
			lnkReverseTransaction.click();
			WaitUtils.waitForListElement(driver, optReverseTransactionType, 1);
			Log.message("Clicked on Reverse transaction after upgrading policy", driver, extentedReport, true);
		} catch (Exception e) {
			throw new Exception("Unable to click on Reverse transaction link : " + e);
		}
	}

	/**
	 * To click MidTermContinue
	 *
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void clickMidTermContinue(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnMidTermContinue);
			btnMidTermContinue.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Mid Term Continue button clicked", driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Mid Term Continue button not clicked : " + e);
		}
	}

	/**
	 * To click BuyMTA
	 *
	 * @param extentedReport
	 * @param screenshot
	 * @throws Exception
	 * 
	 */
	public void clickBuyMTA(ExtentTest extentedReport, boolean screenshot) throws Exception {
		try {
			WaitUtils.waitForelementToBeClickable(driver, btnBuyMTA, "Unable to find Buy MTA button");
			btnBuyMTA.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked on Buy button", driver, extentedReport, screenshot);
		} catch (Exception e) {
			throw new Exception("Unable to Click on Buy Button : " + e);
		}
	}

	/**
	 * To click AddAll MTA
	 *
	 * @param extentedReport
	 * @param screenshot
	 * @throws Exception
	 * 
	 */
	public void clickAddAllMTA(ExtentTest extentedReport, boolean screenshot) throws Exception {
		try {
			WaitUtils.waitForelementToBeClickable(driver, btnAddAllMTA, "Unable to find Add All MTA button");
			btnAddAllMTA.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked on Add all button", driver, extentedReport, screenshot);
		} catch (Exception e) {
			throw new Exception("Unable to Click on addall Button : " + e);
		}
	}

	/**
	 * To click AddMTA
	 *
	 * @param extentedReport
	 * @param screenshot
	 * @throws Exception
	 * 
	 */
	public void clickAddMTA(ExtentTest extentedReport, boolean screenshot) throws Exception {
		try {
			WaitUtils.waitForelementToBeClickable(driver, btnAddMTA, "Unable to find Add MTA button");
			btnAddMTA.click();
			Log.message("Clicked on Add button", driver, extentedReport, screenshot);
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Unable to Click on ADD Button : " + e);
		}
	}

	/**
	 * To click AddAllMTA Next Button
	 *
	 * @param extentedReport
	 * @param screenshot
	 * @throws Exception
	 * 
	 */
	public void clickAddAllMTANextButton(ExtentTest extentedReport, boolean screenshot) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnAddAllMTANext);
			btnAddAllMTANext.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked on Add all  Next button", driver, extentedReport, screenshot);
		} catch (Exception e) {
			throw new Exception("Unable to Click on add all Next Button : " + e);
		}
	}

	/**
	 * To select Available AdjReasons
	 *
	 * @param reason
	 * @param extentedReport
	 * @param screenshot
	 * @throws Exception
	 * 
	 */
	public void selectAvalilableAdjReasons(String reason, ExtentTest extentedReport, boolean screenshot)
			throws Exception {
		try {
			WaitUtils.waitForListElement(driver, lstAdjReasons, 2);
			GenericUtils.getMatchingTextElementFromList(lstAdjReasons, reason).click();
			Log.message("Selected " + reason + " from Adjustment reasons", driver, extentedReport, screenshot);

		} catch (Exception e) {
			throw new Exception("Unable to Click on add all Next Button : " + e);
		}
	}

	/**
	 * To click ConfirmMTA
	 *
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void clickConfirmMTA(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForelementToBeClickable(driver, btnConfirmMTA, "Unable to find Add ConfirmMTA button");
			btnConfirmMTA.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked on Confirm button", driver, extentedReport, true);
		} catch (Exception e) {
			throw new Exception("Unable to Click on Confirm Button : " + e);
		}
	}

	/**
	 * To enter customer details
	 * 
	 * @param testdata
	 * @param Screenshot
	 * @param extentReport
	 * @throws Exception
	 * 
	 */
	public void enterQuoteDetails(HashMap<String, String> testdata, boolean Screenshot, ExtentTest extentReport)
			throws Exception {
		try {

			WaitUtils.waitForElementPresent(driver, popup_NewQuote, "New quote pop up has not shown");
			Log.message("Entering Quote details", extentReport);
			String strDate = GenericUtils.setDate("current", datePicker, 0, 0);
			datePicker.click();
			Log.message("Entered Date : " + strDate, extentReport);
			selectNewQuoteDetails(testdata, extentReport, Screenshot);
		} catch (Exception e) {
			throw new Exception("Unable to Enter Quote Details : " + e);
		}
	}

	/**
	 * To select NewQuoteDetails
	 * 
	 * @param testdata
	 * @param Screenshot
	 * @param extentReport
	 * @throws Exception
	 * 
	 */
	public void selectNewQuoteDetails(HashMap<String, String> testdata, ExtentTest extentReport, boolean Screenshot)
			throws Exception {
		try {
			selectIntermediary(testdata.get("Intermediary").toString(), extentReport);
			Log.message("Entered Intermediary : " + testdata.get("Intermediary").toString(), extentReport);
			selectProduct(testdata.get("Product").toString());
			Log.message("Selected product : " + testdata.get("Product").toString(), extentReport);
			Thread.sleep(3000);
			selectScheme(testdata.get("Scheme").toString());
			Thread.sleep(5000);
			Log.message("Selected scheme : " + testdata.get("Scheme").toString(), extentReport);
			Log.message("Entered Quote Details successfully", driver, extentReport, Screenshot);
		} catch (Exception e) {
			throw new Error("Error while selecting NewQuoteDetails : " + e);
		}
	}

	/**
	 * To enter past due date for New Quote
	 * 
	 * @param noOfDays
	 * @param noOfYear
	 * @param extentReport
	 * @param Screenshot
	 * @throws Exception
	 * 
	 */
	public void enterNewQuotePastDate(int noOfDays, int noOfYear, ExtentTest extentReport, boolean Screenshot)
			throws Exception {
		try {
			WaitUtils.waitForElementPresent(driver, popup_NewQuote, "New quote pop up has not shown");
			String pastAndFutureDate = null;
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			String stringDate = sdf.format(date);
			Date d = sdf.parse(stringDate);
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			cal.add(Calendar.DATE, +noOfDays);
			cal.add(Calendar.YEAR, -noOfYear);
			pastAndFutureDate = sdf.format(cal.getTime());
			datePicker.sendKeys(pastAndFutureDate);
			Log.message("Entered New Quote Start Date : " + pastAndFutureDate, driver, extentReport, Screenshot);
		} catch (Exception e) {
			throw new Exception("Unable to Enter Quote Details : " + e);
		}
	}

	/**
	 * To click continue button
	 * 
	 * @param Screenshot
	 * @param extentReport
	 * @return NewQuotePage
	 * @throws Exception
	 * 
	 */
	public NewQuotePage clickContinueQuote(boolean Screenshot, ExtentTest extentReport) throws Exception {
		try {
			createnewQuote.click();
			Thread.sleep(3000);
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked on Continue button", driver, extentReport, Screenshot);
		} catch (Exception e) {
			throw new Exception("Unable to Click on Continue button : " + e);
		}
		return new NewQuotePage(driver,extentReport);
	}

	/**
	 * To verify contact name
	 * 
	 * @param name
	 * @param extentReport
	 * @param Screenshot
	 * @throws Exception
	 *             return boolean
	 * 
	 */
	public boolean verifyContactName(String name, ExtentTest extentReport, boolean Screenshot) throws Exception {
		try {
			boolean status = false;
			String ContactName[] = txtContactName.getText().split("Date of Birth");
			if (ContactName[0].trim().equalsIgnoreCase(name)) {
				Log.message("Searched Contact Equals the created contact : " + ContactName[0], driver, extentReport,
						Screenshot);
				status = true;
			}
			Log.event("Verified the name of the Searched Contact");
			return status;
		} catch (Exception e) {
			throw new Exception("Verification of Contact Name Failed" + e);
		}

	}

	/**
	 * To select the intermediary
	 * 
	 * @param intermediary
	 * @param extentReport
	 * @throws Exception
	 * 
	 */
	public void selectIntermediary(String intermediary, ExtentTest extentReport) throws Exception {
		try {
			WaitUtils.waitForelementToBeClickable(driver, selectintermediary,
					"Failed to locate intermediay field on new quote pop up");
			Select inter = new Select(selectintermediary);
			inter.selectByValue(intermediary);
			Log.message("Intermediary Selected: " + intermediary, driver, extentReport);
		} catch (Exception e) {
			throw new Exception("Unable to Select Intermediary" + e);
		}
	}

	/**
	 * To select the product
	 * 
	 * @param Product
	 * @throws Exception
	 * 
	 */
	public void selectProduct(String Product) throws Exception {
		try {
			WaitUtils.waitForelementToBeClickable(driver, selectproduct,
					"Failed to locate select product field on new quote pop up");
			Select product = new Select(selectproduct);
			product.selectByValue(Product);
			Log.event("Product Selected: " + Product);
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Unable to Select product" + e);
		}
	}

	/**
	 * To select scheme
	 * 
	 * @param scheme
	 * @throws Exception
	 * 
	 */
	public void selectScheme(String Scheme) throws Exception {
		try {
			WaitUtils.waitForelementToBeClickable(driver, selectscheme,
					"Failed to locate select scheme field on new quote pop up");
			Select scheme = new Select(selectscheme);
			scheme.selectByValue(Scheme);
			Log.event("Scheme Selected: " + Scheme);
		} catch (Exception e) {

			throw new Exception("Unable to Select scheme" + e);

		}
	}

	/**
	 * click Document Tab
	 * 
	 * @param Screenshot
	 * @param extentReport
	 * @throws Exception
	 * 
	 */
	public void clickDocuments(boolean Screenshot, ExtentTest extentReport) throws Exception {
		WaitUtils.waitForSpinner(driver);
		try {
			(new WebDriverWait(driver, 10).pollingEvery(20, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.withMessage("Unable to find documents tab"))
							.until(ExpectedConditions.elementToBeClickable(documenttab));
			documenttab.click();
			Log.message("Clicked on Document Tab", driver, extentReport, Screenshot);
		} catch (Exception e) {
			throw new Exception("Unable to Click on document tab" + e);
		}
	}

	/**
	 * click on Cancel Policy
	 * 
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void clickCancelPolicy(ExtentTest extentedReport) throws Exception {

		try {
			WaitUtils.waitForSpinner(driver);
			(new WebDriverWait(driver, 180).pollingEvery(200, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.withMessage("Unable to find Cancel Policy"))
							.until(ExpectedConditions.elementToBeClickable(drpCancelPolicy));
			drpCancelPolicy.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked on Cancel Policy after upgrading policy", driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Unable to click on Cancel Policy tab :" + e);
		}
	}

	/**
	 * click Standard Cancellation
	 * 
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void clickStandardCancelletion(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, drpoptStandardCancel);
			drpoptStandardCancel.click();
			Thread.sleep(2000);
			Log.message("Clicked on Standard Cancelletion policy", driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Unable to click on standard policy cancel Button" + e);
		}
	}

	/**
	 * Verify the documents generated
	 * 
	 * @throws Exception
	 * @return boolean
	 * 
	 */
	public boolean docgenerationverification() throws Exception {
		boolean descverify;
		try {
			(new WebDriverWait(driver, 10).pollingEvery(20, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.withMessage("Unable to get text")).until(ExpectedConditions.elementToBeClickable(docdescription));
			String desc = docdescription.getText();
			(new WebDriverWait(driver, 10).pollingEvery(20, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.withMessage("Unable to get text")).until(ExpectedConditions.elementToBeClickable(NBdescription));
			String NB = NBdescription.getText();
			if (desc.equalsIgnoreCase("Document Description")
					&& (NB.contains("New Business") || NB.contains("POL_PCL"))) {
				descverify = true;
				Log.event("Documents are generated successfully");
			} else {
				descverify = false;
				Log.event("Document generation failed");
			}
			return descverify;
		} catch (Exception e) {
			throw new Exception("Document generation failed" + e);

		}

	}

	/**
	 * To cancel policy
	 * 
	 * @param testdata
	 * @param Screenshot
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void clickCancelPolicy(HashMap<String, String> testdata, boolean screenshot, ExtentTest extentedReport)
			throws Exception {
		(new WebDriverWait(driver, 20).pollingEvery(200, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
				.withMessage("Cancel Drop down is not clickable"))
						.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(rad_cancel)));
		try {

			selectRadioButton(rad_cancel, "Cancel Policy");

			if (testdata.get("Cancellation type").equals("Standard Cancellation")) {
				standardCancellation.click();
				Thread.sleep(5000);
				Log.message("Clicked on Standard Cancellation Policy", driver, extentedReport, true);
			} else {
				coolingOff.click();
				Thread.sleep(2000);
				Log.message("Clicked on Cancellation-cooling off Policy", driver, extentedReport, true);
			}
		} catch (Exception e) {
			throw new Exception("Unable to click on " + testdata.get("Cancellation type") + e);
		}
	}

	/**
	 * enter effective date
	 * 
	 * @throws Exception
	 * 
	 */
	public void enterEffectiveDate() throws Exception {
		try {
			// (new WebDriverWait(driver, 120).pollingEvery(200,
			// TimeUnit.MILLISECONDS)
			// .ignoring(NoSuchElementException.class,
			// StaleElementReferenceException.class)
			// .withMessage("Standard cancellation date picker is not loaded
			// properly"))
			// .until(ExpectedConditions.visibilityOfElementLocated(
			// By.cssSelector("#date-picker-QUE_8D734F2AC91F8FEB325795")));

			SimpleDateFormat formDate = new SimpleDateFormat("dd/MM/yyyy");
			String effectDate = formDate.format(new Date());
			effectiveDate.sendKeys(effectDate);
			Thread.sleep(500);
			effectiveDate.sendKeys(Keys.TAB);
			Log.event("Entered Effective Date");
		} catch (Exception e) {
			throw new Exception("Unable to Enter the date" + e);
		}
	}

	/**
	 * enter effective Time
	 * 
	 * @throws Exception
	 * 
	 */
	public void enterEffectiveTime() throws Exception {
		try {
			Thread.sleep(1000);
			Select effectTimeDropdown = new Select(effectiveTime);
			effectTimeDropdown.selectByVisibleText("00.01");
			Log.event("Entered Effective Time");
		} catch (Exception e) {
			throw new Exception("Unable to select the Time" + e);
		}
	}

	/**
	 * To enter Reason
	 * 
	 * @param CancelReason
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void enterReason(String CancelReason, ExtentTest extentedReport) throws Exception {
		try {

			Select cancelReasonDropdown = new Select(cancelReason);
			cancelReasonDropdown.selectByVisibleText(CancelReason);
			Log.message("Selected Cancellation Reason : " + CancelReason, extentedReport);
		} catch (Exception e) {
			throw new Exception("Unable to select the reason : " + e);
		}
	}

	/**
	 * enter premium type
	 * 
	 * @param testdata
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void enterPremiumType(HashMap<String, String> testdata, ExtentTest extentedReport) throws Exception {
		try {
			Select cancelPremiumDropdown = new Select(cancelPremiumType);
			cancelPremiumDropdown.selectByVisibleText(testdata.get("Premium type").toString());
			Thread.sleep(4000);
			Log.message("Entered Premium Type : " + testdata.get("Premium type"), extentedReport);
		} catch (Exception e) {
			throw new Exception("Unable to select the Premium Type :" + e);
		}
	}

	/**
	 * click calculate
	 * 
	 * @param Screenshot
	 * @param extentedReport
	 * @throws Exception
	 */
	public void clickCalculate(boolean screenshot, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnCalculateCancel);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnCalculateCancel);
			Thread.sleep(6000);
			Log.message("Clicked Calculate for Cancelling Policy", driver, extentedReport, true);
		} catch (Exception e) {
			throw new Exception("Unable to click on Calculate" + e);
		}
	}

	/**
	 * click confirm
	 * 
	 * @param Screenshot
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void clickConfirm(boolean screenshot, ExtentTest extentedReport) throws Exception {
		try {
			(new WebDriverWait(driver, 120).pollingEvery(200, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.withMessage("Confirm Button is not available to click"))
							.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Confirmbtn)));
			btnConfirmCancel.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked on confirm button", driver, extentedReport, screenshot);
		} catch (Exception e) {
			throw new Exception("Unable to click on Confirm" + e);
		}
		Log.event("Clicked on Confirm");
	}

	/**
	 * Verify cancellation
	 * 
	 * @param screenshot
	 * @param extentedReport
	 * @throws Exception
	 * @return boolean
	 * 
	 */
	public boolean verifyCancellation(boolean screenshot, ExtentTest extentedReport) throws Exception {
		boolean policyCancellation = false;
		try {

			(new WebDriverWait(driver, 60).pollingEvery(200, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.withMessage("Standard cancellation pop-up not loaded properly"))
							.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(popup_cancl)));

			WaitUtils.waitForElementPresent(driver, policyStatusCancelled, "Cancel pop up failed to close");
			if (policyStatusCancelled.getText().toString().contains("Cancelled")) {
				policyCancellation = true;
				Log.message("Policy cancelled status : " + policyStatusCancelled.getText().toString(), driver,
						extentedReport);
			}
		} catch (Exception e) {
			throw new Exception("Error while verifying Cancelled policy" + e);
		}
		return policyCancellation;
	}

	/**
	 * click reinstate policy
	 * 
	 * @param Screenshot
	 * @param extentedReport
	 * @throws Exception
	 */
	public void clickReinstatePolicy(boolean screenshot, ExtentTest extentedReport) throws Exception {
		try {
			(new WebDriverWait(driver, 20).pollingEvery(200, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.withMessage("Reinstate Policy is not clickable"))
							.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(rad_cancel)));
			selectRadioButton(rad_cancel, "Reinstate Policy");
			Log.message("Selected Reinstate Policy", driver, extentedReport, true);
		} catch (Exception e) {
			throw new Exception("Unable to click on Reinstate Policy" + e);
		}
		Log.event("Clicked on Reinstate Policy");
	}

	/**
	 * select reinstatement reason
	 * 
	 * @param testdata
	 * @param Screenshot
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void selectReinstateReason(HashMap<String, String> testdata, boolean screenshot, ExtentTest extentedReport)
			throws Exception {
		try {
			WaitUtils.waitForElement(driver, drpReinstateReason, 3);
			/*drpReinstateReason.click();*/
			Thread.sleep(2000);
			Select scheme = new Select(drpReinstateReason);
			scheme.selectByVisibleText(testdata.get("Reinstate Reason"));
			Log.message("Selected '" + testdata.get("Reinstate Reason") + "' as Reinstatement reason", driver,
					extentedReport, screenshot);

		} catch (Exception e) {
			throw new Exception("Unable to select Reinstate Reason:" + e);
		}
	}

	/**
	 * click calculate in reinstatement
	 * 
	 * @param Screenshot
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void clickCalculateForReinstate(boolean screenshot, ExtentTest extentedReport) throws Exception {
		try {
			fldReinstateReason.sendKeys("Client Request");
			btnCalculateReinstate.click();
			Thread.sleep(5000);
			Log.message("Clicked on Calculate button", driver, extentedReport, screenshot);
		} catch (Exception e) {
			throw new Exception("Unable to click on Calculate" + e);
		}
		Log.event("Clicked on Calculate");
	}

	/**
	 * click confirm in reinstatement
	 * 
	 * @param Screenshot
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void clickConfirmForReinstate(boolean screenshot, ExtentTest extentedReport) throws Exception {

		(new WebDriverWait(driver, 20).pollingEvery(200, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
				.withMessage("Confirm Button is not available to click in reinstate modal"))
						.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(popup_Reinst)));
		(new WebDriverWait(driver, 20).pollingEvery(200, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
				.withMessage("Confirm Button is not available to click"))
						.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(but_resinst)));
		try {
			btnConfirmReinstate.click();
			WaitUtils.waitForinvisiblityofElement(driver, 120, popup_Reinst,
					"Reinstatement pop up didnot close after clicking confirm button");
			Log.message("Clicked on confirm button in reinstate modal", driver, extentedReport, screenshot);
		} catch (Exception e) {
			throw new Exception("Unable to click on Confirm in reinstate modal :" + e);
		}
	}

	/**
	 * Verify reinstate policy
	 * 
	 * @param Screenshot
	 * @param extentedReport
	 * @throws Exception
	 * @return boolean
	 * 
	 */
	public boolean verifyReinstation(boolean screenshot, ExtentTest extentedReport) throws Exception {

		try {
			return GenericUtils.verifyWebElementTextEquals(policyStatusReinstate, "ACTIVE");

		} catch (Exception e) {
			throw new Exception("Error while verifying reinstation policy:" + e);
		}

	}

	/**
	 * select radio button
	 * 
	 * @param locator
	 * @param option
	 * @throws Exception
	 * 
	 */
	private void selectRadioButton(String locator, String option) throws Exception {
		String radio_button_value;
		try {
			List<WebElement> buttonOptions = driver.findElements(By.cssSelector(locator));

			for (int i = 0; i < buttonOptions.size(); i++) {
				radio_button_value = buttonOptions.get(i).getText();
				if (radio_button_value.contains(option)) {
					buttonOptions.get(i).click();
					WaitUtils.waitForSpinner(driver);
					radio_button_value = null;
					break;
				}
			}
		} catch (Exception e) {
			throw new Exception("Unable to Select Button Option" + e);
		}
	}

	/**
	 * click document view to view documents
	 * 
	 * @param Policynum
	 * @param extentedReport
	 * @throws Exception
	 * @return boolean
	 * 
	 */
	public boolean clickdocViewbtn(String Policynum, ExtentTest extentedReport) throws Exception {

		int count = 0;
		try {
			
			List<WebElement> viewbuttonscount = driver.findElements(By.cssSelector(docviewbuttoncounter));
			Log.message("Number of document are displaying as: " +viewbuttonscount.size());
			if(viewbuttonscount.size()>1)
			{
				
				//viewbuttons = driver.findElement(By.cssSelector(docviewFirst));
				String winHandleBefore = driver.getWindowHandle();
				String act = "";
				viewbuttons.sendKeys(Keys.ENTER);
				//viewbuttons.sendKeys(Keys.RETURN);
				WaitUtils.waitForSpinner(driver);
				Thread.sleep(2000);
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
					act = driver.getCurrentUrl();
			}

			/*for (int i = 1; i <= viewbuttonscount.size(); i++) {

				viewbuttons = driver.findElement(By.cssSelector(docviewFirst + i ));

				String winHandleBefore = driver.getWindowHandle();
				String act = "";
				viewbuttons.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				Log.event(i + " View button clicked");
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
					act = driver.getCurrentUrl();
				}*/

				Thread.sleep(2000);
				driver.switchTo().window(winHandleBefore);
				Log.event(act + "current url");
				if (act.contains("EngagementCentre")) {
					if (act.contains(Policynum)) {
						Log.message("Document opened successfully with policy number : " + Policynum, extentedReport);
						count++;
					} else {
						Log.message("Policy number doesnot match with the document opened", extentedReport);
					}

				} else {
					Log.message("PolicyDoc is not present in url", extentedReport);
					count = 0;
				}

			}

		}

		catch (Exception e) {
			throw new Exception("Unable to click on document view button " + e.getMessage());

		}
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Get policy number
	 * 
	 * @return String
	 * @throws Exception
	 * 
	 */

	public String getPolicynumber() throws Exception {
		try {
			List<WebElement> viewbuttonscount = driver.findElements(By.cssSelector(PolicyNumber));
			String Policyno = viewbuttonscount.get(0).getText();
			return Policyno;
		} catch (Exception e) {
			throw new Exception("Unable to get policy number" + e);
		}
	}

	/**
	 * Description : Select MTA from Manager Policy tab
	 * 
	 * @param extentedReport
	 * @param Screenshot
	 * @throws Exception
	 * 
	 */
	public void selectMTAfromManagePolicyTab(ExtentTest extentedReport, boolean Screenshot) throws Exception {
		try {
			clickTab("Manage Policy", extentedReport, true);
			WaitUtils.waitForElementPresent(driver, midTermAdj, "");
			midTermAdj.click();
			Log.message("Clicked on MTA sub menu", extentedReport);
		} catch (Exception e) {
			throw new Exception("Not able to select MTA from Manage Policy" + e);
		}
	}

	/**
	 * Description : Select STA from Manager Policy tab
	 * 
	 * @param extentedReport
	 * @param Screenshot
	 * @throws Exception
	 * 
	 */
	public void selectSTAfromManagePolicyTab(ExtentTest extentedReport, boolean Screenshot) throws Exception {
		try {
			clickTab("Manage Policy", extentedReport, true);
			WaitUtils.waitForElementPresent(driver, shortTermAdj, "");
			shortTermAdj.click();
			Log.message("Clicked on STA sub menu", extentedReport);
		} catch (Exception e) {
			throw new Exception("Not able to select STA from Manage Policy" + e);
		}
	}

	/**
	 * Description : Select Billing Adjustment from Manager Policy tab
	 * 
	 * @param extentedReport
	 * @param Screenshot
	 * @throws Exception
	 * 
	 */
	public void selectBAfromManagePolicyTab(ExtentTest extentedReport, boolean Screenshot) throws Exception {
		try {
			clickTab("Manage Policy", extentedReport, true);
			if (WaitUtils.waitForElement(driver, billingAdj)) {
				billingAdj.click();
				Log.message("Clicked on Billing Adjustment sub menu", driver, extentedReport, Screenshot);
				Thread.sleep(2000);
			} else {
				throw new Exception("Billing Adjustment sub menu not found");
			}
		} catch (Exception e) {
			throw new Exception("Not able to select Billing Adjustment from Manage Policy" + e);
		}
	}

	/**
	 * click manage policy dropdown
	 * 
	 * @param testdata
	 * @param Screenshot
	 * @throws Exception
	 * 
	 */

	public void clickfromManagePolicyDropdown(HashMap<String, String> testdata, boolean screenshot,
			ExtentTest extentedReport) throws Exception {

		WaitUtils.waitForElementPresent(driver, 60, PolicyAdminPane,
				"Manage policy drop down selection was not successful");
		try {
			selectdropDownMenu(rad_cancel, "Manage Policy");
			Log.message("Clicked on Manage Policy", driver, extentedReport);
			String browsername = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("browser");
			if (browsername.equalsIgnoreCase("firefox")) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("javascript:window.scrollBy(0,350)");
			}
			Thread.sleep(2000);
			midTermAdj.click();
			Thread.sleep(500);
			Log.message("Clicked on Mid Term Adjustment(MTA) menu item", extentedReport);

		} catch (Exception e) {
			throw new Exception("Unable to click on Managepolicy > " + testdata.get("ManagePolicy").toString() + e);
		}
	}

	/**
	 * select Manage Policy dropdown
	 * 
	 * @param option
	 * @param extentReport
	 * @param screenshot
	 * @throws Exception
	 * 
	 */
	public void selectTabDropdown(String option, ExtentTest extentReport, boolean screenshot) throws Exception {
		try {
			selectdropDownMenu(rad_cancel, option);
			WaitUtils.waitForElement(driver, lnkMidTermAdjust);
			Thread.sleep(2000);
			Log.message("Clicked on " + option + " dropdown", driver, extentReport, screenshot);

		} catch (Exception e) {
			throw new Exception("Unable to Select Option" + e);
		}
	}

	/**
	 * click webelement
	 * 
	 * @param elment
	 * @param msg
	 * @throws Exception
	 * 
	 */

	public void click(WebElement elment, String msg) throws Exception {
		try {
			WaitUtils.waitForElementPresent(driver, 60, elment, "Failed to " + msg);
			elment.click();
			Log.event(msg);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	/**
	 * select dropdownMenu
	 * 
	 * @param locator
	 * @param option
	 * @throws Exception
	 * 
	 */
	public void selectdropDownMenu(String locator, String option) throws Exception {
		String radio_button_value;

		try {
			List<WebElement> buttonOptions = driver.findElements(By.cssSelector(locator));

			for (int i = 0; i < buttonOptions.size(); i++) {
				radio_button_value = buttonOptions.get(i).getText();
				if (radio_button_value.contains(option)) {
					new WebDriverWait(driver, 30).pollingEvery(200, TimeUnit.MILLISECONDS)
							.until(ExpectedConditions.visibilityOf(buttonOptions.get(i)));
					//buttonOptions.get(i).sendKeys(option);
					buttonOptions.get(i).click();
					Thread.sleep(2000);
					radio_button_value = null;
					break;
				}
			}
		} catch (Exception e) {
			throw new Exception("Unable to Select Option" + e.getMessage());
		}
	}

	/**
	 * enter MTA Details
	 * 
	 * @param testdata
	 * @param screenshot
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public GetQuotePage enterMTADetails(HashMap<String, String> testdata, ExtentTest extentedReport, boolean Screenshot)
			throws Exception {
		try {
			WaitUtils.waitForElementPresent(driver, 40, MTAPopUp, "MTA Reason selection window was not found");

			SimpleDateFormat formDate = new SimpleDateFormat("dd/MM/yyyy");
			String strDate = formDate.format(new Date());
			Log.event("Date is : " + strDate);
			new WebDriverWait(driver, 120).pollingEvery(200, TimeUnit.MILLISECONDS)
					.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(mtaStartDate))));
			WebElement mtaStartDateele = driver.findElement(By.cssSelector(mtaStartDate));
			EnterEffectiveDateOnWind(mtaStartDateele, true);
			Thread.sleep(1000);
			selectMTAReason(testdata.get("AdjustmentReason"));
			Thread.sleep(1000);
			click(mtaContinueBut, "Clicked continue button on MTA popup ");
			WaitUtils.waitForSpinner(driver);
			return new GetQuotePage(driver, extentedReport).get();

		} catch (Exception e) {
			throw new Exception("Failed to enter MTA details: " + e.getMessage());
		}

	}

	/**
	 * enter STA Details
	 * 
	 * @param testdata
	 * @param extentedReport
	 * @param screenshot
	 * @throws Exception
	 * 
	 */
	public void enterSTADetails(HashMap<String, String> testdata, ExtentTest extentedReport, boolean Screenshot)
			throws Exception {
		try {
			WaitUtils.waitForElementPresent(driver, 40, STAPopUp, "STA Reason selection window was not found");

			SimpleDateFormat formDate = new SimpleDateFormat("dd/MM/yyyy");
			String strDate = formDate.format(new Date());
			Log.event("Date is : " + strDate);

			new WebDriverWait(driver, 120).pollingEvery(200, TimeUnit.MILLISECONDS)
					.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(staStartDate))));
			WebElement staStartDateEle = driver.findElement(By.cssSelector(staStartDate));
			EnterEffectiveDateOnWind(staStartDateEle, true);
			Thread.sleep(1000);

			new WebDriverWait(driver, 120).pollingEvery(200, TimeUnit.MILLISECONDS)
					.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(staExpiryDate))));
			WebElement staExpiryDateEle = driver.findElement(By.cssSelector(staExpiryDate));
			EnterExpiryDateOnWind(staExpiryDateEle, true);
			Thread.sleep(1000);

			selectSTAReason(testdata.get("AdjustmentReason"));
			Thread.sleep(1000);
			click(staContinueBut, "Clicked continue button on STA popup ");

		} catch (Exception e) {
			throw new Exception("Failed to enter STA details: " + e);
		}

	}

	/**
	 * 
	 * enter BTA Details
	 * 
	 * @param testdata
	 * @param extentedReport
	 * @param screenshot
	 * @throws Exception
	 *
	 * 
	 */
	public BillingAdjustmentPage enterBADetails(HashMap<String, String> testdata, ExtentTest extentedReport,
			boolean Screenshot) throws Exception {
		try {
			WaitUtils.waitForElementPresent(driver, 10, BAPopUp,
					"Billing Adjustment Reason selection window was not found");

			SimpleDateFormat formDate = new SimpleDateFormat("dd/MM/yyyy");
			String strDate = formDate.format(new Date());
			Log.event("Date is : " + strDate);
			selectBAReason(testdata.get("AdjustmentReason").toString(), extentedReport);
			Thread.sleep(1000);
			click(baContinueBut, "Clicked continue button on BA popup ");
			Thread.sleep(2000);
			WaitUtils.waitForSpinner(driver);
			return new BillingAdjustmentPage(driver,extentedReport).get();

		} catch (Exception e) {
			throw new Exception("Failed to enter BA details: " + e.getMessage());
		}

	}

	/**
	 * Verify GetquotePage
	 * 
	 * @return GetQuotePage
	 * @throws Exception
	 * 
	 */

	public GetQuotePage verifyGetQuotePage(ExtentTest extentReport) throws Exception {

		try {
			WaitUtils.waitForPageLoad(driver);
			(new WebDriverWait(driver, 180).pollingEvery(200, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.withMessage("Unable to Switch to Windows"))
							.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(spinner)));
			(new WebDriverWait(driver, 180).pollingEvery(200, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.withMessage("Unable to find Edit Details Link"))
							.until(ExpectedConditions.elementToBeClickable(btnDashboard));
			if (btnDashboard.isEnabled()) {
				Log.message("Get Quote page is verified", driver, extentReport);
			}

		} catch (Exception ex) {
			throw new Exception("Get Quote page verification Failed" + ex.getMessage());
		}
		return new GetQuotePage(driver, extentedReport).get();
	}

	/**
	 * select MTA Reason
	 * 
	 * @param MidTermReason
	 * @throws Exception
	 * 
	 */
	public void selectMTAReason(String MidTermReason) throws Exception {
		try {
			new WebDriverWait(driver, 300).pollingEvery(200, TimeUnit.MILLISECONDS)
					.until(ExpectedConditions.visibilityOf(mtaReason));
			Select inter = new Select(mtaReason);
			(new WebDriverWait(driver, 180).pollingEvery(200, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.withMessage("Unable to find the MTA Reason"))
							.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(spinner)));
			inter.selectByVisibleText(MidTermReason);
			Log.message("MTA Reason selected was : " + MidTermReason);
		} catch (Exception e) {
			throw new Exception("Unable to Select MTA Reason" + e);
		}
	}

	/**
	 * 
	 * select STA Reason
	 * 
	 * @param staReasonTestdata
	 *            as String
	 * @throws Exception
	 * 
	 */
	public void selectSTAReason(String staReasonTestdata) throws Exception {
		try {
			System.out.println("STA Reason Test Data : " + staReasonTestdata);
			Select inter = new Select(staReason);
			(new WebDriverWait(driver, 180).pollingEvery(200, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.withMessage("Unable to find the STA Reason"))
							.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(spinner)));
			inter.selectByVisibleText(staReasonTestdata);
			Log.message("STA Reason Selected : " + staReasonTestdata);

		} catch (Exception e) {
			throw new Exception("Unable to Select STA resons :" + e);
		}
	}

	/**
	 * 
	 * select BA Reason
	 * 
	 * @param baReasonTestData
	 *            as String
	 * @param extentReport
	 * @throws Exception
	 * 
	 */
	public void selectBAReason(String baReasonTestData, ExtentTest extentReport) throws Exception {
		try {
			System.out.println("BA Reason Test Data : " + baReasonTestData);
			Select inter = new Select(baReason);
			(new WebDriverWait(driver, 180).pollingEvery(200, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.withMessage("Unable to find the BA Reason"))
							.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(spinner)));
			inter.selectByVisibleText(baReasonTestData);
			Log.message("BA reason Selected : " + baReasonTestData, driver, extentReport);
		} catch (Exception e) {
			throw new Exception("Unable to Select BA resons :" + e);
		}
	}

	/**
	 * 
	 * Enter effective date for mta
	 * 
	 * @param ElementToInteract
	 *            as Webelement
	 * @param Screenshot
	 *            as boolean
	 * @throws Exception
	 * 
	 */

	public void EnterEffectiveDateOnWind(WebElement ElementToInteract, boolean Screenshot) throws Exception {
		try {
			WaitUtils.waitForElementPresent(driver, 120, ElementToInteract, "Failed to click on MTA date field");
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar calobj = Calendar.getInstance();
			calobj.add(Calendar.DAY_OF_MONTH, 1);

			String effectDate = format.format(calobj.getTime()).toString();
			new WebDriverWait(driver, 1000).pollingEvery(200, TimeUnit.MILLISECONDS)
					.until(ExpectedConditions.visibilityOf(ElementToInteract));
			ElementToInteract.sendKeys(effectDate);
			Thread.sleep(1000);
			Log.event("Entered Effective Date");
		} catch (Exception e) {
			throw new Exception("Unable to Enter the date: " + e);
		}
	}

	/**
	 * 
	 * Enter expiry date for mta
	 * 
	 * @param ElementToInteract
	 *            as Webelement
	 * @param Screenshot
	 *            as boolean
	 * @throws Exception
	 * 
	 */

	public void EnterExpiryDateOnWind(WebElement ElementToInteract, boolean Screenshot) throws Exception {
		try {
			WaitUtils.waitForElementPresent(driver, 120, ElementToInteract, "Failed to click on MTA date field");
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar calobj = Calendar.getInstance();
			calobj.add(Calendar.DAY_OF_MONTH, 30);
			String effectDate = format.format(calobj.getTime()).toString();
			new WebDriverWait(driver, 1000).pollingEvery(200, TimeUnit.MILLISECONDS)
					.until(ExpectedConditions.visibilityOf(ElementToInteract));
			ElementToInteract.sendKeys(effectDate);
			Thread.sleep(1000);
			Log.event("Entered Expiry Date");
		} catch (Exception e) {
			throw new Exception("Unable to Enter the date: " + e);
		}
	}

	/**
	 * 
	 * Get policy URN
	 * 
	 * @throws Exception
	 *             as custom Exception Message
	 * @param extentedReport
	 * @return HashMap
	 * 
	 */

	public HashMap<String, String> getPolicyURN(ExtentTest extentedReport) throws Exception {
		try {
			HashMap<String, String> hmpolDetails = new HashMap<String, String>();
			WaitUtils.waitForelementToBeClickable(driver, getPolicyTab,
					"View More Quotes and Policies tab is not clickable");
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", getPolicyTab);

			WaitUtils.waitForElementPresent(driver, driver.findElement(By.cssSelector(tblPolicydetails)),
					"Policis were not displayed under view more quotes and policies tab");
			List<WebElement> tbl_Policydetails = driver.findElements(By.cssSelector(cssTableVals));

			hmpolDetails.put("PolicyNo", GenericUtils.getTextOfWebElement(tbl_Policydetails.get(2), driver));
			hmpolDetails.put("Position", GenericUtils.getTextOfWebElement(tbl_Policydetails.get(0), driver));
			hmpolDetails.put("Status", GenericUtils.getTextOfWebElement(tbl_Policydetails.get(1), driver));
			hmpolDetails.put("InceptionDate", GenericUtils.getTextOfWebElement(tbl_Policydetails.get(3), driver));
			hmpolDetails.put("ExpiryDate", GenericUtils.getTextOfWebElement(tbl_Policydetails.get(4), driver));
			hmpolDetails.put("Product", GenericUtils.getTextOfWebElement(tbl_Policydetails.get(5), driver));
			hmpolDetails.put("Scheme", GenericUtils.getTextOfWebElement(tbl_Policydetails.get(6), driver));
			hmpolDetails.put("notification_plcy", GenericUtils.getTextOfWebElement(tbl_Policydetails.get(7), driver));
			Log.event("Policy URN : " + hmpolDetails.get("PolicyNo"));
			Log.message(
					"Policy Created Successfully. Policy URN : " + hmpolDetails.get("PolicyNo") + ", Policy Position : "
							+ hmpolDetails.get("Position") + ", Policy Status : " + hmpolDetails.get("Status"),
					driver, extentedReport, true);
			return hmpolDetails;

		} catch (Exception e) {
			throw new Exception("Unable to get the policy URN from customer dashboard page: " + e);
		}

	}

	/**
	 * 
	 * Click Complete button
	 * 
	 * @param extentedReport
	 * @throws Exception
	 *             as custom Exception Message
	 * 
	 */

	public void clickComplete(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElementPresent(driver, 180, completeButon, "Failed to locate complete button");
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", completeButon);
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked on Complete button successfully", driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Unable to click complete button, throws exception :" + e);
		}
	}

	/**
	 * 
	 * click on Address Edit Button
	 * 
	 * @param extentedReport
	 * @param screenshot
	 * @throws Exception
	 * 
	 * 
	 */

	public void clickAddressEditButton(boolean screenshot, ExtentTest extentedReport) throws Exception {
		try {
			(new WebDriverWait(driver, 20).pollingEvery(200, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.withMessage("Manage Policy Detail button is not available to click"))
							.until(ExpectedConditions
									.visibilityOfElementLocated(By.cssSelector(butManagePolicyAddressEditcss)));
			btnManagePolicyAddressEdit.click();
			Log.message("Clicked edit button in Manage policy detail button", driver, extentedReport, true);
		} catch (Exception e) {
			throw new Exception("Unable to click on edit button in Manage policy" + e);
		}
	}

	/**
	 * 
	 * Verified by entering Home number or Name in edit address
	 * 
	 * @param HouseNumbOrName
	 * @param extentedReport
	 * @throws Exception
	 * 
	 * 
	 */

	public void enterHomeNumbOrNameInEditAddress(String HouseNumbOrName, ExtentTest extentedReport) throws Exception {
		try {
			(new WebDriverWait(driver, 20).pollingEvery(200, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.withMessage("Calculate Button is not available to click"))
							.until(ExpectedConditions
									.visibilityOfElementLocated(By.cssSelector(txtEditAddressHouseNameOrNumcss)));

			txtEditAddressHouseNameOrNum.sendKeys(HouseNumbOrName);
			Log.message("Entered : " + HouseNumbOrName + " in 'House number or name' field", extentedReport);
		} catch (Exception e) {
			throw new Exception("Unable to edit the 'House number or name' field" + e);
		}
	}

	/**
	 * 
	 * Entering Post code in Edit address
	 * 
	 * @param extentedReport
	 * @param PostCodeForAddressEdit
	 * @throws Exception
	 * 
	 * 
	 */

	public void enterPostCodeEditAddress(String PostCodeForAddressEdit, ExtentTest extentedReport) throws Exception {
		try {
			(new WebDriverWait(driver, 20).pollingEvery(200, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.withMessage("Calculate Button is not available to click")).until(
							ExpectedConditions.visibilityOfElementLocated(By.cssSelector(txtEditAddressPostCodecss)));

			txtEditAddressPostCode.sendKeys(PostCodeForAddressEdit);
			Log.message("Entered : " + PostCodeForAddressEdit + " in 'Postcode' field", extentedReport);
		} catch (Exception e) {
			throw new Exception("Unable to edit the 'Postcode' field" + e);
		}
	}

	/**
	 * 
	 * click find address in Address Edit
	 * 
	 * @param extentedReport
	 * @param screenshot
	 * @throws Exception
	 * 
	 * 
	 */

	public void clickFindAddressInAddressEdit(boolean screenshot, ExtentTest extentedReport) throws Exception {
		try {
			(new WebDriverWait(driver, 20).pollingEvery(200, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.withMessage("Find address button is not available to click")).until(
							ExpectedConditions.visibilityOfElementLocated(By.cssSelector(btnEditAddFindAddresscss)));
			btnEditAddFindAddress.click();
			Log.message("'Find Address' button in edit address tab is clicked", driver, extentedReport, true);
		} catch (Exception e) {
			throw new Exception("'Find Address' button in edit address tab is clicked" + e);
		}
		Log.event("Clicked on find address");
	}

	/**
	 * 
	 * To verify error message in address edit while entering post code
	 * 
	 * @param extentedReport
	 * @param textToVerify
	 * @throws Exception
	 * @return boolean
	 * 
	 * 
	 */

	public boolean verifyErPoostCodeNotEnteredEditAddress(String textToVerify, ExtentTest extentedReport,
			boolean Screenshot) throws Exception {
		WaitUtils.waitForElement(driver, txtEditAddressPostCodeErrMsg, 20);
		if (!GenericUtils.verifyWebElementTextContains(txtEditAddressPostCodeErrMsg, textToVerify)) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * Select an Address
	 * 
	 * @param extentedReport
	 * @throws Exception
	 * 
	 * 
	 */

	public void selectAddress(ExtentTest extentedReport) throws Exception {
		try {
			(new WebDriverWait(driver, 180).pollingEvery(200, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.withMessage("Address not Listed")).until(ExpectedConditions.visibilityOf(addressListSelect));
			Select cn_Address = new Select(addressListSelect);
			cn_Address.selectByIndex(0);
			(new WebDriverWait(driver, 180).pollingEvery(200, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.withMessage("Address is not selected")).until(ExpectedConditions.visibilityOf(addressLineOne));
			Log.message("The Address is selected successfully", extentedReport);
		}

		catch (Exception e) {
			throw new Exception("Unable to Select Address" + e);
		}
	}

	/**
	 * 
	 * click on Cancel button in Address Edit
	 * 
	 * @param extentedReport
	 * @throws Exception
	 * 
	 * 
	 */

	public void clickAddressEditCancel(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForelementToBeClickable(driver, btnAddressEditCancel, "Unable to locate element");
			btnAddressEditCancel.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked on Cancel button in Address Edit Popup", extentedReport);
		} catch (Exception e) {
			throw new Exception("Unable to click Cancel button" + e);
		}
	}

	/**
	 * 
	 * click on Close in Address Edit
	 * 
	 * @param extentedReport
	 * @param screenshot
	 * @throws Exception
	 * 
	 * 
	 */

	public void clickCloseInAddressEdit(boolean screenshot, ExtentTest extentedReport) throws Exception {
		try {
			(new WebDriverWait(driver, 20).pollingEvery(200, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.withMessage("Close Button is not available to click"))
							.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(btnEditAddClosecss)));
			btnEditAddClose.click();
			Log.message("'Close' button in edit address tab is clicked", driver, extentedReport, true);
		} catch (Exception e) {
			throw new Exception("'Close' button in edit address tab is clicked" + e);
		}
		Log.event("Clicked on close button");
	}

	/**
	 * 
	 * click on Manage Policy Details button
	 * 
	 * @param extentedReport
	 * @param screenshot
	 * @throws Exception
	 * 
	 * 
	 */

	public void clickManagePolicyDetailsButton(boolean screenshot, ExtentTest extentedReport) throws Exception {
		try {
			(new WebDriverWait(driver, 20).pollingEvery(200, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.withMessage("Manage Policy Detail button is not available to click")).until(
							ExpectedConditions.visibilityOfElementLocated(By.cssSelector(butManagePolicyDetailcss)));
			btnManagePolicyDetails.click();
			Log.message("Clicked Manage policy detail button", driver, extentedReport, true);
		} catch (Exception e) {
			throw new Exception("Unable to click on Manage policy detail" + e);
		}
		Log.event("Clicked on Manage policy detail");
	}

	/**
	 * 
	 * Verify the generated document
	 * 
	 * @param docname
	 *            as string
	 * @param status
	 *            as string
	 * @param extentReport
	 * @throws Exception
	 * @return boolean
	 * 
	 */

	public boolean verifyDocumentGeneration(String docname, String status, ExtentTest extentReport) throws Exception {
		boolean descverify = false;
		try {
			String secondname = null;
			String firstname = null;
			WaitUtils.waitForSpinner(driver);
			if (!WaitUtils.waitForElement(driver, documentdescription, 2))
				return descverify;

			String desc = docdescription.getText();
			WaitUtils.waitForelementToBeClickable(driver, documentdescription,
					"Unable to get document description text");
			String doctitle = documentdescription.getText();

			if (docname.contains("_")) {
				String[] splitedname = docname.split("_");
				firstname = splitedname[0];
				secondname = splitedname[1];
				if (desc.equalsIgnoreCase("Document Description")) {
					if ((doctitle.contains(firstname)) || doctitle.contains(secondname)) {
						descverify = true;
						Log.message("Documents are generated successfully for " + status + " Policy", driver,
								extentReport, true);
					}
				}
			} else if (desc.equalsIgnoreCase("Document Description")) {
				secondname = docname;
				if ((doctitle.contains(docname)) || doctitle.contains(secondname)) {
					descverify = true;
					Log.message("Documents are generated successfully for " + status + " Policy", driver, extentReport,
							true);
				}
			} else {
				Log.fail("Document generation failed ", driver, extentReport, true);
			}

			return descverify;
		} catch (Exception e) {
			throw new Exception("Document generation failed :" + e);

		}

	}

	/**
	 * 
	 * verify expand or collapse functionality on customer dashboard page
	 * 
	 * @param extentedReport
	 * @param Screenshot
	 * @throws Exception
	 *             as custom Exception Message
	 * 
	 */

	public void verify_ExpandCollapse_Custdashboard(ExtentTest extentedReport, boolean Screenshot) throws Exception {
		try {
			WaitUtils.waitForElement(driver, tab_viewQuotPolicies);
			validate_expand(tab_viewQuotPolicies, "Default_Collapse", true, extentedReport);
			validate_expand(tab_contacts, "Default_Expand", true, extentedReport);

			List<WebElement> ele_TabsToChk = Arrays.asList(tab_viewQuotPolicies, tab_viewPolicyNotes, tab_contacts,
					tab_preferences, tab_system_Audit_History);
			for (int j = 0; j < ele_TabsToChk.size(); j++) {

				validate_expand(ele_TabsToChk.get(j), "Expand", true, extentedReport);
				validate_expand(ele_TabsToChk.get(j), "Collapse", true, extentedReport);

			}
		} catch (Exception e) {
			throw new Exception("Unable to expand or collapse " + e);
		}

	}

	/**
	 * 
	 * verify expand or collapse functionality on customer dashboard page @
	 * ele_Tochk : Web element to check whether it is expanded or collapsed @
	 * defaultValue : true / false to check whether the field is expanded by
	 * default l
	 * 
	 * @param ele_Tochk
	 * @param expCollapse
	 * @param Screenshot
	 * @param extentedReport
	 * @throws Exception
	 *             as custom Exception Message
	 * 
	 */
	public void validate_expand(WebElement ele_Tochk, String expCollapse, boolean Screenshot, ExtentTest extentedReport)
			throws Exception {
		String isexpanded;
		try {
			Actions actions = new Actions(driver);

			switch (expCollapse) {

			case "Default_Collapse":

				try {
					WaitUtils.waitForElementPresent(driver, 180, ele_Tochk.findElement(By.cssSelector(but_expand)),
							"Expand caret button was not present as default for" + ele_Tochk.getText() + "field");
					Log.message(ele_Tochk.getText() + " field in collapsed state", driver, extentedReport, true);
				} catch (Exception e) {
					throw new Exception(ele_Tochk.getText() + "field was not collapsed by default" + e);
				}
				break;

			case "Default_Expand":
				try {
					actions.moveToElement(ele_Tochk).click().build().perform();
					WaitUtils.waitForElementPresent(driver, 200, ele_Tochk.findElement(By.cssSelector(but_expand)),
							"Collapse caret button was not present as default for" + ele_Tochk.getText() + "field");
					Log.message(ele_Tochk.getText() + " field in expanded state", driver, extentedReport, true);

				} catch (Exception e) {
					throw new Exception(ele_Tochk.getText() + " field is not expanded by default" + e);
				}
				break;

			case "Expand":
				WaitUtils.waitForelementToBeClickable(driver, ele_Tochk,
						"Unable to locate element on customer dashboard page to perform expand/ collapse");
				GenericUtils.moveToElementJS(driver, ele_Tochk);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele_Tochk);

				WaitUtils.waitForSpinner(driver);
				isexpanded = ele_Tochk.getAttribute("aria-expanded");
				if (isexpanded.equalsIgnoreCase("true"))

					Log.message(ele_Tochk.getText() + " field expanded successfully", driver, extentedReport, true);
				else
					Log.fail(ele_Tochk.getText() + " failed to expand on clicking expand/collapse button", driver,
							extentedReport, true);
				break;

			case "Collapse":
				WaitUtils.waitForelementToBeClickable(driver, ele_Tochk,
						"Unable to locate element on customer dashboard page to perform expand/ collapse");
				GenericUtils.moveToElementJS(driver, ele_Tochk);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele_Tochk);
				WaitUtils.waitForSpinner(driver);
				isexpanded = ele_Tochk.getAttribute("aria-expanded");
				if (isexpanded.equalsIgnoreCase("false"))

					Log.message(ele_Tochk.getText() + " field collapsed successfully", driver, extentedReport, true);
				else
					Log.fail(ele_Tochk.getText() + " field has failed to collapse on clicking expand/collapse button",
							driver, extentedReport, true);

				break;

			}

		} catch (Exception e) {
			throw new Exception("Unable to expand or collapse" + e);
		}

	}

	/**
	 * 
	 * verify_PolicyTab on customer dashboard page @ URN : Policy URN as string
	 * 
	 * @param URN
	 * @param extentedReport
	 * @param Screenshot
	 * @throws Exception
	 *             as custom Exception Message
	 * 
	 */

	public void verify_PolicyTab(String URN, ExtentTest extentedReport, boolean Screenshot) throws Exception {

		try {

			if (GenericUtils.getTextOfWebElement(tab_PolicyHolder_details, driver).trim()
					.equalsIgnoreCase("Policy " + URN + " Household Modular Household Standard Policyholder"))
				Log.message("Policy bar has the product information on policy tab. Displayed as "
						+ tab_PolicyHolder_details.getText(), extentedReport);
			else
				Log.fail("Product information was not displayed on policy tab. Displayed as "
						+ tab_PolicyHolder_details.getText(), extentedReport);

			WaitUtils.waitForinvisiblityofElement(driver, 180, tab_PolicyHolder + but_collapse,
					"Collpase buton was visible on policy bar, it should present on policy information bar");
			WaitUtils.waitForinvisiblityofElement(driver, 180, tab_PolicyHolder + but_expand,
					"Expand buton was visible on policy bar, it should present on policy information bar");

			Log.message("Expand / collpase icon was not found on policy bar as expected", extentedReport);

		} catch (Exception e) {
			throw new Exception("Unable to get the policy information from policy bar :" + e);
		}
	}

	/**
	 * 
	 * verify PolicyDetail Tab on customer dash board page
	 * 
	 * @param extentedReport
	 * @param Screenshot
	 * @throws Exception
	 *             as custom Exception Message
	 * 
	 */

	public void verifyPolDetailTab(ExtentTest extentedReport, boolean Screenshot) throws Exception {
		WaitUtils.waitForElementPresent(driver, 180, tab_viewPolDetails,
				"Unable to locate policy details tab under Policy Bar");
		try {
			List<WebElement> buttonOptions = driver.findElements(By.cssSelector(rad_cancel));
			for (int i = 0; i < buttonOptions.size(); i++) {
				if (buttonOptions.get(i).getText().contains("Policy Details")) {
					WaitUtils.waitForElementPresent(driver, 180, drpDwn_PolDetails,
							"Unable to locate policy details menu item");
					drpDwn_PolDetails.click();
					Log.message("Clicked on Policy Details", extentedReport);
					WaitUtils.waitForElementPresent(driver, 180, drpDwn_polCover,
							"Unable to locate policy cover menu item");
					if (drpDwn_polCover.getText().equalsIgnoreCase("Policy Cover"))
						Log.message("Policy details drop down has the expected Policy cover as menuitem",
								extentedReport);

					else
						Log.fail("Policy details drop down failed to have the expected Policy cover as menuitem",
								extentedReport);

					break;
				}
			}
		} catch (Exception e) {
			throw new Exception("Unable to get the policy information from policy bar" + e);
		}

	}

	/**
	 * 
	 * Description : Get any tab from Policy details page
	 * 
	 * Return : WebElement
	 * 
	 * @param tabName
	 *            - name of the tab to be returned
	 * @param extentedReport
	 * @param Screenshot
	 * 
	 * @throws Exception
	 *             as custom Exception Message
	 * 
	 */
	public WebElement getTabElement(String tabName, ExtentTest extentedReport, boolean Screenshot) {
		WebElement tabElement = null;
		Log.message("Looking for tab " + tabName, driver, extentedReport);
		if (tabName.equalsIgnoreCase("Finance")) {
			tabElement = tab_finance;
		} else if (tabName.equalsIgnoreCase("Manage Policy")) {
			tabElement = tab_manage_policy;
		} else if (tabName.equalsIgnoreCase("Complaints")) {
			tabElement = tab_complaints;
		}
		return tabElement;
	}

	/**
	 * 
	 * Description : Check if any particular Tab available in Policy details
	 * page
	 * 
	 * Return : boolean
	 * 
	 * @param tabName
	 *            - name of the tab to be checked
	 * @param extentedReport
	 * @param screenshot
	 * 
	 * @throws Exception
	 *             as custom Exception Message
	 * 
	 */
	public boolean isThisTabAvailableInPolicyDetails(String tabName, ExtentTest extentedReport, boolean Screenshot)
			throws Exception {
		WebElement tabElement = getTabElement(tabName, extentedReport, Screenshot);
		if (WaitUtils.waitForElement(driver, tabElement)) {
			Log.message(tabName + " Present on the Policy Details", driver, extentedReport, true);
			return true;
		} else {
			Log.message(tabName + " not Presents on the Policy Details", driver, extentedReport, true);
			return false;
		}
	}

	/**
	 * 
	 * Description : Click any particular tab on Policy details page
	 * 
	 * return : void
	 * 
	 * @param tabName
	 *            - name of the tab to be clicked
	 * @param extentedReport
	 * @param screenshot
	 * 
	 * @throws Exception
	 *             as custom Exception Message
	 * 
	 */
	public void clickTab(String tabName, ExtentTest extentedReport, boolean Screenshot) throws Exception {
		if (isThisTabAvailableInPolicyDetails(tabName, extentedReport, Screenshot)) {
			WebElement tabElement = getTabElement(tabName, extentedReport, Screenshot);
			tabElement.click();
			WaitUtils.waitForSpinner(driver);
			WaitUtils.waitForPageLoad(driver, 60);
			Log.message(tabName + " tab is clicked", driver, extentedReport, true);
		} else {
			Log.message(tabName + " tab not clicked", driver, extentedReport, true);
		}
	}

	/**
	 * Description : Check the given tab sections are available in particular
	 * tab of Policy details page
	 * 
	 * Return : boolean
	 * 
	 * @param sections
	 *            - Pass the section names to check whether it is available in
	 *            tab
	 * @param extentedReport
	 * @param Screenshot
	 * 
	 * @throws Exception
	 */
	public boolean showTabSectionsIfAvailable(String[] sections, ExtentTest extentedReport, boolean Screenshot)
			throws Exception {
		boolean toReturn = false;
		List<WebElement> tabSections = driver.findElements(By.cssSelector(tab_sections));

		if (tabSections.size() > 0) {
			int count = 0;
			for (WebElement tabSection : tabSections) {
				if ((!tabSection.getText().isEmpty()) || tabSection.getText() != null) {
					for (String section : sections) {
						if (tabSection.getText().equalsIgnoreCase(section)) {
							count++;
							Log.message("Tab " + count + " exists : " + tabSection.getText() + "--" + section);
						}
					}
				}
			}
			toReturn = (sections.length == count) ? true : false;
			String logMsg = (count == 0) ? "No such tab sections found"
					: ((count == sections.length) ? "All tab section exists" : "Some tab section missing");
			Log.message(logMsg, extentedReport);
		} else {
			Log.message("No tab sections found", extentedReport);
		}
		return toReturn;
	}

	/**
	 * Description : To check the fields of Finance Billing Details section in
	 * Finance Tab of Policy Details
	 * 
	 * Return : boolean
	 * 
	 * @param fields
	 *            - Field names of finance billing details section
	 * @param extentedReport
	 * @param Screenshot
	 * 
	 */
	public boolean checkFieldsOfFinanceBillingDetails(String[] fields, ExtentTest extentedReport, boolean Screenshot) {
		boolean tcReturn = false;
		String financeBillingDetailsFields = tab_finance_section_finance_billing_details.getText();
		int count = 0;
		for (String field : fields) {
			if (financeBillingDetailsFields.contains(field + ":")) {
				count++;
				Log.message("Field " + count + " " + field + " available", extentedReport);
			}
		}
		tcReturn = (fields.length == count) ? true : false;
		String logMsg = (fields.length == count) ? "All fields available"
				: ((fields.length == 0) ? "No fields available" : "Some fields missing");
		Log.message(logMsg, extentedReport);
		return tcReturn;
	}

	/**
	 * Description : Click on manage contact details
	 * 
	 * Return :ManageContactDetailsPage
	 * 
	 * @param extentedReport
	 * @param Screenshot
	 * @throws Exception
	 * 
	 */

	public ManageContactDetailsPage verifyndClickManageCntDetails(ExtentTest extentedReport, boolean screenshot)
			throws Exception {
		try {
			WaitUtils.waitForelementToBeClickable(driver, manageCustDetails,
					"Unable to locate Manage Custometer Details element");
			if (WaitUtils.waitForElement(driver, manageCustDetails)) {
				manageCustDetails.click();
				Log.message("Clicked on Manage Custometer Details button", driver, extentedReport);
				WaitUtils.waitForSpinner(driver);
			}
		} catch (Exception e) {
			throw new Exception("Unable to click Manage Custometer Details button" + e);
		}
		return new ManageContactDetailsPage(driver,extentedReport).get();
	}

	/**
	 * Description : To verify address head
	 * 
	 * @param extentedReport
	 * @param Screenshot
	 * @param AddrsRow
	 * @throws Exception
	 * 
	 */

	public void Verifyaddrshead(ExtentTest extentedReport, boolean Screenshot, String AddrsRow) throws Exception {

		try {
			List<WebElement> AddressHeadingActual = driver.findElements(By.cssSelector(AdressTabHeadfields));
			String[] AddrsHeadingExpected = AddrsRow.split(",");
			for (int i = 0; i < AddressHeadingActual.size(); i++) {
				Thread.sleep(500);
				if (AddressHeadingActual.get(i).isDisplayed()) {
					if (AddressHeadingActual.get(i).getText().equalsIgnoreCase(AddrsHeadingExpected[i]))
						Log.message(AddressHeadingActual.get(i).getText() + " Is Displayed", driver, extentedReport,
								Screenshot);
					else
						Log.fail(AddressHeadingActual.get(i).getText() + " Is Displaying", driver, extentedReport,
								Screenshot);
				} else
					Log.fail(AddressHeadingActual.get(i) + " is not Displayed", driver, extentedReport, Screenshot);

			}

		} catch (Exception e) {
			throw new Exception("Unable to find Address field elements " + e);
		}

	}

	/**
	 * Description : To verify address Details
	 * 
	 * @param extentedReport
	 * @param Screenshot
	 * @param AddrsFields
	 * @throws Exception
	 * 
	 */

	public void VerifyaddrsDetail(ExtentTest extentedReport, boolean Screenshot, String AddrsFields) throws Exception {
		try {
			WaitUtils.waitForElementPresent(driver, adrsDetailFields1, "unable to find the element");
			List<WebElement> AddressActual = driver.findElements(By.cssSelector(adrsDetailFields));
			String[] AddressExpected = AddrsFields.trim().split(",");
			for (int i = 0; i < AddressActual.size(); i++) {
				if (AddressActual.get(i).isDisplayed()) {
					for (int j = 0; j < AddressExpected.length; i++) {

						if (AddressActual.get(i).getText().trim().equalsIgnoreCase(AddressExpected[j]))

							Log.message(AddressExpected[j] + " Is Displayed", driver, extentedReport, Screenshot);
						else
							Log.fail(AddressExpected[j] + " is not Displayed", driver, extentedReport, Screenshot);

					}

				}

			}
		}

		catch (Exception e) {
			throw new Exception("Unable to find Address field elements " + e);
		}

	}

	/**
	 * 
	 * Description : Verify the fields of Account Section in Finance tab
	 * 
	 * @param extentedReport
	 * @param Screenshot
	 * @return
	 * 
	 */
	public boolean verifyAccountSectionFields(ExtentTest extentedReport, boolean Screenshot) {
		if (finTabAccountSecnIncludeReversalField.isDisplayed() && finTabAccountSecnOutstandingField.isDisplayed()
				&& finTabAccountSecnOutstandingAmtField.isDisplayed() && finTabAccountSecnFinanceTbl.isDisplayed()
				&& finTabAccountSecnTakePaymentBtn.isDisplayed()) {
			Log.message("Verified fields of Account section in Finance Tab", driver, extentedReport, true);
			return true;
		} else {
			Log.message("Not Verified fields of Account section in Finance Tab", driver, extentedReport, true);
			return false;
		}
	}

	/**
	 * 
	 * validate mouse hover on view policy details tab customer dash board page
	 * 
	 * @param extentedReport
	 * @param Screenshot
	 * @throws Exception
	 *             as custom Exception Message
	 * 
	 */

	public void validate_mousehover_tabs(ExtentTest extentedReport, boolean Screenshot) throws Exception {
		WaitUtils.waitForElementPresent(driver, 180, tab_viewPolDetails,
				"Unable to locate policy details tab under Policy Bar");
		try {

			GenericUtils.moveToElementJS(driver, tab_viewQuotPolicies);
			Log.message("User able to hover the view policy details tab", extentedReport);
		} catch (Exception e) {
			throw new Exception("Unable to mouse hover on view policy details tab" + e);
		}

	}

	/**
	 * 
	 * validate Policy cover & policy details menu items
	 * 
	 * @param valToSelect
	 * @param extentedReport
	 * @param Screenshot
	 * @throws Exception
	 *             as custom Exception Message
	 * 
	 */

	public void selectMenu_from_policyDetails_tab(String valToSelect, ExtentTest extentedReport, boolean Screenshot)
			throws Exception {
		WaitUtils.waitForElementPresent(driver, 180, tab_viewPolDetails,
				"Unable to locate policy details tab under Policy Bar");
		try {
			List<WebElement> buttonOptions = driver.findElements(By.cssSelector(rad_cancel));
			for (int i = 0; i < buttonOptions.size(); i++) {
				if (buttonOptions.get(i).getText().contains("Policy Details")) {
					WaitUtils.waitForElementPresent(driver, 180, drpDwn_PolDetails,
							"Unable to locate policy details menu item");
					drpDwn_PolDetails.click();
					Log.message("Clicked on Policy Details tab", driver, extentedReport);
					break;
				}
			}

			WaitUtils.waitForSpinner(driver);
			if (valToSelect.equalsIgnoreCase("Policy cover"))
				WaitUtils.waitForElementPresent(driver, 180, dropdwn_polCover,
						"Unable to locate policy cover menu item under Policy details");
			dropdwn_polCover.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked on Policy cover from policy details drop down", driver, extentedReport);

		} catch (Exception e) {
			throw new Exception("Unable to click on policy details tab" + e);
		}

	}

	/**
	 * 
	 * validate PolicyDetailsInfo
	 * 
	 * @param extentedReport
	 * @param Screenshot
	 * @throws Exception
	 *             as custom Exception Message
	 * @return HashMap
	 * 
	 */
	public HashMap<String, String> validate_PolicyDetailsInfo(ExtentTest extentedReport, boolean Screenshot)
			throws Exception {
		WaitUtils.waitForElementPresent(driver, 180, tab_viewPolDetails,
				"Unable to locate policy details tab under Policy Bar");
		try {
			HashMap<String, String> map = new HashMap<String, String>();

			map.put("PolicyNo", txtfld_PolicyNo.getText());
			map.put("Status", txtFld_status.getText());
			map.put("InceptionDate", txtFld_inceptiondate.getText());
			map.put("ExpiryDate", txtFld_expirydate.getText());
			map.put("Product", txtFld_product.getText());
			map.put("Scheme", txtFld_scheme.getText());
			return map;
		} catch (Exception e) {
			throw new Exception("Unable to get the policy details from  policy details section" + e);
		}

	}

	/**
	 * 
	 * validate PolicyDetailsInfo
	 * 
	 * @throws Exception
	 *             as custom Exception Message
	 * 
	 */
	public boolean validate_PolicyDetailSection() throws Exception {
		WaitUtils.waitForElementPresent(driver, 180, fld_bldCover, "Unable to find the policy cover section");
		return GenericUtils.verifyWebElementTextEqualsIgnoreCase(fld_bldCover, "Buildings cover");
	}

	/**
	 * 
	 * validate PolicyDetailsInfo
	 * 
	 * @param chkboxToclick
	 * @param selDeSel
	 * @param extentedReport
	 * @param Screenshot
	 * @throws Exception
	 *             as custom Exception Message
	 * 
	 */
	public void click_PoliciesQuotesChkBox(String chkboxToclick, String selDeSel, ExtentTest extentedReport,
			boolean Screenshot) throws Exception {

		try {
			selectCheckbox(chkBox_PolQuotes, chkboxToclick, selDeSel);

			WaitUtils.waitForSpinner(driver);
			Log.message(selDeSel + "ed " + chkboxToclick + " checkbox in view more policy and quotes section",
					extentedReport);
		} catch (Exception e) {
			throw new Exception("Unable to get the policy details from  policy details section" + e);
		}

	}

	/**
	 * 
	 * validate PolicyDetailsInfo
	 * 
	 * @param extentedReport
	 * @param Screenshot
	 * @throws Exception
	 *             as custom Exception Message
	 * 
	 */
	public void validate_PolicyNotesSection(ExtentTest extentedReport, boolean Screenshot) throws Exception {
		try {
			boolean tab_present = false;
			Actions actions = new Actions(driver);
			actions.moveToElement(tab_viewPolicyNotes).click().build().perform();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked on view policy notes section", extentedReport);
			List<WebElement> ele_title = driver.findElements(By.cssSelector(tab_policyNotesTitle));
			for (int i = 0; i < ele_title.size(); i++) {
				if (ele_title.get(i).getText().equalsIgnoreCase("Policy Notes"))
					tab_present = true;
			}

			if (!tab_present)

				Log.message("'View Policy Notes' section did not contain a heading as 'Policy Notes' below the bar",
						extentedReport);
			else
				Log.fail("'View Policy Notes' section  contains a heading as 'Policy Notes' below the bar",
						extentedReport);
		} catch (Exception e) {
			throw new Exception("Unable to get the policy details from  policy details section" + e);
		}

	}

	/**
	 * 
	 * To verify contact name
	 * 
	 * @param name
	 *            as string
	 * @param Screenshot
	 *            as boolean
	 * @throws Exception
	 * @return boolean
	 * 
	 */
	public boolean verifyContactName(String name, boolean Screenshot) throws Exception {
		boolean status = false;
		String ContactName[] = txtContactName.getText().split("Date of Birth");
		if (ContactName[0].trim().equalsIgnoreCase(name)) {
			Log.message("Searched Contact Equals the created contact");
			status = true;
		}
		Log.event("Verified the name of the Searched Contact");
		return status;
	}

	/**
	 * 
	 * select check box
	 * 
	 * @param locator
	 *            as string
	 * @param option
	 *            as strimg
	 * @param sel_DeSel
	 *            as string
	 * @throws Exception
	 */
	private void selectCheckbox(String locator, String option, String sel_DeSel) throws Exception {
		String radio_button_value;
		try {
			List<WebElement> buttonOptions = driver.findElements(By.cssSelector(locator));

			for (int i = 0; i < buttonOptions.size(); i++) {
				radio_button_value = buttonOptions.get(i).getText();
				if (radio_button_value.contains(option)) {
					WebElement chkBox = buttonOptions.get(i).findElement(By.cssSelector("input[type='checkbox']"));
					if (sel_DeSel.equalsIgnoreCase("Select") && (!chkBox.isSelected()))
						chkBox.click();

					else if (chkBox.isSelected())
						chkBox.click();

					break;
				}

			}

		}

		catch (Exception e) {
			throw new Exception("Unable to Select check box" + e.getMessage());
		}
	}

	/**
	 * 
	 * Click complete button after customer creation *
	 * 
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */

	public void click_cust_compButton(ExtentTest extentedReport) throws Exception {

		WaitUtils.waitForElementPresent(driver, 180, btn_custComplete, "Unable to find the policy cover section");
		try {
			btn_custComplete.click();
			Log.message("Clicked on complete button on customer dashboard page after customer creation",
					extentedReport);
		} catch (Exception e) {
			throw new Exception("Unable to locate complete button on customer dashboard page" + e);
		}

	}

	/**
	 *
	 * Select Transaction Row
	 * 
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void selectTransactionRow(ExtentTest extentedReport) throws Exception {

		try {

			boolean rowSelected = false;
			Integer totalRowSize = lstTransactionTable.size();

			if (totalRowSize == 0) {
				throw new Exception("Search result does not contain any result");
			}

			for (int loopcount = 0; loopcount < totalRowSize; loopcount++) {
				List<WebElement> lstTranscationRow = lstTransactionTable.get(loopcount)
						.findElements(By.cssSelector(cssTransactionstatus));
				Integer TotalElement = lstTranscationRow.size();
				for (int elementCount = 0; elementCount < TotalElement; elementCount++) {

					if (lstTranscationRow.get(elementCount).getText().equals("Inactive")) {
						lstTranscationRow.get(elementCount).click();
						rowSelected = true;
						WaitUtils.waitForSpinner(driver);
						break;
					}
				}

				if (rowSelected) {
					Log.message("Transaction row is selected in transaction table", extentedReport);
					break;
				}
			}

		} catch (Exception e) {
			throw new Exception("Error while selection a row in transaction table" + e);
		}

	}

	/**
	 * 
	 * Click EditTransaction button *
	 * 
	 * @param extentedReport
	 * @param Screenshot
	 * @throws Exception
	 * @return GetQuotePage
	 * 
	 */

	public GetQuotePage clickEditTransactionButton(ExtentTest extentedReport, boolean Screenshot) throws Exception {
		try {
			WaitUtils.waitForelementToBeClickable(driver, btnEditTransaction,
					"Unable to find the policy cover section");
			GenericUtils.scrollIntoView(driver, btnEditTransaction);
			btnEditTransaction.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked on EditTransaction button in customer dashboard page ", driver, extentedReport,
					Screenshot);
			return new GetQuotePage(driver, extentedReport).get();

		} catch (Exception e) {
			throw new Exception("Error while clicking EditTransaction button" + e);
		}

	}

	/**
	 * 
	 * To verify Policy Holder Name
	 *
	 * @param NameToVerify
	 *            - PolicyHolder name
	 * @throws Exception
	 * @return boolean
	 * 
	 */

	public boolean verifyPolicyholderName(String NameToVerify) throws Exception {
		try {
			return GenericUtils.verifyWebElementTextContains(txtAreaPolicyHolder, NameToVerify);
		} catch (Exception e) {
			throw new Exception("Error while veriying the bold font of the main policy holder" + e);
		}

	}

	/**
	 * 
	 * To verify MainPolicyholder is separated by comma
	 *
	 * @throws Exception
	 * @return boolean
	 * 
	 */

	public boolean verifyPolicyholderSeparatedByComma() throws Exception {
		try {
			return GenericUtils.verifyWebElementTextContains(txtAreaPolicyHolder, ",");
		} catch (Exception e) {
			throw new Exception("Error while veriying the bold font of the main policy holder" + e);
		}

	}

	/**
	 * 
	 * To verify MainPolicyholder is displayed first
	 *
	 * @param substringToVerify
	 *            - MainPolicyholder name to verify
	 * @throws Exception
	 * @return boolean
	 * 
	 */

	public boolean verifyMainPolicyholderDisplayedFirst(String substringToVerify) throws Exception {
		try {
			return GenericUtils.verifyWebElementStartWith(driver, txtAreaPolicyHolder, substringToVerify);
		} catch (Exception e) {
			throw new Exception("Error while veriying the bold font of the main policy holder" + e);
		}

	}

	/**
	 * 
	 * To verify MainPolicyholder Bold Font
	 *
	 * @return boolean
	 * @throws Exception
	 * 
	 */

	public boolean verifyMainPolicyholderBoldFont() throws Exception {
		try {
			String fontBold = "bold";
			return GenericUtils.verifyFont(driver, cssMainHolderPolicy, fontBold);
		} catch (Exception e) {
			throw new Exception("Error while veriying the bold font of the main policy holder" + e);
		}

	}

	/**
	 * 
	 * click edit option from manage policy dropdown
	 * 
	 * @param extentedReport
	 * 
	 * @param Screenshot
	 *            as boolean
	 * @throws Exception
	 * @return GetQuotePage
	 * 
	 */

	public GetQuotePage clickEditfromManagePolicyDropdown(ExtentTest extentedReport, boolean screenshot)
			throws Exception {
		try {
			driver.findElement(By.partialLinkText("Manage Quote")).click();
			Log.message("Clicked on Manage Policy", driver, extentedReport, screenshot);

			WaitUtils.waitForElement(driver, dropDownOptionEdit);
			dropDownOptionEdit.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked on Edit Policy", driver, extentedReport);
			return new GetQuotePage(driver, extentedReport).get();

		} catch (Exception e) {
			throw new Exception("Unable to click edit option from Managepolicy " + e);
		}
	}

	/**
	 *
	 * To select ViewTransaction link in transaction table
	 * 
	 * @param extentedReport
	 * @param screenshot
	 * @throws Exception
	 * 
	 */
	public ViewTransactionPage clickViewTransaction(ExtentTest extentedReport, boolean screenshot) throws Exception {

		try {

			boolean iconClicked = false;
			Integer totalRowSize = lstTransactionTable.size();

			if (totalRowSize == 0) {
				throw new Exception("Search result does not contain any result");
			}

			for (int loopcount = 0; loopcount < totalRowSize; loopcount++) {
				List<WebElement> lstTranscationRow = lstTransactionTable.get(loopcount)
						.findElements(By.cssSelector(cssTransactionstatus));
				Integer TotalElement = lstTranscationRow.size();
				for (int elementCount = 0; elementCount < TotalElement; elementCount++) {

					if (lstTranscationRow.get(elementCount).getText().equals("MidTermAdjustment")) {
						GenericUtils.scrollIntoView(driver, btnEditTransaction); // scroll
																					// down
						lstTransactionTable.get(elementCount).findElement(By.cssSelector(cssViewTransaction)).click();
						iconClicked = true;
						WaitUtils.waitForSpinner(driver);
						break;
					}
				}

				if (iconClicked) {
					Log.message("ViewTransaction button is selected in transaction table", extentedReport);
					break;
				}
			}
			return new ViewTransactionPage(driver, extentedReport).get();

		} catch (Exception e) {
			throw new Exception("Error while clicking ViewTransaction button in transaction table" + e);
		}

	}

	/**
	 * 
	 * To enter customer details
	 * 
	 * @param testdata
	 *            as hashmap
	 * @param Screenshot
	 *            as boolean
	 * @param extentReport
	 * @param dateToEnter
	 * @throws Exception
	 * 
	 */
	public void enterQuoteDetails(HashMap<String, String> testdata, boolean Screenshot, ExtentTest extentReport,
			String dateToEnter) throws Exception {
		WaitUtils.waitForElementPresent(driver, popup_NewQuote, "New quote pop up has not shown");
		try {

			Log.message("Entering Quote details", extentReport);
			WaitUtils.waitForelementToBeClickable(driver, datePicker, "DatePicker to enter start date is not found");
			datePicker.sendKeys(DateTimeUtility.getCurrentDate());
			datePicker.click();
			Log.message("Entered Date : " + dateToEnter, extentReport);
			selectIntermediary(testdata.get("Intermediary").toString(), extentReport);
			Log.message("Selected Intermediary : " + testdata.get("Intermediary").toString(), extentReport);
			selectProduct(testdata.get("Product").toString());
			Log.message("Selected Product : " + testdata.get("Product").toString(), extentReport);
			Thread.sleep(2000);
			selectScheme(testdata.get("Scheme").toString());
			Log.message("Selected Scheme" + testdata.get("Scheme").toString(), extentReport);
			Log.message("Entered Quote Details successfully : ", driver, extentReport, Screenshot);
		} catch (Exception e) {
			throw new Exception("Unable to Enter Quote Details : " + e);
		}
	}

	/**
	 * 
	 * click InviteRenewal option from manage policy dropdown
	 * 
	 * @param extentedReport
	 * 
	 * @param Screenshot
	 *            as boolean
	 * @throws Exception
	 * 
	 * 
	 */

	public void clickInviteRenewalfromManagePolicyDropdown(ExtentTest extentedReport, boolean screenshot)
			throws Exception {
		try {
			driver.findElement(By.partialLinkText("Manage Renewals")).click();
			Log.message("Clicked on Manage Policy", extentedReport);

			WaitUtils.waitForElement(driver, optionInviteRenewal);
			optionInviteRenewal.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Invite Renewal option is selected", driver, extentedReport, screenshot);

		} catch (Exception e) {
			throw new Exception("Unable to click InviteRenewal option from Managepolicy " + e);
		}
	}

	/**
	 * Verify banner title as Engagement centre
	 * 
	 * @param extentedReport
	 * @return boolean
	 * @throws Exception
	 *             : Custom Exception Message
	 */

	public boolean ECbannertitleCheck(ExtentTest extentedReport) throws Exception {
		try {
			return GenericUtils.verifyWebElementTextEquals(txtBannerName, "Engagement Centre");
		}

		catch (Exception e) {
			throw new Exception("Exception while getting banner title" + e);
		}

	}

	/**
	 * Enter Request Cancellation Details
	 * 
	 * @param type
	 * @param extentedReport
	 * @throws Exception
	 *             : Custom Exception Message
	 */

	public void enterRequestCancellationDetails(String type, String reason, ExtentTest extendedReport) throws Exception {
		try {
			enterRequestCancellationDate(extendedReport);
			enterReason(reason,extentedReport);
			drpCancelType.click();
			GenericUtils.getMatchingTextElementFromList(drpoptCancelType, type).click();
			Log.message("Selected Return Premium Type as : " + type,
					driver, extendedReport, true);
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnCalculateCancel);
			Thread.sleep(6000);
			WaitUtils.waitForElement(driver, btnConfirmCancel);
			btnConfirmCancel.click();
			Thread.sleep(8000);
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked on Calculate button", driver, extendedReport);
		}

		catch (Exception e) {
			throw new Exception("Erorr while entering cancellation details : " + e);
		}
	}
	
	/**
	 * Enter Cancellation effective date
	 * 
	 * @param type
	 * @param extentedReport
	 * @throws Exception
	 *             : Custom Exception Message
	 */
	public void enterRequestCancellationDate(ExtentTest extendedReport) throws Exception {
		try {
			SimpleDateFormat formDate = new SimpleDateFormat("dd/MM/yyyy");
			String strDate = formDate.format(new Date());
			WaitUtils.waitForElement(driver, txtCancelPolicyDate);
			txtCancelPolicyDate.sendKeys(strDate);
			txtCancelPolicyDate.click();
			txtCancelPolicyDate.sendKeys(Keys.TAB);
			Log.message("Entered Effective date as : " + strDate,driver, extendedReport, true);
		}
		catch (Exception e) {
			throw new Exception("Erorr while entering cancellation date : " + e);
		}
	}

	/**
	 * To verify MTA Premium
	 * 
	 * @return boolean
	 * @param premium
	 * @throws Exception
	 *             : Custom Exception Message
	 */

	public boolean verifyMTAPremium(String premium) throws Exception {
		boolean status = false;
		if (GenericUtils.verifyMatchingTextContainsElementFromList(txtMTAPremium, premium))
			status = true;
		return status;

	}

	/**
	 * 
	 * click manage policy dropdown
	 * 
	 * @param testdata
	 *            as Hashmap
	 * @param Screenshot
	 *            as boolean
	 * @throws Exception
	 * 
	 * 
	 */

	public void clickfromManagePolicyDropdown(HashMap<String, String> testdata, boolean screenshot) throws Exception {

		WaitUtils.waitForElementPresent(driver, 60, PolicyAdminPane,
				"Manage policy drop down selection was not successful");
		try {
			selectdropDownMenu(rad_cancel, "Manage Policy");

			Log.event("Clicked on Manage Policy");
			String browsername = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("browser");
			if (browsername.equalsIgnoreCase("firefox")) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("javascript:window.scrollBy(0,350)");
			}
			Thread.sleep(2000);
			midTermAdj.click();
			Thread.sleep(500);

		} catch (Exception e) {
			throw new Exception("Unable to click on Managepolicy > " + testdata.get("ManagePolicy").toString() + e);
		}
	}

	/**
	 * 
	 * click edit option from manage policy dropdown
	 * 
	 * @param extentedReport
	 * 
	 * @param Screenshot
	 *            as boolean
	 * @throws Exception
	 * 
	 */

	public void clickViewTandCfromManagePolicyDropdown(ExtentTest extentedReport, boolean screenshot) throws Exception {
		try {
			driver.findElement(By.partialLinkText("Manage Policy")).click();
			Log.message("Clicked on Manage Policy", extentedReport);

			WaitUtils.waitForElement(driver, dropdownViewTandC);
			dropdownViewTandC.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("View terms and condition option is selected from manage policy drop down", driver,
					extentedReport, screenshot);
		} catch (Exception e) {
			throw new Exception("Unable to click ViewTermsandCondition option from Managepolicy " + e);
		}
	}

	/**
	 * Description : To verify whether the terms and condition is added under
	 * terms & condition section
	 * 
	 * Return : boolean
	 * 
	 * @param extentedReport
	 * @param policyToClick
	 * @throws Exception
	 * 
	 */
	public boolean verifyAddedTandC_Collapsed(String policyToClick, ExtentTest extentedReport, boolean Screenshot)
			throws Exception {
		try {
			WebElement rowToClick = null;

			String cssPolicy = "[id*='C2__FMT_304899FEFEF1DDEB821953_R1_']";
			List<WebElement> PolicyOptions = driver.findElements(By.cssSelector(cssPolicy));

			if (PolicyOptions.size() == 0) {
				throw new Exception("No Terms&condition Policy are availbale to click under terms&condition section");
			}

			for (int i = 0; i < PolicyOptions.size(); i++) {
				rowToClick = PolicyOptions.get(i);
				String displayedPolicyName = rowToClick
						.findElement(
								By.cssSelector("[id*='C2__C6__C2__QUE_304899FEFEF1DDEB353990_R1_" + (i + 1) + "']"))
						.getText();
				if (displayedPolicyName.equals(policyToClick)) {
					rowToClick.click();
					Log.message(policyToClick + " - added T&C is clicked under terms&condition", driver,
							extentedReport);
					break;
				}
			}

			WebElement btnCloseOfCurrentTC = null;

			if (WaitUtils.waitForElement(driver, rowToClick.findElement(By.cssSelector(cssCloseButton)))) {
				Log.message(policyToClick + " - Added T&C is expanded " + policyToClick, driver, extentedReport,
						Screenshot);
				btnCloseOfCurrentTC = rowToClick.findElement(By.cssSelector(cssCloseButton));
				btnCloseOfCurrentTC.click();
				Log.message("Close button is clicked for the added T&C - " + policyToClick, driver, extentedReport);
			} else {
				throw new Exception("close button is not available for the T&C - " + policyToClick);
			}

			Thread.sleep(2000);

			boolean isCollapsed = (new WebDriverWait(driver, 50).pollingEvery(200, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.withMessage("Close button is still visible"))
							.until(ExpectedConditions.invisibilityOf(btnCloseOfCurrentTC));

			/*
			 * WebDriverWait wait = new WebDriverWait(driver, 20); WebElement
			 * element =
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id
			 * )));
			 */
			/*
			 * if (rowToClick.findElement(By.cssSelector(cssCloseButton)).
			 * isDisplayed()) { isCollapsed = false; Log.
			 * message("Close button is visible after clicking close button for the T&C - "
			 * + policyToClick, driver, extentedReport, Screenshot); } else {
			 * Log.
			 * message("Close button is not visible after clicking close button for the added T&C - "
			 * + policyToClick, driver, extentedReport, Screenshot); }
			 */

			return isCollapsed;

		} catch (Exception e) {
			throw new Exception("Error while clicking added T&C :" + e);
		}
	}

	/**
	 * To verify the Renewal Process
	 * 
	 * @param extentedReport
	 * @param screenshot
	 * @throws Exception
	 * 
	 */

	public void performRenewals_LapseRenewal(String menuToClick, ExtentTest extentedReport, boolean screenshot)
			throws Exception {

		try {
			WebElement eleToClick;
			WaitUtils.waitForSpinner(driver);
			WaitUtils.waitForElement(driver, drpManageRenewals);
			drpManageRenewals.click();
			if (menuToClick.equalsIgnoreCase("Invite Renewal"))
				eleToClick = drpoptInviteRenewals;
			else
				eleToClick = drpoptLapseQuote;
			WaitUtils.waitForElement(driver, eleToClick);
			Log.message("Clicked on Manage Renewals", driver, extentedReport, screenshot);
			eleToClick.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked on " + menuToClick, driver, extentedReport, screenshot);
		} catch (Exception e) {
			throw new Exception("Unable to locate Manage renewals tab in customer dashboard page:" + e);
		}
	}

	/**
	 * To click SuspendBilling from ManagePolicy Dropdown
	 * 
	 * @param extentedReport
	 * @param screenshot
	 * @return BuyQuotePage
	 * @throws Exception
	 * 
	 */
	public SuspendBillingPage selectSuspendBillingfromManagePolicy(ExtentTest extentedReport, boolean screenshot)
			throws Exception {
		try {
			driver.findElement(By.partialLinkText("Manage Policy")).click();
			Log.message("Clicked on Manage Policy", extentedReport);
			Thread.sleep(2000);
			WaitUtils.waitForElement(driver, drpdwnSuspendBilling);
			drpdwnSuspendBilling.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Suspend Billing option is selected from manage policy drop down", driver, extentedReport,
					screenshot);
			return new SuspendBillingPage(driver, extentedReport).get();
		} catch (Exception e) {
			throw new Exception("Unable to click SuspendBilling option from Managepolicy : " + e);
		}
	}

	/**
	 * To verify SuspendBilling is Accepted
	 * 
	 * @return boolean
	 * @throws Exception
	 * 
	 */
	public boolean verifySuspendBilling_Accepted() throws Exception {
		try {

			boolean status = false;

			if (WaitUtils.waitForElement(driver, titleSuspendBilling)) {
				status = GenericUtils.verifyWebElementTextContains(titleSuspendBilling, "Billing Suspended");
			}
			return status;
		} catch (Exception e) {
			throw new Exception("Error while verifying whether suspend billing is accepted : " + e);
		}
	}

	/**
	 * To click UnsuspendBilling from ManagePolicy Dropdown
	 * 
	 * @param extentedReport
	 * @param screenshot
	 * @return BuyQuotePage
	 * @throws Exception
	 * 
	 */
	public UnsuspendBillingPage clickUnsuspendBillingfromManagePolicy(ExtentTest extentedReport, boolean screenshot)
			throws Exception {
		try {
			driver.findElement(By.partialLinkText("Manage Policy")).click();
			Log.message("Clicked on Manage Policy", extentedReport);

			WaitUtils.waitForElement(driver, drpdwnUnsuspendBilling);
			drpdwnUnsuspendBilling.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("UnsuspendBilling option is selected from manage policy drop down", driver, extentedReport,
					screenshot);
			return new UnsuspendBillingPage(driver, extentedReport).get();
		} catch (Exception e) {
			throw new Exception("Unable to click SuspendBilling option from Managepolicy : " + e);
		}
	}

	/**
	 * To verify SuspendBilling is Accepted
	 * 
	 * @return boolean
	 * @throws Exception
	 * 
	 */
	public boolean verifyUnsuspendBilling_Accepted() throws Exception {
		try {
			if (WaitUtils.waitForElement(driver, titleUnsuspendBilling)) {
				return GenericUtils.verifyWebElementTextContains(titleUnsuspendBilling, " ACTIVE");
			} else {
				throw new Error("Unsuspend billing title is not found");
			}
		} catch (Exception e) {
			throw new Exception("Error while verifying whether Unsuspend billing is accepted : " + e);
		}
	}

	/**
	 * To verify PaymentMethod
	 * 
	 * @return boolean
	 * @throws Exception
	 * 
	 */
	public boolean verifyPaymentMethod(String Paymentmethod) throws Exception {
		try {
			if (WaitUtils.waitForElement(driver, txtPayementCard)) {
				return GenericUtils.verifyWebElementTextContains(txtPayementCard, Paymentmethod);
			} else {
				throw new Error("Payment method text is not found in customer dashboard");
			}
		} catch (Exception e) {
			throw new Exception("Error while verifying Payment method : " + e);
		}
	}

	/**
	 * Description : Select New Complaint from Complaints tab
	 * 
	 * Return : complaintPage
	 * 
	 * @param extentedReport
	 * @param Screenshot
	 * @throws Exception
	 */
	public ComplaintPage selectNewcomplaint_ComplaintsTab(ExtentTest extentedReport, boolean Screenshot)
			throws Exception {
		try {
			clickTab("Complaints", extentedReport, true);
			if (WaitUtils.waitForElement(driver, drpDwn_newComplaint, 2)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", drpDwn_newComplaint);
				Log.message("Clicked on New complaint sub menu", extentedReport);
				Thread.sleep(6000);
				WaitUtils.waitForPageLoad(driver);
			} else {
				throw new Exception("New Complaint sub menu not found");
			}
		} catch (Exception e) {
			throw new Exception("Not able to select New complaint from Complaints tab");
		}
		return new ComplaintPage(driver,extentedReport).get();
	}

	/**
	 * Description : To verify System Audit History
	 * 
	 * Return : boolean
	 * 
	 * @param extentedReport
	 * @param message
	 * @throws Exception
	 */
	public boolean verifySystemAuditHistory(ExtentTest extentedReport, String[] message) throws Exception {
		try {
			boolean allMatched = false;
			int totalElement = message.length;
			int totalMatched = 0;
			WaitUtils.waitForElement(driver, tab_system_Audit_History);
			GenericUtils.scrollIntoView(driver, tab_system_Audit_History);
			tab_system_Audit_History.click();
			btnView1.click();
			GenericUtils.scrollIntoView(driver, txtpaneSystemAudit);
			String systemAuditDetail = txtpaneSystemAudit.getText();

			for (int i = 0; i < totalElement; i++) {
				if (systemAuditDetail.contains(message[i])) {
					totalMatched++;
					Log.message(message[i] + " - is present in the system audit detail - " + systemAuditDetail, driver,
							extentedReport);
				}
			}

			if (totalMatched == totalElement) {
				allMatched = true;
				return allMatched;
			} else {
				return allMatched;
			}
		} catch (Exception e) {
			throw new Exception("Error while verifying system audit history detail : " + e);
		}
	}

	/**
	 * Description : Select Renewal quote variations
	 * 
	 * Return : BuyQuotePage
	 * 
	 * @param extentedReport
	 * @param Screenshot
	 * @throws Exception
	 * 
	 */
	public BuyQuotePage performRenewals_QuoteVariation(ExtentTest extentedReport, boolean screenshot) throws Exception {

		try {
			WaitUtils.waitForSpinner(driver);
			WaitUtils.waitForElement(driver, drpRenewQotVariations);
			drpRenewQotVariations.click();
			WaitUtils.waitForElement(driver, drpoptRenewQotVariations);
			Log.message("Clicked on Renew quote variation", driver, extentedReport, screenshot);
			WaitUtils.waitForelementToBeClickable(driver, drpoptRenewQotVariations,
					"Failed to get the quote variations list unde Renewal Quote Variations tab");
			drpoptRenewQotVariations.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Saved renewal quote was clicked", driver, extentedReport, screenshot);
		} catch (Exception e) {
			throw new Exception("Unable to click on Renewals quote variation Button :" + e);
		}
		return new BuyQuotePage(driver,extentedReport).get();
	}

	/**
	 * Description : To verify Review status
	 * 
	 * Return : boolean
	 * 
	 * @param extentedReport
	 * @param Screenshot
	 * @throws Exception
	 * 
	 */

	public boolean verify_reviewStatus(String statusname, ExtentTest extentedReport, boolean screenshot)
			throws Exception {
		try {
			boolean boolReturn = false;
			switch (statusname.toLowerCase()) {

			case "review required":
				Log.message("Status dislaying as" + txt_ReviewStatus.getAttribute("title"), driver, true);
				return (txt_ReviewStatus.getAttribute("Title").contains(statusname));

			case "reviewed":
				Log.message("Status dislaying as" + txt_ReviewStatus.getAttribute("title"), driver, true);
				return (txt_ReviewStatus.getAttribute("Title").contains(statusname));

			}

			return boolReturn;
		} catch (Exception e) {
			throw new Exception("Unable to get the renewal notification status :" + e);
		}
	}

	/**
	 * click complete button
	 * 
	 * @throws Exception
	 * 
	 */
	public HomePage clickCompleteButton() throws Exception {
		try {
			(new WebDriverWait(driver, 250).pollingEvery(250, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.withMessage("Unable to find username text box"))
							.until(ExpectedConditions.visibilityOf(btnComplete));
			btnComplete.click();
		} catch (Exception e) {
			throw new Exception("Customer Dashboard Page is not loaded properly");
		}
		Log.event("Clicked on Complete Button");
		return new HomePage(driver).get();
	}// clickCompleteButton

	/**
	 * Description : To get the quote variations
	 * 
	 * @param Returntype
	 *            : Hash map with all the variations details
	 * @throws Exception
	 *             : Custom Exception Message
	 * @param extentedReport
	 * @param screenshot
	 */

	public HashMap<String, String> getQuoteVariations(ExtentTest extentedReport, boolean screenshot) throws Exception {
		try {
			HashMap<String, String> quoteDetails = new HashMap<String, String>();
			WaitUtils.waitForElement(driver, drpRenewQotVariations);
			drpRenewQotVariations.click();
			WaitUtils.waitForElement(driver, drpoptRenewQotVariations);
			Log.message("Clicked on Renew quote variation", driver, extentedReport, true);

			List<WebElement> eleLstVariation = driver.findElements(By.cssSelector(lstQuotevariations));
			for (int i = 0; i < eleLstVariation.size(); i++) {
				List<WebElement> eleVariationitem = eleLstVariation.get(i).findElements(By.tagName("span"));
				quoteDetails.put("quoteDate_" + i, eleVariationitem.get(0).getText());
				quoteDetails.put("quoteNo_" + i, eleVariationitem.get(1).getText());
				quoteDetails.put("quoteDesc_" + i, eleVariationitem.get(2).getText());
				quoteDetails.put("quoteAmt_" + i, eleVariationitem.get(3).getText());
				quoteDetails.put("quoteStatus_" + i, eleVariationitem.get(4).getText());
				quoteDetails.put("quoteStatusCommand_" + i, eleVariationitem.get(4).getAttribute("class"));
			}
			drpRenewQotVariations.click();
			return quoteDetails;
		} catch (Exception e) {
			throw new Exception(
					"Failed to get the quote varation details under Renewal Quote variation tab, throws exception :"
							+ e);
		}
	}

	/**
	 * Description : To Click and verify the lapse option
	 * 
	 * @param Returntype
	 *            : boolean
	 * @throws Exception
	 *             : Custom Exception Message
	 * @param extentedReport
	 */

	public boolean VerifyLapseRenewalModal(ExtentTest extentedReport, boolean screenshot) throws Exception {
		try {
			// Verify the message
			boolean boolVal = false;
			boolean boolmsg = GenericUtils.verifyWebElementTextContains(msgWarningLapseQte,
					"You are about to lapse this renewal quote variation leaving no active variations against this policy. Do you wish to continue?");
			if (WaitUtils.waitForElement(driver, btnContinueLapseQuote, 2)
					&& WaitUtils.waitForElement(driver, btnCancelLapseQuote, 2) && boolmsg) {
				Log.message("Warning message, continue and cancel button were present in Lapse quote warning modal",
						driver, extentedReport, true);
				boolVal = true;
			}
			return boolVal;
		} catch (Exception e) {
			throw new Exception("Unable to verify the lapse quote button, throws exception :" + e);
		}
	}

	/**
	 * Description : To Click Lapse cancel / continue button
	 * 
	 * @param Returntype
	 *            : void
	 * @throws Exception
	 *             : Custom Exception Message
	 * @param extentedReport
	 */

	public void clickLapseCancelContinue(String btnToClick, ExtentTest extentedReport, boolean screenshot)
			throws Exception {
		try {
			// Verify the message
			if (btnToClick.equalsIgnoreCase("cancel")) {
				btnCancelLapseQuote.click();
				WaitUtils.waitForSpinner(driver);
				Log.message("Clicked on cancel button", extentedReport);

			} else
				btnContinueLapseQuote.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked on continue button", extentedReport);

		} catch (Exception e) {
			throw new Exception("Unable to click " + btnToClick + "button, throws exception :" + e);
		}
	}

	/**
	 * Verifies that the given position with expected status is available at
	 * 'Transactions' table.
	 * 
	 * @param expectedPosition
	 * @param expectedStatus
	 * @param extentedReport
	 * @param screenshot
	 * @return true if the 'Transactions' table has expected position with
	 *         expected status as expected; false otherwise.
	 * @throws Exception
	 */
	public boolean verifyTransactionStatus(String expectedPosition, String expectedStatus, ExtentTest extentedReport,
			boolean screenshot) throws Exception {
		boolean isOk = false;

		try {
			int totalRows = lstTransactionTable.size();
			if (totalRows == 0) {
				throw new Exception("The 'Transactions' table has no rows");
			}

			Log.message("Expected Position: '" + expectedPosition + "'", extentedReport);
			for (int row = 0; row < totalRows; row++) {
				List<WebElement> lstTranscationColumns = lstTransactionTable.get(row).findElements(By.tagName("td"));
				int totalcolumns = lstTranscationColumns.size();
				if (totalcolumns == 0) {
					throw new Exception("The row #" + row + " of 'Transactions' table has no columns");
				}

				String actualPosition = lstTranscationColumns.get(0).getText();
				String actualStatus = lstTranscationColumns.get(1).getText();

				Log.message("Row No: '" + (row + 1) + "'; Position: '" + actualPosition + "'; Status: '" + actualStatus
						+ "'", extentedReport);

				if (actualPosition.equals(expectedPosition) && actualStatus.equals(expectedStatus)) {
					Log.message("Expected Status: '" + expectedStatus + "'; Actual Status: '" + actualStatus + "'",
							extentedReport);
					isOk = true;
					break;
				}
			}

		} catch (Exception e) {
			throw new Exception("Exception while verifying the transaction status. " + e);
		}

		return isOk;
	}

	/**
	 * Verifies that the premium summary details available matches the payment
	 * details grabed from Acceptance tab.
	 * 
	 * @param testData
	 * @param extentedReport
	 * @param screenShot
	 * @return true if the premium summary details available are as expected;
	 *         false otherwise.
	 * @throws Exception
	 */
	public boolean verifyPremiumSummary(HashMap<String, String> testData, ExtentTest extentedReport, boolean screenShot)
			throws Exception {
		boolean isOk = false;

		try {
			String expectedTotalPaid = "0.00";
			String expectedTotalBalance = testData.get("totalPaymentAcceptanceTab");

			String totalPaid = divTotalPaid.getText().replaceFirst("£", "").trim();
			String totalBalance = divTotalBalance.getText().replaceFirst("£", "").trim();

			Log.message(
					"Premium Summary Details:- Total Paid: [" + totalPaid + "]; Total Balance: [" + totalBalance + "]",
					extentedReport);

			boolean isOkTotalPaid = totalPaid.equals(expectedTotalPaid);
			boolean isOkTotalBalance = totalBalance.equals(expectedTotalBalance);

			isOk = isOkTotalPaid && isOkTotalBalance;
		} catch (Exception e) {
			throw new Exception("Exception in verifying premium summary. " + e);
		}

		return isOk;
	}

	/**
	 * Verifies the preferences in customer dashboard page
	 * 
	 * @param btnToCheck
	 *            as Strinig
	 * @param extentedReport
	 * @param screenShot
	 * @throws Exception
	 */

	public boolean verifyPreferences(String btnToCheck, ExtentTest extentedReport, boolean screenshot)
			throws Exception {
		try {
			boolean boolval = false;

			validate_expand(tab_preferences, "Expand", true, extentedReport);
			switch (btnToCheck.toLowerCase()) {

			// Verify the message
			case "post":
				WaitUtils.waitForElementPresent(driver, radEmailpref,
						"Post preference was not found in customer dashboard page");
				if (radPostpref.getAttribute("checked").equalsIgnoreCase("checked"))
					boolval = true;
				Log.message("Selected preferences reflects in customer dashboard page", extentedReport);
				break;

			case "email":
				WaitUtils.waitForElementPresent(driver, radEmailpref,
						"Email preference was not found in customer dashboard page");
				if (radEmailpref.getAttribute("checked").equalsIgnoreCase("checked"))
					boolval = true;
				Log.message("Selected Email preference reflects in customer dashboard page", extentedReport);
				break;

			}
			return boolval;
		}

		catch (Exception e) {
			throw new Exception("Unable to validate preferences in customer dashboard page, throws exception :" + e);
		}
	}

	/**
	 * Description: Get the premiums from customer dashboard page
	 * 
	 * @param extentedReport
	 * @param screenShot
	 * @throws Exception
	 */

	public String getPremiums(ExtentTest extentedReport, boolean screenshot) throws Exception {
		try {
			return GenericUtils.getTextOfWebElement(txtPremiumAmt, driver);
		}

		catch (Exception e) {
			throw new Exception(
					"Unable to get the premium amount from customer dashboard page, throws exception :" + e);
		}

	}

	/**
	 * Description: Edit and verify the address field
	 * 
	 * @param extentedReport
	 * @param screenShot
	 * @throws Exception
	 */

	public boolean verifyEditBusinesAddress(ExtentTest extentedReport, boolean screenshot) throws Exception {
		try {
			boolean boolval = false;
			WaitUtils.waitForElement(driver, btnManageBusinsDetails, 2);
			btnManageBusinsDetails.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked Manage Business Details button", extentedReport);
			if (WaitUtils.waitForElement(driver, tabBusiAddress, 2)) {
				Log.message("Manage Business details modal opened", extentedReport);
				tabBusiAddress.click();
				List<WebElement> eleTabs = driver.findElements(By.cssSelector(cssbusinAddres));
				String OldAdd = GenericUtils.getTextOfWebElement(eleTabs.get(0), driver);
				// to click edit button
				eleTabs.get(4).findElement(By.tagName("Button")).click();
				// Wait for edit window
				if (WaitUtils.waitForElement(driver, txtBusinsPostCode, 5)) {
					txtBusinsPostCode.sendKeys(strPostCode);
					Log.message("Entered new post code to search:" + strPostCode, extentedReport);
					btnFindAdd.click();
					WaitUtils.waitForSpinner(driver);
					Log.message("Clicked on find address button", extentedReport);
					selectAddress();
					WaitUtils.waitForelementToBeClickable(driver, btnSaveAddres, "Save Address button not clickable");
					WaitUtils.waitForSpinner(driver);
					btnSaveAddres.click();
					WaitUtils.waitForSpinner(driver);
					Log.message("Clicked on save button", extentedReport);
					String NewAddress = GenericUtils.getTextOfWebElement(txtAddress, driver);
					Log.message("Old Address:" + OldAdd
							+ " ,New Address in manage business details modal after selecting from list :" + NewAddress,
							driver, extentedReport, true);

					btnClose.click();
					Log.message("Clicked close button to close Manage Business details modal", extentedReport);
					WaitUtils.waitForElementPresent(driver, txtAddressCustPage,
							"Customer dashbaord page was not loaded after closing the manage business details modal");
					boolval = GenericUtils.verifyWebElementTextEqualsIgnoreCase(txtAddressCustPage, NewAddress);
					// Verify the address in customer dashboard page

				} else
					throw new Exception("Failed to locate post code in replace address field");
			}

			return boolval;
		}

		catch (Exception e) {
			throw new Exception("Unable to edit the address in manage business details modal, throws exception :" + e);
		}

	}

	/**
	 * To select address
	 * 
	 * @throws Exception
	 * 
	 */
	public void selectAddress() throws Exception {
		try {
			if (WaitUtils.waitForElement(driver, cn_AddressList, 3)) {
				(new WebDriverWait(driver, 180).pollingEvery(200, TimeUnit.MILLISECONDS)
						.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
						.withMessage("Address not Listed")).until(ExpectedConditions.visibilityOf(cn_AddressList));
				Select cn_Address = new Select(cn_AddressList);
				cn_Address.selectByIndex(0);
				(new WebDriverWait(driver, 180).pollingEvery(200, TimeUnit.MILLISECONDS)
						.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
						.withMessage("Address is not selected")).until(ExpectedConditions.visibilityOf(cn_AddressLine));
			}
		} catch (Exception e) {
			throw new Exception("Unable to Select Address" + e);
		}
	}

	/**
	 * To verify the Renewal Process
	 * 
	 * @param extentedReport
	 * @param screenshot
	 * @throws Exception
	 * 
	 */

	public void performRenewals(ExtentTest extentedReport, boolean screenshot) throws Exception {

		try {

			clickManageRenewal(extentedReport, true);
			drpoptInviteRenewals.click();
			WaitUtils.waitForSpinner(driver);

			Log.message("Clicked on Invite Renewals", driver, extentedReport, screenshot);
		} catch (Exception e) {
			throw new Exception("Unable to locate Invite renewals tab in customer dashboard page:" + e);
		}
	}

	/**
	 * To click manage renewals
	 * 
	 * @param extentedReport
	 * @param screenshot
	 * @throws Exception
	 * 
	 */

	public void clickManageRenewal(ExtentTest extentedReport, boolean screenshot) throws Exception {

		try {
			WaitUtils.waitForSpinner(driver);
			WaitUtils.waitForElement(driver, drpManageRenewals);
			drpManageRenewals.click();
			WaitUtils.waitForElement(driver, drpoptInviteRenewals);
			Log.message("Clicked on Manage Renewals", driver, extentedReport, screenshot);
		} catch (Exception e) {
			throw new Exception("Unable to click Manage renewals tab in customer dashboard page:" + e);
		}
	}

	/**
	 * To click continue button in warning message pop up during invite renewal
	 * 
	 * @param extentedReport
	 * @param screenshot
	 * @throws Exception
	 * 
	 */
	public void clickContinueWarningMsg(ExtentTest extentedReport, boolean screenshot) throws Exception {
		try {
			WaitUtils.waitForElementPresent(driver, txtWarningMsg,
					"Warning message pop up did not open when user tried to invite renewal for  the monthly policy");
			Log.message(
					txtWarningMsg.getText()
							+ " message displayed when clicked on invite renewal option for monthly payment",
					driver, extentedReport, true);
			WaitUtils.waitForElement(driver, btnContnToInvRenwal);
			btnContnToInvRenwal.click();
			Log.message("Clicked on Continue button", driver, extentedReport);
			WaitUtils.waitForSpinner(driver);

		} catch (Exception e) {
			throw new Exception("Unable to click Manage renewals tab in customer dashboard page:" + e);
		}
	}

	/**
	 * To verify the blocked renewal status
	 * 
	 * @param extentedReport
	 * @param screenshot
	 * @throws Exception
	 * 
	 */
	public boolean verify_blockedRenewalStatus(ExtentTest extentedReport, boolean screenshot) throws Exception {
		try {

			return (txtBlockRenwal.getAttribute("Title").contains("Blocked Renewal Status"));

		} catch (Exception e) {
			throw new Exception("Unable to get the Blocked Renewal status in notification column :" + e);

		}
	}

	/**
	 * To verify the option in Manage Renewal
	 * 
	 * @param menuToClick
	 * @param extentedReport
	 * @param screenshot
	 * @throws Exception
	 * @return boolean
	 */

	public boolean verifyOptionInManageRenewals(String menuToClick, ExtentTest extentedReport, boolean screenshot)
			throws Exception {
		boolean status = false;
		try {
			for (int i = 0; i <= lstOptionInManageRenewals.size(); i++) {
				if (lstOptionInManageRenewals.get(i).getText().equals(menuToClick)) {
					status = true;
					break;
				}
			}
			return status;
		} catch (Exception e) {
			throw new Exception("Unable to locate Manage renewals options: " + e);
		}
	}

	/**
	 * To click the option in Manage Renewal
	 * 
	 * @param menuToClick
	 * @param extentedReport
	 * @param screenshot
	 * @throws Exception
	 */
	public void ClickOptionInManageRenewals(String menuToClick, ExtentTest extentedReport, boolean screenshot)
			throws Exception {
		boolean status = false;
		try {
			for (int i = 0; i <= lstOptionInManageRenewals.size(); i++) {
				if (lstOptionInManageRenewals.get(i).getText().equals(menuToClick)) {
					lstOptionInManageRenewals.get(i).click();
					status = true;
					break;
				}
			}
			if (status)
				Log.message("Clicked on " + menuToClick + " from Manage Renewals");
		} catch (Exception e) {
			throw new Exception("Unable to click Manage renewals options in customer dashboard page: " + e);
		}
	}

	/**
	 * To verify the option in Renewal Quote Variations
	 * 
	 * @param menuToClick
	 * @param extentedReport
	 * @param screenshot
	 * @throws Exception
	 * @return boolean
	 */

	public boolean verifyOptionInRenewalQuoteVariations(String menuToClick, ExtentTest extentedReport,
			boolean screenshot) throws Exception {
		boolean status = false;
		try {
			for (int i = 0; i <= lstVariationInQuoteVariations.size(); i++) {
				if (lstVariationInQuoteVariations.get(i).getText().equals(menuToClick)) {
					status = true;
					break;
				}
			}
			return status;
		} catch (Exception e) {
			throw new Exception("Unable to locate Renewal Quote Variations options in customer dashboard page: " + e);
		}
	}

	/**
	 * To click the option in Renewal Quote Variations
	 * 
	 * @param menuToClick
	 * @param extentedReport
	 * @param screenshot
	 * @throws Exception
	 */
	public void ClickOptionInRenewalQuoteVariations(String menuToClick, ExtentTest extentedReport, boolean screenshot)
			throws Exception {
		boolean status = false;
		try {
			for (int i = 0; i <= lstVariationInQuoteVariations.size(); i++) {
				if (lstVariationInQuoteVariations.get(i).getText().equals(menuToClick)) {
					lstVariationInQuoteVariations.get(i).click();
					WaitUtils.waitForSpinner(driver);
					status = true;
					break;
				}
			}
			if (status)
				Log.message("Clicked on " + menuToClick + " from Renewal Quote Variations");
		} catch (Exception e) {
			throw new Exception("Unable to click Renewal Quote Variations in customer dashboard page: " + e);
		}
	}

	/**
	 * To click Renewal Quote Variations
	 * 
	 * @param extentedReport
	 * @param screenshot
	 * @throws Exception
	 * 
	 */

	public void clickRenewalQuoteVariations(ExtentTest extentedReport, boolean screenshot) throws Exception {

		try {
			WaitUtils.waitForSpinner(driver);
			WaitUtils.waitForElement(driver, drpRenewQotVariations);
			drpRenewQotVariations.click();
			(new WebDriverWait(driver, 180).pollingEvery(200, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.withMessage("Manage renewal option is opened"))
							.until(ExpectedConditions.visibilityOfAllElements(lstVariationInQuoteVariations));
			Log.message("Clicked on Renewal Quote Variations", driver, extentedReport, screenshot);
		} catch (Exception e) {
			throw new Exception("Unable to click Renewal Quote Variationss tab in customer dashboard page: " + e);
		}
	}

	/**
	 * To verify Status For QuoteVariations
	 * 
	 * @param optionToCheck
	 * @param statusToCheck
	 * @param extentedReport
	 * @param screenshot
	 * @throws Exception
	 * @return boolean
	 * 
	 */

	public boolean verifyStatusForQuoteVariations(String optionToCheck, String statusToCheck, ExtentTest extentedReport,
			boolean screenshot) throws Exception {
		boolean status = false;
		WebElement statusElement = null;
		try {
			for (int i = 0; i <= lstVariationInQuoteVariations.size(); i++) {
				if (lstVariationInQuoteVariations.get(i).getText().equals(optionToCheck)) {
					statusElement = lstVariationInQuoteVariations.get(i).findElement(By.xpath("../.."))
							.findElement(By.cssSelector("span[class*='status_icon']"));
					if (statusElement.getText().equals(statusToCheck)) {
						status = true;
						break;
					}
				}
			}
			return status;
		} catch (Exception e) {
			throw new Exception("Unable to locate list of variations in quote variations : " + e);
		}
	}

	/**
	 * To get Date List
	 * 
	 * @param extentedReport
	 * @param screenshot
	 * @throws Exception
	 * @return List<String>
	 */

	public List<String> getDateList(ExtentTest extentedReport, boolean screenshot) throws Exception {
		List<String> DateList = new ArrayList<String>();
		try {
			WaitUtils.waitForElement(driver, drpRenewQotVariations);
			drpRenewQotVariations.click();
			WaitUtils.waitForElement(driver, drpoptRenewQotVariations);
			Log.message("Clicked on Renew quote variation", driver, extentedReport, true);

			HashMap<String, String> QuoteVariationsetails = getQuoteVariations(extentedReport, true);
			List<WebElement> eleLstVariation = driver.findElements(By.cssSelector(lstQuotevariations));
			for (int i = 0; i < eleLstVariation.size(); i++) {
				DateList.add(QuoteVariationsetails.get("quoteDate_" + i));
			}
			return DateList;
		} catch (Exception e) {
			throw new Exception(
					"Failed to get the date details under Renewal Quote variation tab, throws exception : " + e);
		}
	}

	/**
	 * To check the dates are in ascending/descending order
	 * 
	 * @param sortType
	 *            'asc' or 'desc'
	 * @0aram extentedReport
	 * @param screenshot
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyQuoteVariationSortingByDate(String sortType, ExtentTest extentedReport, boolean screenshot)
			throws Exception {
		Log.event("Checking the dates are sorted in " + sortType + " order");
		boolean status = true;
		Date previousDate = null;
		Date currentDate = null;
		List<String> lstOfDates = getDateList(extentedReport, false);
		switch (sortType) {
		case "asc":
			for (final String current : lstOfDates) {
				currentDate = new SimpleDateFormat("dd/MM/yyyy").parse(current);
				if (previousDate != null && currentDate.compareTo(previousDate) < 0) {
					status = false;
					break;
				}
				previousDate = currentDate;
			}
			break;

		case "desc":
			for (final String current : lstOfDates) {
				currentDate = new SimpleDateFormat("dd/MM/yyyy").parse(current);
				if (previousDate != null && currentDate.compareTo(previousDate) > 0) {
					status = false;
					break;
				}
				previousDate = currentDate;
				Log.message("currentDate " + previousDate);
			}
			break;
		}

		return status;
	}

	/**
	 * To Click quote variations from drop down based on quote descriotion text
	 * 
	 * @param variationName
	 *            'desc text
	 * @0aram extentedReport
	 * @param screenshot
	 * @return BuyquotePage
	 * @throws Exception
	 */
	public BuyQuotePage clickQuoteVariations(String variationName, ExtentTest extentedReport, boolean screenshot)
			throws Exception {
		try {
			WaitUtils.waitForElement(driver, drpRenewQotVariations);
			drpRenewQotVariations.click();
			List<WebElement> lstVariations = driver.findElements(By.cssSelector(cssQuoteVariaList));
			for (int i = 0; i < lstVariations.size(); i++) {
				if (lstVariations.get(i).getText().equalsIgnoreCase(variationName)) {
					lstVariations.get(i).click();
					Log.message("Clicked on Quoted variation, description name:" + variationName, extentedReport);
					break;
				}
			}
			return new BuyQuotePage(driver,extentedReport);
		} catch (Exception e) {
			throw new Exception("Failed to get the variations details" + e);
		}
	}

	/**
	 * To verify tabs under policy holder
	 * 
	 * @param tabToCheck
	 * @param extentedReport
	 * @param screenshot
	 * @throws Exception
	 * @return boolean
	 * 
	 */

	public boolean verifyTabUnderPolicyHolder(String tabToCheck, ExtentTest extentedReport, boolean screenshot)
			throws Exception {
		boolean status = false;
		try {
			for (int i = 0; i <= lstTabUnderPolicyHolder.size(); i++) {
				if (lstTabUnderPolicyHolder.get(i).getText().equals(tabToCheck)) {
					status = true;
					break;
				}
			}
			return status;
		} catch (Exception e) {
			throw new Exception("Unable to locate list of tabs: " + e);
		}
	}

	/**
	 * To verify tabs under policy holder
	 * 
	 * 
	 * @return boolean
	 * 
	 */

	public void verifyAndClickManageBusinesDeatils(ExtentTest extentedReport, boolean screenshot) {
		WaitUtils.waitForElement(driver, btnManageBusinsDetails, 2);
		btnManageBusinsDetails.click();
		WaitUtils.waitForSpinner(driver);
		Log.message("Clicked Manage Business Details button", extentedReport);
		if (WaitUtils.waitForElement(driver, tabBusiAddress, 2)) {
			Log.message("Manage Business details modal opened", extentedReport);
			tabBusiAddress.click();
			List<WebElement> eleTabs = driver.findElements(By.cssSelector(cssbusinAddres));
			eleTabs.get(4).findElement(By.tagName("Button")).click();
		}
	}
	
	/**
	 * To verify warning pop up
	 * 
	 * 
	 * @return boolean
	 * 
	 */

	public boolean verifyOutstandingWarningPopup(ExtentTest extentedReport)
	{
		boolean status = false;
		if(WaitUtils.waitForElement(driver, btnWarningContinue, 2) && GenericUtils.getTextOfWebElement(txtWarningMsg, driver).equalsIgnoreCase("The policy has outstanding debt. Do you wish to continue with the renewal invitation?"))
		{
			status = true;
		}
		return status;
	}
	
	/**
	 * To click continue in warning pop up
	 * 
	 * 
	 * @0aram extentedReport
	 * 
	 */
	public void clickWarningContinue(ExtentTest extentedReport) {
		if (WaitUtils.waitForElement(driver, btnWarningContinue, 2)) {
			btnWarningContinue.click();
			WaitUtils.waitForSpinner(driver);
		}

	}
	
	/**
	 * Description : To verify edit and save terms&condition under terms & condition
	 * section
	 * 
	 * @param extentedReport
	 * @param Screenshot
	 * @param policyToEdit
	 *            - Policy name
	 * @return boolean
	 * @throws Exception
	 *             : Custom Exception Message
	 */
	public boolean verifyEditedValueExitsInTermAndCond(String policyToEdit, String editedValue, ExtentTest extentedReport, boolean Screenshot)
			throws Exception {
		try {
			boolean isedited = false;
			boolean isClicked = false;
			WebElement rowToClick = null;
			Integer rowValue = null;

			String cssPolicy = "[id*='C6__C2__FMT_304899FEFEF1DDEB821953_R1_']";
			List<WebElement> PolicyOptions = driver.findElements(By.cssSelector(cssPolicy));

			for (int i = 0; i < PolicyOptions.size(); i++) {
				rowToClick = PolicyOptions.get(i);
				String displayedPolicyName = rowToClick  
						.findElement(By.cssSelector("[id*='C2__QUE_304899FEFEF1DDEB353990_R1_" + (i + 1) + "']"))
						.getText();
				if (displayedPolicyName.equals(policyToEdit)) {
					rowToClick.click();
					Log.message(policyToEdit + " - added T&C is clicked under terms&condition", driver, extentedReport,
							Screenshot);
					isClicked = true;
					rowValue = i;
					break;
				}
			}

			if (!isClicked) {
				throw new Exception(policyToEdit + " is not availed to click");
			}
			                         
			String cssTandCTextArea = "[id*='C6__C2__QUE_A048EC24ED762AD77362602_R1_" + (rowValue + 1) + "']";

			if (WaitUtils.waitForElement(driver, rowToClick.findElement(By.cssSelector(cssTandCTextArea)))) {

				WebElement txtAreaTandC = rowToClick.findElement(By.cssSelector(cssTandCTextArea));

				String EditedText = txtAreaTandC.getText();
				if (EditedText.contains(editedValue)) {
					isedited = true;
					Log.message("Edited strings are saved in T&C", driver, extentedReport,
							Screenshot);
				}

			} else {
				throw new Exception("T&C text area is not found to edit");
			}

			return isedited;

		} catch (Exception e) {
			throw new Exception("Error while saving the edited T&C" + e);
		}
	}
	
	
	
	
	
	
	
}// CustomerDashboardPage
