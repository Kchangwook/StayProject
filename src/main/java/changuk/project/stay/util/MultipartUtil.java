package changuk.project.stay.util;

import org.springframework.web.multipart.MultipartFile;

/** 파일 관련 유틸 클래스 **/
public class MultipartUtil {

	public static String upload(MultipartFile file, String path, String name) {
		
		String ary[] = file.getOriginalFilename().split("\\.");
		
		return path;
		
	}//end of upload
	
}//end of MultipartUtil
