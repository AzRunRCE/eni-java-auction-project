package fr.eni.ecole.DAL.Interface;

import fr.eni.ecole.DAL.DALException;

public interface DAO<T> {

   
  /**
  * Méthode de création
  * @param obj
  * @return boolean 
  */
  public int create(T obj)throws DALException;

  /**
  * Méthode pour effacer
  * @param obj
  * @return boolean 
  */
  public int delete(T obj)throws DALException;

  /**
  * Méthode de mise à jour
  * @param obj
  * @return boolean
  */
  public boolean update(T obj)throws DALException;

  /**
  * Méthode de recherche des informations
  * @param id
  * @return T
  */
  public T find(int id) throws DALException;
  
  
}