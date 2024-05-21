package appUI.com.pages

import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver

class MainPage(driver: AndroidDriver<MobileElement>) : BasePage(driver) {
    private val teamIconLoc = MobileBy.AndroidUIAutomator(
        """new UiSelector().className("android.widget.TextView")"""
    )

    fun verifyTeamIcon(teamIconTitle: String): Boolean {
        val actualText = ifElementWithTextPresent(teamIconLoc, teamIconTitle)
        if (!actualText) {
            throw AssertionError("The title is different from : $teamIconTitle")
        }
        return actualText
    }
}
