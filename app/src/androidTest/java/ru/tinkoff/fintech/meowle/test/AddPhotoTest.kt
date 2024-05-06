package ru.tinkoff.fintech.meowle.test

import androidx.test.espresso.intent.Intents
import androidx.test.ext.junit.rules.activityScenarioRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import ru.tinkoff.fintech.meowle.helpers.PreferencesRule
import ru.tinkoff.fintech.meowle.pageObjects.AddCatPage
import ru.tinkoff.fintech.meowle.pageObjects.TabsPage
import ru.tinkoff.fintech.meowle.presentation.MainActivity

class AddPhotoTest {

    private val preferencesRule = PreferencesRule()
    private val activityScenarioRule = activityScenarioRule<MainActivity>()

    @get:Rule
    val ruleChain = RuleChain
        .outerRule(preferencesRule)
        .around(activityScenarioRule)

    @Before
    fun setUp() {
        Intents.init()
    }

    @Test
    fun addPhoto() {

        val tabsPage = TabsPage()
        val addCatPage = AddCatPage()

        tabsPage.clickAddTab()
        addCatPage.clickAddCatAvatar()
        addCatPage.checkPhotoPickerIsOpen()
    }

    @After
    fun tearDown() {
        Intents.release()
    }
}