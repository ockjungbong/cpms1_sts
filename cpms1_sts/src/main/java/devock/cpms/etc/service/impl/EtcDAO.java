package devock.cpms.etc.service.impl;


import org.springframework.stereotype.Repository;
import devock.cpms.common.dao.AbstractDAO;

@Repository("etcDAO")
public class EtcDAO extends AbstractDAO{


	public Integer selectAlertCount (String userno) {
		// TODO Auto-generated method stub
		return (Integer) selectOne("etc.selectAlertCount", userno);
	}


}

