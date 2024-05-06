package ru.tinkoff.fintech.meowle.pageObjects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.uiautomator.By
import ru.tinkoff.fintech.meowle.helpers.Constants

class RatingPage: BasePage() {

    private val likeCount = By.res(Constants.APP_PCKG, "cat_likes")
    private val catFromRating = By.res(Constants.APP_PCKG, "cat_name")
    private val topDislike = onView(withText("Топ по дизлайкам"))

    fun getCountLike(searchElement: Int): Int {
        return waitFindObjects(likeCount, searchElement).text.substring(3).toInt()
    }

    fun getCatName(searchElement: Int): String {
        return waitFindObjects(catFromRating, searchElement).text
    }

    fun clickCatFromRating(searchElement: Int) {
        waitFindObjects(catFromRating, searchElement).click()
    }

    fun clickTopDislike() {
        topDislike.perform(click())
    }
}