package anas.commerce.cartservice.contracts;

import java.math.BigInteger;

public interface IRemoveItemFromCartService {

    /**
     *
     */

    boolean removeItem(BigInteger cartId, BigInteger itemId);
}
