package com.example.cucumberandroid.test.steps

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.example.cucumberandroid.MainActivity
import com.example.cucumberandroid.R
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

class CounterSteps {
    @When("the application starts")
    fun applicationStarts() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Then("the counter should display {string}")
    fun counterShouldDisplay(count: String) {
        Espresso.onView(ViewMatchers.withId(R.id.counter))
            .check(ViewAssertions.matches(ViewMatchers.withText(count)))
    }
}