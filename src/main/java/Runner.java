import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature"
        , glue = "stepDefs"
        , monochrome = true
        , plugin = {"pretty", "html:target/cucumber-html-report"}
        , tags = "@test_api"
)
class Runner {

}
