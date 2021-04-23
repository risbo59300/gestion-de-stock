package fr.gestionStock.repositories;

import org.springframework.data.repository.CrudRepository;

import fr.gestionStock.persistance.entities.Client;

import java.lang.String;
import java.util.List;

//@Repository
public interface ClientRepository extends CrudRepository<Client, Integer>{

	List<Client>  findByPrenomclientOrNomclientOrDatenaissanceclient(String nomclient,String prenomclient,String datenaissance);
}