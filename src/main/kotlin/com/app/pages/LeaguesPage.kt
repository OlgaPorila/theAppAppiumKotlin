package appUI.com.pages

import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver

class LeaguesPage(driver: AndroidDriver<MobileElement>) : BasePage(driver) {

    private val favoriteLeagueButLoc = MobileBy.AndroidUIAutomator(
        """new UiSelector().className("android.widget.TextView")"""
    )

    private val leagueBut = MobileBy.AndroidUIAutomator(
        """new UiSelector().className("android.widget.TextView").text("Leagues")"""
    )

    fun clickFavoriteLeagueBut(teamIconTitle: String) {
        clickElementWithText(favoriteLeagueButLoc, teamIconTitle)
    }

    fun clickByText(text: String) {
        waitForClickableElement(
            MobileBy.AndroidUIAutomator(
                """new UiSelector().text("""" + text + """")"""
            )
        ).click()
    }
}
