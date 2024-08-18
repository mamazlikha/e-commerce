package anas.ecommerce.userservice.integration.cucumber.stepdef;

import anas.ecommerce.userservice.contracts.repositories.IUserRepository;
import anas.ecommerce.userservice.dtos.AddressDto;
import anas.ecommerce.userservice.dtos.userdto.CreateUserDto;
import anas.ecommerce.userservice.entities.UserEntity;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openapitools.client.ApiException;
import org.openapitools.client.api.CreateCartForUserControllerApi;
import org.openapitools.client.model.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.mockito.Mockito.when;

public class CreateNewUserStepDef {

    private final RestTemplate restTemplate;
    private CreateUserDto userDto;
    private ResponseEntity<CreateUserDto> response;
    private final HttpHeaders headers = new HttpHeaders();

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Autowired
    private IUserRepository userRepository;

    @Mock
    private CreateCartForUserControllerApi createCartForUserControllerApiMock;
    @Autowired
    public CreateNewUserStepDef(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Given("Empty database")
    public void emptyDatabase() throws ApiException {
        userRepository.deleteAll();
        Assert.assertEquals(0, userRepository.findAll().size());
        when(createCartForUserControllerApiMock.createCartForUser()).thenReturn(new CartDto());
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
        Assert.assertEquals(HttpStatusCode.valueOf(statusCode), response.getStatusCode());
    }

    @And("the client is in the database")
    public void theClientIsInTheDatabase() {
        String id = response.getBody().getId();
        Optional<UserEntity> addedUserOpt = userRepository.findById(new ObjectId(id));
        Assert.assertTrue(addedUserOpt.isPresent());
        UserEntity userEntity = addedUserOpt.get();
        Assert.assertEquals(userDto.getEmail(), userEntity.getEmail());
        Assert.assertEquals(userDto.getUserAddressDto().getCity(), userEntity.getAddress().getCity());
        Assert.assertEquals(userDto.getUserAddressDto().getCountry(), userEntity.getAddress().getCountry());
        Assert.assertEquals(userDto.getUserAddressDto().getStreetName(), userEntity.getAddress().getStreetName());
        Assert.assertEquals(userDto.getFirstname(), userEntity.getFirstname());
        Assert.assertEquals(userDto.getLastname(), userEntity.getLastname());
    }
}
