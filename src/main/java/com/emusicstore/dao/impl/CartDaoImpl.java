package com.emusicstore.dao.impl;

import com.emusicstore.dao.CartDao;
import com.emusicstore.model.Cart;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alan_Finn on 27/05/2016.
 */
@Repository
public class CartDaoImpl implements CartDao{
    private Map<String,Cart> listOfCarts;

    public CartDaoImpl(){
        listOfCarts = new HashMap<String, Cart>();

    }

    public Cart create(Cart cart){
        if (listOfCarts.keySet().contains(cart.getCartId())){
            throw new IllegalArgumentException(String.format("Cannot make Cart.ID(%) "+ "already" +"exists", cart.getCartId()));
        }
        listOfCarts.put(cart.getCartId(), cart);

        return cart;
    }

    public Cart read(String cartId){
        return listOfCarts.get(cartId);
    }
    public void update(String cartId, Cart cart){
        if(!listOfCarts.keySet().contains(cartId)){
            throw new IllegalArgumentException(String.format("Cannot update Cart.ID(%) "+ "doesnt" +"exist", cart.getCartId()));
        }

        listOfCarts.put(cartId, cart);
    }
    public void delete(String cartId){
        if(!listOfCarts.keySet().contains(cartId)){
            throw new IllegalArgumentException(String.format("Cannot delete Cart.ID(%) "+ "doesnt" +"exist", cartId));
        }

        listOfCarts.remove(cartId);
    }
}
