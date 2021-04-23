package fr.gestionStock.persistance.service;

import java.util.List;

import fr.gestionStock.persistance.entities.Categorie;

public interface CategorieService {
	
	public void add(Categorie categorie);

    public List<Categorie> findAll();

    public void update(Categorie categorie);

    public void delete(Categorie categorie);

    public Categorie findById(int categorie);

}
