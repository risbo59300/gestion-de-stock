package fr.gestionStock.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.gestionStock.hibernate.util.HibernateUtil;
import fr.gestionStock.persistance.entities.Categorie;

public class CategorieDaoImpl implements CategorieDao {

	@Override
	public void add(Categorie categ) {
		Session s = HibernateUtil.getSessionFactory().openSession(); // Ouvrir une session s

        Transaction tx = s.beginTransaction();// Commencer une transaction

        s.save(categ);
        tx.commit();// Valider la transaction
        s.close();// Fermer la session
	}

	@Override
	public List<Categorie> findAll() {
		List<Categorie> listeCategorie = new ArrayList<Categorie>();

	      Session s = HibernateUtil.getSessionFactory().openSession();

	      listeCategorie = s.createQuery("from Categorie").list();
	      s.close();
	      return listeCategorie;
	}

	@Override
	public void update(Categorie categ) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = s.beginTransaction(); //commencer une transaction
		
		s.update(categ);
		
		tx.commit();
		s.close();
	}

	@Override
	public Categorie findbyId(Categorie categ) {
		Session s = HibernateUtil.getSessionFactory().openSession();

		Categorie ca = (Categorie) s.get(Categorie.class, categ);

        return ca;
	}

	@Override
	public void delete(Categorie categ) {
		Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();

        s.delete(categ);// supprimer
        tx.commit();
        s.close();
	}

}
