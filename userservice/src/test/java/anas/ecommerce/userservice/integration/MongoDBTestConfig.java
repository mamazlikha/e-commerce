package anas.ecommerce.userservice.integration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@EnableAutoConfiguration
@EnableMongoRepositories
@Testcontainers
public class MongoDBTestConfig {
/*
    @Container
    private static final GenericContainer<?> MONGO_CONTAINER =
            new GenericContainer<>("mongo:latest")
                    .withExposedPorts(27017)
                    .withEnv("SPRING_DATA_MONGODB_DATABASE_USERNAME", "root")
                    .withEnv("SPRING_DATA_MONGODB_PWD", "password");

    @Override
    protected String getDatabaseName() {
    }

    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder) {
        // beforeAll();
    }


    @DynamicPropertySource
    public static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.host", MONGO_CONTAINER::getHost);
        registry.add("spring.data.mongodb.port", MONGO_CONTAINER::getFirstMappedPort);
        registry.add("spring.data.mongodb.authentication-database", () -> "admin");
        registry.add("spring.data.mongodb.username", () -> "root");
        registry.add("spring.data.mongodb.password", () -> "password");
    }

    @BeforeAll
    public static void beforeAll() {
        MONGO_CONTAINER.start();
    }*/

    @Container
    public static final GenericContainer<?> mongoDBContainer =
            new GenericContainer<>("mongo:latest")
                    .withExposedPorts(27017)
                    .waitingFor(Wait.forLogMessage(".*Waiting for connections.*\\n", 2))
                    .withEnv("MONGO_INITDB_ROOT_USERNAME", "root")
                    .withReuse(true)
                    .withEnv("MONGO_INITDB_ROOT_PASSWORD", "password");
    static {
        mongoDBContainer.start();
        var mappedPort = mongoDBContainer.getMappedPort(27017);
        System.setProperty("SPRING_DATA_MONGODB_PORT", String.valueOf(mappedPort));
    }

}
