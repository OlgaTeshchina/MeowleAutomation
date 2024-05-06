package ru.tinkoff.fintech.meowle.test

import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.UiDevice
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import ru.tinkoff.fintech.meowle.helpers.PreferencesRule
import ru.tinkoff.fintech.meowle.pageObjects.CatDetailsPage
import ru.tinkoff.fintech.meowle.pageObjects.FavoritePage
import ru.tinkoff.fintech.meowle.pageObjects.RatingPage
import ru.tinkoff.fintech.meowle.pageObjects.TabsPage
import ru.tinkoff.fintech.meowle.presentation.MainActivity

class RemoveFromFavoritesTest {

    private val uiDevice = UiDevice.getInstance(getInstrumentation())
    private val tabsPage = TabsPage()
    private val ratingPage = RatingPage()
    private val catDetailsPage = CatDetailsPage()
    private val favoritePage = FavoritePage()

    private val preferencesRule = PreferencesRule()
    private val activityScenarioRule = activityScenarioRule<MainActivity>()

    @get:Rule
    val ruleChain = RuleChain
        .outerRule(preferencesRule)
        .around(activityScenarioRule)

    @Before
    fun setUp() {
        tabsPage.clickRatingTab()
        ratingPage.clickCatFromRating(0)
        catDetailsPage.clickFavoriteBtn()
    }

    @Test
    fun removeFromFavoritesCat() {

        tabsPage.clickFavoriteTab()
        favoritePage.clickFavoriteCat(0)

        catDetailsPage.clickFavoriteBtn()

        uiDevice.pressBack()
        uiDevice.waitForIdle(200L)
        favoritePage.checkCatsNotFoundInList()
    }
}