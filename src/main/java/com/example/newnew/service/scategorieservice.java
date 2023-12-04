package com.example.newnew.service;

import com.example.newnew.entity.Scategories;
import com.example.newnew.repository.ScategoriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class scategorieservice implements scategorieserviceinterface {
    @Autowired
    private  ScategoriesRepository ScategoriesRepository;
    public List<Scategories> getAllScategories() {

        return ScategoriesRepository.findAll();
    }
    @Override
    public void ajouterCategorie(Scategories c)
    {
        ScategoriesRepository.save(c);
    }

    }

