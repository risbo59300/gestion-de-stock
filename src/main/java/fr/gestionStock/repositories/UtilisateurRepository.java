package fr.gestionStock.repositories;

import org.springframework.data.repository.CrudRepository;

import fr.gestionStock.persistance.entities.Utilisateur;

import java.lang.String;
import java.util.List;

//@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer>{

	 List<Utilisateur> findByUsernameAndPassword(String username,String password);
	
}