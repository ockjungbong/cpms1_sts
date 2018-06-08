package devock.cpms.main.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleMapper {

	List<?> selectBoardGroupCount4Statistic() throws Exception;

}
