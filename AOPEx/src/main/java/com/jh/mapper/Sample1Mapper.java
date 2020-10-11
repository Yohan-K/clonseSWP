package com.jh.mapper;

import org.apache.ibatis.annotations.Insert;

public interface Sample1Mapper {

	@Insert("insert into t_sample1 (col1) values (#{data})")
	public int insertCol1(String data);
}
