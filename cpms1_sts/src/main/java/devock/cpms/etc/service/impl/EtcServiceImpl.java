package devock.cpms.etc.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devock.cpms.etc.service.EtcService;

@Service("etcService")
public class EtcServiceImpl implements EtcService{	

	
	@Autowired
	private EtcMapper etcMapper;

	@Override
	public Integer selectAlertCount(String userno) throws Exception {		
		return etcMapper.selectAlertCount(userno);
	}
	
	/*
	@Resource(name="etcDAO")
	private EtcDAO etcDAO;

	public Integer selectAlertCount (String userno) throws Exception {

		// TODO Auto-generated method stub
		return etcDAO.selectAlertCount(userno);

	}
	*/



}
