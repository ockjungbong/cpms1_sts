package devock.cpms.admin.organ.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptMapper {

	List<?> selectDepartment() throws Exception;
	
	

}
