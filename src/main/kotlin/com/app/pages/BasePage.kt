package appUI.com.pages

import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

open class BasePage(protected val driver: AndroidDriver<MobileElement>) {

    private val continueButLoc =
        MobileBy.AndroidUIAutomator("""new UiSelector().className("android.widget.TextView").text("Continue")""")
    private val maybeLaterButLoc =
        MobileBy.AndroidUIAutomator("""new UiSelector().className("android.widget.TextView").text("Maybe Later")""")
    private val allowNotificationButLoc =
        MobileBy.AndroidUIAutomator("""new UiSelector().className("android.widget.Button").text("Allow")""")
    private val returnButLoc =
        MobileBy.AndroidUIAutomator("""new UiSelector().className("android.widget.ImageButton").description("Navigate up")""")

    fun waitForClickableElement(locator: By): MobileElement {
        val wait = WebDriverWait(driver, 20)
        return wait.until(ExpectedConditions.elementToBeClickable(locator)) as MobileElement
    }

    fun clickElementWithText(locator: By, textToClick: String) {
        val wait = WebDriverWait(driver, 20)
        val elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator))
        for (element in elements) {
            if (element.text == textToClick) {
                val clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element))
                clickableElement.click()
                return
            }
        }
        throw NoSuchElementException("Element with text '$textToClick' not found in the list.")
    }

    fun clickElement(locator: By) {
        val wait = WebDriverWait(driver, 20)
        val elements = wait.until(ExpectedConditions.presenceOfElementLocated(locator))
        elements.click()
        return
    }

    fun ifElementWithTextPresent(locator: By, textToFind: String): Boolean {
        val wait = WebDriverWait(driver, 20)
        val elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator))
        for (element in elements) {
            if (element.text == textToFind) {
                return true
            }
        }
        return false
    }

    fun clickContinueBut() {
        waitForClickableElement(continueButLoc).click()
    }

    fun clickMaybeLaterBut() {
        waitForClickableElement(maybeLaterButLoc).click()
    }


    fun clickAllowNotificationBut() {
        waitForClickableElement(allowNotificationButLoc).click()
    }

    fun clickReturnBut() {
        waitForClickableElement(returnButLoc).click()
    }

    fun clickContinueTwice() {
        clickContinueBut()
        clickContinueBut()
    }

    fun navigateBack(mainPage: MainPage, header: String) {
        clickReturnBut()
        mainPage.verifyTeamIcon(header)
    }

    fun navigateToFavoriteLeaguePage(
        landing: LandingPage, leagues: LeaguesPage, base: BasePage,
        teams: TeamsPage, main: MainPage, league: String, icon: String, team: String
    ) {
        landing.clickStartedBut()
        leagues.clickFavoriteLeagueBut(league)
        main.verifyTeamIcon("Choose your favorite leagues")
        base.clickContinueBut()
        base.clickMaybeLaterBut()
        teams.clickFavoriteTeamBut(team)
        main.verifyTeamIcon(icon)
        base.clickContinueTwice()
        base.clickMaybeLaterBut()
        base.clickAllowNotificationBut()
    }
}