package com.myspring.pro28.ex02;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.coobird.thumbnailator.Thumbnails;

@Controller("fileDownloadController2")
public class FileDownloadController2 {
	private static final Logger logger = LoggerFactory.getLogger(FileDownloadController2.class);
	private static String CURR_IMAGE_REPO_PATH ="C:\\spring\\image_repo";
	
	@RequestMapping(value = "/download2", method = RequestMethod.GET)
	public void download(@RequestParam("imageFileName") String imageFileName,   HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		logger.info("넘어온 이미지 파일 명"+imageFileName);
		
		OutputStream out = response.getOutputStream();
		
		String filePath = CURR_IMAGE_REPO_PATH + "\\"+"thumbnail" +"\\"+ imageFileName;
		
		logger.info("파라미터로 넘어온 이미지 파일 경로 " + filePath);
		
		File image = new File(filePath);
		
//		String encodedFileName = URLEncoder.encode(imageFileName, "UTF-8");
		
		int lastIndex=imageFileName.lastIndexOf(".");
		logger.info("마지막 . 의 위치" + lastIndex);
		
		String fileName  = imageFileName.substring(0,lastIndex);
		
		logger.info("파일이름만 가져옴 그 파일명은 : " + fileName);
		
		//새로운 썸네일 폴더 경로로 파일 객체 만들고 확장자는 png로만
		
		File thumbnail = new File(CURR_IMAGE_REPO_PATH+"\\"+"thumbnail"+"\\"+fileName+".jpg");
		
		if (image.exists()) { //파라미터로 넘어온 이미지 파일 객체  존재 여부 확인
			
			thumbnail.getParentFile().mkdirs();
			//Thumbnails.of(image).size(50,50).outputFormat("png").toFile(thumbnail);
			Thumbnails.of(image).size(50,50).outputFormat("jpg").toFile(thumbnail);
		}
		
		FileInputStream in = new FileInputStream(thumbnail);
		
		byte[] buffer = new byte[1024 * 8];
		
		while (true) {
			int count = in.read(buffer);
			if (count == -1) {
				break;
			}
			
			out.write(buffer, 0, count);
			
		}
		in.close();
		
	
		out.close();
	}
	
}
