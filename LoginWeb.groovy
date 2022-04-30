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



class LoginWeb {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("User membuka https://evermos.com")
	def openEvermos() {
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://evermos.com/home/')
	}
	
	@When("User klik Masuk")
	def klikMasuk() {
		WebUI.click(findTestObject('Object Repository/EvermosLoginWeb/Page_Evermos Reseller online dan aplikasi D_3b84c7/a_Masuk'))
		WebUI.delay(10)
	}

	@When("User mengisi (.*) yang benar dan invalid (.*)")
	def memasukkanInvalidPassword(String noHP, String password) {
		WebUI.setText(findTestObject('Object Repository/EvermosLoginWeb/Page_Masuk Sebagai Reseller Evermos/input_Nomor Telepon_inputText__input'),
			noHP)
		WebUI.setEncryptedText(findTestObject('Object Repository/EvermosLoginWeb/Page_Masuk Sebagai Reseller Evermos/input_Kata Sandi_inputText__input'),
			password)
	}
	
	@Then("User akan melihat error 'Nomor Telepon atau Kata Sandi anda salah!'")
	def invalidPasswordMessage() {
		WebUI.click(findTestObject('Object Repository/EvermosLoginWeb/Page_Masuk Sebagai Reseller Evermos/p_Nomor Telepon atau Kata Sandi anda salah'))
		WebUI.closeBrowser()
	}
	
	@When("User mengisi (.*) yang invalid dan (.*) yang benar")
	def memasukkanInvalidNoHP(String noHP, String password) {
		WebUI.setText(findTestObject('Object Repository/EvermosLoginWeb/Page_Masuk Sebagai Reseller Evermos/input_Nomor Telepon_inputText__input'),
			noHP)
		WebUI.setEncryptedText(findTestObject('Object Repository/EvermosLoginWeb/Page_Masuk Sebagai Reseller Evermos/input_Kata Sandi_inputText__input'),
			password)
	}
	
	@Then("User akan melihat error 'Nomor ini belum terdaftar sebagai reseller'")
	def invalidNoHPMessage() {
		WebUI.click(findTestObject('Object Repository/EvermosLoginWeb/Page_Masuk Sebagai Reseller Evermos/p_Nomor ini belum terdaftar sebagai reseller'))
		WebUI.closeBrowser()
	}
	
	@When("User mengisi (.*) yang sudah terdaftar and (.*) yang benar")
	def memasukkanDataValid(String noHP, String password ) {
		WebUI.setText(findTestObject('Object Repository/EvermosLoginWeb/Page_Masuk Sebagai Reseller Evermos/input_Nomor Telepon_inputText__input'),
			noHP)
		WebUI.setEncryptedText(findTestObject('Object Repository/EvermosLoginWeb/Page_Masuk Sebagai Reseller Evermos/input_Kata Sandi_inputText__input'),
			password)
	}
	
	@And("User klik tombol login")
	def klikLogin() {
		WebUI.click(findTestObject('Object Repository/EvermosLoginWeb/Page_Masuk Sebagai Reseller Evermos/button_Masuk'))
	}

	@Then("User berhasil login and masuk ke halaman beranda")
	def beranda() {
		WebUI.delay(40)
		WebUI.click(findTestObject('Object Repository/EvermosLoginWeb/Page_Evermos - Katalog/button_LAIN KALI'))
	}
}