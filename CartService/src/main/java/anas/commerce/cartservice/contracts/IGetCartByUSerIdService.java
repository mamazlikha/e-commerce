package anas.commerce.cartservice.contracts;

import anas.commerce.cartservice.dtos.CartDto;

import java.math.BigInteger;

public interface IGetCartByUSerIdService {

    CartDto userCart(BigInteger userId) throws Exception;

}
