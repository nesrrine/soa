package com.example.newnew.service;
import com.example.newnew.entity.Scategories;
import com.example.newnew.entity.product;
import com.example.newnew.repository.ProductRepository;
import com.example.newnew.repository.ScategoriesRepository;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class productservice implements productserviceinterfce {
    @Autowired  //injection de dépendances

    private ProductRepository productRepository;
    @Autowired  //injection de dépendances
    ScategoriesRepository ScategoriesRepository;

    public List<product> getAllProducts() {

        return productRepository.getAllproductbyqte_stock();
    }

    public Optional<product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public product addProduct(product newProduct) {
        return productRepository.save(newProduct);
    }
    public product ajouterproduit(String reference, String designation, String marque, double prix, int qteStock, Scategories scategorie, String imageArt) {
        product nouveauProduit = new product();
        nouveauProduit.setImageArt(imageArt);
        nouveauProduit.setReference(reference);
        nouveauProduit.setDesignation(designation);
        nouveauProduit.setMarque(marque);
        nouveauProduit.setPrix(prix);
        nouveauProduit.setQteStock(qteStock);
        ScategoriesRepository.save(scategorie);

        nouveauProduit.setScategorie(scategorie);

        return productRepository.save(nouveauProduit);
    }

    public product updateProduct(Long id, product updatedProduct) {
        Optional<product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            updatedProduct.setId(id);
            return productRepository.save(updatedProduct);
        }
        return null; // Handle this scenario according to your application logic
    }

    public boolean deleteProduct(Long id) {
        Optional<product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
