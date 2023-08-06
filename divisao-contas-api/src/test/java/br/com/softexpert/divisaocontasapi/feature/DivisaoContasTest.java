package br.com.softexpert.divisaocontasapi.feature;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertNotNull;

public class DivisaoContasTest extends FeatureBase {

    @Given("que estou dividindo uma conta")
    public void divisaoContas() {
    }

    @Given("que estou dividindo uma conta com dados validos")
    public void divisaoContas_ExpectedSucess() {
        responseEntityExpected = postDivisaoContas(ScenarioFactory.NEW_CONTAGERAL_DTO);
        assertNotNull(responseEntityExpected.getBody());
    }


    @Then("é retornado o status{int}")
    public void divisaoContas_ReturnTheStatusHttpCode(Integer value) {
        assertThat(value).isEqualTo(this.responseEntityExpected.getStatusCodeValue());
    }
}
