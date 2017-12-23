package com.client.storage;

import org.apache.shiro.session.Session;

import java.util.HashMap;
import java.util.Map;

public enum SessionStorage {
	INSTANCE;
	private Map<String, Session> map = new HashMap<String, Session>();
	
	public void set(String token, Session session) {
		map.put(token, session);
	}
	
	public Session get(String token) {
		if (map.containsKey(token)) {
			return map.remove(token);
		}
		return null;
	}
}