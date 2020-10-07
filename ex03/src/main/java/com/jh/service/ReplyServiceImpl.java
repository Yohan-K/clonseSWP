package com.jh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jh.domain.ReplyVO;
import com.jh.domain.Criteria;
import com.jh.domain.ReplyPageDTO;
import com.jh.mapper.BoardMapper;
import com.jh.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;

	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;

	@Transactional
	@Override
	public int register(ReplyVO vo) {

		log.info("register......" + vo);

		return mapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long bno) {

		log.info("get......" + bno);

		return mapper.read(bno);

	}

	@Override
	public int modify(ReplyVO vo) {

		log.info("modify......" + vo);

		return mapper.update(vo);
	}

	@Transactional
	@Override
	public int remove(Long rno) {

		log.info("remove...." + rno);

		return mapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {

		log.info("get Reply List of a Board " + cri);

		return mapper.getListWithPaging(cri, bno);
	}

	@Override 
	public int getTotal(Criteria cri) { return 0; }

	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {
		return new ReplyPageDTO(mapper.getCountByBno(bno), mapper.getListWithPaging(cri, bno));
	}
	
}
