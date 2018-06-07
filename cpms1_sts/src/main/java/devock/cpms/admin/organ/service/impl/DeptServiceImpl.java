package devock.cpms.admin.organ.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devock.cpms.admin.organ.service.DeptService;

@Service("deptService")
public class DeptServiceImpl implements DeptService{
	
	@Autowired
	private DeptMapper deptMapperr;

	@Override
	public List<?> selectDepartment() throws Exception {
		// TODO Auto-generated method stub
		return deptMapperr.selectDepartment();
	}

}
