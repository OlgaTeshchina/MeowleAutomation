package ru.tinkoff.fintech.meowle.pageObjects

import androidx.annotation.StringRes
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.Until

abstract class BasePage {

    protected val instrumentationRegistry = InstrumentationRegistry.getInstrumentation()
    protected val uiDevice = UiDevice.getInstance(instrumentationRegistry)

    protected fun waitFindObject(selector: BySelector, timeout: Long = 3_000L): UiObject2 {
        return uiDevice.wait(Until.findObject(selector), timeout)
    }

    protected fun waitFindObjects(selector: BySelector, searchElement: Int, timeout: Long = 3_000L): UiObject2 {
        return uiDevice.wait(Until.findObjects(selector), timeout)[searchElement]
    }

    protected fun resourceString(@StringRes stringId: Int): String {
        return instrumentationRegistry.targetContext.getString(stringId)
    }
}