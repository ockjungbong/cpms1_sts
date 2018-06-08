package devock.cpms.main.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import devock.cpms.main.service.SampleService;

@Service("sampleService")
public class SampleServiceImpl implements SampleService{
	
	@Resource(name= "sampleMapper")
	private SampleMapper sampleMapper;

	@Override
	public List<?> selectBoardGroupCount4Statistic() throws Exception {
		return sampleMapper.selectBoardGroupCount4Statistic();
	}

}
