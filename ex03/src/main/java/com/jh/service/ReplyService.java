package com.jh.service;

import java.util.List;

import com.jh.domain.ReplyVO;
import com.jh.domain.Criteria;


public interface ReplyService {

	public void register(ReplyVO vo);

	public ReplyVO get(Long rno);

	public int modify(ReplyVO vo);

	public int remove(Long rno);

	public List<ReplyVO> getList(Criteria cri, Long bno);

	public int getTotal(Criteria cri);

}
