package fr.gestionStock.persistance.service;

import java.util.List;

import fr.gestionStock.persistance.entities.Produit;


public interface ProduitService  {

	public void add(Produit produit);

    public List<Produit> findAll();

    public void update(Produit produit);

    public void delete(Produit produit);

    public Produit findById(int produit);
    
    List<Produit> findByDesigproduitOrMarqueproduit(String desigproduit, String marqueproduit);
}
