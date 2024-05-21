package appUI.com.pages

import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver

class TeamsPage(driver: AndroidDriver<MobileElement>) : BasePage(driver) {
    private val headerLoc =
        MobileBy.AndroidUIAutomator("""new UiSelector().className("android.widget.TextView")""")

    fun verifyHeaderIsPresented(header: String): Boolean {
        val actualText = ifElementWithTextPresent(headerLoc, header)
        if (!actualText) {
            throw AssertionError("$header is not presented.")
        }
        return actualText
    }

    fun clickFavoriteTeamBut(teamIconTitle: String) {
        clickElementWithText(headerLoc, teamIconTitle)
    }
}