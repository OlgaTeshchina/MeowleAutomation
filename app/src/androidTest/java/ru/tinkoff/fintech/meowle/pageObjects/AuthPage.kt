package ru.tinkoff.fintech.meowle.pageObjects

import androidx.test.uiautomator.By
import junit.framework.TestCase.assertEquals
import ru.tinkoff.fintech.meowle.R
import ru.tinkoff.fintech.meowle.helpers.Constants

class AuthPage: BasePage() {

    private val titleField = By.res(Constants.APP_PCKG, "tw_person_screen_title")
    private val nameField = By.res(Constants.APP_PCKG, "et_name")
    private val phoneField = By.res(Constants.APP_PCKG, "et_phone")
    private val submitButton = By.res(Constants.APP_PCKG, "submit_button")

    fun checkTitleTextAuth() {
        val actualTitleText = waitFindObject(titleField).text
        val expectedTitleText = resourceString(R.string.auth_title)
        assertEquals(expectedTitleText, actualTitleText)
    }

    fun enterName(name: String) {
        waitFindObject(nameField).text = name
    }

    fun enterPhone(phone: String) {
        waitFindObject(phoneField).text = phone
    }

    fun clickSubmit() {
        waitFindObject(submitButton).click()
    }
}