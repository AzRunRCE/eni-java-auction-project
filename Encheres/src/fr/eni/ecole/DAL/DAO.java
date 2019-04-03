package fr.eni.ecole.DAL;

public interface DAO<T> {

   
  /**
  * M�thode de cr�ation
  * @param obj
  * @return boolean 
  */
  public  boolean create(T obj) throws DALException;

  /**
  * M�thode pour effacer
  * @param obj
  * @return boolean 
  */
  public  boolean delete(T obj) throws DALException;

  /**
  * M�thode de mise � jour
  * @param obj
  * @return boolean
  */
  public boolean update(T obj) throws DALException;

  /**
  * M�thode de recherche des informations
  * @param id
  * @return T
  */
  public T find(int id) throws DALException;
  
  
}