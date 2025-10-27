package anas.commerce.items.contracts;

import org.bson.types.ObjectId;

public interface IDeleteProductByIdService {

    /**
     * Delete a product from the database
     * @param id
     * @return true if product was deleted, false otherwise
     */
    boolean deleteById(ObjectId id);
}
