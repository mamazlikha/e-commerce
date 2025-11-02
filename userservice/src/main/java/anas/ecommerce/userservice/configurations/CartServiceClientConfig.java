package anas.ecommerce.userservice.configurations;

import anas.ecommerce.client.ApiClient;
import anas.ecommerce.client.api.CreateCartForUserControllerApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CartServiceClientConfig {
    @Value("${cartservice.host}")
    private String cartServiceUrl;

    @Value("${cartservice.port}")
    private String cartServicePort;

    @Bean
    public CreateCartForUserControllerApi createCartForUserControllerApi() {
        ApiClient client = anas.ecommerce.client.Configuration.getDefaultApiClient();
        client.setBasePath(cartServiceUrl + ":" + cartServicePort);
        return new CreateCartForUserControllerApi(client);
    }
}
