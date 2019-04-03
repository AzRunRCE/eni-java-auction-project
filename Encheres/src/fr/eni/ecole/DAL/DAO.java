package fr.eni.ecole.DAL;

public interface DAO<T> {

   
  /**
  * Méthode de création
  * @param obj
  * @return boolean 
  */
  public  boolean create(T obj) throws DALException;

  /**
  * Méthode pour effacer
  * @param obj
  * @return boolean 
  */
  public  boolean delete(T obj) throws DALException;

  /**
  * Méthode de mise à jour
  * @param obj
  * @return boolean
  */
  public boolean update(T obj) throws DALException;

  /**
  * Méthode de recherche des informations
  * @param id
  * @return T
  */
  public T find(int id) throws DALException;
  
  
}