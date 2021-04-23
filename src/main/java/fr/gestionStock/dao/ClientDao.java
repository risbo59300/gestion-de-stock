package fr.gestionStock.dao;


	import java.util.List;

import fr.gestionStock.persistance.entities.Client;

	public interface ClientDao extends GenericDao<Client> 
	{
		List<Client> findClientBynom(String nom);
	}
