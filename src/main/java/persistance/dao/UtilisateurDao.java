package persistance.dao;

import persistance.entities.Utilisateur;

public interface UtilisateurDao extends GenericDao<Utilisateur>{

	Utilisateur findUtilisateurByUsernameAndPassword(String username, String password);
}
