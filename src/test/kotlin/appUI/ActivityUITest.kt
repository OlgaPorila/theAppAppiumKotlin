package appUI;

import BaseTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class ActivityUITest : BaseTest() {
    companion object {
        @JvmStatic
        fun provideTestData(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("PGA Tour", "PGA"),
                Arguments.of("MLB Baseball", "MLB"),
                Arguments.of("NCAA Football", "NCAAF")
            )
        }

        @JvmStatic
        fun provideTeamsTestData(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("NCAA Football", "NCAAF", "Miami Dolphins"),
                Arguments.of("NFL Fantasy News", "NFLFAN", "Miami Marlins"),
                Arguments.of("PGA Tour", "PGA", "Miami Heat")
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideTeamsTestData")
    @DisplayName("Test leagues flow ")
    fun testLeaguesFlow(league: String, icon: String, team: String) {
        base.navigateToFavoriteLeaguePage(landing, leagues, base, teams, main, league, icon, team)
        leagues.clickByText(icon)
        teams.verifyHeaderIsPresented(league)
        base.navigateBack(main, icon)
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    @DisplayName("Test teams flow")
    fun testTeamsFlow(league: String, icon: String) {
        landing.clickStartedBut()
        leagues.clickFavoriteLeagueBut(league)
        main.verifyTeamIcon(icon)
        base.clickContinueBut()
        base.clickMaybeLaterBut()
        teams.clickFavoriteTeamBut(icon)
        main.verifyTeamIcon(icon)
        base.clickContinueTwice()
        base.clickMaybeLaterBut()
        base.clickAllowNotificationBut()
    }
}
