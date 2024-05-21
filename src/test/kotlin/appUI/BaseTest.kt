import appUI.com.Utility
import appUI.com.pages.*
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.MobileCapabilityType
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInfo
import org.junit.jupiter.api.TestInstance
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL
import java.nio.file.Paths
import java.util.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class BaseTest : Utility() {
    lateinit var driver: AndroidDriver<MobileElement>
    lateinit var landing: LandingPage
    lateinit var leagues: LeaguesPage
    lateinit var base: BasePage
    lateinit var teams: TeamsPage
    lateinit var main: MainPage

    @BeforeEach
    fun setUp(testInfo: TestInfo) {
        println("Starting API test: ${testInfo.displayName}")
        val cap = DesiredCapabilities()
        val adbPath = getAdbPath()
        val prop = Properties()
        prop.load(ClassLoader.getSystemResourceAsStream("config.properties"))
        val device = Runtime.getRuntime().exec("$adbPath devices").inputStream.bufferedReader()
            .use { it.readText() }.trim().split("\n")[1].split("\\s+".toRegex())[0]
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("platform"))
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, device)
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty("automation"))
        val file = Paths.get("", "./files/" + prop.getProperty("apk")).toAbsolutePath().toString()
        cap.setCapability(MobileCapabilityType.APP, file)
        val appiumUrl = prop.getProperty("appium")
        driver = AndroidDriver(URL(appiumUrl), cap)
        landing = LandingPage(driver)
        leagues = LeaguesPage(driver)
        base = BasePage(driver)
        teams = TeamsPage(driver)
        main = MainPage(driver)
    }

    @AfterEach
    fun tearDown(testInfo: TestInfo) {
        println("Finished test: ${testInfo.displayName}")
        driver?.quit()
    }
}

