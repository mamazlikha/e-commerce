package anas.commerce.items.contracts;

import anas.commerce.items.dtos.ProductDTO;

import java.util.List;

public interface IFindAllProductsService {



    /**
     * @return List of ProductDTO in the database
     * */
    List<ProductDTO> findAll();

}
