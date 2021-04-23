package fr.gestionStock.persistance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gestionStock.persistance.entities.Commande;
import fr.gestionStock.repositories.CommandeRepository;

@Service
public class CommandeServiceImpl implements CommandeService {

	@Autowired
	CommandeRepository commandeRepository;

	@Override
	public void add(Commande commande) {
		// TODO Auto-generated method stub
		commandeRepository.save(commande);
	}

	@Override
	public List<Commande> findAll() {
		// TODO Auto-generated method stub
		return (List<Commande>) commandeRepository.findAll();
	}

	@Override
	public void update(Commande commande) {
		// TODO Auto-generated method stub
		commandeRepository.save(commande);
	}

	@Override
	public void delete(Commande commande) {
		// TODO Auto-generated method stub
		commandeRepository.delete(commande);
	}

	@Override
	public Commande findById(int commande) {
		// TODO Auto-generated method stub
		return commandeRepository.findOne(commande);
	}
	
	
}
