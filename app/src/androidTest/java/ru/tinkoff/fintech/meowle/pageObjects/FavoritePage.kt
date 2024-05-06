package ru.tinkoff.fintech.meowle.pageObjects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.uiautomator.By
import ru.tinkoff.fintech.meowle.R
import ru.tinkoff.fintech.meowle.helpers.Constants

class FavoritePage: BasePage() {

    private val favoritesCatNames = By.res(Constants.APP_PCKG, "cat_name")
    private val favoritesCatNames2 = onView(withId(R.id.cat_name))

    fun getNameFavoriteCat(searchElement: Int): String {
        return waitFindObjects(favoritesCatNames, searchElement).text
    }

    fun clickFavoriteCat(searchElement: Int) {
        waitFindObjects(favoritesCatNames, searchElement).click()
    }

    fun checkCatsNotFoundInList() {
        favoritesCatNames2.check(doesNotExist())
    }
}