package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
    features={"src/test/resources/FeatureFile"},
    glue={"StepDefinitions"},
    tags="@1234Abc",
        plugin =
        {
                "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:rerun/failed_scenarios.txt"
        },
        monochrome = true

)

public class TestRunner extends AbstractTestNGCucumberTests
{
//   @Override
//   @DataProvider(parallel = true)
//   public Object[][] scenarios(){
//           return super.scenarios();
//   }
}
