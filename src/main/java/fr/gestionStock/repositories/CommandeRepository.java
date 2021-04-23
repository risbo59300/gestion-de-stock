package fr.gestionStock.repositories;

import org.springframework.data.repository.CrudRepository;

import fr.gestionStock.persistance.entities.Commande;

import java.lang.String;
import java.util.Date;
import java.util.List;

//@Repository
public interface CommandeRepository extends CrudRepository<Commande, Integer>{

	List<Commande> findByEtatcommandeAndDatecommandeBetween(String etatcommande,Date datedebut, Date datefin);
	
}