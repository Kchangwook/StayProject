package changuk.project.stay.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/** 매핑 관련 유틸 **/
public class MapperUtil {

	/** 객체의 필드를 Map<String,String>으로 변경 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws InvocationTargetException **/
	public static MultiValueMap<String, String> changeStringMap(Object object) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		
		LinkedMultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		
		Field fields[] = object.getClass().getDeclaredFields();
		Method methods[] = object.getClass().getDeclaredMethods();
		
		for(Field f: fields) {
			f.setAccessible(true);
			String name = f.getName();
			
			for(Method m: methods) {
				if(m.getName().contains("get" + name.substring(0,1).toUpperCase() + name.substring(1))) {
					
					Object result = m.invoke(object);
					
					if(result == null) map.add(name, "");
					else map.add(name, String.valueOf(m.invoke(object)));
					
				}
			}
			
		}
		
		return map;
		
	}//end of changeStringMap
	
	/** 객체의 필드를 Map<String,String>으로 변경 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws InvocationTargetException **/
	public static Map<String, String> changeStringHashMap(Object object) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		
		Map<String, String> map = new HashMap<>();
		
		Field fields[] = object.getClass().getDeclaredFields();
		Method methods[] = object.getClass().getDeclaredMethods();
		
		for(Field f: fields) {
			f.setAccessible(true);
			String name = f.getName();
			
			for(Method m: methods) {
				if(m.getName().contains("get" + name.substring(0,1).toUpperCase() + name.substring(1))) {
					
					Object result = m.invoke(object);
					
					if(result == null) map.put(name, "");
					else map.put(name, String.valueOf(m.invoke(object)));
					
				}
			}
			
		}
		
		return map;
		
	}//end of changeStringMap
	
}//end of MapperUtil
