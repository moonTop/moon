package com.yzframework.base;

public class ActionContext {

	private final static ThreadLocal<SessionInfo> session = new ThreadLocal<SessionInfo>(){
		@Override
		protected SessionInfo initialValue() {
			return null;
		}
	};
	
	public static SessionInfo getSession(){
		SessionInfo sessionInfo = session.get();
		if (sessionInfo == null) {
			sessionInfo = new SessionInfo();
			setSession(sessionInfo);
		}
		return sessionInfo;
	}
	
	public static void setSession(SessionInfo sessionInfo){
		session.set(sessionInfo);
	}
	
	public static void removeSession(){
		session.set(null);
		session.remove();
	}
}
