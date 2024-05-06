package ru.tinkoff.fintech.meowle.test

import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.tinkoff.fintech.meowle.pageObjects.AuthPage
import ru.tinkoff.fintech.meowle.pageObjects.SettingsPage
import ru.tinkoff.fintech.meowle.pageObjects.TabsPage
import ru.tinkoff.fintech.meowle.presentation.view.AuthActivity

@RunWith(AndroidJUnit4::class)
class LogoutTest {

    @get:Rule
    val activityScenarioRule = activityScenarioRule<AuthActivity>()

    @Test
    fun logout() {

        val authPage = AuthPage()
        val tabsPage = TabsPage()
        val settingsPage = SettingsPage()

        with(authPage) {
            enterName("Оля")
            enterPhone("+79508904567")
            clickSubmit()
        }
        tabsPage.clickSettingsTab()
        settingsPage.clickLogoutBtn()
        authPage.checkTitleTextAuth()
    }
}