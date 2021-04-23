package fr.gestionStock.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.gestionStock.hibernate.util.HibernateUtil;
import fr.gestionStock.persistance.entities.Produit;

public class ProduitDaoImpl implements ProduitDao {

	@Override
	public void add(Produit produit) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = s.beginTransaction(); //commencer une transaction
		
		s.save(produit);
		
		tx.commit();
		s.close();
	}

	@Override
	public List<Produit> findAll() {
		List<Produit> listeProduit = new ArrayList<Produit>();

	    Session s = HibernateUtil.getSessionFactory().openSession();

	    listeProduit = s.createQuery("from Produit").list();
	    s.close();
	    return listeProduit;
	}

	@Override
	public void update(Produit produit) {
Session s = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = s.beginTransaction(); //commencer une transaction
		
		s.update(produit);
		
		tx.commit();
		s.close();
	}

	@Override
	public Produit findbyId(Produit produit) {
		Session s = HibernateUtil.getSessionFactory().openSession();

		Produit pr = (Produit) s.get(Produit.class, produit);

        return pr;
	}

	@Override
	public void delete(Produit produit) {
		Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();

        s.delete(produit);// supprimer
        tx.commit();
        s.close();
	}

}
