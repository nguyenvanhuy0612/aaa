package cucumberTests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features/Login.feature", glue = "stepImplementations", tags = "@tag1")
public class LoginTestRunner {

}
