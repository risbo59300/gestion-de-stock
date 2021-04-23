package fr.gestionStock.dao;

import java.util.List;

public interface GenericDao<T> 
{
	public void add(T entity);
	
	public List<T> findAll();
	
	public void update(T entity);
	
	public T findbyId(T entity);
	
	public void delete(T entity);
}
