package br.com.softexpert.divisaocontasapi.feature;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:br/com/softexpert/divisaocontasapi/feature/"},
        plugin = { "pretty" },
        tags = {"@WIP"}
        )
public class
RunCucumberTestIT {

}