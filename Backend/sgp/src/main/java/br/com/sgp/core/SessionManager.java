package br.com.sgp.core;

import java.util.HashMap;
import java.util.Map;

import br.com.sgp.entities.Teacher;

public class SessionManager {

	private Map<Integer, Teacher> sessions;
	private static SessionManager instance;

	private SessionManager() {
		sessions = new HashMap<>();
	}

	private static SessionManager getInstance() {
		if (instance == null) {
			synchronized (SessionManager.class) {
				if (instance == null) {
					instance = new SessionManager();
				}
			}
		}
		return instance;
	}

	public static Teacher getUser(Integer sessionID) {
		return getInstance().sessions.get(sessionID);
	}

	public static int getSessionID(Teacher newUser) {
		if (newUser != null) {
			int sessionID = newUser.hashCode();
			if (!getInstance().sessions.containsKey(sessionID)) {
				getInstance().sessions.put(sessionID, newUser);
			}
			return sessionID;
		}
		return -1;
	}

	public static boolean isLogged(Teacher user) {
		return getInstance().sessions.containsValue(user);
	}
}
