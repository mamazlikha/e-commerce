package anas.ecommerce.userservice.integration.cucumber.stepdef;

import anas.ecommerce.userservice.contracts.repositories.IUserRepository;
import anas.ecommerce.userservice.dtos.AddressDto;
import anas.ecommerce.userservice.dtos.userdto.CreateUserDto;
import anas.ecommerce.userservice.entities.UserEntity;
import com.github.tomakehurst.wiremock.WireMockServer;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

public class CreateNewUserStepDef {

    RestTemplate restTemplate;
    CreateUserDto userDto;
    ResponseEntity<CreateUserDto> response;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Autowired
    IUserRepository userRepository;

    @Autowired
    public CreateNewUserStepDef(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    WireMockServer wireMockServer;

    @Before
    public void startWireMock() {
        wireMockServer = new WireMockServer(8082);
        wireMockServer.start();

        wireMockServer.stubFor(post(urlEqualTo("/carts/createforuser"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{ \"id\": \"6903ccd91ac6ffa53b99d881\", \"itemsDto\": [], \"totalPrice\": 0.0 }")));
    }

    @Given("Empty database")
    public void emptyDatabase() {
        userRepository.deleteAll();
        assertEquals(0, userRepository.findAll().size());
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
                break;
            default:
                throw new Exception("Method not supported to perform an integration test");
        }
    }

    @Then("the client receives status code of {int}")
    public void theClientReceivesStatusCodeOf(int statusCode) {
        assertNotNull(response.getBody());
        assertEquals(HttpStatusCode.valueOf(statusCode), response.getStatusCode());
    }

    @And("the client is in the database")
    public void theClientIsInTheDatabase() {
        String id = response.getBody().getId();
        Optional<UserEntity> addedUserOpt = userRepository.findById(new ObjectId(id));
        assertTrue(addedUserOpt.isPresent());
        UserEntity userEntity = addedUserOpt.get();
        assertEquals(userDto.getEmail(), userEntity.getEmail());
        assertEquals(userDto.getUserAddressDto().getCity(), userEntity.getAddress().getCity());
        assertEquals(userDto.getUserAddressDto().getCountry(), userEntity.getAddress().getCountry());
        assertEquals(userDto.getUserAddressDto().getStreetName(), userEntity.getAddress().getStreetName());
        assertEquals(userDto.getFirstname(), userEntity.getFirstname());
        assertEquals(userDto.getLastname(), userEntity.getLastname());
    }
}
