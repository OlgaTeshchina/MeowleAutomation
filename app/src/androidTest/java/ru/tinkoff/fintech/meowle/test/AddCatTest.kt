package ru.tinkoff.fintech.meowle.test

import androidx.test.ext.junit.rules.activityScenarioRule
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import ru.tinkoff.fintech.meowle.helpers.Helpers
import ru.tinkoff.fintech.meowle.helpers.PreferencesRule
import ru.tinkoff.fintech.meowle.pageObjects.AddCatPage
import ru.tinkoff.fintech.meowle.pageObjects.TabsPage
import ru.tinkoff.fintech.meowle.presentation.MainActivity

class AddCatTest {

    private val preferencesRule = PreferencesRule()
    private val activityScenarioRule = activityScenarioRule<MainActivity>()

    @get:Rule
    val ruleChain = RuleChain
        .outerRule(preferencesRule)
        .around(activityScenarioRule)

    @Test
    fun addCatSuccess() {

        val tabsPage = TabsPage()
        val addCatPage = AddCatPage()
        val catName = Helpers.getRandomName()

        tabsPage.clickAddTab()
        with(addCatPage) {
            enterTextName(catName)
            chooseGenderFemale()
            enterTextDescription("Самый милый котик")
            clickBtnAdd()
            checkSuccessMessage()
        }
    }
}