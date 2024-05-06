package ru.tinkoff.fintech.meowle.pageObjects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.uiautomator.By
import junit.framework.TestCase.assertEquals
import ru.tinkoff.fintech.meowle.R
import ru.tinkoff.fintech.meowle.helpers.Constants

class CatDetailsPage: BasePage() {

    private val titleCatText = By.res(Constants.APP_PCKG, "tw_details_title")
    private val likeCount = By.res(Constants.APP_PCKG, "cat_likes")
    private val descriptionText = By.res(Constants.APP_PCKG, "cat_description")
    private val descriptionTextEspresso = onView(withId(R.id.cat_description))
    private val likeBtn = onView(withId(R.id.ib_like))
    private val editBtn = onView(withId(R.id.btn_edit))
    private val favoriteBtn = onView(withId(R.id.ib_favorite))

    fun checkTitleCat(expectedTitle: String) {
        val resultTitle = waitFindObject(titleCatText).text
        assertEquals(expectedTitle, resultTitle)
    }

    fun checkDescription(expectedDescription: String) {
        val actualDescription = waitFindObject(descriptionText).text
        assert(expectedDescription == actualDescription)
    }

    fun checkDescriptionIsEnable() {
        descriptionTextEspresso.check(matches(isEnabled()))
    }

    fun enterDescription(descriptionText: String) {
        descriptionTextEspresso.perform(replaceText(descriptionText))
    }

    fun clickLikeBtn() {
        likeBtn.perform(click())
    }

    fun clickEditBtn() {
        editBtn.perform(click())
    }

    fun clickFavoriteBtn() {
        favoriteBtn.perform(click())
    }

    fun getCountLikeTheCat(): Int {
        return waitFindObject(likeCount).text.substring(3).toInt()
    }
}