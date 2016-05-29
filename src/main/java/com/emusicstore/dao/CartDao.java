package com.emusicstore.dao;

import com.emusicstore.model.Cart;

/**
 * Created by Alan_Finn on 27/05/2016.
 */
public interface CartDao {
    Cart create(Cart cart);
    Cart read(String cartId);
    void update(String cartId, Cart cart);
    void delete(String cartId);
}
