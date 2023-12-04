package com.example.newnew.controller;
import com.example.newnew.entity.Scategories;

import com.example.newnew.entity.product;
import com.example.newnew.service.productservice;
import com.example.newnew.service.scategorieservice;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/product")
public class productcontroller {

    private productservice productservice;
    private scategorieservice scategorieservice;

    @GetMapping(value = "/products", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<product> getAllProducts() {
        return productservice.getAllProducts();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<product> getProductById(@PathVariable Long id) {
        Optional<product> foundProduct = productservice.getProductById(id);
        return foundProduct.map(product -> new ResponseEntity<>(product, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping(value = "/scategories", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Scategories>> getAllScategories() {
        List<Scategories> allScategories = scategorieservice.getAllScategories();
        return new ResponseEntity<>(allScategories, HttpStatus.OK);
    }
    @PostMapping(value = "/add", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<product> addProduct(@RequestBody product newProduct) {
        product createdProduct = productservice.addProduct(newProduct);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }
    @PostMapping("/ajouter")
    public ResponseEntity<product> ajouterProduit(@RequestBody product newProduct) {
        product createdProduct = productservice.ajouterproduit(
                newProduct.getReference(),
                newProduct.getDesignation(),
                newProduct.getMarque(),
                newProduct.getPrix(),
                newProduct.getQteStock(),
                newProduct.getScategorie(),
                newProduct.getImageArt()
        );
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }
    @PutMapping(value ="update/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<product> updateProduct(@PathVariable Long id, @RequestBody product updatedProduct) {
        product product = productservice.updateProduct(id, updatedProduct);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping(value ="delete/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        boolean deleted = productservice.deleteProduct(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}