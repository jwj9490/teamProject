package travel.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utility.Paging;

//@Component("myTravelDao")
@Service("myTravelDao") // Dao객체만들때 @Service 써도 괜찮다.
public class TravelDao {

	private String namespace = "travel.TravelBean";
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<TravelBean> getTravelList(Paging pageInfo, Map<String, String> map) {
		
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		// 1페이지 : new RowBounds(0, 2); (몇개 건너뛰냐?, 몇개 가져오냐)
		// 2페이지 : new RowBounds(2, 2);
		List<TravelBean> lists = sqlSessionTemplate.selectList(namespace + ".getTravelList", map, rowBounds);
		System.out.println("TravelDao lists.size() : " + lists.size());
		
		return lists;
	}// getTravelList;
	
	public int insertTravel(TravelBean tb) {
		
		int cnt = sqlSessionTemplate.insert(namespace + ".insertTravel", tb);
		System.out.println("TravelDao insert cnt : " + cnt);
		
		return cnt;
	}// insertTravel;
	
	public int deleteTravel(int num) {
		
		int cnt = sqlSessionTemplate.delete(namespace + ".deleteTravel", num);
		System.out.println("TravelDao delete cnt : " + cnt);
		
		return cnt;
	}// deleteTravel;
	
	public TravelBean getOneSelect(int num) {
		
		TravelBean tb = sqlSessionTemplate.selectOne(namespace + ".getOneSelect", num);
		
		return tb;
	}// getOneSelect;
	
	public int updateTravel(TravelBean tb) {
		
		int cnt = sqlSessionTemplate.update("travel.TravelBean.updateTravel", tb);
		System.out.println("updateTravel cnt : " + cnt);
		
		return cnt;
	}// updateTravel;
	
	public int getTotalCount(Map<String, String> map) {
		
		int cnt = sqlSessionTemplate.selectOne(namespace + ".getTotalCount", map);
		
		return cnt;
	}
}
