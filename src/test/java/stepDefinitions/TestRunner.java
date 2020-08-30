package stepDefinitions;
//xxxxxxxxxxxxxxxxxxxxxxxxxxxyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"C:\\eclipse-workspace\\BDDCucumberAutomationFeb2020\\src\\main\\java\\Feature\\Login.feature"},
                 glue= {"stepDefinitions"},
                 plugin= {"pretty","html:C:\\eclipse-workspace\\BDDCucumberAutomationFeb2020\\target",
                         "json:json_output/cucumber.json",
                         "junit:junit_output/cucumber.json"},
                          tags= {"@Smoke"},
                          dryRun=false,
                          strict=true,
                          monochrome=true
                         )

public class TestRunner {

}
