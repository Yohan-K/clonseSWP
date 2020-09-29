package com.jh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jh.domain.Criteria;
import com.jh.domain.ReplyVO;

public interface ReplyMapper {

	public int insert(ReplyVO vo);
	
	public ReplyVO read(Long bno);
	
	public int delete(Long rno);
	
	public int update(ReplyVO vo);
	
	public List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri,
										   @Param("bno") Long bno);
}
