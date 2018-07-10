package DAO;



import domain.Person;


public interface PersonDAO {
   boolean check(String username) throws Exception;
   boolean save(Person pers) throws Exception;
   
 

}
