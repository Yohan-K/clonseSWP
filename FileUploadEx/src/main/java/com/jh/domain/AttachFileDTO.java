package com.jh.domain;

import lombok.Data;

/**
 * 
 * @description 첨부파일의 정보들을 저장하는 AttachFileDTO 클래스
 *
 */

@Data
public class AttachFileDTO {

	private String fileName;
	private String uploadPath;
	private String uuid;
	private boolean image;
	
}
