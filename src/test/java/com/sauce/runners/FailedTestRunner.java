package com.sauce.runners;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;

@RunWith(Runner.class)
@CucumberOptions(
        plugin = {
                "html:target/failed-html-report.html"
        },
        features = "@target/rerun.txt",
        glue = "com/sauce/stepDefs"
)
public class FailedTestRunner {
}
