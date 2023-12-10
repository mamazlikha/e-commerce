package anas.commerce.items.contracts;

import anas.commerce.items.dtos.ProductDTO;
import anas.commerce.items.exceptions.ProductNotFoundException;
import org.bson.types.ObjectId;


public interface IGetProductByIdService {

    /**
     * @param id item's id
     * @return ItemDto by id
     * */
    ProductDTO getProductById(ObjectId id) throws ProductNotFoundException;

}
