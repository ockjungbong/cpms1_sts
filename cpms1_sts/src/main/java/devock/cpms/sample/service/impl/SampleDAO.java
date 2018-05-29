package devock.cpms.sample.service.impl;



import java.util.List;

import java.util.Map;



import org.springframework.stereotype.Repository;



import devock.cpms.common.dao.AbstractDAO;



 

@Repository("sampleDAO")
public class SampleDAO extends AbstractDAO{


	public List<Map<String, Object>> selectBoardList (Map<String, Object> map) throws Exception{		

		return (List<Map<String, Object>>) selectList("sample.selectBoardList", map);
	}

}



