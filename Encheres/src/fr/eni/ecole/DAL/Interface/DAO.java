package fr.eni.ecole.DAL.Interface;

public interface DAO<T> {

   
  /**
  * M�thode de cr�ation
  * @param obj
  * @return boolean 
  */
  public int create(T obj);

  /**
  * M�thode pour effacer
  * @param obj
  * @return boolean 
  */
  public int delete(T obj);

  /**
  * M�thode de mise � jour
  * @param obj
  * @return boolean
  */
  public boolean update(T obj);

  /**
  * M�thode de recherche des informations
  * @param id
  * @return T
  */
  public T find(int id);
  
  
}