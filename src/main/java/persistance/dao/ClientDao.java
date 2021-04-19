package persistance.dao;

import java.util.List;

import persistance.entities.Client;

public interface ClientDao extends GenericDao<Client> 
{
	List<Client> findClientBynom(String nom);
}
