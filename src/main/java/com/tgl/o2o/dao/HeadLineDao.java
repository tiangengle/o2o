package com.tgl.o2o.dao;

import java.util.List;

import com.tgl.o2o.entity.HeadLine;
import org.apache.ibatis.annotations.Param;


public interface HeadLineDao {

	/**
	 * 根据传入的查询条件（头条名查询头条）
	 * @return
	 */
	List<HeadLine> queryHeadLine(@Param("headLineCondition") HeadLine headLineCondition);


	/*HeadLine queryHeadLineById(long lineId);

	List<HeadLine> queryHeadLineByIds(List<Long> lineIdList);

	int insertHeadLine(HeadLine headLine);

	int updateHeadLine(HeadLine headLine);

	int deleteHeadLine(long headLineId);

	int batchDeleteHeadLine(List<Long> lineIdList);*/
}
