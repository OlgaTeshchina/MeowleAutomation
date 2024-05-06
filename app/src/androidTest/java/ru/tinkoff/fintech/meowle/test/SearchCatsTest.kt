package ru.tinkoff.fintech.meowle.test

import androidx.test.ext.junit.rules.activityScenarioRule
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import ru.tinkoff.fintech.meowle.helpers.PreferencesRule
import ru.tinkoff.fintech.meowle.pageObjects.SearchPage
import ru.tinkoff.fintech.meowle.presentation.MainActivity

class SearchCatsTest {

    private val preferencesRule = PreferencesRule()
    private val activityScenarioRule = activityScenarioRule<MainActivity>()

    @get:Rule
    val ruleChain = RuleChain
        .outerRule(preferencesRule)
        .around(activityScenarioRule)

    @Test
    fun successfulSearchCats() {

        with(SearchPage()) {
            enterSearchText("кот")
            clickSearchBtn()
            checkFoundCatName("кот", 0)
        }
    }
}