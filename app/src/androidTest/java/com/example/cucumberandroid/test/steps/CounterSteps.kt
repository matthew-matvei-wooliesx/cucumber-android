package com.example.cucumberandroid.test.steps

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import com.example.cucumberandroid.MainActivity
import com.example.cucumberandroid.R
import io.cucumber.java.Before
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

class CounterSteps {
    @Before
    fun setup() {
        ActivityScenario.launch<MainActivity>(
            Intent(
                InstrumentationRegistry.getInstrumentation().targetContext,
                MainActivity::class.java
            )
        )
    }

    @When("the application starts")
    fun applicationStarts() {
        // Application already started in @Before hook
    }

    @Then("the counter should display {string}")
    fun counterShouldDisplay(count: String) {
        onView(withId(R.id.counter)).check(matches(withText(count)))
    }

    @Given("the counter starts at {int}")
    fun counterStartsAt(count: Int) {
        incrementCounterXTimes(count)

        onView(withId(R.id.counter)).check(matches(withText(count.toString())))
    }

    @When("the user increments the counter {int} times")
    fun userIncrementsCounterXTimes(x: Int) {
        incrementCounterXTimes(x)
    }

    @When("the user decrements the counter {int} times")
    fun userDecrementsCounterXTimes(x: Int) {
        decrementCounterXTimes(x)
    }

    private fun incrementCounterXTimes(x: Int) {
        val incrementer = onView(withId(R.id.incrementer))

        for (i in 1..x) {
            incrementer.perform(click())
        }
    }

    private fun decrementCounterXTimes(x: Int) {
        val decrementer = onView(withId(R.id.decrementer))

        for (i in 1..x) {
            decrementer.perform(click())
        }
    }
}