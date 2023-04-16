package CucumberJavaGlobal.CucumberJavaGlobal;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/CucumberJavaGlobal/CucumberJavaGlobal/Features", glue = {
		"CucumberJavaGlobal.StepDefinitions" }, monochrome = true, plugin = { "pretty",
				"junit:target/reports/report.xml", "json:target/reports/cucumber.json",
				"html:target/reports/report.html" }, tags = "@cart")
public class RunCucumberTest {
}
