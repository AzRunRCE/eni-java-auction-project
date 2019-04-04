package fr.eni.ecole.DAL;

public interface DAO<T> {

   
  /**
  * M�thode de cr�ation
  * @param obj
  * @return boolean 
  */
  public  boolean create(T obj);

  /**
  * M�thode pour effacer
  * @param obj
  * @return boolean 
  */
  public  boolean delete(T obj);

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