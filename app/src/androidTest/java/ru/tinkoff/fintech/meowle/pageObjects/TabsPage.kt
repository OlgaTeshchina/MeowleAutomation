package ru.tinkoff.fintech.meowle.pageObjects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.uiautomator.By
import ru.tinkoff.fintech.meowle.R
import ru.tinkoff.fintech.meowle.helpers.Constants

class TabsPage:  BasePage() {

    private val settingsTab = By.res(Constants.APP_PCKG, "navigation_bar_item_icon_view")
    private val addTab = onView(withId(R.id.tab_btn_add))
    private val ratingTab = onView(withId(R.id.tab_btn_rating))
    private val favoriteTab = onView(withId(R.id.tab_btn_favourite))

    fun clickSettingsTab() {
        val settingsTabField = waitFindObjects(settingsTab, 4)
        settingsTabField.click()
    }

    fun clickAddTab() {
        addTab.perform(click())
    }

    fun clickRatingTab() {
        ratingTab.perform(click())
    }

    fun clickFavoriteTab() {
        favoriteTab.perform(click())
    }
}