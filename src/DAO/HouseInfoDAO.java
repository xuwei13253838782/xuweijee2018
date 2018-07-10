package DAO;



import java.util.List;

import domain.HouseInfo;
import domain.Province;


public interface HouseInfoDAO {
	
   List<HouseInfo> getAllrent_all_house(int pageSize, int pageNow) throws Exception;
	
   boolean save_rent(String username,HouseInfo hf) throws Exception;
   boolean mark_del(int id) throws Exception;
   List<String[]> getAllrent_house(String username) throws Exception;
   
   
   boolean save_need(String username,HouseInfo hf) throws Exception;
   
   
   boolean save_collect(HouseInfo hf) throws Exception;
   List<String[]> getAllcollect_info() throws Exception;
   boolean collect_del(int id) throws Exception;
   
   
   boolean save_image(HouseInfo hf) throws Exception;
   HouseInfo findImage(int id) throws Exception;
   
}
