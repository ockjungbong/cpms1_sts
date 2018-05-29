package devock.cpms.etc.service.impl;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EtcMapper {

	Integer selectAlertCount(String userno) throws Exception;

}
