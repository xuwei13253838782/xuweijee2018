package DAO;




import java.util.List;
import domain.Province;




public interface ProvinceDAO {
   boolean check(String shi) throws Exception;
   
   boolean save_shi(Province pro) throws Exception;
   List<String[]> getAllPros_shi() throws Exception;
   boolean update_shi(Province pro) throws Exception;
   Province findById_shi(int shi_id) throws Exception;
   
   List<String[]> getAllPros_qu() throws Exception;
   boolean save_qu(Province pro_qu) throws Exception;;
   boolean update_qu(Province pro) throws Exception;
   Province findById_qu(int  qu_id) throws Exception;

}
