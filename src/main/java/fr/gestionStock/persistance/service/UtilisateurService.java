package fr.gestionStock.persistance.service;

import java.util.List;

import fr.gestionStock.persistance.entities.Utilisateur;

public interface UtilisateurService {

	public void add(Utilisateur utilisateur);

    public List<Utilisateur> findAll();

    public void update(Utilisateur utilisateur);

    public void delete(Utilisateur utilisateur);

    public Utilisateur findById(int utilisateur);
    
    List<Utilisateur> findByUsernameAndPassword(String username,String password);
    }
