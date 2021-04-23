package fr.gestionStock.persistance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gestionStock.persistance.entities.Client;
import fr.gestionStock.repositories.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepository clientRepository;

	@Override
	public void add(Client client) {
		// TODO Auto-generated method stub
		clientRepository.save(client);
	}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return (List<Client>) clientRepository.findAll();
	}

	@Override
	public void update(Client client) {
		// TODO Auto-generated method stub
		clientRepository.save(client);
	}

	@Override
	public void delete(Client client) {
		// TODO Auto-generated method stub
		clientRepository.delete(client);
	}

	@Override
	public Client findById(int client) {
		// TODO Auto-generated method stub
		return clientRepository.findOne(client);
	}

	@Override
	public List<Client> findByPrenomclientOrNomclientOrDatenaissanceclient(String nomclient, String prenomclient,
			String datenaissance) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
