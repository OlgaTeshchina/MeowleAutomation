package ru.tinkoff.fintech.meowle.test

import androidx.test.ext.junit.rules.activityScenarioRule
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import ru.tinkoff.fintech.meowle.helpers.PreferencesRule
import ru.tinkoff.fintech.meowle.pageObjects.CatDetailsPage
import ru.tinkoff.fintech.meowle.pageObjects.SearchPage
import ru.tinkoff.fintech.meowle.presentation.MainActivity

class TransitionToCatDetailsTest {

    private val preferencesRule = PreferencesRule()
    private val activityScenarioRule = activityScenarioRule<MainActivity>()

    @get:Rule
    val ruleChain = RuleChain
        .outerRule(preferencesRule)
        .around(activityScenarioRule)

    @Test
    fun transitionFromSearchingForCatsToDetails() {

        val searchPage = SearchPage()
        val catsDetailsPage = CatDetailsPage()

        with(searchPage) {
            enterSearchText("кот")
            clickSearchBtn()
        }

        val catName = searchPage.getFoundCatName(0)
        searchPage.clickFoundCat(0)

        catsDetailsPage.checkTitleCat("Досье по $catName")
    }
}