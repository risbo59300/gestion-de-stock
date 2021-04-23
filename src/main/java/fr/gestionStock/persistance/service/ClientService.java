package fr.gestionStock.persistance.service;

import java.util.List;

import fr.gestionStock.persistance.entities.Client;

public interface ClientService  
{
	public void add(Client client);

    public List<Client> findAll();

    public void update(Client client);

    public void delete(Client client);

    public Client findById(int client);
    
    List<Client>  findByPrenomclientOrNomclientOrDatenaissanceclient(String nomclient,String prenomclient,String datenaissance);
    
}
