package com.example.newnew.service;

import com.example.newnew.entity.Scategories;

import java.util.List;

public interface scategorieserviceinterface {
    List<Scategories>  getAllScategories();
    void ajouterCategorie(Scategories c);

}
