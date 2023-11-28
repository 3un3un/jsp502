package com.z3un3un.book.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.z3un3un.dao.FileDao;
import com.z3un3un.dto.FileDto;

public class FileUploadService {
	private int maxSize = 1024*1000;
	private String uploadDir = "c:/upload";
	private String encode = "UTF-8";
	
	public FileUploadService() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FileUploadService(int maxSize, String uploadDir, String encode) {
		super();
		this.maxSize = maxSize;
		this.uploadDir = uploadDir;
		this.encode = encode;
	}
	
	public MultipartRequest fileUpload(HttpServletRequest request, String uploadFile, String cate) {
		try {
			MultipartRequest mr = new MultipartRequest(request, uploadDir, maxSize, encode);
			
			String fileName = mr.getFilesystemName(uploadFile);
			//파일이 첨부된 경우 파일의 이름을 변경 후 파일정보를 DB에 저장한다.
			if(fileName != null && !"".equals(fileName)) {
				String oFileName = rename(fileName);
				FileDto fileDto = new FileDto();
				fileDto.setSfile(oFileName);
				fileDto.setOfile(fileName);
				fileDto.setCate(cate);
				fileDto.setName("");
				fileDto.setTitle("");
				//저장된 파일의 이력을 관리하기 위해서 DB에 저장한다.
				FileDao dao = new FileDao();
				dao.regFile(fileDto);
			}
			return mr;
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 중복된 파일명의 경우 소실될 위험이 있으므로 파일명을 변경한다.
	 * 파일의 이름을 변경하고 변경된 이름을 반환한다.
	 */
	public String rename(String fileName) {
		String oFileName="";
		if(fileName != null && !fileName.equals("")) {
			//새로운 파일이름을 생성 : 원본파일명 + 시간날짜(uuid) + 확장자
			//H : 0~23, S : millisecond
			String now = new SimpleDateFormat("yyyyMMDD_HmsS").format(new Date());
			
			//첨부파일의 확장자
			String ext = fileName.substring(fileName.lastIndexOf("."));
			
			//원본파일 이름
			oFileName = fileName.substring(0, fileName.lastIndexOf("."));
			String newFileName = oFileName + "_" + now + ext;
			System.out.println("newFileName : " + newFileName);
			
			File oldFile = new File("c:/upload/" + fileName);
			File newFile = new File("c:/upload/" + newFileName);
			
			//파일이름을 변경
			oldFile.renameTo(newFile);
			//원본파일명과 변경된파일명을 각각 DTO에 저장한다.
		}
		return oFileName;
		
	}
	
	

}
