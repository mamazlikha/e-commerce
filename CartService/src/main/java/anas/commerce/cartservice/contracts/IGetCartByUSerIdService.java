package anas.commerce.cartservice.contracts;

import anas.commerce.cartservice.dtos.CartDto;

import java.math.BigInteger;

public interface IGetCartByUSerIdService {

    /**
     *
     * */
    CartDto getCartById(BigInteger userId) throws Exception;

}
