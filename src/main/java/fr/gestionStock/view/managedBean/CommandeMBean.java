package fr.gestionStock.view.managedBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.pie.PieChartDataSet;
import org.primefaces.model.charts.pie.PieChartModel;
import org.primefaces.model.charts.polar.PolarAreaChartModel;

import fr.gestionStock.dao.CommandeDao;
import fr.gestionStock.dao.CommandeDaoImpl;
import fr.gestionStock.persistance.entities.Commande;

@ManagedBean
@SessionScoped
public class CommandeMBean
{
	private  Commande com = new  Commande();
	private  Commande selectcom = new  Commande();
	
	 CommandeDao comDaoImpl = new  CommandeDaoImpl();
	
	private List< Commande> listCommandes = new ArrayList< Commande>();
	
	/**
	 * @return the com
	 */
	public Commande getCom() {
		return com;
	}

	/**
	 * @param com the com to set
	 */
	public void setCom(Commande com) {
		this.com = com;
	}

	/**
	 * @return the selectcom
	 */
	public Commande getSelectcom() {
		return selectcom;
	}

	/**
	 * @param selectcom the selectcom to set
	 */
	public void setSelectcom(Commande selectcom) {
		this.selectcom = selectcom;
	}

	/**
	 * @return the comDaoImpl
	 */
	public CommandeDao getComDaoImpl() {
		return comDaoImpl;
	}

	/**
	 * @param comDaoImpl the comDaoImpl to set
	 */
	public void setComDaoImpl(CommandeDao comDaoImpl) {
		this.comDaoImpl = comDaoImpl;
	}

	/**
	 * @return the listCommandes
	 */
	public List<Commande> getListCommandes() {
		listCommandes = comDaoImpl.findAll();
		return listCommandes;
	}

	/**
	 * @param listCommandes the listCommandes to set
	 */
	public void setListCommandes(List<Commande> listCommandes) {
		this.listCommandes = listCommandes;
	}

	public void addCommande(ActionEvent e) 
	{
		comDaoImpl.add(com);
		com = new Commande();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ajout commande effectué avec succès"));
	}
	
	public void deleteCommande(ActionEvent e) 
	{
		if (selectcom == null || selectcom.getIdCommande() == new BigDecimal(0))
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez selectionner une commande à supprimer!"));
		}
		else
		{
		comDaoImpl.delete(selectcom);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Suppression commande effectué avec succès"));
		}
	}
	
	public String editCommande()
	{
		return "modifyCommande.xhtml";
	}
	
	public String updateCommande() 
	{
		comDaoImpl.update(selectcom);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("commande modifier effectué avec succès"));

		return "showCommande.xhtml";
	}
	
	
	
}
