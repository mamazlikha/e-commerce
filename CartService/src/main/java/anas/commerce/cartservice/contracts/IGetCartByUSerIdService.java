package anas.commerce.cartservice.contracts;

import anas.commerce.cartservice.dtos.CartDto;

import java.math.BigInteger;

public interface IGetCartByUSerIdService {

    /**
     * @param userId user's id
     * @return CartDto by it's user's id
     * */
    CartDto getCartById(BigInteger userId) throws Exception;

}
