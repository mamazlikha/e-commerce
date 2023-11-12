package anas.commerce.cartservice.contracts;

import anas.commerce.cartservice.dtos.CartDto;

public interface ICreateCartForUserService {


    /**
     * Will create an empty cart for a user
     * @return CartDto to associate this cart with a user when created
     * */
    CartDto createNewCart();


}
