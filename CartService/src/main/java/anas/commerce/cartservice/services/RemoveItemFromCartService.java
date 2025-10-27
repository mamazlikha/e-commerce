package anas.commerce.cartservice.services;

import anas.commerce.cartservice.contracts.IRemoveItemFromCartService;
import anas.commerce.cartservice.contracts.repositories.ICartRepository;
import anas.commerce.cartservice.entities.CartEntity;
import anas.commerce.cartservice.entities.ItemEntity;
import anas.ecommerce.client.ApiClient;
import anas.ecommerce.client.ApiException;
import anas.ecommerce.client.Configuration;
import anas.ecommerce.client.api.GetProductByIdControllerApi;
import anas.ecommerce.client.model.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
@RequiredArgsConstructor
public class RemoveItemFromCartService implements IRemoveItemFromCartService {

    private ICartRepository repository;

    @Setter
    private GetProductByIdControllerApi getProductByIdControllerApi;

    @Value("${productservice.port}")
    private String productServicePort;

    @Value("${productservice.host}")
    private String productServiceUrl;

    @Autowired
    public RemoveItemFromCartService(ICartRepository repository){
        this.repository = repository;
        ApiClient productServiceDefaultConfig = Configuration.getDefaultApiClient();
        productServiceDefaultConfig.setBasePath(productServiceUrl + ":"+productServicePort);
        this.getProductByIdControllerApi = new GetProductByIdControllerApi(productServiceDefaultConfig);
    }

    @Override
    public boolean removeItem(ObjectId cartId, ObjectId itemId) {
        Optional<CartEntity> cartOpt = repository.findById(cartId);

        if(cartOpt.isPresent()) {
            CartEntity cart = cartOpt.get();
            Optional<ItemEntity> itemToDeleteOpt = cart.getItems().stream().filter(x -> itemId.equals(x.getId())).findAny();
            if(itemToDeleteOpt.isPresent()){
                ItemEntity itemToDelete = itemToDeleteOpt.get();
                try {
                    ProductDTO productDTO = this.getProductByIdControllerApi.getProductById(itemToDelete.getProductEntityId().toHexString());
                    cart.setTotalPrice(cart.getTotalPrice() - productDTO.getPrice());
                    cart.getItems().remove(itemToDelete);
                    repository.save(cart);
                    return true;
                }
                catch (ApiException e) {
                    // handleProductServiceResponse(e);
                }
            }
        }
        return false;
    }
/*
    private void handleProductServiceResponse(ApiException exception) throws Exception {
        case 404 -> throw new ProductNotFoundException("Product not found", exception);
        default -> throw new ProductServiceException("Error calling Product Service", exception);

    }
*/
}
