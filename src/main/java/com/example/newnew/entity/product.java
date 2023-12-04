package com.example.newnew.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;
    private String designation;
    private String imageArt; // Correspond à imageart dans TypeScript
    private String marque;
    private double prix;
    private int qteStock; // Correspond à qtestock dans TypeScript
    // Relation ManyToOne avec Scategories
    @ManyToOne
    @JoinColumn(name = "scategorie_id")
    private Scategories scategorie;
    @Override
    public String toString() {
        return  "  Produit [id=" + id + ", designation=" + designation +
                ",   prix=" + prix + ", quantite=" + qteStock+", marque= "+
               ", categorie=" + scategorie + ", reference=" + reference + "]";
    }

}
