package persistance.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import persistance.entities.Client;
import persistance.util.HibernateUtil;

public class ClientDaoImpl implements ClientDao {

	@Override
	public void add(Client client) {
		Session s = HibernateUtil.getSessionFactory().openSession(); // Ouvrir une session s

        Transaction tx = s.beginTransaction();// Commencer une transaction

        s.save(client);
        tx.commit();// Valider la transaction
        s.close();// Fermer la session
	}

	@Override
	public List<Client> findAll() {
		List<Client> listeClient = new ArrayList<Client>();

	      Session s = HibernateUtil.getSessionFactory().openSession();

	      listeClient = s.createQuery("from Client").list();
	      s.close();
	      return listeClient;
	}

	@Override
	public void update(Client client) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = s.beginTransaction(); //commencer une transaction
		
		s.update(client);
		
		tx.commit();
		s.close();
	}

	@Override
	public Client findbyId(Client client) {
		Session s = HibernateUtil.getSessionFactory().openSession();

		Client cl = s.get(Client.class, client);

        return cl;
	}

	@Override
	public void delete(Client client) {
		Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();

        s.delete(client);// supprimer
        tx.commit();
        s.close();
	}

	@Override
	public List<Client> findClientBynom(String nom) 
	{
			Session s  = HibernateUtil.getSessionFactory().openSession();
	        Criteria crt=s.createCriteria(Client.class);
	        Criterion criterion1=Restrictions.eq("nomclient",nom);// condition de recherche ici par nom
	        crt.add(criterion1);
	        
	        List<Client> liste = crt.list();
	        s.close();
	        return liste;
	}



}
