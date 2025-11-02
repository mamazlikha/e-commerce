package anas.ecommerce.userservice;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@CucumberContextConfiguration
@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Slf4j
public class UserServiceApplicationTests {

	@ServiceConnection
	@Container
	static final MongoDBContainer mongoDBContainer =
			new MongoDBContainer(DockerImageName.parse("mongo:5.0"))
					.withExposedPorts(27017)
					.withLogConsumer(new Slf4jLogConsumer(log));

	@BeforeAll
	public static void setup() {
		mongoDBContainer.start();
	}

	@AfterAll
	public static void tearDown() {
		mongoDBContainer.stop();
	}
	@Test
	void contextLoads() {

	}


}
