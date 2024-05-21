import io.restassured.RestAssured
import io.restassured.RestAssured.baseURI
import io.restassured.parsing.Parser
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInfo
import org.junit.jupiter.api.TestInstance
import java.util.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class BaseApiTest {
    companion object {
        lateinit var baseApiUrl: String

        @JvmStatic
        @BeforeAll
        fun setup(testInfo: TestInfo) {
            println("Starting API test: ${testInfo.displayName}")
            val properties = Properties()
            properties.load(ClassLoader.getSystemResourceAsStream("config.properties"))
            baseApiUrl = properties.getProperty("api.url")
            baseURI = baseApiUrl
            RestAssured.registerParser("text/plain", Parser.TEXT)
        }
    }
}

