package fr.gestionStock.persistance.service;

import java.util.List;

import fr.gestionStock.persistance.entities.Commande;


public interface CommandeService {
	
	public void add(Commande commande);

    public List<Commande> findAll();

    public void update(Commande commande);

    public void delete(Commande commande);

    public Commande findById(int commande);

}
