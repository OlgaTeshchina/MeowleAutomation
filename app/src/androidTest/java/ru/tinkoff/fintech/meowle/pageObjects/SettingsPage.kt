package ru.tinkoff.fintech.meowle.pageObjects

import androidx.test.uiautomator.By
import junit.framework.TestCase
import ru.tinkoff.fintech.meowle.helpers.Constants

class SettingsPage: BasePage() {

    private val logoutBtn = By.res(Constants.APP_PCKG, "logout_btn")

    fun checkLogoutBtnText(expectedText: String) {
        val resultText = waitFindObject(logoutBtn).text
        TestCase.assertEquals(expectedText, resultText)
    }

    fun clickLogoutBtn() {
        waitFindObject(logoutBtn).click()
    }
}