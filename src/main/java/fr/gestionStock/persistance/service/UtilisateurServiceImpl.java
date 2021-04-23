package fr.gestionStock.persistance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gestionStock.persistance.entities.Utilisateur;
import fr.gestionStock.repositories.UtilisateurRepository;

@Service
public  class UtilisateurServiceImpl  implements UtilisateurService{

	@Autowired
	UtilisateurRepository utilisateurRepository;

	@Override
	public void add(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		utilisateurRepository.save(utilisateur);
		}

	@Override
	public List<Utilisateur> findAll() {
		// TODO Auto-generated method stub
		return (List<Utilisateur>) utilisateurRepository.findAll();
	}

	@Override
	public void update(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		utilisateurRepository.save(utilisateur);
	}

	@Override
	public void delete(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		utilisateurRepository.delete(utilisateur);
	}

	@Override
	public Utilisateur findById(int utilisateur) {
		// TODO Auto-generated method stub
		return utilisateurRepository.findOne(utilisateur);
	}

	@Override
	public List<Utilisateur> findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return utilisateurRepository.findByUsernameAndPassword(username, password);
	}

	
	

		
		


}
