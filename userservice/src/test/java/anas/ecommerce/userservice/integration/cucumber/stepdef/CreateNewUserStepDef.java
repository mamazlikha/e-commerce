package anas.ecommerce.userservice.integration.cucumber.stepdef;

import anas.ecommerce.userservice.UserServiceApplicationTests;
import anas.ecommerce.userservice.contracts.repositories.IUserRepository;
import anas.ecommerce.userservice.dtos.AddressDto;
import anas.ecommerce.userservice.dtos.userdto.CreateUserDto;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CreateNewUserStepDef {

    private final RestTemplate restTemplate;
    private CreateUserDto userDto;
    private ResponseEntity<CreateUserDto> response;
    private final HttpHeaders headers = new HttpHeaders();

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    public CreateNewUserStepDef(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    @Given("Empty database")
    public void emptyDatabase() {
        Assert.assertEquals(0, userRepository.findAll().size());
    }

    @Given("This user information")
    public void thisUserInformation(DataTable dataTable) {
        var dataTableInfo = dataTable.asLists().get(1);
        AddressDto addressDto = new AddressDto(Integer.parseInt(dataTableInfo.get(5)), dataTableInfo.get(6), dataTableInfo.get(7), dataTableInfo.get(8), dataTableInfo.get(9));
        userDto = new CreateUserDto(dataTableInfo.get(0), dataTableInfo.get(1), LocalDate.parse(dataTableInfo.get(2), dtf), dataTableInfo.get(3), dataTableInfo.get(4), addressDto);
    }

    @When("the client calls {string} method with url {string}")
    public void theClientCallsPOSTMethodWithUrlUsersRegisterUser(String method, String url) throws Exception {
        String buildUrl = "http://localhost:8087/" + url;
        switch (method) {
            case "POST":
                response = restTemplate.postForEntity(buildUrl, userDto, CreateUserDto.class);
            default:
                throw new Exception("Method not supported to perform an integration test");
        }
    }

    @Then("the client receives status code of {int}")
    public void theClientReceivesStatusCodeOf(int statusCode) {
        Assert.assertEquals(HttpStatusCode.valueOf(statusCode), response.getStatusCode());
        String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
    }
}
