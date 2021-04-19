package persistance.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import persistance.entities.Commande;
import persistance.util.HibernateUtil;

public class CommandeDaoImpl implements CommandeDao {

	@Override
	public void add(Commande commande) {
		Session s = HibernateUtil.getSessionFactory().openSession(); // Ouvrir une session s

        Transaction tx = s.beginTransaction();// Commencer une transaction

        s.save(commande);
        tx.commit();// Valider la transaction
        s.close();// Fermer la session
	}

	@Override
	public List<Commande> findAll() {
		List<Commande> listeCommande = new ArrayList<Commande>();

	      Session s = HibernateUtil.getSessionFactory().openSession();

	      listeCommande = s.createQuery("from Commande").list();
	      s.close();
	      return listeCommande;
	}

	@Override
	public void update(Commande commande) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = s.beginTransaction(); //commencer une transaction
		
		s.update(commande);
		
		tx.commit();
		s.close();
	}

	@Override
	public Commande findbyId(Commande commande) {
		Session s = HibernateUtil.getSessionFactory().openSession();

		Commande co = s.get(Commande.class, commande);

        return co;
	}

	@Override
	public void delete(Commande commande) {
		Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();

        s.delete(commande);// supprimer
        tx.commit();
        s.close();
	}

}
