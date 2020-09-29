package com.jh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jh.domain.ReplyVO;
import com.jh.domain.Criteria;
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

	@Override
	public void register(ReplyVO vo) {

		log.info("register......" + vo);

		mapper.insert(vo);
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
	public int getTotal(Criteria cri) {
		return 0;
	}
}
