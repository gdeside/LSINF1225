package com.example.wishlist.Classesapp;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Product {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "Nom_Product")
    private String name;

    @ColumnInfo(name = "Prix")
    private int prix;

    @ColumnInfo(name = "Categorie")
    private String categorie;

    @ColumnInfo(name = "Note")
    private float note;

    @ColumnInfo(name = "Lien")
    private String lien;

    public Product(@NonNull String name, int prix) {
        this.name = name;
        this.prix = prix;
        this.lien = "";
        this.note=0;
        this.categorie="";
    }

    @NonNull
    public String getName() {
        return name;
    }


    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public static Product[] populateData()
    {
        Product product = new Product("Ordinateur", 999);
        product.setNote((float) 4.5);
    ;
        return new Product[]{
                product,
                new Product("Smartphone", 599),
                new Product("Une âme", 999999),
                new Product("Bierre Corona",1)
        };
    }
}
