package fr.gestionStock.repositories;

import org.springframework.data.repository.CrudRepository;

import fr.gestionStock.persistance.entities.Produit;

import java.lang.String;
import java.util.List;

//@Repository
public interface ProduitRepository extends CrudRepository<Produit, Integer>{

	List<Produit> findByDesigproduitOrMarqueproduit(String desigproduit, String marqueproduit);
	
}