package com.emusicstore.controller;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Alan_Finn on 27/05/2016.
 */
@Controller
public class AdminController {

    @Autowired
    private ProductDao productDao;


    @RequestMapping("/admin")
    public String adminPage(){
        return "admin";
    }

    @RequestMapping("/admin/productInventory")
    public String productInventory(Model model){
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products", products);
        return "productInventory";
    }

    @RequestMapping("admin/productInventory/addProduct")
    public String addProduct(Model model){
        Product product = new Product();
        product.setProductCategory("Instrument");
        product.setProductCondition("new");
        product.setProductStatus("In stock");

        model.addAttribute("product", product);
        return "addProduct";
    }

    @RequestMapping(value = "admin/productInventory/addProduct", method = RequestMethod.POST)
    public String addProductPost(@Valid @ModelAttribute("product")Product product, BindingResult result){

        if(result.hasErrors()){
            return "addProduct";
        }
        productDao.addProduct(product);
        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/admin/productInventory/deleteProduct/{id}")
    public String deleteProduct(@PathVariable String id, Model model){

        productDao.deleteProduct(id);


        return "redirect:/admin/productInventory";
    }
}
