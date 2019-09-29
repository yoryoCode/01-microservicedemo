package com.example.microservicedemo.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;

public class GenericMapper {
	
	public static Object mapping(Object bean, List<KeyValue> properties){
		
		Map<String, Object> mapProperties = new HashMap<String, Object>();
		for (KeyValue keyValue : properties) {
			mapProperties.put(keyValue.getKey(), keyValue.getValue());
		}
		
		try {
			BeanUtils.populate(bean, mapProperties);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		return bean;
	}

}
