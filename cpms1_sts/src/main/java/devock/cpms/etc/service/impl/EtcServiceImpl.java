package devock.cpms.etc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import devock.cpms.etc.service.EtcService;

import devock.cpms.sample.service.impl.SampleDAO;

@Service("etcService")
public class EtcServiceImpl implements EtcService{	

	@Resource(name="etcDAO")
	private EtcDAO etcDAO;

	public Integer selectAlertCount (String userno) throws Exception {

		// TODO Auto-generated method stub
		return etcDAO.selectAlertCount(userno);

	}



}
