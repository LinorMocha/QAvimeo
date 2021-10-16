import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebDriver as WebDriver
import java.util.List as List
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import bsh.Variable

import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

//// CONSTS Start

VIDEO_SELECTOR = String.format('a[href="%s"]',GlobalVariable.videoUrl )

SECOND_VIDEO_SELECTOR = String.format('a[href="%s"]', GlobalVariable.secondVideoUrl)

// CONSTS End

WebDriver driver = DriverFactory.getWebDriver()


WebElement login = driver.findElement(By.className('js-topnav_menu_auth'))

login.click()

WebElement emailInput = driver.findElement(By.name('email'))

emailInput.sendKeys(GlobalVariable.userMail)

WebElement passwordInput = driver.findElement(By.name('password'))

passwordInput.sendKeys(GlobalVariable.userPassword)

WebElement Submit = driver.findElement(By.cssSelector('input[class=\'iris_btn iris_btn--lg iris_btn--positive js-email-submit\']'))

Submit.click()

// search box
WebElement Search = driver.findElement(By.id('topnav-search'))

// Inserting the requested video 
Search.sendKeys(GlobalVariable.videoName + '\n')

// chose the requested video 
driver.findElement(By.cssSelector(VIDEO_SELECTOR)).click()

ArrayList<WebElement> commentList = driver.findElements(By.cssSelector(' p[class=\'first\']'))

ArrayList<WebElement> commentorList = driver.findElements(By.cssSelector('a[class=\'js-user_link jT_ky Y3PvY\']'))

i = 0

for (WebElement comment : commentList) {
    if (comment.getText().equals(GlobalVariable.comment)) {
        if ((commentorList[i]).getText().equals(GlobalVariable.userName)) {
            print((('comment verified' + '\n') + 'The comment is: ') + comment.getText())
        }
    }
    
    i++
}

// search box
WebElement SearchBox = driver.findElement(By.id('topnav-search'))

// Inserting the second video name in the search box
SearchBox.sendKeys(GlobalVariable.secondVideoName + '\n')

// chose the requested video
driver.findElement(By.cssSelector(SECOND_VIDEO_SELECTOR)).click()

WebElement commentsUrl = driver.findElement(By.cssSelector('a[href=\'#comments\']'))

WebElement commentsElement = commentsUrl.findElement(By.cssSelector('span[class=\'sc-jqCOkK ixuvoI\']'))

WebElement likesUrl = driver.findElement(By.cssSelector('a[href=\'/99666551/likes\']'))

WebElement likesElement = likesUrl.findElement(By.cssSelector('span[class=\'sc-jqCOkK ixuvoI\']'))

GlobalVariable.commentNumber = commentsElement.getText()

def likeNumber = likesElement.getText()



