package changuk.project.stay.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

/** 파일 관련 유틸 클래스 **/
public class MultipartUtil {

	public static String upload(MultipartFile file, String path, String name) throws IllegalStateException, IOException {
		
		String ary[] = file.getOriginalFilename().split("\\.");
		String fileName = name + "." + ary[ary.length - 1];
		File dest = new File("C:\\Users\\kchan\\eclipse-workspace\\stay\\src\\main\\resources\\static\\data\\" + path + "\\" + fileName);
		
		file.transferTo(dest);
		
		return "\\data\\" + path + "\\" + fileName;
		
	}//end of upload
	
}//end of MultipartUtil
