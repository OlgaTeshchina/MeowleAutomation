package ru.tinkoff.fintech.meowle.test

import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.UiDevice
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import ru.tinkoff.fintech.meowle.helpers.PreferencesRule
import ru.tinkoff.fintech.meowle.pageObjects.CatDetailsPage
import ru.tinkoff.fintech.meowle.pageObjects.RatingPage
import ru.tinkoff.fintech.meowle.pageObjects.TabsPage
import ru.tinkoff.fintech.meowle.presentation.MainActivity

class LikeTopCatTest {

    private val preferencesRule = PreferencesRule()
    private val activityScenarioRule = activityScenarioRule<MainActivity>()

    @get:Rule
    val ruleChain = RuleChain
        .outerRule(preferencesRule)
        .around(activityScenarioRule)

    @Test
    fun likeTopCat() {

        val uiDevice = UiDevice.getInstance(getInstrumentation())
        val tabsPage = TabsPage()
        val catDetailsPage = CatDetailsPage()
        val ratingPage = RatingPage()

        tabsPage.clickRatingTab()
        val likesInRating = ratingPage.getCountLike(0)
        ratingPage.clickCatFromRating(0)

        catDetailsPage.clickLikeBtn()
        val likesInDetails = catDetailsPage.getCountLikeTheCat()
        assertEquals(likesInRating + 1, likesInDetails)

        uiDevice.pressBack()
        val likesRatingAfter = ratingPage.getCountLike(0)
        assert(likesRatingAfter == likesInDetails)
    }
}