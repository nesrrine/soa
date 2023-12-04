package com.example.newnew.service;

import com.example.newnew.entity.Scategories;
import com.example.newnew.entity.product;
import org.springframework.http.MediaType;

import java.util.List;
import java.util.Optional;

public interface productserviceinterfce {

    List<product> getAllProducts();

    Optional<product> getProductById(Long id);
    product ajouterproduit(String reference, String designation, String marque, double prix, int qteStock, Scategories scategorie, String imageArt);
    product addProduct(product newProduct);

    product updateProduct(Long id, product updatedProduct);

    boolean deleteProduct(Long id);
}

