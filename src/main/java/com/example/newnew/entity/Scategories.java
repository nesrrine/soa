package com.example.newnew.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Scategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomscategorie;
    private String imagescategorie;
    // Relation OneToMany avec Products
    @JsonIgnore

    @OneToMany(mappedBy = "scategorie")
    private List<product> products;

    @Override
    public String toString() {
        return "Scategories{" +
                "id=" + id +
                ", nomscategorie='" + nomscategorie + '\'' +
                ", imagescategorie='" + imagescategorie + '\'' +
                ", products=" + products +
                '}';
    }
}
