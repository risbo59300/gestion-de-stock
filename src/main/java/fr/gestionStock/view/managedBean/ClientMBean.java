package fr.gestionStock.view.managedBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import fr.gestionStock.dao.ClientDao;
import fr.gestionStock.dao.ClientDaoImpl;
import fr.gestionStock.persistance.entities.Client;

@ManagedBean
@SessionScoped
public class ClientMBean 
{
	private Client client = new Client();
	private Client selectclient = new Client();
	
	ClientDao clientDaoImpl = new ClientDaoImpl();
	
	private List<Client> listClients = new ArrayList<Client>();
	
	public List<Client> getListClients() {
		listClients = clientDaoImpl.findAll();
		return listClients;
	}
	
	private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @param listClients the listClients to set
	 */
	public void setListClients(List<Client> listClients) {
		this.listClients = listClients;
	}


	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	


	/**
	 * @return the selectclient
	 */
	public Client getSelectclient() {
		return selectclient;
	}


	/**
	 * @param selectclient the selectclient to set
	 */
	public void setSelectclient(Client selectclient) {
		this.selectclient = selectclient;
	}


	public void addClient(ActionEvent e) {
		clientDaoImpl.add(client);
		client = new Client();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ajout client effectué avec succès"));
	}
	
	public void deleteClient(ActionEvent e) {
		if (selectclient == null || selectclient.getIdclient() == new BigDecimal(0))
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez selectionner un client à supprimer!"));
		}
		else
		{
		clientDaoImpl.delete(selectclient);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Suppression client effectué avec succès"));
		}
	}
	
	public String editClient() {
		return "modifyClient.xhtml";
	}
	
	public String updateClient() {
		clientDaoImpl.update(selectclient);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Suppression client effectué avec succès"));

		return "showClient.xhtml";
	}
	
	public void search(ActionEvent e) {

	    listClients = clientDaoImpl.findClientBynom(nom);
	        }

}
