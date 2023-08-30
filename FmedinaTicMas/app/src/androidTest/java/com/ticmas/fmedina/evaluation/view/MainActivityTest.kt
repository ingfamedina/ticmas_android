package com.ticmas.fmedina.evaluation.view

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.ticmas.fmedina.evaluation.R
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun mainActivity_compareEqual() {
        Espresso.onView(
            ViewMatchers.withId(R.id.txtPalabra1)
        ).perform(
            ViewActions.typeText("APROBAME!")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.txtPalabra2)
        ).perform(
            ViewActions.typeText("APROBAME!")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.btnComparar)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.lblResultado)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("IGUALES")
            )
        )
    }
}