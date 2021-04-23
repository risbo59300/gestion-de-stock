package fr.gestionStock.persistance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gestionStock.persistance.entities.Produit;
import fr.gestionStock.repositories.ProduitRepository;

@Service
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	ProduitRepository produitRepository;

	@Override
	public void add(Produit produit) {
		// TODO Auto-generated method stub
		produitRepository.save(produit);
	}

	@Override
	public List<Produit> findAll() {
		// TODO Auto-generated method stub
		return (List<Produit>) produitRepository.findAll();
	}

	@Override
	public void update(Produit produit) {
		// TODO Auto-generated method stub
		produitRepository.save(produit);
	}

	@Override
	public void delete(Produit produit) {
		// TODO Auto-generated method stub
		produitRepository.delete(produit);
	}

	@Override
	public Produit findById(int produit) {
		// TODO Auto-generated method stub
		return produitRepository.findOne(produit);
	}

	@Override
	public List<Produit> findByDesigproduitOrMarqueproduit(String desigproduit, String marqueproduit) {
		// TODO Auto-generated method stub
		return produitRepository.findByDesigproduitOrMarqueproduit(desigproduit, marqueproduit);
	}
}
