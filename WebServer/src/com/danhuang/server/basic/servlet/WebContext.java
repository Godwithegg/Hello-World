package com.danhuang.server.basic.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebContext {
	private List<Entity> entitys = null;
	private List<Mapping> mappings = null;
	
	//key --> servlet-name value -->servlet-class
	private Map<String, String> entityMap = new HashMap<>();
	//key --> url-pattern value-->servlet-name
	private Map<String, String> mappingMap = new HashMap<>();
	
	public WebContext(List<Entity> entitys, List<Mapping> mappings) {
		this.entitys = entitys;
		this.mappings = mappings;
		//��entityListר�ɶ�Ӧ��map
		for(Entity entity:entitys) {
			entityMap.put(entity.getName(), entity.getClz());
		}
		//��entity��Listת���˶�Ӧmap
		for(Mapping mapping:mappings) {
			for(String pattern:mapping.getPatterns()) {
				mappingMap.put(pattern,mapping.getName());
			}
		}
	}
	/**
	 * ͨ��url·���ҵ���Ӧ��class
	 * @param pattern
	 * @return
	 */
	public String getClz(String pattern) {
		String name = mappingMap.get(pattern);
		return entityMap.get(name);
		
	}
}
