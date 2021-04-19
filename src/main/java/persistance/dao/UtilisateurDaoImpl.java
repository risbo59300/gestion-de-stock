package persistance.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import persistance.entities.Client;
import persistance.entities.Utilisateur;
import persistance.util.HibernateUtil;

public  class UtilisateurDaoImpl  implements UtilisateurDao{

	public Utilisateur findUtilisateurByUsernameAndPassword(String username, String password) {

		 Session s = HibernateUtil.getSessionFactory().openSession(); // Ouvrir une session s
		 Criteria crt = s.createCriteria(Utilisateur.class);
		 Criterion crt1 = Restrictions.eq("username", username);
		 Criterion crt2 = Restrictions.eq("password", password);
		 crt.add(crt1);
		 crt.add(crt2);
		 Utilisateur u = (Utilisateur) crt.uniqueResult();
		
		return u;
	}

	public void add(Utilisateur u)
	{
		Session s = HibernateUtil.getSessionFactory().openSession(); // Ouvrir une session s

        Transaction tx = s.beginTransaction();// Commencer une transaction

        s.save(u);
        tx.commit();// Valider la transaction
        s.close();// Fermer la session
	}

	public void update(Utilisateur u)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = s.beginTransaction(); //commencer une transaction
		
		s.update(u);
		
		tx.commit();
		s.close();
	}

	public void delete(Utilisateur u) 
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();

        s.delete(u);// supprimer
        tx.commit();
        s.close();
	}


	public List<Utilisateur> findAll() 
	{
		List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();

	      Session s = HibernateUtil.getSessionFactory().openSession();

	      listeUtilisateur = s.createQuery("from Utilisateur").list();
	      s.close();
	      return listeUtilisateur;
	}


	@Override
	public Utilisateur findbyId(Utilisateur u) 
	{
		Session s = HibernateUtil.getSessionFactory().openSession();

		Utilisateur util = s.get(Utilisateur.class, u);

        return util;
	}
}
