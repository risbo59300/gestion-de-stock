package fr.gestionStock.view.managedBean;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fr.gestionStock.dao.UtilisateurDao;
import fr.gestionStock.dao.UtilisateurDaoImpl;
import fr.gestionStock.persistance.entities.Utilisateur;


@ManagedBean
@SessionScoped
public class UserMBean {
	
	private String username;
	private String pwd;
	
	private String message;
	
	private Utilisateur user = new Utilisateur() ;
	private Utilisateur selectuser = new Utilisateur();
	
	private UtilisateurDao userDaoImpl = new UtilisateurDaoImpl();
	
	private List<Utilisateur> listUsers = new ArrayList<Utilisateur>();
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public UtilisateurDao getUserDaoImpl() {
		return userDaoImpl;
	}

	public void setUserDaoImpl(UtilisateurDao userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}

	public Utilisateur getSelectuser() {
		return selectuser;
	}

	public void setSelectuser(Utilisateur selectuser) {
		this.selectuser = selectuser;
	}

	public List<Utilisateur> getListUsers() {
		listUsers = userDaoImpl.findAll();
		return listUsers;
	}

	public void setListUsers(List<Utilisateur> listUsers) {
		this.listUsers = listUsers;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void addUser(ActionEvent e) {
		userDaoImpl.add(user);
		user = new Utilisateur();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ajout utilisateur effectué avec succès"));
	}
	
	public void deleteUser(ActionEvent e) {
		if (selectuser == null || selectuser.getIdUtilisateur() == new BigDecimal(0))
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez selectionner un utilisateur à supprimer!"));
		}
		else
		{
			userDaoImpl.delete(selectuser);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Suppression utilisateur effectué avec succès"));
		}
	}
	
	public String editUser() {
		return "modifyUser.xhtml";
	}
	
	public String updateUser() {
		userDaoImpl.update(selectuser);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Utilisateur modifié avec succès"));

		return "showUser.xhtml";
	}
	
	public String login()
	{
		if (username.equals("admin") && pwd.equals("admin")) 
		{
			return "AccueilAdmin.xhtml";
		} 
		else
		{
			if (userDaoImpl.findUtilisateurByUsernameAndPassword( username,  pwd) != null)
			{
				return "AccueilUser.xhtml";
			} 
			else
			{
				FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Attention", "Utilisateur inexistant"));
			}
			return "login.xhtml";
		}
		
	}	
	
	
	
	
}
