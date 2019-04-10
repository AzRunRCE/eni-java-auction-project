package fr.eni.ecole.DAL.Interface;

import fr.eni.ecole.DAL.DALException;

public interface DAO<T> {

   
  /**
  * M�thode de cr�ation
  * @param obj
  * @return boolean 
  */
  public int create(T obj)throws DALException;

  /**
  * M�thode pour effacer
  * @param obj
  * @return boolean 
  */
  public int delete(T obj)throws DALException;

  /**
  * M�thode de mise � jour
  * @param obj
  * @return boolean
  */
  public boolean update(T obj)throws DALException;

  /**
  * M�thode de recherche des informations
  * @param id
  * @return T
  */
  public T find(int id) throws DALException;
  
  
}