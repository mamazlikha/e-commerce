package anas.commerce.cartservice.contracts;

import anas.commerce.cartservice.dtos.CartDto;
import anas.commerce.cartservice.dtos.ItemDTO;

import java.math.BigInteger;

public interface IAddItemToCartService {

    /**
     *
     * */
    CartDto addItem(BigInteger cartId, String itemId) throws Exception;

}
