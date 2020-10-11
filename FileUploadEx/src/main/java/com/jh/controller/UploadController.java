package com.jh.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class UploadController {

	@GetMapping("/uploadForm")
	public void uploadForm() {

		log.info("upload form");
	}
	
	@PostMapping("/uploadFormAction")
	public void uploadFormPost(MultipartFile[] uploadFile, Model model) {
		
		String uploadFolder = "C:\\upload";
		
		for (MultipartFile multipartFile : uploadFile) {
			
			log.info("========================================");
			log.info("Upload File Name: " + multipartFile.getOriginalFilename());
			log.info("Upload File Size: " + multipartFile.getSize());
			
			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			
			try {
				multipartFile.transferTo(saveFile);
			} catch(Exception e) {
				log.error(e.getMessage());
			}
		}
	}
	
	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		
		log.info("upload ajax");
	}
	
	@PostMapping("/uploadAjaxAction")
	public void uploadAjaxPost(MultipartFile[] uploadFile) {
		
		String uploadFolder = "C:\\upload";
		
		// 폴더 생성
		File uploadPath = new File(uploadFolder, getFolder());
		
		log.info("업로드 경로: " + uploadPath);
		
		if(uploadPath.exists() == false) {
			uploadPath.mkdir();
		}
		
		// 년/월/일 폴더 생성
		for (MultipartFile multipartFile : uploadFile) {
			
			log.info("=======================================");
			log.info("Upload File Name: " + multipartFile.getOriginalFilename());
			log.info("Upload File Size: " + multipartFile.getSize());
			
			String uploadFileName = multipartFile.getOriginalFilename();
			
			// IE를 위한 경로 지정
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
			
			log.info("only file name : " + uploadFileName);
			
			UUID uuid = UUID.randomUUID();
			
			uploadFileName = uuid.toString() + "_" + uploadFileName;
			
			//File saveFile = new File(uploadFolder, uploadFileName);
			File saveFile = new File(uploadPath, uploadFileName);
			
			try {
				multipartFile.transferTo(saveFile);
			} catch(Exception e) {
				log.error(e.getMessage());
			}
		}
	}
	
	//오늘 날짜의 경로를 문자열로 생성
	private String getFolder() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();
		
		String str = sdf.format(date);
		
		return str.replace("-", File.separator);
	}
}
