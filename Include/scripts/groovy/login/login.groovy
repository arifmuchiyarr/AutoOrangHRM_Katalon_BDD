package login
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class login {

	static object(String xpath) {
		TestObject obj = new TestObject().addProperty("xpath", ConditionType.EQUALS, xpath)
		return obj
	}

	@Given("I Open Browser and navigate to Website")
	def OpenBrowserAndNavigateToWebsite() {
		WebUI.openBrowser(GlobalVariable.URL, FailureHandling.STOP_ON_FAILURE)
		WebUI.maximizeWindow()
		WebUI.waitForPageLoad(10)
		WebUI.verifyElementPresent(object('//input[@name="username"]'), 0, FailureHandling.STOP_ON_FAILURE)
		WebUI.takeScreenshot()
	}

	@When("I input Username and Password and click login button")
	def inputUserandPassandClickLogin() {
		WebUI.setText(object('//input[@name="username"]'), 'Admin', FailureHandling.STOP_ON_FAILURE)
		WebUI.setText(object('//input[@name="password"]'), 'admin123', FailureHandling.STOP_ON_FAILURE)
		WebUI.takeScreenshot()
		WebUI.click(object('//button[@type="submit" and text()=" Login "]'), FailureHandling.STOP_ON_FAILURE)
	}

	@Then("I verify success login")
	def I_verify_success_Login() {
		WebUI.waitForPageLoad(10)
		WebUI.verifyElementPresent(object('//h6[text()="Dashboard"]'), 0, FailureHandling.STOP_ON_FAILURE)
	}
	

	@When("I click login button without input form")
	def ClickLoginWithoutFillForm() {
		WebUI.takeScreenshot()
		WebUI.click(object('//button[@type="submit" and text()=" Login "]'), FailureHandling.STOP_ON_FAILURE)
	}

	@And("I verify get error required both field")
	def I_verify_getErrorBothField() {
		WebUI.verifyElementPresent(object('//div[input[@name="username"]]/following-sibling::span[text()="Required"]'), 0, FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementPresent(object('//div[input[@name="password"]]/following-sibling::span[text()="Required"]'), 0, FailureHandling.STOP_ON_FAILURE)
		WebUI.takeScreenshot()
	}

	@Then("I verify still on the login page")
	def I_verify_still_on_Login_Page() {
		WebUI.verifyElementPresent(object('//input[@name="username"]'), 0, FailureHandling.STOP_ON_FAILURE)
	}
	
	
	@When("I click login button without input username")
	def ClickLoginWithoutFillusername() {
		WebUI.setText(object('//input[@name="password"]'), 'admin123', FailureHandling.STOP_ON_FAILURE)
		WebUI.takeScreenshot()
		WebUI.click(object('//button[@type="submit" and text()=" Login "]'), FailureHandling.STOP_ON_FAILURE)
	}

	@And("I verify get error required username field")
	def I_verify_getErrorOnUsernameField() {
		WebUI.verifyElementPresent(object('//div[input[@name="username"]]/following-sibling::span[text()="Required"]'), 0, FailureHandling.STOP_ON_FAILURE)
		WebUI.takeScreenshot()
	}
	
	
	@When("I click login button without input password")
	def ClickLoginWithoutFillpassword() {
		WebUI.setText(object('//input[@name="username"]'), 'Admin', FailureHandling.STOP_ON_FAILURE)
		WebUI.takeScreenshot()
		WebUI.click(object('//button[@type="submit" and text()=" Login "]'), FailureHandling.STOP_ON_FAILURE)
	}

	@And("I verify get error required password field")
	def I_verify_getErrorOnpasswordField() {
		WebUI.verifyElementPresent(object('//div[input[@name="password"]]/following-sibling::span[text()="Required"]'), 0, FailureHandling.STOP_ON_FAILURE)
		WebUI.takeScreenshot()
	}
	
	
	
	
	@When("I click login button with invalid input username")
	def ClickLoginWithinvalidusername() {
		WebUI.setText(object('//input[@name="username"]'), 'Admin123', FailureHandling.STOP_ON_FAILURE)
		WebUI.setText(object('//input[@name="password"]'), 'admin123', FailureHandling.STOP_ON_FAILURE)
		WebUI.takeScreenshot()
		WebUI.click(object('//button[@type="submit" and text()=" Login "]'), FailureHandling.STOP_ON_FAILURE)
	}

	@And("I verify get error error Invalid Credential")
	def I_verify_getErrorOinvalidCredential() {
		WebUI.verifyElementPresent(object('//p[text()="Invalid credentials"]'), 0, FailureHandling.STOP_ON_FAILURE)
		WebUI.takeScreenshot()
	}
	
	@When("I click login button with invalid input password")
	def ClickLoginWithinvalidpassword() {
		WebUI.setText(object('//input[@name="username"]'), 'Admin', FailureHandling.STOP_ON_FAILURE)
		WebUI.setText(object('//input[@name="password"]'), 'admin1234', FailureHandling.STOP_ON_FAILURE)
		WebUI.takeScreenshot()
		WebUI.click(object('//button[@type="submit" and text()=" Login "]'), FailureHandling.STOP_ON_FAILURE)
	}
	
	@When("I click login button with invalid input username dan password")
	def ClickLoginWithinvalidusernamedanpassword() {
		WebUI.setText(object('//input[@name="username"]'), 'Admin234', FailureHandling.STOP_ON_FAILURE)
		WebUI.setText(object('//input[@name="password"]'), 'admin1234', FailureHandling.STOP_ON_FAILURE)
		WebUI.takeScreenshot()
		WebUI.click(object('//button[@type="submit" and text()=" Login "]'), FailureHandling.STOP_ON_FAILURE)
	}
	
	
	
	
}