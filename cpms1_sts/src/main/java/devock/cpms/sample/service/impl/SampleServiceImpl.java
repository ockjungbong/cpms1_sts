package devock.cpms.sample.service.impl;

import java.util.List;
import java.util.Map;



import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import devock.cpms.sample.service.SampleService;



@Service("sampleService")
public class SampleServiceImpl implements SampleService{


	@Resource(name="sampleDAO")
	private SampleDAO sampleDAO;

	     
    @Override
    public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {

        return sampleDAO.selectBoardList(map);

    }


 

}

