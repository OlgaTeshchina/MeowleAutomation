package ru.tinkoff.fintech.meowle.helpers

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class PreferencesRule : TestRule {
    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            override fun evaluate() {
                putAuthParam()
                base.evaluate()
                clearPrefs()
            }
        }
    }

    private fun putAuthParam() {
        InstrumentationRegistry.getInstrumentation().targetContext
            .getSharedPreferences("meowle", Context.MODE_PRIVATE)
            .edit()
            .putBoolean("auth", true)
            .putString("name", "NAME")
            .commit()
    }

    private fun clearPrefs() {
        InstrumentationRegistry.getInstrumentation().targetContext
            .getSharedPreferences("meowle", Context.MODE_PRIVATE)
            .edit()
            .clear()
            .commit()
    }
}