package ru.tinkoff.fintech.meowle.test

import androidx.test.ext.junit.rules.activityScenarioRule
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import ru.tinkoff.fintech.meowle.helpers.PreferencesRule
import ru.tinkoff.fintech.meowle.pageObjects.CatDetailsPage
import ru.tinkoff.fintech.meowle.pageObjects.FavoritePage
import ru.tinkoff.fintech.meowle.pageObjects.RatingPage
import ru.tinkoff.fintech.meowle.pageObjects.TabsPage
import ru.tinkoff.fintech.meowle.presentation.MainActivity

class AddToFavoritesTest {

    private val preferencesRule = PreferencesRule()
    private val activityScenarioRule = activityScenarioRule<MainActivity>()

    @get:Rule
    val ruleChain = RuleChain
        .outerRule(preferencesRule)
        .around(activityScenarioRule)

    @Test
    fun addCatToFavorites() {

        val tabsPage = TabsPage()
        val ratingPage = RatingPage()
        val catDetailsPage = CatDetailsPage()
        val favoritePage = FavoritePage()

        tabsPage.clickRatingTab()
        val nameCatFromRating = ratingPage.getCatName(0)
        ratingPage.clickCatFromRating(0)

        catDetailsPage.clickFavoriteBtn()
        tabsPage.clickFavoriteTab()

        val nameFavoriteCat = favoritePage.getNameFavoriteCat(0)
        assert(nameCatFromRating == nameFavoriteCat)
    }
}