package ru.tinkoff.fintech.meowle.test

import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.UiDevice
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import ru.tinkoff.fintech.meowle.helpers.PreferencesRule
import ru.tinkoff.fintech.meowle.pageObjects.CatDetailsPage
import ru.tinkoff.fintech.meowle.pageObjects.RatingPage
import ru.tinkoff.fintech.meowle.pageObjects.TabsPage
import ru.tinkoff.fintech.meowle.presentation.MainActivity

class EditCatDescriptionTest {

    private val preferencesRule = PreferencesRule()
    private val activityScenarioRule = activityScenarioRule<MainActivity>()

    @get:Rule
    val ruleChain = RuleChain
        .outerRule(preferencesRule)
        .around(activityScenarioRule)

    @Test
    fun editCatDescription() {

        val uiDevice = UiDevice.getInstance(getInstrumentation())
        val tabsPage = TabsPage()
        val ratingPage = RatingPage()
        val catDetailsPage = CatDetailsPage()

        tabsPage.clickRatingTab()
        ratingPage.clickTopDislike()
        ratingPage.clickCatFromRating(0)

        with(catDetailsPage) {
            checkDescription("Описание котика")
            clickEditBtn()
            checkDescriptionIsEnable()
            enterDescription("Новое описание")
            clickEditBtn()
        }

        uiDevice.pressBack()
        ratingPage.clickTopDislike()
        ratingPage.clickCatFromRating(0)
        catDetailsPage.checkDescription("Новое описание")
    }
}