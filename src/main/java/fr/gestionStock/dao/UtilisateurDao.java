package fr.gestionStock.dao;

import fr.gestionStock.persistance.entities.Utilisateur;

public interface UtilisateurDao extends GenericDao<Utilisateur>{

	Utilisateur findUtilisateurByUsernameAndPassword(String username, String password);
}