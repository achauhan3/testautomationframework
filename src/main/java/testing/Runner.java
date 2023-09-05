package testing;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;


//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature"
        , glue = "stepDefs"
        , monochrome = true
        , plugin = {"pretty", "html:target/cucumber-html-report"}
        , tags = "@test_api_post"
)
class Runner extends AbstractTestNGCucumberTests {

}
