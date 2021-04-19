package view.managedBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import persistance.dao.CategorieDao;
import persistance.dao.CategorieDaoImpl;
import persistance.entities.Categorie;

@ManagedBean
@SessionScoped
public class CategorieMBean 
{
	private Categorie cat = new Categorie();
	private Categorie selectcat = new Categorie();
	
	CategorieDao catDaoImpl = new CategorieDaoImpl();
	
	private List<Categorie> listCategories = new ArrayList<Categorie>();
	
	
	/**
	 * @return the cat
	 */
	public Categorie getCat() 
	{
		return cat;
	}

	/**
	 * @param cat the cat to set
	 */
	public void setCat(Categorie cat) 
	{
		this.cat = cat;
	}

	/**
	 * @return the selectcat
	 */
	public Categorie getSelectcat() 
	{
		return selectcat;
	}

	/**
	 * @param selectcat the selectcat to set
	 */
	public void setSelectcat(Categorie selectcat) 
	{
		this.selectcat = selectcat;
	}

	/**
	 * @return the catDaoImpl
	 */
	public CategorieDao getCatDaoImpl() 
	{
		return catDaoImpl;
	}

	/**
	 * @param catDaoImpl the catDaoImpl to set
	 */
	public void setCatDaoImpl(CategorieDao catDaoImpl) 
	{
		this.catDaoImpl = catDaoImpl;
	}

	/**
	 * @return the listCategories
	 */
	public List<Categorie> getListCategories() 
	{
		listCategories = catDaoImpl.findAll();
		return listCategories;
	}

	/**
	 * @param listCategories the listCategories to set
	 */
	public void setListCategories(List<Categorie> listCategories) 
	{
		this.listCategories = listCategories;
	}

	public void addCategorie(ActionEvent e) 
	{
		catDaoImpl.add(cat);
		cat = new Categorie();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ajout categorie effectué avec succès"));
	}
	
	public void  deleteCategorie(ActionEvent e) 
	{
		if (selectcat == null || selectcat.getIdcateg() == new BigDecimal(0))
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez selectionner une categorie à supprimer!"));
		}
		else
		{
		catDaoImpl.delete(selectcat);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Suppression categorie effectué avec succès"));
		}
	}
	
	public String editCategorie()
	{
		return "showCategorie.xhtml";
	}
	
	public String updateCategorie() 
	{
		catDaoImpl.update(selectcat);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("categorie modifier effectué avec succès"));

		return "showCategorie.xhtml";
		
	}
}
