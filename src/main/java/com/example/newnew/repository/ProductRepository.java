package com.example.newnew.repository;

import com.example.newnew.entity.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository  extends JpaRepository<product,Long> {
    @Query(value = "select * from product order by qte_stock desc ",nativeQuery = true)

    public List<product>getAllproductbyqte_stock();
}
