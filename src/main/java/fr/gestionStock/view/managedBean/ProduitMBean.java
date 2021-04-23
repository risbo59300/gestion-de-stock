package fr.gestionStock.view.managedBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import fr.gestionStock.dao.ProduitDao;
import fr.gestionStock.dao.ProduitDaoImpl;
import fr.gestionStock.persistance.entities.Produit;

@ManagedBean
@SessionScoped
public class ProduitMBean 
{
	private  Produit prod = new  Produit();
	private  Produit selectprod = new  Produit();
	
	ProduitDao prodDaoImpl = new  ProduitDaoImpl();
	
	private List< Produit> listProduits = new ArrayList< Produit>();
	
	/**
	 * @return the prod
	 */
	public Produit getProd() {
		return prod;
	}

	/**
	 * @param com the prod to set
	 */
	public void setProd(Produit prod) {
		this.prod = prod;
	}

	/**
	 * @return the selectprod
	 */
	public Produit getSelectprod() {
		return selectprod;
	}

	/**
	 * @param selectprod the selectprod to set
	 */
	public void setSelectprod(Produit selectprod) {
		this.selectprod = selectprod;
	}

	/**
	 * @return the prodDaoImpl
	 */
	public ProduitDao getProdDaoImpl() {
		return prodDaoImpl;
	}

	/**
	 * @param prodDaoImpl the prodDaoImpl to set
	 */
	public void setProdDaoImpl(ProduitDao prodDaoImpl) {
		this.prodDaoImpl = prodDaoImpl;
	}

	/**
	 * @return the listProduits
	 */
	public List<Produit> getListProduits() {
		listProduits = prodDaoImpl.findAll();
		return listProduits;
	}

	/**
	 * @param listProduits the listProduits to set
	 */
	public void setListProduits(List<Produit> listProduits) {
		this.listProduits = listProduits;
	}

	public void addProduit(ActionEvent e) 
	{
		prodDaoImpl.add(prod);
		prod = new Produit();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ajout produit effectué avec succès"));
	}
	
	public void deleteProduit(ActionEvent e) 
	{
		if (selectprod == null || selectprod.getIdproduit() == new BigDecimal(0))
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez selectionner un produit à supprimer!"));
		}
		else
		{
		prodDaoImpl.delete(selectprod);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Suppression produit effectué avec succès"));
		}
	}
	
	public String editProduit()
	{
		return "showProduit.xhtml";
	}
	
	public String updateProduit() 
	{
		prodDaoImpl.update(selectprod);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("produit modifier effectué avec succès"));

		return "showProduit.xhtml";
		
	}
}
