package appAPI

import BaseApiTest
import io.restassured.RestAssured.given
import io.restassured.filter.log.ErrorLoggingFilter
import io.restassured.filter.log.RequestLoggingFilter
import io.restassured.filter.log.ResponseLoggingFilter
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


class ActivityAPITest : BaseApiTest() {
    data class ConnectivityCheckItem(
        val api_uri: String,
        val android_url: String,
        val copyright_url: String
    )

    companion object {
        @JvmStatic
        fun provideTestData(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("/leagues/", 1),
                Arguments.of("/leagues/", 2),
                Arguments.of("/leagues/", 3),
                Arguments.of("/leagues/", 4),
                Arguments.of("/leagues/", 5),
                Arguments.of("/leagues/", 6),
                Arguments.of("/leagues/", 7),
                Arguments.of("/teams/", 1),
                Arguments.of("/teams/", 2),
                Arguments.of("/teams/", 3),
                Arguments.of("/teams/", 4),
                Arguments.of("/teams/", 5),
                Arguments.of("/teams/", 6),
                Arguments.of("/teams/", 7),
            )
        }

        @JvmStatic
        fun provideLeaguesTestData(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("/nfl/", 59),
                Arguments.of("/nfl/", 60),
                Arguments.of("/nba/", 59),
                Arguments.of("/nba/", 60)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    @DisplayName("Test Hockey League endpoint")
    fun testHockeyLeaguesEndpoint(path: String, id: Int) {
        given().get("/hockey" + path + id).then().statusCode(200)
            .body("id", equalTo(id))
    }

    @ParameterizedTest
    @MethodSource("provideLeaguesTestData")
    @DisplayName("Test Leagues endpoint")
    fun testLeaguesEndpoint(path: String, id: Int) {
        given().filters(RequestLoggingFilter(), ResponseLoggingFilter(), ErrorLoggingFilter())
            .get(path + "seasons/" + id).then().statusCode(200)
            .body("id", equalTo(id))
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    @DisplayName("Test Football League endpoint")
    fun testFootballLeaguesEndpoint(path: String, id: Int) {
        given().get("/hockey" + path + id).then().statusCode(200)
            .body("id", equalTo(id))
    }

    @Test
    fun testMultisportScheduleEndpoint() {
        given().get("/multisport/schedule").then().statusCode(200)
            .body("groups[0].guid", equalTo("multisport:2024-05-13"))
    }

    @Test
    fun testMetaLeaguesEndpoint() {
        given().get("/meta/leagues").then().statusCode(200)
            .body("leagues.show[0].id", equalTo(1))
    }

    @Test
    fun testMetaConnectEndpoint() {
        val response =
            given()
                .get("/meta/connectivity-check")
                .then()
                .statusCode(200)
                .extract()
                .response().asString()
        assert(response.contains("OK"))
    }

    @Test
    fun testMetaEndpoint() {
        given()
            .get("/meta")
            .then()
            .statusCode(200)
            .body("copyright_url", equalTo("https://www.thescore.com/pages/copyright"))
    }

    @Test
    fun testSpotlightsEndpoint() {
        val response = given()
            .get("/spotlights")
            .then()
            .statusCode(200)
            .extract()
            .response()

        val responseBody = response.asString()
        println("Response: $responseBody")

        val items: List<ConnectivityCheckItem> = response.jsonPath().getList("", ConnectivityCheckItem::class.java)
        assert(items.isNotEmpty())
        assert(items[0].api_uri == "/spotlights/1630")
        assert(items[0].android_url == "https://www.thepwhl.com/en/stats/standings")
    }

    @Test
    fun testNFLStandingsEndpoint() {
        val response = given()
            .get("/nfl/standings")
            .then()
            .statusCode(200)
            .extract()
            .response()

        val responseBody = response.asString()
        println("Response: $responseBody")
        val items: List<ConnectivityCheckItem> = response.jsonPath().getList("", ConnectivityCheckItem::class.java)
        assert(items.isEmpty())
    }

    @Test
    fun testNFLLeadersEndpoint() {
        val response = given()
            .get("/nfl/leaders?league_name.eq=nfl")
            .then()
            .statusCode(200)
            .extract()
            .response()

        val responseBody = response.asString()
        println("Response: $responseBody")
        val items: List<ConnectivityCheckItem> = response.jsonPath().getList("", ConnectivityCheckItem::class.java)
        assert(items.isEmpty())
    }
}