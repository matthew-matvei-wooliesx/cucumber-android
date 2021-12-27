package com.example.cucumberandroid

import io.cucumber.junit.CucumberOptions

@CucumberOptions(
    features = ["features"],
    glue = ["com.example.cucumberandroid.steps"]
)
class CucumberConfig