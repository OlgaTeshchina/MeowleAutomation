package ru.tinkoff.fintech.meowle.pageObjects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import ru.tinkoff.fintech.meowle.R
import ru.tinkoff.fintech.meowle.helpers.ToastMatcherAPI29

class AddCatPage: BasePage() {

    private val addCatAvatar = onView(withId(R.id.iw_add_cat_avatar))
    private val nameField = onView(withId(R.id.et_name))
    private val genderField = onView(withHint("Пол"))
    private val genderFemale = onView(withText(R.string.gender_female))
    private val descriptionField = onView(withId(R.id.cat_description))
    private val btnAdd = onView(withId(R.id.btn_add))
    private val successMessage = onView(withText(R.string.add_snackbar_success_message))

    fun clickAddCatAvatar() {
        addCatAvatar.perform(click())
    }

    fun clickBtnAdd() {
        btnAdd.perform(click())
    }

    fun enterTextName(nameText: String) {
        nameField.perform(replaceText(nameText))
    }

    fun enterTextDescription(textDescription: String) {
        descriptionField.perform(replaceText(textDescription))
    }

    fun chooseGenderFemale() {
        genderField.perform(click())
        genderFemale
            .inRoot(RootMatchers.isPlatformPopup())
            .perform(click())
    }

    fun checkSuccessMessage() {
        successMessage.inRoot(ToastMatcherAPI29())
            .check(matches(isDisplayed()))
    }

    fun checkPhotoPickerIsOpen() {
        Intents.intended(IntentMatchers.toPackage("com.google.android.providers.media.module"))
    }
}