package ru.tinkoff.fintech.meowle.pageObjects

import androidx.test.uiautomator.By
import junit.framework.TestCase.assertTrue
import ru.tinkoff.fintech.meowle.helpers.Constants

class SearchPage: BasePage() {

    private val searchField = By.res(Constants.APP_PCKG, "et_search")
    private val searchBtn = By.res(Constants.APP_PCKG, "search_button")
    private val foundCat = By.res(Constants.APP_PCKG, "cat_name")

    fun enterSearchText(searchName: String) {
        waitFindObject(searchField).text = searchName
    }

    fun clickSearchBtn() {
        waitFindObject(searchBtn).click()
    }

    fun clickFoundCat(foundCatIndexed: Int) {
        waitFindObjects(foundCat, foundCatIndexed).click()
    }

    fun checkFoundCatName(foundName: String, foundCatIndexed: Int) {
        val foundCatName = waitFindObjects(foundCat, foundCatIndexed).text
        assertTrue(foundCatName.contains(foundName))
    }

    fun getFoundCatName(foundCatIndexed: Int): String {
        return waitFindObjects(foundCat, foundCatIndexed).text
    }
}