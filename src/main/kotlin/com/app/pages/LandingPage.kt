package appUI.com.pages

import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver

class LandingPage(driver: AndroidDriver<MobileElement>) : BasePage(driver) {

    private val startedButLoc = MobileBy.AndroidUIAutomator(
        """new UiSelector().className("android.widget.TextView").text("Get Started")"""
    )

    fun clickStartedBut() {
        waitForClickableElement(startedButLoc).click()
    }
}
